//package com.cs.test;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.StringReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.cs.bean.Case;
//import com.cs.bean.WebSuite;
//import com.cs.util.RemoteWebDriverUtil;
//import com.cs.util.SnapshotUtil;
//import com.cs.util.XMLUtils;
//
//public class SeleniumTest2 {
//
//	
//	public WebDriver driver;
//	String url = "https://www.hapag-lloyd.com/en/online-business/tracing/tracing-by-booking.html";
//	String number = "97564765";
//
//	// @Parameters( { "url", "query-string", "btn-id", "txt-id", "verify-String"
//	// }) 按先后顺序
//	
//	
//	@Parameters("xmlPath")
//	@BeforeTest
//	public void beforeTest(String xmlPath) throws InterruptedException, IOException {
//
//
//		String Node = "http://10.222.48.46:5555/wd/hub";
//
//		DesiredCapabilities cap = null;
//			System.out.println(" Executing on FireFox");
//			cap = DesiredCapabilities.firefox();
//			cap.setBrowserName("firefox");
//			driver = new RemoteWebDriver(new URL(Node), cap);
//			/*
//		} else if (browser.equalsIgnoreCase("chrome")) {
//
//			// System.setProperty("webdriver.chrome.driver",
//			// "C:\\chromedriver.exe");
//			// System.setProperty("webdriver.chrome.bin", "C:\\Program Files
//			// (x86)\\Google\\Chrome\\Application\\chrome.exe");
//			System.out.println(" Executing on CHROME");
//			cap = DesiredCapabilities.chrome();
//			cap.setBrowserName("chrome");
//			driver = new RemoteWebDriver(new URL(Node), cap);
//		} else if (browser.equalsIgnoreCase("ie")) {
//
//			// System.setProperty("webdriver.ie.bin", "C:\\Program
//			// Files\\Internet Explorer\\iexplore.exe");
//			// System.setProperty("webdriver.ie.driver",
//			// "D:\\IEDriverServer.exe");
//			System.out.println(" Executing on IE");
//			cap = DesiredCapabilities.internetExplorer();
//			cap.setCapability("ignoreZoomSetting", true);
//			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//			// cap.setBrowserName("internet explorer");
//			// cap.setVersion("11");
//			// cap.setPlatform(Platform.ANY);
//			driver = new RemoteWebDriver(new URL(Node), cap);
//			// driver = new InternetExplorerDriver();
//		} else {
//			cap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, true);
//			cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
//					RemoteWebDriverUtil.getGhostDriverPath());
//			driver = new PhantomJSDriver(cap);
//		}
//*/
//	}
//
//	@Test
//	public void test() {
//
//		driver.manage().window().maximize();
//		driver.get(url);
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tracing_by_booking_f:hl10")));// 等待网页响应完成，这里以Booking
//																									// No.的label出现算ok
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tracing_by_booking_f:hl10")));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tracing_by_booking_f:hl10")));
//		WebElement findButton = driver.findElement(By.xpath("//input[@id='tracing_by_booking_f:hl18']"));// Find按钮
//		WebElement bookingInput = driver.findElement(By// Booking No.输入框
//				.xpath("//input[@id='tracing_by_booking_f:hl12']"));
//		// 输入框输入number
//		jse.executeScript("arguments[0].setAttribute('value', arguments[1])", bookingInput, number);// bookingInput.sendKeys(number);
//		// 点击Find按钮
//		jse.executeScript("arguments[0].click();", findButton); // findButton.click();
//		wait.until(
//				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='tracing_by_booking_f:hl27:hl53']")));// 等待Details按钮
//
//		WebElement trEle = driver.findElement(By.className("hal-table-body")).findElements(By.tagName("tr")).get(0)
//				.findElements(By.tagName("td")).get(0).findElement(By.tagName("input"));// 第一个单选按钮
//		trEle.click();
//		Actions action = new Actions(driver);
//		action.clickAndHold();
//		Assert.assertTrue(trEle.isSelected());
//		SnapshotUtil.snapshot(driver);
//
//		System.out.println("url: " + driver.getCurrentUrl());
//
//	}
//
//	@AfterTest
//	public void afterTest() {
//		driver.close();
//	}
//
//}
