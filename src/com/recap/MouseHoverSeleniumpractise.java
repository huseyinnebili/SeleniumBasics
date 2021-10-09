package com.recap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class MouseHoverSeleniumpractise {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("https://seleniumpractise.blogspot.com/search?q=hover");
		driver.get("https://www.toolsqa.com/");
		// WebElement element = driver
		// .findElement(By.xpath("//*[@id=\"post-body-4229879368008023176\"]/div[1]/div[2]/button"));

		// WebElement element =
		// driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/a/span/span"));

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[2]/a/span/span"))).perform();
		Thread.sleep(2000);

		action.contextClick().perform();
		Thread.sleep(2000);

		action.doubleClick().perform();
		Thread.sleep(2000);

//		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"mobile-menu\"]/li[3]/a/span/span"));
//		Actions action1 = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"primary-menu\"]/li[6]/a/span/span"))).perform();
		Thread.sleep(2000);

		action.contextClick().perform();
		Thread.sleep(2000);

		driver.quit();

	}

}
