package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookStartContains {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys("fatihsaki@yandex.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[starts-with(@type,'pass')]")).sendKeys("2112522hn");
		// driver.findElement(By.xpath("//a[contains(text(),'account?')]")).click();

		//// a[text()='Forgot account?']
		// a[starts-with(text(),'Forgot ')]
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//input[starts-with(@data-testid,'royal_pa')]")).sendKeys("2112522hn");
		// driver.findElement(By.xpath("//input[starts-with(@value,'Log')]")).click();
		driver.findElement(By.xpath("//input [starts-with(@type,'sub')]")).click();
		Thread.sleep(3000);
		driver.close();
	}
}