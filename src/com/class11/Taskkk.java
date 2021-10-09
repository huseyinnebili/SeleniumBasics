package com.class11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Taskkk extends CommonMethods {

	String browser = "chrome";
	String url = "https://www.aa.com/homePage.do";

	@BeforeMethod
	public void setUp() {
		setUpDriver(browser, url);

	}

	@Test
	public void searchFlight() throws InterruptedException {
		sendText(driver.findElement(By.name("originAirport")), "DCA");
		sendText(driver.findElement(By.name("destinationAirport")), "JFK");
		driver.findElement(By.xpath("//*[@id='aa-leavingOn']/following-sibling::button")).click();

		WebElement depMonth = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']"));

		while (true) {
			driver.findElement(By.xpath("//*[@title='Next']")).click();
			depMonth = driver.findElement(By.xpath("//*[@class='ui-datepicker-title']"));
			//Thread.sleep(5000);

			if (depMonth.getText().contains("October")) {
				break;
			}

		}

		List<WebElement> cells = driver.findElements(By.xpath("//*[contains(@class,'group-first')]/table/tbody/tr/td"));
		for (WebElement cell : cells) {
			if (cell.getText().equals("18")) {

				cell.click();

				break;
			}
		}
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}