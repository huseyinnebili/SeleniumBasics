package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumeasyAlert {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.findElement(By.xpath("//*[@class = 'btn btn-default']")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		if (text.equals("I am an alert box!")) {
			System.out.println("'�I am an alert box!�' text presents.");
		} else {
			System.out.println("'�I am an alert box!�' text not presents.");
		}
		alert.accept();
		//driver.quit();
	}
}
