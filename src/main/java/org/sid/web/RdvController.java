/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.web;

import java.util.Date;
import javax.validation.Valid;
import org.sid.dao.RdvRepository;
import org.sid.entities.Rdv;
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
@RequestMapping(value="/Rdv")
public class RdvController {
    
        @Autowired
	private RdvRepository rdvRepository;
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String FormRdv(Model model) {
		model.addAttribute("rdv", new Rdv());
		return "FormRdv";
	}
        @RequestMapping(value="/SaveRdv", method=RequestMethod.POST)
	public String save(@Valid Rdv r, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormRdv";
                    
                }
                else{
                
                rdvRepository.save(r);
            
		return "redirect:list";
                }
	}
        @RequestMapping(value="/list", method=RequestMethod.GET)
	public String ListRdv(Model model,@RequestParam(name="page", defaultValue = "0")int p) {
                Page<Rdv> lp = rdvRepository.findAll( new PageRequest(p, 15));
                int pagesCount = lp.getTotalPages();
                int [] pages = new int[pagesCount];
                for(int i=0; i<pagesCount; i++){
                    pages[i]=i;
                }
                model.addAttribute("pages", pages);  
		model.addAttribute("pagerdvs", lp);
                model.addAttribute("pageCourante", p);
		return "ListRdv";
	}
        @RequestMapping(value="/supprimer")
	public String supprimer(Long numerordv) {
		
            rdvRepository.deleteById(numerordv);
            
            return "redirect:list";
	}
         @RequestMapping(value="/editer")
	public String editer(Long numerordv, Model model) {
		
            Rdv pt = rdvRepository.getOne(numerordv);
            
            model.addAttribute("rdv", pt);
            
            return "EditRdv";
	}
        @RequestMapping(value="/UpdateRdv", method=RequestMethod.POST)
	public String update(@Valid Rdv p, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormRdv";
                    
                }
                else{
               
                rdvRepository.save(p);
            
		return "redirect:list";
                }
	}
}
