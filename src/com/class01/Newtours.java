package com.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newtours {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\husey\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();

		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		driver.findElement(By.name("firstName")).sendKeys("Huseyin");
		Thread.sleep(2000);
		driver.findElement(By.name("lastName")).sendKeys("Nebili");
		Thread.sleep(2000);
		driver.findElement(By.name("phone")).sendKeys("2017075777");
		Thread.sleep(2000);
		driver.findElement(By.id("userName")).sendKeys("huseyinnebili36@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("address1")).sendKeys("61 courter Avenue " );
		Thread.sleep(2000);
		driver.findElement(By.name("address2")).sendKeys(" " );
		Thread.sleep(2000);
		driver.findElement(By.name("city")).sendKeys("Wayne");
		Thread.sleep(2000);
		driver.findElement(By.name("state")).sendKeys("New Jersey");
		Thread.sleep(2000);
		driver.findElement(By.name("postalCode")).sendKeys("07470");
		Thread.sleep(2000);
		driver.findElement(By.name("country")).sendKeys("UNITED STATES");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("huseyinnebili36@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("2112522hn");
		Thread.sleep(2000);
		driver.findElement(By.name("confirmPassword")).sendKeys("2112522hn");
		Thread.sleep(2000);
		driver.findElement(By.name("register")).click();
		driver.close();
	
}
}