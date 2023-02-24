package com.BottomFunnel.TravelFlap.Model;

import jakarta.validation.constraints.NotNull;

public class UserDtoMobile {
	@NotNull(message = "Mobile is mandatory")
	private String mobileNo;
	
	@NotNull(message = "Password is mandatory")
	private String password;


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
