package com.cs.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    public static WebDriver getRemoteDriver(String host,String browser) {
    	
        DesiredCapabilities caps = null;
        
        if (browser.contains("firefox")) {
        	caps = DesiredCapabilities.firefox();
        }else if(browser.contains("chrome")) {
        	caps = DesiredCapabilities.chrome();
        }else if(browser.contains("ie")){
        	caps = DesiredCapabilities.internetExplorer();
        	caps.setCapability("ignoreZoomSetting", true);
        }else{
        	return getPhanTomJsDriver(host);
        }
//      setBrowserInfo(caps);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(host), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        return driver;
    }
    
    public static void setBrowserInfo(DesiredCapabilities capability){
    	
    	capability.setBrowserName("ie");
    	capability.setVersion("8.0");
    	capability.setPlatform(Platform.WINDOWS);
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
}
