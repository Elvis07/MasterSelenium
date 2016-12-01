package com.cs.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.cs.bean.Task;
import com.cs.bean.WebSuite;
import com.cs.mapping.InteractionMapping;
import com.cs.util.Loader;

public class Executor {

	public static void execute(WebDriver driver) {
		WebSuite suite = Loader.suite;

		driver.manage().window().maximize();
		int length = suite.getCases().get(0).getTasks().size();
		for (int i = 0; i < length; i++) {
			Task task = suite.getCases().get(0).getTasks().get(i);
			InteractionMapping.runInteraction(driver, task);
			
		}

	}

}
