/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author babacar
 */
@Controller
@RequestMapping(value="/AccueilSec")
public class AccueilSecController {
    
    
     @RequestMapping(value="/accueil", method=RequestMethod.GET)
	public String FormComptePatient(Model model) {
		
		return "AccueilSece";
	}
    
}
