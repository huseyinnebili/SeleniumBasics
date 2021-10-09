package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Saucedemo1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		WebElement userName = driver.findElement(By.cssSelector("input[id='user-name']"));
		userName.sendKeys("standard_user");
		WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
		password.sendKeys("secret_sauce");
		WebElement login = driver.findElement(By.cssSelector("input[type='submit']"));
		login.click();
	}
}