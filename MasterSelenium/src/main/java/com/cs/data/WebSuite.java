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

	public RegisterData getRegiterdata() {
		return regiterdata;
	}

	public void setRegiterdata(RegisterData regiterdata) {
		this.regiterdata = regiterdata;
	}

	public WebSuite() {
		super();
	}

}
