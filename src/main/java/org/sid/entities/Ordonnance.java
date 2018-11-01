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

/**
 *
 * @author babacar
 */
@Entity
public class Ordonnance implements Serializable{
   
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroordonnance;
	@ManyToOne
	@JoinColumn(name="mat_med")
	private Medecin medecin;
	@ManyToOne
	@JoinColumn(name="num_pa")
	private Patient patient;
	private Date dateordonnance;
	private String contenu;
	public Ordonnance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ordonnance(Medecin medecin, Patient patient, Date dateordonnance, String contenu) {
		super();
	
		this.medecin = medecin;
		this.patient = patient;
		this.dateordonnance = dateordonnance;
		this.contenu = contenu;
	}
	public Long getNumeroordonnance() {
		return numeroordonnance;
	}
	public void setNumeroordonnance(Long numeroordonnance) {
		this.numeroordonnance = numeroordonnance;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getDateordonnance() {
		return dateordonnance;
	}
	public void setDateordonnance(Date dateordonnance) {
		this.dateordonnance = dateordonnance;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
}
