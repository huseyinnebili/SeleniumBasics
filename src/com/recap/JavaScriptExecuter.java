package com.recap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecuter {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		WebElement button = driver.findElement(By.id("u_0_b"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,250)");// scroll up
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0, -400)");// scroll down
		Thread.sleep(2000);

		// Login to Guru99
		// driver.findElement(By.name("uid")).sendKeys("mngr34926");
		// driver.findElement(By.name("password")).sendKeys("amUpenu");
		js.executeScript("document.getElementById('email').value='fatihsakitas@yandex.com';");
		js.executeScript("document.getElementById('pass').value='2112522hn';");

		// Perform Click on LOGIN button using JavascriptExecutor
		// js.executeScript("arguments[0].click();", button);
		button.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

//		Alert alert = driver.switchTo().alert();
//		alert.dismiss();
//		Thread.sleep(2000);

		WebElement elmnt = driver.findElement(By.className("_1frb"));
		elmnt.sendKeys("Dish Washer");
		elmnt.sendKeys(Keys.ENTER);

		Thread.sleep(7000);

		driver.quit();

	}

}
