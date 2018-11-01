/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import org.sid.dao.RecuRepository;
import org.sid.entities.Recu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author babacar
 */
@Controller
@RequestMapping(value="/Recu")
public class RecuController {
    
      
    
        @Autowired
        private RecuRepository recuRepository;
    
        @RequestMapping(value="/form", method=RequestMethod.GET)
	public String FormRecu(Model model) {
		model.addAttribute("recu", new Recu());
		return "FormRecu";
	}
        
        @RequestMapping(value="/SaveRecu", method=RequestMethod.POST)
	public String save(@Valid Recu c, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormRecu";
                    
                }
                else{
                c.setDaterecu(new Date());
                c.setHeurerecu(new Date());
                recuRepository.save(c);
		
		return "redirect:list";
                }
	}
        
        @RequestMapping(value="/list", method=RequestMethod.GET)
	public String ListRecu(Model model,@RequestParam(name="page", defaultValue = "0")int p) {
                Page<Recu> lp = recuRepository.findAll( new PageRequest(p, 15));
                int pagesCount = lp.getTotalPages();
                int [] pages = new int[pagesCount];
                for(int i=0; i<pagesCount; i++){
                    pages[i]=i;
                }
                model.addAttribute("pages", pages);  
		model.addAttribute("pagerecus", lp);
                model.addAttribute("pageCourante", p);
		return "ListRecu";
	}
        
        @RequestMapping(value="/supprimer")
	public String supprimer(Long numerorecu) {
		
            recuRepository.deleteById(numerorecu);
            
           
            
            return "redirect:list";
	}
        @RequestMapping(value="/imprimer")
	public void imprimer(Long numerorecu) throws JRException {
            
            List<Map<String, Object>> datasource = new ArrayList<Map<String, Object>>();
            
            Recu recu = recuRepository.getOne(numerorecu);
            
            Map<String, Object> row = new HashMap<String, Object>();
            
            row.put("numero", recu.getNumerorecu());
            
            row.put("montant", recu.getMontantrecu());
            
            row.put("date", recu.getDaterecu());
            
            row.put("heure", recu.getHeurerecu());
           
            datasource.add(row);
            
            JRDataSource jRDataSource = new JRBeanCollectionDataSource(datasource);
            
            JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\Papa NDIAYE\\Desktop\\Programme_L2\\Projet fin d'année\\gestion d'un cab medical\\Conception\\cabinet\\src\\main\\java\\org\\sid\\web\\recureport.jrxml");
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jRDataSource);
            
           // JasperViewer jasperViewer = new JasperViewer(jasperPrint);
            
            
                       
            
           
	}
     
    
}
