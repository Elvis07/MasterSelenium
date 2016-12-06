package com.cs.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SearchData {
	
	@XmlElement(name = "SearchingValue")
	public String searingValue;

	public String getSearingValue() {
		return searingValue;
	}

	public void setSearingValue(String searingValue) {
		this.searingValue = searingValue;
	}
	
	

}
