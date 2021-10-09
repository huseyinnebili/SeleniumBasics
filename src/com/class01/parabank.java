package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parabank {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\husey\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=6AAB6E40702D36DA111142142AA610F9");
		driver.findElement(By.id("customer.firstName")).sendKeys("Huseyin");
		Thread.sleep(2000);
		driver.findElement(By.id("customer.lastName")).sendKeys("Nebili");
		Thread.sleep(2000);
		driver.findElement(By.id("customer.address.street")).sendKeys("61 courter avenue wayne");
		Thread.sleep(2000);
		driver.findElement(By.id("customer.address.city")).sendKeys("Wayne");
		Thread.sleep(2000);
		driver.findElement(By.id("customer.address.state")).sendKeys("NJ");
		Thread.sleep(2000);
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("07470");
		Thread.sleep(2000);
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("2017577759");
		Thread.sleep(2000);
		driver.findElement(By.id("customer.ssn")).sendKeys("543222367");
		Thread.sleep(2000);
		driver.findElement(By.id("customer.username")).sendKeys("hsyn34");
		Thread.sleep(2000);
		driver.findElement(By.id("customer.password")).sendKeys("2112522hn");
		Thread.sleep(2000);
		driver.findElement(By.id("repeatedPassword")).sendKeys("2112522hn");
		Thread.sleep(20000);
		driver.findElement(By.className("button")).click();
		driver.close();
		
		
}
}
