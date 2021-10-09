package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShortcutKeysFacebook {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.cssSelector("input[type^='em']")).sendKeys("fatihsaki@yandex.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[type$='word']")).sendKeys("2112522hn");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id*='u_']")).click();
		Thread.sleep(2000);
		driver.close();
		
}
}