package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryToursContainsStarts {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[starts-with(@name,'user')]")).sendKeys("huseyinnebili36@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'pass')]")).sendKeys("2112522hn");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[starts-with(@name,'log')]")).click();
		Thread.sleep(2000);
		driver.close();
		
		
}
}