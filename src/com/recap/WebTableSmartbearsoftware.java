package com.recap;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.ScreenshotException;

import utils.CommonMethods;

public class WebTableSmartbearsoftware extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		try {

			setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx");

			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
			driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
			driver.findElement(By.id("ctl00_MainContent_login_button")).click();

			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
			List<WebElement> cols = driver
					.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/th"));

			String exp_Text = "Susan McLaren";
			String exp_Text1 = "Paul Brown";

			for (int i = 2; i <= rows.size(); i++) {
				for (int j = 1; j < cols.size(); j++) {

					String cell_Text = driver
							.findElement(By
									.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + i + " ]/td[" + j + "]"))
							.getText();
					System.out.println("Cell Text : " + cell_Text);

					if (cell_Text.contains(exp_Text)) {
						driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid_ctl06_OrderSelector']"))
								.click();
						break;
					}

					if (cell_Text.contains(exp_Text1)) {
						driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid_ctl02_OrderSelector']"))
								.click();
						break;
					}

				}

			}

			TakesScreenshot camera = ((TakesScreenshot) driver);
			File selfie = camera.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(selfie, new File("screenshots/WebTable/smartbearsoftware.png"));

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		Thread.sleep(2000);
		driver.quit();

	}
}
