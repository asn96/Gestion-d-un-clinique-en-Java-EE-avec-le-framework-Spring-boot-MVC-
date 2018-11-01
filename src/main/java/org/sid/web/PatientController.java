package org.sid.web;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.sid.dao.PatientRepository;
import org.sid.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/Patient")
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String FormPatient(Model model) {
		model.addAttribute("patient", new Patient());
		return "FormPatient";
	}
        @RequestMapping(value="/SavePatient", method=RequestMethod.POST)
	public String save(@Valid Patient p, BindingResult bindingResult, Model model) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormPatient";
                    
                }
                else{
                p.setDateajout(new Date());
                patientRepository.save(p);
                
            
		
		return "redirect:list";
                }
	}
        @RequestMapping(value="/list", method=RequestMethod.GET)
	public String ListPatient(Model model,@RequestParam(name="page", defaultValue = "0")int p) {
                Page<Patient> lp = patientRepository.findAll( new PageRequest(p, 15));
                int pagesCount = lp.getTotalPages();
                int [] pages = new int[pagesCount];
                for(int i=0; i<pagesCount; i++){
                    pages[i]=i;
                }
                model.addAttribute("pages", pages);  
		model.addAttribute("pagepatients", lp);
                model.addAttribute("pageCourante", p);
		return "ListPatient";
	}
        @RequestMapping(value="/supprimer")
	public String supprimer(Long numeropatient) {
		
            patientRepository.deleteById(numeropatient);
            
            return "redirect:list";
	}
        
        @RequestMapping(value="/editer")
	public String editer(Long numeropatient, Model model) {
		
            Patient pt = patientRepository.getOne(numeropatient);
            
            model.addAttribute("patient", pt);
            
            return "EditPatient";
	}
        
        @RequestMapping(value="/UpdatePatient", method=RequestMethod.POST)
	public String update(@Valid Patient p, BindingResult bindingResult) {
            
                if(bindingResult.hasErrors()){
                    
                    return "FormPatient";
                    
                }
                else{
                p.setDateajout(new Date());
                patientRepository.save(p);
            
		
		return "redirect:list";
                }
	}

    	@RequestMapping(value ="/" )

    	public String layout() {

    		return "layout" ;	
    }

    	@RequestMapping(value ="/Accueil" )

    	public String Accueil() {

    		return "Accueil" ;	
    }
    	

    	@RequestMapping(value ="/Conection" )

    	public String Conection() {

    		return "Conection" ;	
    }
    	
    	@RequestMapping(value ="/Secretaire" )

    	public String Secretaire() {

    		return "Secreetaire" ;	
    }


    	@RequestMapping(value ="/tarif" )

    	public String tarif() {

    		return "tarif" ;	
    }
    	@RequestMapping(value ="/heureDeVisite" )

    	public String heureDeVisite() {

    		return "heureDeVisite";
    	}
    	
    	@RequestMapping(value ="/services" )

    	public String services() {

    		return "services";
    	}
        
}
