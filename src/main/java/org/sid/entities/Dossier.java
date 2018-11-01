/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author babacar
 */
@Entity
public class Dossier implements Serializable{
    
    	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        @Id
        @NotEmpty
	private String numerodossier;
	private Date datecreation;
	@ManyToOne
	@JoinColumn(name="num_pa")
	private Patient patient;
        @NotEmpty
	private String motif;
        @NotEmpty
	private String histoire;
        @NotEmpty
	private String antecedents;
        @NotEmpty
	private String examen;
	public Dossier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dossier(String numerodossier, Date datecreation, Patient patient, String motif, String histoire,
			String antecedents, String examen) {
		super();
		this.numerodossier = numerodossier;
		this.datecreation = datecreation;
		this.patient = patient;
		this.motif = motif;
		this.histoire = histoire;
		this.antecedents = antecedents;
		this.examen = examen;
	}
	public String getNumerodossier() {
		return numerodossier;
	}
	public void setNumerodossier(String numerodossier) {
		this.numerodossier = numerodossier;
	}
	public Date getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getHistoire() {
		return histoire;
	}
	public void setHistoire(String histoire) {
		this.histoire = histoire;
	}
	public String getAntecedents() {
		return antecedents;
	}
	public void setAntecedents(String antecedents) {
		this.antecedents = antecedents;
	}
	public String getExamen() {
		return examen;
	}
	public void setExamen(String examen) {
		this.examen = examen;
	}
}
