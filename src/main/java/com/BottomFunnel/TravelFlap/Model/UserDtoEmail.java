package com.BottomFunnel.TravelFlap.Model;

import jakarta.validation.constraints.NotNull;

public class UserDtoEmail {
	@NotNull(message = "Email is mandatory")
	private String email;
	
	@NotNull(message = "Password is mandatory")
	private String password;


	public String getEmail() {
		return email;
	}


	public void setEmail(String mobileNo) {
		this.email = mobileNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
