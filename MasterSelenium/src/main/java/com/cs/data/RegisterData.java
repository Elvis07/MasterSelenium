package com.cs.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class RegisterData {

	@XmlElement(name = "FirstName")
	public String firstName;
	@XmlElement(name = "LastName")
	public String lastName;
	@XmlElement(name = "Email")
	public String email;
	@XmlElement(name = "Telephone")
	public String telephone;
	@XmlElement(name = "Country")
	public String country;
	@XmlElement(name = "State")
	public String state;
	@XmlElement(name = "Company")
	public String company;
	@XmlElement(name = "UserID")
	public String userid;
	@XmlElement(name = "Password1")
	public String password1;
	@XmlElement(name = "Password2")
	public String password2;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public RegisterData() {
		super();
	}

}
