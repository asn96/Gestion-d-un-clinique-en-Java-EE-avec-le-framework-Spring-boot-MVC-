/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sid.entities;

import com.sun.xml.internal.ws.developer.Serialization;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author babacar
 */
@Entity
public class Medecin implements Serializable{
    
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        @Id
        @NotEmpty
	private String matriculemedecin;
        @NotEmpty
	private String nommedecin;
        @NotEmpty
	private String prenommedecin;
        @NotEmpty
	private String datenaissance;
        @NotEmpty
	private String lieunaissance;
        @NotEmpty
	private String sexemedecin;
        @NotEmpty
	private String specialite;
        @NotEmpty
	private String adressemedecin;
        @NotEmpty
	private String telephonemedecin;
        @NotEmpty
        private String login;
        @NotEmpty
        private String password;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date  dateajout;
        
        
	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medecin(String matriculemedecin, String nommedecin, String prenommedecin, String datenaissance,
			String lieunaissance, String sexemedecin, String specialite, String adressemedecin,
			String telephonemedecin, String login, String password, Date dateajout) {
		super();
		this.matriculemedecin = matriculemedecin;
		this.nommedecin = nommedecin;
		this.prenommedecin = prenommedecin;
		this.datenaissance = datenaissance;
		this.lieunaissance = lieunaissance;
		this.sexemedecin = sexemedecin;
		this.specialite = specialite;
		this.adressemedecin = adressemedecin;
		this.telephonemedecin = telephonemedecin;
                this.login=login;
                this.password=password;
                this.dateajout=dateajout;
                
	}

        public Date getDateajout() {
            return dateajout;
        }

        public void setDateajout(Date dateajout) {
            this.dateajout = dateajout;
        }
        
        

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        
        
        
	public String getMatriculemedecin() {
		return matriculemedecin;
	}
	public void setMatriculemedecin(String matriculemedecin) {
		this.matriculemedecin = matriculemedecin;
	}
	public String getNommedecin() {
		return nommedecin;
	}
	public void setNommedecin(String nommedecin) {
		this.nommedecin = nommedecin;
	}
	public String getPrenommedecin() {
		return prenommedecin;
	}
	public void setPrenommedecin(String prenommedecin) {
		this.prenommedecin = prenommedecin;
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
	public String getSexemedecin() {
		return sexemedecin;
	}
	public void setSexemedecin(String sexemedecin) {
		this.sexemedecin = sexemedecin;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getAdressemedecin() {
		return adressemedecin;
	}
	public void setAdressemedecin(String adressemedecin) {
		this.adressemedecin = adressemedecin;
	}
	public String getTelephonemedecin() {
		return telephonemedecin;
	}
	public void setTelephonemedecin(String telephonemedecin) {
		this.telephonemedecin = telephonemedecin;
	}

 

}
