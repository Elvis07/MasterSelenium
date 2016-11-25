package com.cs.mapping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.bean.Task;
import com.cs.util.Loader;
import com.cs.util.SnapshotUtil;

public class Interaction {
	static int waitTime;
	static {
		waitTime = Loader.timeOut;
	}

	public static void openSite(WebDriver driver, Task task) {
		driver.get(task.getUrl());
	}

	public static void click(WebDriver driver, Task task) {

		WebElement element = driver.findElement(ByMapping.getBy(task));
		JavaScriptMapping.clickJs(driver, element);
	}

	public static void sendKey(WebDriver driver, Task task) {

		WebElement element = driver.findElement(ByMapping.getBy(task));
		String toSend = task.getInputValue();
		JavaScriptMapping.sendKey(driver, element, toSend);
	}

	public static void waitUntil(WebDriver driver, Task task) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.presenceOfElementLocated(ByMapping.getBy(task)));
	}

	public static void snapshot(WebDriver driver) {
		SnapshotUtil.snapshot(driver);
	}

}
