//package com.BottomFunnel.TravelFlap.Model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//@Entity
//public class UserVerificationCode {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer iD;
//	@Column(unique =true)
//	private String userId;
//	private String uUID;
//	
//	public UserVerificationCode() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public UserVerificationCode(String userId, String uUID) {
//		super();
//		this.userId = userId;
//		this.uUID = uUID;
//	}
//	public Integer getiD() {
//		return iD;
//	}
//	public void setiD(Integer iD) {
//		this.iD = iD;
//	}
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	public String getuUID() {
//		return uUID;
//	}
//	public void setuUID(String uUID) {
//		this.uUID = uUID;
//	}
//
//	
//	
//}
