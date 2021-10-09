package com.recap;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class HiddenButtonLetskodeit extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		try {

			setUpDriver("chrome", "https://learn.letskodeit.com/p/practice");

			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)");

			driver.findElement(By.id("hide-textbox")).click();

			// driver.findElement(By.id("displayed-text")).sendKeys("huseyin");

			js.executeScript("document.getElementById('displayed-text').value= 'huseyin'");

			driver.findElement(By.id("show-textbox")).click();

			TakesScreenshot image = (TakesScreenshot) driver;
			File photo = image.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(photo, new File("screenshots/WebTool/letskodeit.png"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		Thread.sleep(5000);
		driver.quit();

	}

}
