package com.BottomFunnel.TravelFlap.Model;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class CurrentUserSession {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique =true)
	private String userId;
	
	private String status;
	
	private LocalDateTime localDateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public CurrentUserSession(String userId, String status, LocalDateTime localDateTime) {
		super();
		this.userId = userId;
		this.status = status;
		this.localDateTime = localDateTime;
	}

	public CurrentUserSession() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
