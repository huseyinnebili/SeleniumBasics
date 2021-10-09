package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContainsAnsStartsCapitalOne {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.capitalone.com/");
		driver.findElement(By.xpath("//input[starts-with(@type,'text')]")).sendKeys("hsynnebi");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys("2112522n");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[starts-with(@type,'sub')]")).click();
		Thread.sleep(2000);
		// driver.close();
		
	}

}
