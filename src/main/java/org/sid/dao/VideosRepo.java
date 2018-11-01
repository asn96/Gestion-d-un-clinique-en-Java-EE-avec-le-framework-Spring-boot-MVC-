/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.dao;

import org.sid.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author babacar
 */
public interface VideosRepo extends JpaRepository<Medecin, String>{
    
     @Query("select e from Medecin e where(e.login=:x AND e.password=:y)")
      public Medecin chercher(@Param("x")String login, @Param("y")String password);
    
}
