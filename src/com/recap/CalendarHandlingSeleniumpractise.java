package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandlingSeleniumpractise {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();

		String expected_Day = "29";

		List<WebElement> allDates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']//td"));

		for (WebElement allDate : allDates) {

			String Date = allDate.getText();
			System.out.println("Dates: " + Date);

			if (Date.equalsIgnoreCase(expected_Day)) {
				allDate.click();
			}

		}
		Thread.sleep(2000);
		driver.quit();
	}
}
