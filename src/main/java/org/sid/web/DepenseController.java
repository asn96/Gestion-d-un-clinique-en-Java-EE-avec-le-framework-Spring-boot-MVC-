/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.web;

import java.util.Date;
import javax.validation.Valid;
import org.sid.dao.DepenseRepository;
import org.sid.entities.Depense;
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
@RequestMapping(value="Depense")
public class DepenseController {
    
     @Autowired
    private DepenseRepository depenseRepository;
    
    @RequestMapping(value="/form", method=RequestMethod.GET)
	public String FormPatient(Model model) {
		model.addAttribute("depense", new Depense());
		return "FormDepense";
	}
        @RequestMapping(value="/SaveDepense", method=RequestMethod.POST)
	public String save(@Valid Depense m, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormDepense";
                    
                }
                else{
                m.setDatedepense(new Date());
                depenseRepository.save(m);
		
		return "redirect:list";
                
                }
	}
        
           @RequestMapping(value="/list", method=RequestMethod.GET)
	        public String ListRecu(Model model,@RequestParam(name="page", defaultValue = "0")int p) {
                Page<Depense> lp = depenseRepository.findAll( new PageRequest(p, 15));
                int pagesCount = lp.getTotalPages();
                int [] pages = new int[pagesCount];
                for(int i=0; i<pagesCount; i++){
                    pages[i]=i;
                }
                model.addAttribute("pages", pages);  
		model.addAttribute("pagedepenses", lp);
                model.addAttribute("pageCourante", p);
		return "ListDepense";
	}
        
        @RequestMapping(value="/supprimer")
	public String supprimer(Long numerodepense) {
		
            depenseRepository.deleteById(numerodepense);
            
            return "redirect:list";
	}

    
}
