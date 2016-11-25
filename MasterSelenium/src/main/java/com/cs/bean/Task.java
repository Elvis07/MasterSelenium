package com.cs.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Task {

	@XmlElement(name = "TaskSequence")
	public int taskSeq;
	@XmlElement(name = "Element")
	public Element element;
	@XmlElement(name = "InputValue")
	public String inputValue;
	@XmlElement(name = "Url")
	public String url;
	@XmlElement(name = "Description")
	public String description;
	@XmlElement(name = "ScrollFrom")
	public String scrollFrom;
	@XmlElement(name = "ScrollTo")
	public String scrollTo;

	public Task() {
		super();
	}

	public int getTaskSeq() {
		return taskSeq;
	}

	public void setTaskSeq(int taskSeq) {
		this.taskSeq = taskSeq;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public String getInputValue() {
		return inputValue;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScrollFrom() {
		return scrollFrom;
	}

	public void setScrollFrom(String scrollFrom) {
		this.scrollFrom = scrollFrom;
	}

	public String getScrollTo() {
		return scrollTo;
	}

	public void setScrollTo(String scrollTo) {
		this.scrollTo = scrollTo;
	}

}
