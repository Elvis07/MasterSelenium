package com.cs.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ForgotPwdData {

	@XmlElement(name = "RequestPasswordReset_userID")
	public String RequestPasswordReset_userID;
	@XmlElement(name = "RequestPasswordReset_email")
	public String RequestPasswordReset_email;
	
	
	public String getRequestPasswordReset_userID() {
		return RequestPasswordReset_userID;
	}
	public void setRequestPasswordReset_userID(String requestPasswordReset_userID) {
		RequestPasswordReset_userID = requestPasswordReset_userID;
	}
	public String getRequestPasswordReset_email() {
		return RequestPasswordReset_email;
	}
	public void setRequestPasswordReset_email(String requestPasswordReset_email) {
		RequestPasswordReset_email = requestPasswordReset_email;
	}
	
	
}
