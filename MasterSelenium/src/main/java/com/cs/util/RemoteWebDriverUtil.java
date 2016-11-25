package com.cs.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverUtil {
	static DesiredCapabilities sCaps = null;
	static String Host = null;
	static String PhanTomJsPath = null;
	static String GhostPath = null;
//	public static WebDriver driver;



	public static  WebDriver loadDriver(String host, String browser) {
		if (browser.contains("chrome")) {
			return getChromeDriver(host);
		} else if (browser.contains("firefox")) {
			return getFirefoxDriver(host);
		}
		return null;

	}

	private static void getProperties() throws IOException {
		Host = System.getProperty("selenium");
		PhanTomJsPath = System.getProperty("phantomjs");

		if (Host == null || PhanTomJsPath == null) {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("selenium.properties");
			Properties prop = new Properties();
			prop.load(is);
			Host = prop.getProperty("URL");
			PhanTomJsPath = prop.getProperty("PhanTomJsPath");
		}
	}

	private static String getPhanTomJsDriverPath() {
		return PhanTomJsPath;
	}

	private static String getHost() {
		return Host;
	}

	public static WebDriver getPhanTomJsDriver() throws IOException {
		sCaps = DesiredCapabilities.phantomjs();
		sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, true);
		sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, getPhanTomJsDriverPath());
		sCaps.setCapability("phantomjs.page.settings.loadImages", false);
		sCaps.setCapability("applicationCacheEnabled", false);

		sCaps.setJavascriptEnabled(true);
		// sCaps.setCapability("phantomjs.page.settings.userAgent",UserAgentUtil.getOneUserAgent());
		// String proxy = "176.9.134.141:3128";
		// org.openqa.selenium.Proxy p = new org.openqa.selenium.Proxy();
		// p.setHttpProxy(proxy).setFtpProxy(proxy).setSslProxy(proxy);
		// sCaps.setCapability(CapabilityType.PROXY, p);
		// sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_CUSTOMHEADERS_PREFIX
		// + "Referer",
		// "https://www.hapag-lloyd.com/en/tracing/by_booking.html");
		// sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_CUSTOMHEADERS_PREFIX
		// + "Host",
		// "www.hapag-lloyd.com");
		// sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_CUSTOMHEADERS_PREFIX
		// + "Accept",
		// "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		WebDriver driver = new RemoteWebDriver(new URL(getHost()), sCaps);

		// driver.manage().timeouts().setScriptTimeout(-1, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(-1, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(-1, TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver getIEDriver() throws IOException {
		sCaps = DesiredCapabilities.internetExplorer();
		sCaps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		sCaps.setBrowserName("internet explorer");
		sCaps.setVersion("9");
		sCaps.setPlatform(Platform.ANY);
		WebDriver driver = new RemoteWebDriver(new URL(getHost()), sCaps);
		return driver;
	}

	public static WebDriver getChromeDriver(String host) {
		DesiredCapabilities sCaps = DesiredCapabilities.chrome();
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(host), sCaps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	public static WebDriver getGhostDriver() throws IOException {
		sCaps = DesiredCapabilities.phantomjs();
		sCaps.setCapability("phantomjs.page.settings.loadImages", false);
		sCaps.setCapability("applicationCacheEnabled", false);
		sCaps.setCapability("takesScreenshot", true);
		sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, true);
		sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, getGhostDriverPath());
		sCaps.setJavascriptEnabled(true);
		// sCaps.setCapability("phantomjs.page.settings.userAgent",
		// UserAgentUtil.getOneUserAgent());
		sCaps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_CUSTOMHEADERS_PREFIX + "Referer",
				"https://www.hapag-lloyd.com/en/tracing/by_booking.html");
		// String proxy = "176.9.134.141:3128";
		// org.openqa.selenium.Proxy p = new org.openqa.selenium.Proxy();
		// p.setHttpProxy(proxy).setFtpProxy(proxy).setSslProxy(proxy);
		// sCaps.setCapability(CapabilityType.PROXY, p);
		WebDriver driver = new PhantomJSDriver(sCaps);
		((PhantomJSDriver) driver).executePhantomJS("this.onResourceRequested = function(requestData, request){" +
		// " if ((/http:\\/\\/.+?olb\\.js).test(requestData['url']) ||
		// requestData['Content-Type'] == 'text/css') {"
		// +
		// " console.log('The url of the request is matching. Aborting: ' +
		// requestData['url']);"
		// +
		// " request.abort();" +
		// " }" +
				"   if (requestData.url.indexOf('olb.js') != -1|" + "requestData.url.indexOf('.css') != -1|"
				+ "requestData.url.indexOf('.gif') != -1|" + "requestData.url.indexOf('t.js') != -1|"
				+ "requestData.url.indexOf('woff') != -1|" + "requestData.url.indexOf('svg') != -1|"
				+ "requestData.url.indexOf('cnt') != -1|" + "requestData.url.indexOf('even') != -1|"
				+ "requestData.url.indexOf('webE') != -1|" + "requestData.url.indexOf('png') != -1|"
				+ "requestData.url.indexOf('jpg') != -1) {" + "       console.log('Abort ' + requestData.url);"
				+ "       request.abort();" + "   }" + "};");
		// driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920, 1080));
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
		// return "D:\\Psoftware\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
	}
}
