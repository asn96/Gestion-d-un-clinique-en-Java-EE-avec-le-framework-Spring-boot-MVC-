/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.web;

import java.util.Date;
import javax.validation.Valid;
import org.sid.dao.DossierRepository;
import org.sid.entities.Dossier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author babacar
 */
@Controller
@RequestMapping(value="/Dossier")
public class DossierController {
    
    
	@Autowired
	private DossierRepository dossierRepository;
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String FormDossier(Model model) {
		model.addAttribute("dossier", new Dossier());
		return "FormDossier";
	}
        
        @RequestMapping(value="/SaveDossier", method=RequestMethod.POST)
	public String save(@Valid Dossier m, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormDossier";
                    
                }
                else{
                m.setDatecreation(new Date());
                dossierRepository.save(m);
		
		return "redirect:list";
                
                }
	}
        
         @RequestMapping(value="/list", method=RequestMethod.GET)
	public String ListConsultation(Model model,@RequestParam(name="page", defaultValue = "0")int p) {
                Page<Dossier> lp = dossierRepository.findAll( new PageRequest(p, 15));
                int pagesCount = lp.getTotalPages();
                int [] pages = new int[pagesCount];
                for(int i=0; i<pagesCount; i++){
                    pages[i]=i;
                }
                model.addAttribute("pages", pages);  
		model.addAttribute("pagedossiers", lp);
                model.addAttribute("pageCourante", p);
		return "ListDossier";
	}
        @RequestMapping(value="/supprimer")
	public String supprimer(String numerodossier) {
		
            dossierRepository.deleteById(numerodossier);
            
            return "redirect:list";
	}
         @RequestMapping(value="/editer")
	public String editer(String numerodossier, Model model) {
		
            Dossier pt = dossierRepository.getOne(numerodossier);
            
            model.addAttribute("dossier", pt);
            
            return "EditDossier";
	}
        @RequestMapping(value="/UpdateDossier", method=RequestMethod.POST)
	public String update(@Valid Dossier p, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormDossier";
                    
                }
                else{
                p.setDatecreation(new Date());
                dossierRepository.save(p);
            
		return "redirect:list";
                }
	}
}
