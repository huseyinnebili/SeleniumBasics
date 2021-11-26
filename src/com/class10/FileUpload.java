package com.class10;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;


import utils.CommonMethods;

public class FileUpload extends CommonMethods {

	public static void main(String[] args) throws InterruptedException, IOException {

		String url = "http://the-internet.herokuapp.com";
		setUpDriver("chrome", url);

		driver.findElement(By.linkText("File Upload")).click();
		Thread.sleep(3000);

		String filePath = "C:\\Users\\husey\\Selenium\\selenium-server-standalone-3.141.59.jar";
		driver.findElement(By.id("file-upload")).sendKeys(filePath);
		driver.findElement(By.id("file-submit")).click();

		boolean isDisplayed = driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed();

		if (isDisplayed) {
			System.out.println("File uploaded successfully");
		} else {
			System.out.println("File uploaded successfully");
		}

		// Take the screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Copy the file to a location and use try catch block to handle exception
		
			FileUtils.copyFile(screenshot, new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshotst.png"));
		

		Thread.sleep(2000);

		driver.quit();

	}
}
