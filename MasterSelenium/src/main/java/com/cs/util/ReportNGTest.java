package com.cs.util;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReportNGTest {

	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	}

	@Test
	public void Open1() throws InterruptedException {

		// System.setProperty("webdriver.friefox.bin", "C:\\Program
		// Files\\Mozilla Firefox\\friefox.exe");
		//
		// FirefoxProfile fp = new FirefoxProfile();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("testerhome");

	}

	@Test
	public void Open() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("testerhome");
		Reporter.log("测试1通过");

	}

	@Test
	public void Open11() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("kw")).sendKeys("testerhome");
		Reporter.log("测试2通过");

	}

	@Test
	public void Open2() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.findElement(By.id("k1w")).sendKeys("testerhome");
		Reporter.log("测试3通过");

	}

	@After

	public void quit() throws InterruptedException {

		driver.quit();

	}

}