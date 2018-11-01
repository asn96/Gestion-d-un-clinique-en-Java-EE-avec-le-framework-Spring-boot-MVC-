/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.web;

import org.sid.dao.DepenseRepository;
import org.sid.dao.RecuRepository;
import org.sid.dao.SoldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author babacar
 */
@Controller
@RequestMapping(value="/solde")
public class SoldeController {
    
    @Autowired
    private RecuRepository recuRepository;
    @Autowired
    private DepenseRepository depenseRepository;
    @Autowired
    private SoldeRepository soldeRepository;
    
    
}
