package com.class9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class Taskkk extends CommonMethods {
	public static void main(String[] args) {
		/*
		 * Open chrome browser Go to
		 * “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.
		 * aspx” Login to the application Verify customer “Susan McLaren” is present in
		 * the table Click on customer detailsUpdate customers last name Verify updated
		 * customers name is displayed in tableClose browser
		 *
		 */

		try {

			String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx";
			setUpDriver("chrome", url);

			driver.findElement(By.cssSelector("*[id='ctl00_MainContent_username']")).sendKeys("Tester");
			driver.findElement(By.cssSelector("*[id='ctl00_MainContent_password']")).sendKeys("test");
			driver.findElement(By.cssSelector("*[id='ctl00_MainContent_login_button']")).click();

			// WebElement
			// table=driver.findElement(By.cssSelector("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr"));

			WebElement table = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody"));

			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println("Row size= "+rows.size());
			String expectedText = "Samuel Clemens";
			for (WebElement row : rows) {
				// System.out.println(cell.getText() + ",");
				System.out.println(row.getText());

				List<WebElement> cells = row.findElements(By.tagName("td"));
				 System.out.println("Cells size= "+cells.size());
				for (WebElement cell : cells) {
					//System.out.println("Cell size ="+cell.getSize());
					System.out.println(cell.getText());

				}

				if (row.getText().contains(expectedText)) {

					driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[8]/td[13]/input"))
							.click();

					break;
				}
			}

			driver.findElement(By.cssSelector("*[id='ctl00_MainContent_fmwOrder_txtName']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("*[id='ctl00_MainContent_fmwOrder_txtName']")).sendKeys("Huseyin Nebili");
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("*[id='ctl00_MainContent_fmwOrder_UpdateButton']")).click();
			Thread.sleep(2000);
//			List<WebElement> cells1 = driver
//					.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td"));
//			System.out.println(cells1.size());
//
//			for (WebElement cell1 : cells1) {
//				System.out.println(cell1.getText() + ",");
//				Thread.sleep(2000);
//			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		driver.quit();
	}
}