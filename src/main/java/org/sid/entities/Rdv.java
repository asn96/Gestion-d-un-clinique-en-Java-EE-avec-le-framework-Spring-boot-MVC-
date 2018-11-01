/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author babacar
 */
@Entity
public class Rdv implements Serializable{
    
    
       /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numerordv;
	@ManyToOne
	@JoinColumn(name="num_pa")
	private Patient patient;
     
	private String daterdv;
      
	private String heurerdv;
	public Rdv() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rdv(Patient patient,  String daterdv, String heurerdv) {
		super();
	
		this.patient = patient;
		
		this.daterdv = daterdv;
		this.heurerdv = heurerdv;
	}
	public Long getNumerordv() {
		return numerordv;
	}
	public void setNumerordv(Long numerordv) {
		this.numerordv = numerordv;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public String getDaterdv() {
		return daterdv;
	}
	public void setDaterdv(String daterdv) {
		this.daterdv = daterdv;
	}
	public String getHeurerdv() {
		return heurerdv;
	}
	public void setHeurerdv(String heurerdv) {
		this.heurerdv = heurerdv;
	}
	
}
