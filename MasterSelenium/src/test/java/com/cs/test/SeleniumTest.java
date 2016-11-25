package com.cs.test;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cs.core.Executor;
import com.cs.util.Loader;
import com.cs.util.RemoteWebDriverUtil;

public class SeleniumTest {

	WebDriver driver;

	@Parameters({ "host", "browser", "xmlPath" }) //
	@BeforeTest
	public void beforeTest(String host, String browser, String xmlPath)
			throws InterruptedException, JAXBException, IOException {
		Loader.loadSuite(xmlPath);
		driver = RemoteWebDriverUtil.loadDriver(host, browser);
	}

	@Test
	public void test() throws InterruptedException {

		Executor.execute(driver);

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
