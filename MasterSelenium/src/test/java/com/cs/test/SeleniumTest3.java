package com.cs.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cs.util.RemoteWebDriverUtil;
import com.thoughtworks.selenium.Selenium;

public class SeleniumTest3 {

	public WebDriver driver;
	String url = "https://jazz.net/action/register";
	String number = "97564765";

	@Parameters("browser")
	// @Parameters( { "host", "browser", "xmlPath"})// 按先后顺序
	@BeforeTest
	public void beforeTest(String browser) throws MalformedURLException, InterruptedException {

		String Node = "http://10.222.48.46:5555/wd/hub";
		// String Node = "http://10.222.47.44:5555/wd/hub";
		browser = "chrome";
		DesiredCapabilities cap = null;
		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			driver = new RemoteWebDriver(new URL(Node), cap);
		} else if (browser.equalsIgnoreCase("chrome")) {

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\chromedriver.exe");
			// System.setProperty("webdriver.chrome.bin", "C:\\Program Files
			// (x86)\\Google\\Chrome\\Application\\chrome.exe");
			System.out.println(" Executing on CHROME");
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			driver = new RemoteWebDriver(new URL(Node), cap);
		} else if (browser.equalsIgnoreCase("ie")) {

			// System.setProperty("webdriver.ie.bin", "C:\\Program
			// Files\\Internet Explorer\\iexplore.exe");
			// System.setProperty("webdriver.ie.driver",
			// "D:\\IEDriverServer.exe");
			System.out.println(" Executing on IE");
			cap = DesiredCapabilities.internetExplorer();
			cap.setCapability("ignoreZoomSetting", true);
			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			// cap.setBrowserName("internet explorer");
			// cap.setVersion("11");
			// cap.setPlatform(Platform.ANY);
			driver = new RemoteWebDriver(new URL(Node), cap);
			// driver = new InternetExplorerDriver();
		} else {
			cap = DesiredCapabilities.phantomjs();
			cap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, true);
			// cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,RemoteWebDriverUtil.getGhostDriverPath());
			driver = new PhantomJSDriver(cap);
		}

	}

	@Test
	public void test() {

		driver.manage().window().maximize();
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement country = driver.findElement(By.xpath("//input[@id='userId']"));
		country.sendKeys("dd");
		WebElement country1 = driver.findElement(By.xpath("//input[@id='termsAgreed1']"));
		country1.click();

		// WebElement country =
		// driver.findElement(By.id("countryResidence"));//Find按钮
		// Select select=new Select(country);
		// select.selectByValue("China");
		// select.selectByIndex(2);
		// select.deselectByIndex(2);
		// select.selectByVisibleText("Angola");
		// input[@id='userId']

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
