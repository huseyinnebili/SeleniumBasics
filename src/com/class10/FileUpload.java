package com.class10;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class FileUpload extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		try {
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

		Thread.sleep(2000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File pic = ts.getScreenshotAs(OutputType.FILE);
		
			FileUtils.copyFile(pic, new File("screenshots/herokuapp/upload.jpg"));
			Thread.sleep(2000);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Screenshot not taken");

		}finally {
		
		driver.quit();
		}
	}
}
