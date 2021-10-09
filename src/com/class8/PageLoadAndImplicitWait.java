package com.class8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoadAndImplicitWait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src\\\\driver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

	    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://cnn.com");

		driver.findElement(By.linkText("World")).click();

		boolean isDisplayed = driver.findElement(By.xpath("//h1[text()='World']")).isDisplayed();

		if (isDisplayed) {
			System.out.println("Element is present");
		} else {
			System.out.println("Element is NOT present");
		}
		driver.quit();
	}
}
