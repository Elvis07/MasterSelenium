package com.cs.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "user-id")
	@CacheLookup
	public WebElement userId;
	
	@FindBy(id = "pass-word")
	@CacheLookup
	public WebElement password;
	
	@FindBy(id = "log-in-button")
	@CacheLookup
	public WebElement getLogin;
	
	@FindBy(xpath = "//button[contains(@class,'jazz')]")
	@CacheLookup
	public WebElement loginButton;

	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
