/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.dao;

import org.sid.entities.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author babacar
 */
public interface DossierRepository extends JpaRepository<Dossier, String>{
    
}
