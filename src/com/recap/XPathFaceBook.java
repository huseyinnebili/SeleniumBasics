package com.recap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathFaceBook {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://facebook.com");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("fatihsaki@yandex.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("2112522hn");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='u_0_2']")).click();
		driver.close();

	}

}
