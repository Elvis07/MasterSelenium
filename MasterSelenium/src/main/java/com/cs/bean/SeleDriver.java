package com.cs.bean;

import org.openqa.selenium.WebDriver;

import com.cs.util.RemoteWebDriverUtil;

public class SeleDriver {

	public WebDriver driver;
	private String host;
	private String browser;

	public SeleDriver(String host, String browser) {
		super();
		this.driver = RemoteWebDriverUtil.loadDriver(host, browser);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

}
