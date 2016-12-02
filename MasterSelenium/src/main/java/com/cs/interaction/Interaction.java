package com.cs.interaction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Interaction {

	public static void selectByValue(WebElement ele, String value) {

		Select select = new Select(ele);
		select.selectByValue(value);
	}
	
	public static void inputValue(WebElement ele, String value) {
		
		ele.clear();
		ele.sendKeys(value);
	}

}
