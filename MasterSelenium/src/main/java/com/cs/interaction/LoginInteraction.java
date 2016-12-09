package com.cs.interaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.data.LoginData;
import com.cs.exception.TestFailException;
import com.cs.page.BasePage;
import com.cs.page.LoginPage;
import com.cs.util.Loader;
import com.cs.util.SnapshotUtil;

public class LoginInteraction extends LoginPage implements BasePage {

	private LoginData data;

	public LoginInteraction(WebDriver driver) {
		super(driver);
		this.data = Loader.suite.getLoginData();
	}

	@Override
	public void close() {

	}

	@Override
	public void openSite() {

		driver.get("http://jazz.net/");
	}
	
	public void login(){
		Interaction.clickAndWait(getLogin, 2000);
		Interaction.inputValue(userId,data.getUserid());
		Interaction.inputValue(password, data.getPassword());
		loginButton.click();
	}

	@Override
	public boolean isRedirectSuccess() throws TestFailException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.stalenessOf(getLogin));
			return true;
		} catch (Exception e) {
			SnapshotUtil.snapshot(driver,"LoginPage");
			throw new TestFailException("Invalid user ID or password",e);
		}
	}
	
	

}
