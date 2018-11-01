/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.web;

import java.util.Date;
import javax.validation.Valid;
import org.sid.dao.MedecinRepository;
import org.sid.entities.Medecin;
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
@RequestMapping(value="/Medecin")
public class MedecinController {
    
    @Autowired
    private MedecinRepository medecinRepository;
    
     @RequestMapping(value="/form1", method=RequestMethod.GET)
	public String FormMedecin(Model model) {
		model.addAttribute("medecin", new Medecin());
		return "FormMedecin";
	}
        @RequestMapping(value="/SaveMedecin", method=RequestMethod.POST)
	public String save(@Valid Medecin m, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormMedecin";
                    
                }
                else{
                m.setDateajout(new Date());
                medecinRepository.save(m);
		
		return "redirect:list1";
                
                }
	}
         @RequestMapping(value="/list1", method=RequestMethod.GET)
	 public String ListMedecin(Model model,@RequestParam(name="page", defaultValue = "0")int p) {
                Page<Medecin> lp = medecinRepository.findAll( new PageRequest(p, 15));
                int pagesCount = lp.getTotalPages();
                int [] pages = new int[pagesCount];
                for(int i=0; i<pagesCount; i++){
                    pages[i]=i;
                }
                model.addAttribute("pages1", pages);  
		model.addAttribute("pagemedecins", lp);
                model.addAttribute("pageCourante1", p);
                
		return "ListMedecin";
	}
         
           @RequestMapping(value="/supprimer")
	   public String supprimer(String matriculemedecin) {
		
            medecinRepository.deleteById(matriculemedecin);
            
            return "redirect:list1";
	}
        
        @RequestMapping(value="/editer")
	public String editer(String matriculemedecin, Model model) {
		
            Medecin pt = medecinRepository.getOne(matriculemedecin);
            
            model.addAttribute("medecin", pt);
            
            return "EditMedecin";
	}
        
        @RequestMapping(value="/UpdateMedecin", method=RequestMethod.POST)
	public String updateMedecin(@Valid Medecin p, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormMedecin";
                    
                }
                else{
                p.setDateajout(new Date());
                medecinRepository.save(p);
            
		
		return "redirect:list1";
                }
	}
}
