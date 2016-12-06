package com.cs.interaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.data.ForgotPwdData;
import com.cs.exception.TestFailException;
import com.cs.page.BasePage;
import com.cs.page.ForgotPwdPage;
import com.cs.util.Loader;
import com.cs.util.SnapshotUtil;



public class ForgotPwdInteraction extends ForgotPwdPage implements BasePage{
	
	private ForgotPwdData data;
	
	public ForgotPwdInteraction(WebDriver driver) {
		super(driver);
		this.data = Loader.suite.getForgotPwdData();
		
	}

	@Override
	public void openSite() {
		// TODO Auto-generated method stub
		driver.get("https://jazz.net/pub/user/password-reset-request.jsp");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRedirectSuccess() throws TestFailException {
		// TODO Auto-generated method stub
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.textToBePresentInElement(succsess_h1, "E-mail Sent"));
			return true;
			} catch (Exception e) {
				SnapshotUtil.snapshot(driver,"ForgotPwdPage");
				throw new TestFailException("invalid or empty of your user id and e-mail",e);
			}
		}
	
	public void fillForgotPwdForm(){
		Interaction.inputValue(RequestPasswordReset_userID, data.getRequestPasswordReset_userID());
		Interaction.inputValue(RequestPasswordReset_email, data.getRequestPasswordReset_email());
		submitResetPwd.click();
	}

}
