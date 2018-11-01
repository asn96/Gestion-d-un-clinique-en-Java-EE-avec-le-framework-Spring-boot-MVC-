/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solde implements Serializable{
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsolde;
    private double montantsolde;
    private Date dateajout;

    public Solde() {
    }

    public Solde(double montantsolde, Date dateajout) {
        this.montantsolde = montantsolde;
        this.dateajout = dateajout;
    }

    public Long getIdsolde() {
        return idsolde;
    }

    public double getMontantsolde() {
        return montantsolde;
    }

    public Date getDateajout() {
        return dateajout;
    }

    public void setIdsolde(Long idsolde) {
        this.idsolde = idsolde;
    }

    public void setMontantsolde(double montantsolde) {
        this.montantsolde = montantsolde;
    }

    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }
    
    
    
}
