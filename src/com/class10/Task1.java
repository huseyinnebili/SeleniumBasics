package com.class10;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.CommonMethods;

public class Task1 extends CommonMethods {

	static String expected = "File uploaded!";

	public static void main(String[] args) {
		String url = "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload";
		setUpDriver("chrome", url);

		takeScreenshot("WebTool", "Login");

		String filePath = "C:\\Users\\husey\\Downloads\\Class 5 Notes";
		driver.findElement(By.cssSelector("input.gwt-FileUpload")).sendKeys(filePath);

		takeScreenshot("WebTool", "Upload1");

		driver.findElement(By.cssSelector("button.gwt-Button")).click();

		String textActual = getAlertText();

		if (textActual.equals(expected)) {
			System.out.println("File is uploaded");
		} else {
			System.out.println("File is NOT uploaded");
		}

		acceptAlert();

		// takeScreenshot("WebTool", "Upload");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scr, new File("screenshots/WebTool/Upload.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to take screesnhot");
		}

		driver.quit();
	}
}
