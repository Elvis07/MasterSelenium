package com.cs.bean;

public class Task {
	
	private int taskSeq;
	private String locator;
	private String inputValue;
	private String url;
	private String description;
	
	public Task() {
		super();
	}
	
	public int getTaskSeq() {
		return taskSeq;
	}
	public void setTaskSeq(int taskSeq) {
		this.taskSeq = taskSeq;
	}
	public String getLocator() {
		return locator;
	}
	public void setLocator(String locator) {
		this.locator = locator;
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
	
}
