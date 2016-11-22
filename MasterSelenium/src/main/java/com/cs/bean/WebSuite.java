package com.cs.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "WebSuite")
public class WebSuite {
	
	@XmlElement(name="WebCase")
	public List<WebCase> cases;

	public WebSuite() {
		super();
	}
	
	public List<WebCase> getCases() {
		return cases;
	}

	public void setCases(List<WebCase> cases) {
		this.cases = cases;
	}
	
}
