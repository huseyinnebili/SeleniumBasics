package com.class11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

/* TC 12356 - search flight verification
 * Step 1: navigate to URL
 * Step 2: enter details
 * Step 3 verify search is successful
 */

public class FlightSearch extends CommonMethods {

	String browser = "chrome";
	String url = "https://www.aa.com/homePage.do";

	@BeforeMethod
	public void setUp() {
		setUpDriver(browser, url);
	}

	@Test
	public void searchFlight() throws InterruptedException {
		// enter to and from
		sendText(driver.findElement(By.name("originAirport")), "DCA");
		sendText(driver.findElement(By.name("destinationAirport")), "JFK");
		// click on calendar icon
		driver.findElement(By.xpath("//input[@id='aa-leavingOn']/following-sibling::button")).click();
		// grab element that holds month & year
		WebElement depMonth = driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-left')]/div"));

//		while (!depMonth.getText().contains("October")) {
//			driver.findElement(By.xpath("//a[@title='Next']")).click();
//			// if we wont perform this action we will get
//			// StaleElementReferenceException: stale element reference: element is not
//			// attached to the page document
//			depMonth = driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-left')]/div"));
//	}

		while (true) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			//Thread.sleep(5000);
			depMonth = driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-right')]/div"));
			Thread.sleep(5000);
			if (depMonth.getText().contains("October")) {
				break;
			}
		}
		// capturing all cell and then loop and search for specific date
		List<WebElement> depCells = driver.findElements(By.xpath("//div[contains(@class, 'group-first')]/table/tbody/tr/td"));
		for (WebElement cell : depCells) {
			if (cell.getText().equals("18")) {
				cell.click();
				break;
			}
		}
		// selecting arrival details

		// click on calendar icon
		driver.findElement(By.xpath("//input[@id='aa-returningFrom']/following-sibling::button")).click();
		// grab element that holds month & year
		WebElement arrMonth = driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-right')]/div"));
		
		
//		boolean flag = true;
//		
//		while(flag) {
//			if (3>2) {
//				flag = false;
//			}
//		}
//
//		while (!arrMonth.getText().contains("December")) {
//			driver.findElement(By.xpath("//a[@title='Next']")).click();
//			// if we wont perform this action we will get
//			// StaleElementReferenceException: stale element reference: element is not
//			// attached to the page document
//			arrMonth = driver.findElement(By.xpath("//div[contains(@class, 'ui-corner-right')]/div"));
		// }
		while (true) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			arrMonth = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/div"));
			Thread.sleep(5000);
			if (arrMonth.getText().contains("December")) {
				break;

			}

		}
		// capturing all cell and then loop and search for specific date
		List<WebElement> arrCells = driver.findElements(By.xpath("//div[contains(@class, 'group-last')]/table/tbody/tr/td"));
		for (WebElement cell : arrCells) {
			if (cell.getText().equals("24")) {
				cell.click();
				break;
			}
		}

		Thread.sleep(5000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
