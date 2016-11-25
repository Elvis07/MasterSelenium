package com.cs.mapping;

import org.openqa.selenium.WebDriver;

import com.cs.bean.Task;

public class InteractionMapping {

	public static void runInteraction(WebDriver driver, Task task) {

		switch (task.getDescription()) {

		case "opensite":
			Interaction.openSite(driver, task);
			break;
		case "click":
			Interaction.click(driver, task);
			break;
		case "sendkeys":
			Interaction.sendKey(driver, task);
			break;
		case "wait":
			Interaction.waitUntil(driver, task);
			break;
		case "snapshot":
			Interaction.snapshot(driver);
			break;

		}

	}

}
