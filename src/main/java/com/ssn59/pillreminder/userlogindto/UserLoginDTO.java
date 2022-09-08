package com.ssn59.pillreminder.userlogindto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserLoginDTO {

	private String fullname;

	private String email;

	private String phone;
	private String country;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date DOB;
	private String pass;

	public UserLoginDTO() {
	}

	public UserLoginDTO(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	public UserLoginDTO(String fullname, String email, String phone, String country, Date dOB, String pass) {

		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.country = country;
		DOB = dOB;
		this.pass = pass;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
