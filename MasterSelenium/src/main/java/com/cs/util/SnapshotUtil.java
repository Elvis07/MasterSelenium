package com.cs.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SnapshotUtil {

	public static void snapshot(WebDriver driver,String page) {
		Date date = new Date();
		SimpleDateFormat df3 = new SimpleDateFormat("HHmmss");
		String filename = df3.format(date) +"_"+page +".png";
		// String currentPath = System.getProperty("user.dir"); // get current
		// System.out.println(currentPath);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
		System.out.println("save snapshot name is:" + filename);
		FileUtils.copyFile(scrFile, new File("D:\\snapshot" + "\\"
		+ filename));
		} catch (IOException e) {
		System.out.println("Can't save screenshot");
		e.printStackTrace();
		} finally {
		System.out.println("screen shot finished");
		}
	}
}
