package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssFace {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.inputtext")).sendKeys("fatihsaki@yandex.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#pass")).sendKeys("2112522hn");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(2000);
		driver.close();
}
}