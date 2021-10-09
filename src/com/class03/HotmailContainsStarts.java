package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HotmailContainsStarts {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1558068338&rver=7.0.6737.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fRpsCsrfState%3dfb382a08-e610-6541-e802-d9e2923e5157&id=292841&aadredir=1&whr=hotmail.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[starts-with(@type,'email')]")).sendKeys("huseyinnebili@hotmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@type,'sub')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@type,'word')]")).sendKeys("2112522hn");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@id,'idSIButt')]")).click();
		Thread.sleep(2000);
		driver.close();
		
}
}