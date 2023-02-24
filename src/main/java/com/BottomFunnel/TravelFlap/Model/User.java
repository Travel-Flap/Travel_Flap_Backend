package com.BottomFunnel.TravelFlap.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//@NotNull(message = "Name is mandatory")
	private String name;
	
	//@Size(max = 10,min = 10)
	private String mobileNo;
	
	
	//@NotNull(message = "Email is mandatory")
	private String email;
	
	//@NotNull(message = "Password is mandatory")
	private String password;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Integer id, @NotNull(message = "Name is mandatory") String name,
			@Size(max = 10, min = 10) String mobileNo, @NotNull(message = "Email is mandatory") String email,
			@NotNull(message = "Password is mandatory") String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
