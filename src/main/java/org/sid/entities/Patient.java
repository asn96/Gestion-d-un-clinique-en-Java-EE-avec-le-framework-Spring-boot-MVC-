/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



/**
 *
 * @author babacar
 */
@Entity
public class Patient implements Serializable {
	

	private static final long serialVersionUID = 1L;
				@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		   private Long numeropatient;
                   @NotEmpty
		   private String nompatient;
                   @NotEmpty
		   private String prenompatient;
		   private String datenaissance;
		   private String lieunaissance;
                   @NotEmpty
		   private String sexepatient;
		   private String adressepatient;
		   private String telephonepatient;
                   @DateTimeFormat(pattern="yyyy-MM-dd")
                   private Date dateajout;

                        public Date getDateajout() {
                            return dateajout;
                        }

                        public void setDateajout(Date dateajout) {
                            this.dateajout = dateajout;
                        }
                   
                        
                       
   
		        public Long getNumeropatient() {
				return numeropatient;
			}
			
			public void setNumeropatient(Long numeropatient) {
				this.numeropatient = numeropatient;
			}
			
			public String getNompatient() {
				return nompatient;
			}
			
			public void setNompatient(String nompatient) {
				this.nompatient = nompatient;
			}
			
			public String getPrenompatient() {
				return prenompatient;
			}
			
			public void setPrenompatient(String prenompatient) {
				this.prenompatient = prenompatient;
			}
			
			public String getDatenaissance() {
				return datenaissance;
			}
			
			public void setDatenaissance(String datenaissance) {
				this.datenaissance = datenaissance;
			}
			
			public String getLieunaissance() {
				return lieunaissance;
			}
			
			public void setLieunaissance(String lieunaissance) {
				this.lieunaissance = lieunaissance;
			}
			
			public String getSexepatient() {
				return sexepatient;
			}
			
			public void setSexepatient(String sexepatient) {
				this.sexepatient = sexepatient;
			}
			
			public String getAdressepatient() {
				return adressepatient;
			}
			
			public void setAdressepatient(String adressepatient) {
				this.adressepatient = adressepatient;
			}
			
			public String getTelephonepatient() {
				return telephonepatient;
			}
			
			public void setTelephonepatient(String telephonepatient) {
				this.telephonepatient = telephonepatient;
			}
			
			public Patient(String nompatient, String prenompatient, String datenaissance, String lieunaissance,
					String sexepatient, String adressepatient, String telephonepatient, Date dateajout) {
				super();
				
				this.nompatient = nompatient;
				this.prenompatient = prenompatient;
				this.datenaissance = datenaissance;
				this.lieunaissance = lieunaissance;
				this.sexepatient = sexepatient;
				this.adressepatient = adressepatient;
				this.telephonepatient = telephonepatient;
                                this.dateajout=dateajout;
			}
			
			public Patient() {
				super();
				// TODO Auto-generated constructor stub
			  }
}
