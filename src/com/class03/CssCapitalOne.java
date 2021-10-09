package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssCapitalOne {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.capitalone.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[(@type='text')]")).sendKeys("hsynnebi");
		
		driver.findElement(By.cssSelector("input.darkPlaceholder login-password ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched")).sendKeys("2112522n");
	
		driver.findElement(By.cssSelector("button#no-acct-submit")).click();
		Thread.sleep(2000);
		// driver.close();
		
	}

}
