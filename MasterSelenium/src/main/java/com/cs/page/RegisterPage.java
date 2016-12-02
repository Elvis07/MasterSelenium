package com.cs.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cs.util.RemoteWebDriverUtil;

import bsh.commands.dir;

public class RegisterPage {

	@FindBy(id = "firstname")
	@CacheLookup
	public WebElement firstname;

	@FindBy(id = "lastname")
	@CacheLookup
	public WebElement lastname;

	@FindBy(id = "emailAddress")
	@CacheLookup
	public WebElement email;

	@FindBy(id = "phone")
	@CacheLookup
	public WebElement telephone;

	@FindBy(id = "countryResidence")
	@CacheLookup
	public WebElement country;

	@FindBy(id = "state")
	@CacheLookup
	public WebElement state;

	@FindBy(id = "companyName")
	@CacheLookup
	public WebElement company;

	@FindBy(id = "userId")
	@CacheLookup
	public WebElement userid;

	@FindBy(id = "password1")
	@CacheLookup
	public WebElement password1;

	@FindBy(id = "password2")
	@CacheLookup
	public WebElement password2;

	@FindBy(id = "NC_CHECK_EMAIL")
	@CacheLookup
	public WebElement byEmail;

	@FindBy(id = "NC_CHECK_PHONE")
	@CacheLookup
	public WebElement byTelephone;

	@FindBy(id = "termsAgreed1")
	@CacheLookup
	public WebElement agree;

	@FindBy(id = "submit1")
	@CacheLookup
	public WebElement submit;

	protected WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
