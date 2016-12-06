package com.cs.test;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.cs.util.DriverFactory;
import com.cs.util.Loader;

public class SeleniumTest {

	protected WebDriver driver;

	@Parameters({ "host", "browser", "dataPath" })
	@BeforeTest
	public void beforeTest(String host, String browser, String path)
			throws InterruptedException, JAXBException, IOException {
		Loader.loadSuite(path);
		driver = DriverFactory.getRemoteDriver(host, browser);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		driver.quit();
	}


}
