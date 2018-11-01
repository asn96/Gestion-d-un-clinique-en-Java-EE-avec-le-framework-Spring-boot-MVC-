/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.web;

import java.util.Date;
import javax.validation.Valid;
import org.sid.dao.SecretaireRepository;
import org.sid.entities.Secretaire;
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
@RequestMapping(value="/Secretaire")
public class SecretaireController {
    
     @Autowired
    private SecretaireRepository secretaireRepository;
     @RequestMapping(value="/form2", method=RequestMethod.GET)
	public String Formsecretaire(Model model) {
		model.addAttribute("secretaire", new Secretaire());
		return "FormSecretaire";
	}
        @RequestMapping(value="/SaveSecretaire", method=RequestMethod.POST)
	public String savesecretaire(@Valid Secretaire s, BindingResult bindingResult) {
            
               if(bindingResult.hasErrors()){
                    
                    return "FormSecretaire";
                    
                }
               else{
                
                s.setDateajout(new Date());
                secretaireRepository.save(s);
		
		return "redirect:list2";
                
               }
	}
        
         @RequestMapping(value="/list2", method=RequestMethod.GET)
	public String ListSecretaire(Model model,@RequestParam(name="page", defaultValue = "0")int p) {
                Page<Secretaire> lp = secretaireRepository.findAll( new PageRequest(p, 15));
                int pagesCount = lp.getTotalPages();
                int [] pages = new int[pagesCount];
                for(int i=0; i<pagesCount; i++){
                    pages[i]=i;
                }
                model.addAttribute("pages2", pages);  
		model.addAttribute("pagesecretaires", lp);
                model.addAttribute("pageCourante2", p);
		return "ListSecretaire";
	}
        
        @RequestMapping(value="/editer1")
	public String editer1(String matriculesecretaire, Model model) {
		
            Secretaire pt = secretaireRepository.getOne(matriculesecretaire);
            
            model.addAttribute("secretaire", pt);
            
            return "EditSecretaire";
	}
        
         @RequestMapping(value="/supprimer1")
	   public String supprimer1(String matriculesecretaire) {
		
            secretaireRepository.deleteById(matriculesecretaire);
            
            return "redirect:list2";
	}
            @RequestMapping(value="/UpdateSecretaire", method=RequestMethod.POST)
	public String updateSecretaire(@Valid Secretaire p, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormSecretaire";
                    
                }
                else{
                p.setDateajout(new Date());
                secretaireRepository.save(p);
            
		
		return "redirect:list2";
                }
	}
    
}
