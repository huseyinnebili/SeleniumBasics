package com.recap;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class UploadAndDownloadSoftwaretestingplace extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		try {

			setUpDriver("chrome", "http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");

			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			WebElement upload = driver.findElement(By.id("uploadfile"));

			upload.sendKeys("C:\\Users\\husey\\Desktop\\verbling.docx");

			TakesScreenshot camera = ((TakesScreenshot) driver);
			File selfie = camera.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(selfie, new File("screenshots/WebTable/softwaretestingplace.png"));

			driver.findElement(By.xpath("//*[@id='post-body-5864649494765988891']/div[1]/form/div[1]/a[1]")).click();

			Runtime.getRuntime().exec("C:\\Users\\husey\\Desktop\\doc1\\AutoIt\\SoftwareTestingMaterial.txt");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		Thread.sleep(2000);
		driver.quit();

	}

}
