package com.recap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssHotmail {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://outlook.live.com/owa/");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[data-task^='signin']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[type^='email']")).sendKeys("huseyinnebili@hotmail.com");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[type^='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name^='passwd']")).sendKeys("2112522hn");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id^='idSIButton9']")).click();
		Thread.sleep(3000);
		driver.close();

	}

}
