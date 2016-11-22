package com.cs.test;

import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cs.util.Loader;
import com.cs.util.SnapshotUtil;

public class SeleniumTest {

	public WebDriver driver;
	String url = "https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html";
	String number = "97564765";


	@Parameters("xmlPath")
	@BeforeTest
	public void beforeTest(String xmlPath) throws InterruptedException, IOException, JAXBException {

		Loader.loadSuite(xmlPath);

		String Node = "http://10.222.48.46:5555/wd/hub";
		DesiredCapabilities cap = null;
		System.out.println(" Executing on FireFox");
		cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		driver = new RemoteWebDriver(new URL(Node), cap);
	}

	@Test
	public void test() {

		driver.manage().window().maximize();
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tracing_by_booking_f:hl10")));// 等待网页响应完成，这里以Booking
																									// No.的label出现算ok
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tracing_by_booking_f:hl10")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tracing_by_booking_f:hl10")));
		WebElement findButton = driver.findElement(By.xpath("//input[@id='tracing_by_booking_f:hl18']"));// Find按钮
		WebElement bookingInput = driver.findElement(By// Booking No.输入框
				.xpath("//input[@id='tracing_by_booking_f:hl12']"));
		// 输入框输入number
		jse.executeScript("arguments[0].setAttribute('value', arguments[1])", bookingInput, number);// bookingInput.sendKeys(number);
		// 点击Find按钮
		jse.executeScript("arguments[0].click();", findButton); // findButton.click();
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='tracing_by_booking_f:hl27:hl53']")));// 等待Details按钮

		WebElement trEle = driver.findElement(By.className("hal-table-body")).findElements(By.tagName("tr")).get(0)
				.findElements(By.tagName("td")).get(0).findElement(By.tagName("input"));// 第一个单选按钮
		trEle.click();
		Actions action = new Actions(driver);
		action.clickAndHold();
		Assert.assertTrue(trEle.isSelected());
		SnapshotUtil.snapshot(driver);

		System.out.println("url: " + driver.getCurrentUrl());

	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
