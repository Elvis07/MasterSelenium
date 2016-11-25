package com.cs.mapping;

import org.openqa.selenium.By;

import com.cs.bean.Task;

public class ByMapping {

	public static By getBy(Task task) {

		String by = task.getElement().getBy().toLowerCase();
		String locator = task.getElement().getLocator();
		
		switch (by) {
		case "id":
			return By.id(locator);
		case "name":
			return By.name(locator);
		case "class":
			return By.className(locator);
		case "tagname":
			return By.tagName(locator);
		case "linktext":
			return By.linkText(locator);
		case "partial":
			return By.partialLinkText(locator);
		case "css":
			return By.cssSelector(locator);
		case "xpath":
			return By.xpath(locator);
		}
		return null;
	}

}
