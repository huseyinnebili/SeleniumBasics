package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://facebook.com");
		driver.findElement(By.id("email")).sendKeys("huseyinnebili36@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys("2112522hn");
		Thread.sleep(2000);
		driver.findElement(By.id("u_0_2")).click();
		driver.close();
	}
}