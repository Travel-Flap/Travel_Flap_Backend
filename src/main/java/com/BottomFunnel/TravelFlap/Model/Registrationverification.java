package com.BottomFunnel.TravelFlap.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Registrationverification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
    private String verificationCode;
	     
	 private String enabled;
	 
	 
	 


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getVerificationCode() {
		return verificationCode;
	}


	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}


	public String isEnabled() {
		return enabled;
	}


	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}


	


	public Registrationverification(Integer id, String verificationCode, String enabled) {
		super();
		this.id = id;
		this.verificationCode = verificationCode;
		this.enabled = enabled;
		
	}


	public Registrationverification() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 
}
