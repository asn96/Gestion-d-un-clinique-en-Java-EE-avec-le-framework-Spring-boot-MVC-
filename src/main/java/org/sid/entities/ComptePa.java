/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author babacar
 */
@Entity
public class ComptePa implements Serializable{
    
    @Id
    private String login;
    
    private String password;
    
     @ManyToOne
    @JoinColumn(name="num_pa")
     private Patient patient;

    public ComptePa() {
    }

    public ComptePa(String login, String password, Patient patient) {
        this.login = login;
        this.password = password;
        this.patient = patient;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
     
     
     
}
