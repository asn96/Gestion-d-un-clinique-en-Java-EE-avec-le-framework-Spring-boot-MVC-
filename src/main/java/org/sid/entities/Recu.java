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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author babacar
 */
@Entity
public class Recu implements Serializable{
    
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numerorecu;
        @ManyToOne
        @JoinColumn(name="num_pa")
	private Patient patient;
        @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date daterecu;
        @DateTimeFormat(pattern="HH:mm:ss")
	private Date heurerecu;
        private double montantrecu;
	public Recu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recu(Patient patient, Date daterecu, Date heurerecu, double montantrecu) {
		super();
		this.patient = patient;
		this.daterecu = daterecu;
		this.heurerecu = heurerecu;
                this.montantrecu=montantrecu;
	}
	public Long getNumerorecu() {
		return numerorecu;
	}
	public void setNumerorecu(Long numerorecu) {
		this.numerorecu = numerorecu;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getDaterecu() {
		return daterecu;
	}
	public void setDaterecu(Date daterecu) {
		this.daterecu = daterecu;
	}
	public Date getHeurerecu() {
		return heurerecu;
	}
	public void setHeurerecu(Date heurerecu) {
		this.heurerecu = heurerecu;
	}

        public double getMontantrecu() {
            return montantrecu;
        }

        public void setMontantrecu(double montantrecu) {
            this.montantrecu = montantrecu;
        }
	
	
}
