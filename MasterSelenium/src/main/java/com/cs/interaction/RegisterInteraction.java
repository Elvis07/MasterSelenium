package com.cs.interaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.data.RegisterData;
import com.cs.exception.TestFailException;
import com.cs.page.BasePage;
import com.cs.page.RegisterPage;
import com.cs.util.Loader;
import com.cs.util.SnapshotUtil;

public class RegisterInteraction extends RegisterPage implements BasePage {

	private RegisterData data;

	public RegisterInteraction(WebDriver driver) {
		super(driver);
		this.data = Loader.suite.getRegiterdata();
	}

	public void fillForm() {

		Interaction.inputValue(firstname, data.getFirstName());
		Interaction.inputValue(lastname, data.getLastName());
		Interaction.inputValue(email, data.getEmail());
		Interaction.inputValue(telephone, data.getTelephone());
		Interaction.selectByValue(country, data.getCountry());
		Interaction.selectByValue(state, data.getState());
		Interaction.inputValue(company, data.getCompany());
		Interaction.inputValue(userid, data.getUserid());
		Interaction.inputValue(password1, data.getPassword1());
		Interaction.inputValue(password2, data.getPassword2());
		byEmail.click();
		byTelephone.click();
		agree.click();
		submit.click();

	}

	@Override
	public void close() {

	}

	@Override
	public void openSite() {

		driver.get("https://jazz.net/action/register");
	}

	@Override
	public boolean isRedirectSuccess() throws TestFailException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.stalenessOf(byEmail));
			return true;
		} catch (Exception e) {
			SnapshotUtil.snapshot(driver,"RegisterPage");
			throw new TestFailException("Form Dada are wrong",e);
		}
	}
	
	

}
