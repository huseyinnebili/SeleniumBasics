package com.class9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class Task1 extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {

		/*
		 * Open chrome browser Go to
		 * “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.
		 * aspx” Login to the application Verify customer “Susan McLaren” is present in
		 * the table Click on customer details Update customers last name Verify updated
		 * customers name is displayed in table Close browser
		 * 
		 * 
		 */

		String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders";

		setUpDriver("chrome", url);

		sendText(driver.findElement(By.cssSelector("input[id$='username']")), "Tester");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")), "test");
		driver.findElement(By.cssSelector("input[value='Login']")).click();

		String expectedValue = "Susan McLaren";

		List<WebElement> row = driver.findElements(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr"));

		for (int i = 1; i <= row.size(); i++) {
			String rowText = driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[" + i + "]")).getText();

			if (rowText.contains(expectedValue)) {
				driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[" + i + "]/td[13]")).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys("Susan Bostan");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]")).click();
		Thread.sleep(3000);
		driver.quit();
	}
	

}
