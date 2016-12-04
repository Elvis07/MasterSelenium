package com.cs.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "WebSuite")
public class WebSuite {

	@XmlElement(name = "RegisterData")
	public RegisterData regiterdata;
	
	@XmlElement(name = "LoginData")
	public LoginData loginData;
	
	@XmlElement(name = "ForgotPwdData")
	public ForgotPwdData forgotPwdData;

	public RegisterData getRegiterdata() {
		return regiterdata;
	}

	public void setRegiterdata(RegisterData regiterdata) {
		this.regiterdata = regiterdata;
	}

	public LoginData getLoginData() {
		return loginData;
	}

	public void setLoginData(LoginData loginData) {
		this.loginData = loginData;
	}

	public ForgotPwdData getForgotPwdData() {
		return forgotPwdData;
	}

	public void setForgotPwdData(ForgotPwdData forgotPwdData) {
		this.forgotPwdData = forgotPwdData;
	}

	public WebSuite() {
		super();
	}

}
