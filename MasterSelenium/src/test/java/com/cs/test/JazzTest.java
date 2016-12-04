package com.cs.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.exception.TestFailException;
import com.cs.interaction.ForgotPwdInteraction;
import com.cs.interaction.LoginInteraction;
import com.cs.interaction.RegisterInteraction;

public class JazzTest extends SeleniumTest {

	RegisterInteraction regInteract;
	LoginInteraction logInteract;
	ForgotPwdInteraction pwdInteract;

	@Test(description = "test register")
	public void register() throws InterruptedException,TestFailException {

		regInteract = new RegisterInteraction(driver);
		regInteract.openSite();
		regInteract.fillForm();
		boolean isSuccess = regInteract.isRedirectSuccess();
		Assert.assertTrue(isSuccess);
	}
	
	@Test(description = "test login")
	public void login() throws InterruptedException,TestFailException {

		logInteract = new LoginInteraction(driver);
		logInteract.openSite();
		logInteract.login();
		boolean isSuccess = logInteract.isRedirectSuccess();
		Assert.assertTrue(isSuccess);
	}

	@Test(description = "test forgotPwd")
	public void forgotPwd() throws InterruptedException, TestFailException  {
		pwdInteract = new ForgotPwdInteraction(driver);
		pwdInteract.openSite();
		pwdInteract.forgotPwdForm();
		//
	}
}
