package com.cs.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cs.exception.ParseResultException;
import com.cs.interaction.RegisterInteraction;

public class JazzTest extends SeleniumTest {

	RegisterInteraction rp;

	@Test(description = "test register")
	public void register() throws InterruptedException, ParseResultException {

		rp = new RegisterInteraction(driver);
		rp.openSite();
		rp.fillForm();
		boolean isSuccess = rp.isRedirectSuccess();
		Assert.assertTrue(isSuccess);
	}

}
