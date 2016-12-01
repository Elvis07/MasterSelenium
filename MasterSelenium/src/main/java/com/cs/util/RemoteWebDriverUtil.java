package com.cs.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverUtil {

	public static WebDriver loadDriver(String host, String browser) {

		if (browser.contains("chrome")) {
			return getChromeDriver(host);
		} else if (browser.contains("firefox")) {
			return getFirefoxDriver(host);
		} else if (browser.contains("ie")) {
			return getIEDriver(host);
		} else {
			return getPhanTomJsDriver(host);
		}
	}

	public static WebDriver getPhanTomJsDriver(String host) {

		DesiredCapabilities sCaps = DesiredCapabilities.phantomjs();
		sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, true);
		sCaps.setCapability("phantomjs.page.settings.loadImages", false);
		sCaps.setCapability("applicationCacheEnabled", false);
		sCaps.setJavascriptEnabled(true);
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(host), sCaps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static WebDriver getIEDriver(String host) {

		DesiredCapabilities sCaps = DesiredCapabilities.internetExplorer();
		sCaps.setCapability("ignoreZoomSetting", true);
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(host), sCaps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static WebDriver getChromeDriver(String host) {

		DesiredCapabilities sCaps = DesiredCapabilities.chrome();
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(host), sCaps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static WebDriver getFirefoxDriver(String host) {

		DesiredCapabilities sCaps = DesiredCapabilities.firefox();
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(host), sCaps);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void snapshot(TakesScreenshot drivername) {

		Date date = new Date();
		SimpleDateFormat df3 = new SimpleDateFormat("HH-mm-ss");
		String filename = df3.format(date) + ".png";
		// String currentPath = System.getProperty("user.dir"); // get current
		// System.out.println(currentPath);
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("save snapshot name is:" + filename);
			FileUtils.copyFile(scrFile, new File("D:\\snapshot" + "\\" + filename));
		} catch (IOException e) {
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished");
		}
	}

	public static String getGhostDriverPath() {

		return "D:\\ELVIS\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
	}
}
