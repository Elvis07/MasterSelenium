package com.cs.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.exception.TestFailException;
import com.cs.interaction.ForgotPwdInteraction;
import com.cs.interaction.LoginInteraction;
import com.cs.interaction.RegisterInteraction;
import com.cs.interaction.SearchInteraction;

public class JazzTest extends SeleniumTest {

	@Test(description = "test register")
	public void register() throws InterruptedException,TestFailException {

		RegisterInteraction regInteract = new RegisterInteraction(driver);
		regInteract.openSite();
		regInteract.fillForm();
		Assert.assertTrue(regInteract.isRedirectSuccess());
	}
	
	@Test(description = "test login")
	public void login() throws InterruptedException,TestFailException {

		LoginInteraction logInteract = new LoginInteraction(driver);
		logInteract.openSite();
		logInteract.login();
		Assert.assertTrue(logInteract.isRedirectSuccess());
	}

	@Test(description = "test forgotPwd")
	public void forgotPwd() throws InterruptedException, TestFailException  {
		ForgotPwdInteraction pwdInteract = new ForgotPwdInteraction(driver);
		pwdInteract.openSite();
		pwdInteract.fillForgotPwdForm();
		Assert.assertTrue(pwdInteract.isRedirectSuccess());
	}
	
	@Test(description = "test searching")
	public void search() throws InterruptedException, TestFailException  {
		
		SearchInteraction searchInteract = new SearchInteraction(driver);
		searchInteract.openSite();
		searchInteract.search();
		Assert.assertTrue(searchInteract.isRedirectSuccess());
	}
}
