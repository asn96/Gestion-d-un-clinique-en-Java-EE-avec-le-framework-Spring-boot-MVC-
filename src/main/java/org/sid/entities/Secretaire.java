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
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author babacar
 */
@Entity
public class Secretaire  implements Serializable{
    
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        @Id
        @NotEmpty
	private String matriculesecretaire;
        @NotEmpty    
	private String nomsecretaire;
        @NotEmpty
	private String prenomsecretaire;
        @NotEmpty
	private String datenaissance;
        @NotEmpty
	private String lieunaissance;
        @NotEmpty
	private String sexesecretaire;
        @NotEmpty
	private String adressesecretaire;
        @NotEmpty
	private String telephonesecretaire;
        @NotEmpty
        private String login;
        @NotEmpty
        private String password;
        @DateTimeFormat(pattern="yyyy-MM-dd")
        private Date  dateajout;
	public Secretaire(String matriculesecretaire, String nomsecretaire, String prenomsecretaire, String datenaissance,
			String lieunaissance, String sexesecretaire, String adressesecretaire, String telephonesecretaire, String login, String password, Date dateajout) {
		super();
		this.matriculesecretaire = matriculesecretaire;
		this.nomsecretaire = nomsecretaire;
		this.prenomsecretaire = prenomsecretaire;
		this.datenaissance = datenaissance;
		this.lieunaissance = lieunaissance;
		this.sexesecretaire = sexesecretaire;
		this.adressesecretaire = adressesecretaire;
		this.telephonesecretaire = telephonesecretaire;
                this.login=login;
                this.password=password;
                this.dateajout=dateajout;
                
	}
	public Secretaire() {
		super();
		// TODO Auto-generated constructor stub
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
        
	public String getMatriculesecretaire() {
		return matriculesecretaire;
	}
	public void setMatriculesecretaire(String matriculesecretaire) {
		this.matriculesecretaire = matriculesecretaire;
	}
	public String getNomsecretaire() {
		return nomsecretaire;
	}
	public void setNomsecretaire(String nomsecretaire) {
		this.nomsecretaire = nomsecretaire;
	}
	public String getPrenomsecretaire() {
		return prenomsecretaire;
	}
	public void setPrenomsecretaire(String prenomsecretaire) {
		this.prenomsecretaire = prenomsecretaire;
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
	public String getSexesecretaire() {
		return sexesecretaire;
	}
	public void setSexesecretaire(String sexesecretaire) {
		this.sexesecretaire = sexesecretaire;
	}
	public String getAdressesecretaire() {
		return adressesecretaire;
	}
	public void setAdressesecretaire(String adressesecretaire) {
		this.adressesecretaire = adressesecretaire;
	}
	public String getTelephonesecretaire() {
		return telephonesecretaire;
	}
	public void setTelephonesecretaire(String telephonesecretaire) {
		this.telephonesecretaire = telephonesecretaire;
	}
}
