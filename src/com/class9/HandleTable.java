package com.class9;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class HandleTable extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Open chrome browser Go to
		 * �http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.
		 * aspx� Login to the application Verify customer �Susan McLaren� is present in
		 * the table Click on customer detailsUpdate customers last name Verify updated
		 * customers name is displayed in tableClose browser
		 *
		 */

		try {
			String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx";
			setUpDriver("chrome", url);

			// login to the application
			driver.findElement(By.xpath("//*[@id='ctl00_MainContent_username']")).sendKeys("Tester");
			driver.findElement(By.xpath("//*[@id='ctl00_MainContent_password']")).sendKeys("test");
			driver.findElement(By.xpath("//*[@id='ctl00_MainContent_login_button']")).click();

			WebElement tableBody = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody"));
			List<WebElement> rows = tableBody.findElements(By.tagName("tr"));

			for (WebElement row : rows) {
				System.out.println(row.getText());
			}

			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for (WebElement cell : cells) {
					System.out.print(cell.getText() + ",");
				}
				System.out.println();
			}

			String expectedText = "Susan McLaren";
			Thread.sleep(1000);
			for (WebElement row : rows) {
				if (row.getText().contains(expectedText)) {
					List<WebElement> cells = row.findElements(By.tagName("td"));
					WebElement cell = cells.get(12);
					cell.click();
					break;
				}
			}

			WebElement textField = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]"));
			sendText(textField, "Susan Abc");
			Thread.sleep(2000);

			WebElement updateButton = driver
					.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]"));
			updateButton.click();
			Thread.sleep(2000);

			//WebElement tableCells = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td"));

//	        boolean result = false;
//	        List<WebElement> list1 = new ArrayList<>();
//	        WebElement element = null;
//	        for (int i = 0; i < rows.size(); i++) {
//	            
//	            list1 = tableBody.findElements(By.tagName("td"));
//	            for (int j = 0; j < list1.size(); j++) {
//	                if (list1.get(j).getText().contains("Susan McLaren")) {
//	                    result = true;
//	                    System.out.println("Susan McLaren found.");
			//
////	                    
			//
//	                }
//	                if (result) {
//	                    element = list1.get(list1.size()-1);
//	                    Thread.sleep(1000);
//	                    //new Actions(driver).moveToElement(element).click().build().perform();
//	                    break;
//	                }
			//
//	            }
//	        }

			Thread.sleep(5000);
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		driver.quit();
	}
}
