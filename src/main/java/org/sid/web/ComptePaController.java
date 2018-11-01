/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.web;

import javax.validation.Valid;
import org.sid.entities.ComptePa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.sid.dao.ComptePaRepository;

/**
 *
 * @author babacar
 */
@Controller
@RequestMapping(value="/Compte")
public class ComptePaController {
     
    @Autowired
    private ComptePaRepository compteRepository;
    
     @RequestMapping(value="/form", method=RequestMethod.GET)
	public String FormMedecin(Model model) {
		model.addAttribute("compte", new ComptePa());
		return "FormComptepa";
	}
        @RequestMapping(value="/SaveCompte", method=RequestMethod.POST)
	public String savecompte(@Valid ComptePa m, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormComptepa";
                    
                }
                else{
                compteRepository.save(m);
		
		return "redirect:list";
                
                }
	}
         @RequestMapping(value="/list", method=RequestMethod.GET)
	 public String ListCompte(Model model,@RequestParam(name="page", defaultValue = "0")int p) {
                Page<ComptePa> lp = compteRepository.findAll( new PageRequest(p, 15));
                int pagesCount = lp.getTotalPages();
                int [] pages = new int[pagesCount];
                for(int i=0; i<pagesCount; i++){
                    pages[i]=i;
                }
                model.addAttribute("pages", pages);  
		model.addAttribute("pagecomptes", lp);
                model.addAttribute("pageCourante", p);
                
		return "ListCompte";
	}
         
           @RequestMapping(value="/supprimer")
	   public String supprimer(String login) {
		
            compteRepository.deleteById(login);
            
            return "redirect:list";
	}
        
        @RequestMapping(value="/editer")
	public String editer(String login, Model model) {
		
            ComptePa pt = compteRepository.getOne(login);
            
            model.addAttribute("compte", pt);
            
            return "EditCompte";
	}
        
        @RequestMapping(value="/UpdateCompte", method=RequestMethod.POST)
	public String updateCompte(@Valid ComptePa p, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormComptepa";
                    
                }
                else{
                compteRepository.save(p);
            
		
		return "redirect:list";
                }
	}
}
