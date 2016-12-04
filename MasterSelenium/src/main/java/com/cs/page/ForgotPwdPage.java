package com.cs.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPwdPage {
	
	@FindBy(id = "RequestPasswordReset_userID")
	@CacheLookup
	public WebElement RequestPasswordReset_userID;

	@FindBy(id = "RequestPasswordReset_email")
	@CacheLookup
	public WebElement RequestPasswordReset_email;

	//TODO as submit & change password
	@FindBy(id = "RequestPasswordReset_0")
	@CacheLookup
	public WebElement submitResetPwd;
	
	@FindBy(id = "title-profile")
	@CacheLookup
	public WebElement succsess_h1;


	protected WebDriver driver;

	public ForgotPwdPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
