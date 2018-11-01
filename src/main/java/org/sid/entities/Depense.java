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
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author babacar
 */
@Entity
public class Depense implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numerodepense;
    
    @NotEmpty
    private String commentaire;
    
    private double montantdepense;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date datedepense;

    public Depense() {
    }

    public Depense(String commentaire, double montantdepense, Date datedepense) {
        this.commentaire = commentaire;
        this.montantdepense = montantdepense;
        this.datedepense = datedepense;
    }

    public Long getNumerodepense() {
        return numerodepense;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public double getMontantdepense() {
        return montantdepense;
    }

    public Date getDatedepense() {
        return datedepense;
    }

    public void setNumerodepense(Long numerodepense) {
        this.numerodepense = numerodepense;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setMontantdepense(double montantdepense) {
        this.montantdepense = montantdepense;
    }

    public void setDatedepense(Date datedepense) {
        this.datedepense = datedepense;
    }

    
    
}
