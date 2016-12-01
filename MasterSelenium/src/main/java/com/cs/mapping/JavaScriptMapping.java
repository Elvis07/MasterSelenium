package com.cs.mapping;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptMapping{

	
	public static void clickJs(WebDriver driver,WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}
	
	public static void sendKey(WebDriver driver,WebElement element,String toSend) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('value', arguments[1])", element, toSend);
	}
	
	public static void scroll(WebDriver driver,WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	

}
