package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarHandlingSeleniumeasy {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");

		driver.findElement(By.xpath("//*[@type='text']")).click();

		List<WebElement> dates = driver.findElements(By.xpath("//*[@class='datepicker-days']//td"));

		for (WebElement date : dates) {

			String all_Dates = date.getText();
			System.out.println("Dates :" + all_Dates);

			if (all_Dates.equalsIgnoreCase("1")) {

				date.click();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@type='text']")).click();

				driver.findElement(By.xpath("//*[@class='datepicker-days']//table//tfoot//tr[2]//th")).click();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@type='text']")).click();

				driver.findElement(By.xpath("//*[@class='today']")).click();
				
				break;

			}

		}

		Thread.sleep(2000);
		driver.quit();

	}

}
