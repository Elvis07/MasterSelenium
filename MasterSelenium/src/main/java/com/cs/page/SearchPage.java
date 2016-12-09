package com.cs.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	@FindBy(id = "sandSearchButton")
	@CacheLookup
	public WebElement seachButton;

	@FindBy(id = "searchQueryBox")
	@CacheLookup
	public WebElement searchBox;
	
	@FindBy(id = "peopleDiv")
	@CacheLookup
	public WebElement divFilter;

	protected WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
