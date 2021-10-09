package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssCanvas {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://canvas.instructure.com/login/canvas#view_start=2019-02-09&view_name=month");
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("huseyinnebili36@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("2112522hn");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
        driver.close();

	}
}
