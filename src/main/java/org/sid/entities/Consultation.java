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
public class Consultation implements Serializable {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroconsultation;
    @ManyToOne
    @JoinColumn(name="num_pa")
    private Patient patient;
 
    private String Motif;
    
    private String diagnostic;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateajout;

    public Long getNumeroconsultation() {
        return numeroconsultation;
    }

    public Patient getPatient() {
        return patient;
    }

  

    public String getMotif() {
        return Motif;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public Date getDateajout() {
        return dateajout;
    }

    public void setNumeroconsultation(Long numeroconsultation) {
        this.numeroconsultation = numeroconsultation;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

   

    public void setMotif(String Motif) {
        this.Motif = Motif;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    public Consultation() {
    }

    public Consultation(Patient patient, String Motif, String diagnostic, Date dateajout) {
        this.patient = patient;
        this.Motif = Motif;
        this.diagnostic = diagnostic;
        this.dateajout = dateajout;
    }
    
    
    
    
}
