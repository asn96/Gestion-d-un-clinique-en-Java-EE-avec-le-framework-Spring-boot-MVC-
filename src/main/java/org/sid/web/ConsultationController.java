/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.web;

import java.util.Date;
import javax.validation.Valid;
import org.sid.dao.ConsultationRepository;
import org.sid.entities.Consultation;
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
@RequestMapping(value="/Consultation")
public class ConsultationController {
    
    @Autowired
    private ConsultationRepository consultationRepository;
    
       @RequestMapping(value="/form", method=RequestMethod.GET)
	public String FormPatient(Model model) {
		model.addAttribute("consultation", new Consultation());
		return "FormConsultation";
	}
        @RequestMapping(value="/SaveConsultation", method=RequestMethod.POST)
	public String save(@Valid Consultation m, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormConsultation";
                    
                }
                else{
                m.setDateajout(new Date());
                
                consultationRepository.save(m);
		
		return "redirect:list";
                
                }
	}
        
        @RequestMapping(value="/list", method=RequestMethod.GET)
	public String ListConsultation(Model model,@RequestParam(name="page", defaultValue = "0")int p) {
                Page<Consultation> lp = consultationRepository.findAll( new PageRequest(p, 15));
                int pagesCount = lp.getTotalPages();
                int [] pages = new int[pagesCount];
                for(int i=0; i<pagesCount; i++){
                    pages[i]=i;
                }
                model.addAttribute("pages", pages);  
		model.addAttribute("pageconsultations", lp);
                model.addAttribute("pageCourante", p);
		return "ListConsultation";
	}
        @RequestMapping(value="/supprimer")
	public String supprimer(Long numeroconsultation) {
		
            consultationRepository.deleteById(numeroconsultation);
            
            return "redirect:list";
	}
         @RequestMapping(value="/editer")
	public String editer(Long numeroconsultation, Model model) {
		
            Consultation pt = consultationRepository.getOne(numeroconsultation);
            
            model.addAttribute("consultation", pt);
            
            return "EditConsultation";
	}
        @RequestMapping(value="/UpdateConsultation", method=RequestMethod.POST)
	public String update(@Valid Consultation p, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormConsultation";
                    
                }
                else{
                p.setDateajout(new Date());
                consultationRepository.save(p);
            
		return "redirect:list";
                }
	}
    
}
