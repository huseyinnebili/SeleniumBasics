package com.recap;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class WebTableToolsqa extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		try {

			setUpDriver("firefox", "http://uitestpractice.com/Students/Index");

			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			List<WebElement> rows = driver.findElements(By.xpath("//*[@class='table']/tbody/tr"));

			List<WebElement> columns = driver.findElements(By.xpath("//*[@class='table']/tbody/tr[1]/th"));

			for (int i = 2; i <= rows.size(); i++) {
				for (int j = 1; j <= columns.size(); j++) {
					String cell_Text = driver
							.findElement(By.xpath("//*[@class='table']/tbody/tr[" + i + "]/td[" + j + "]")).getText();

					System.out.println("Cell Text : " + cell_Text);
				}
			}

			driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();

			driver.findElement(By.id("FirstName")).sendKeys("Huseyin");
			driver.findElement(By.id("LastName")).sendKeys("Arikan");
			driver.findElement(By.id("EnrollmentDate")).sendKeys("02/13/2020");
			driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();
			driver.findElement(By.id("Search_Data")).sendKeys("Huseyin");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			Thread.sleep(3000);

			TakesScreenshot camera = (TakesScreenshot) driver;
			File table = camera.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(table, new File("screenshots/WebTable/uitestpractice.png"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		Thread.sleep(2000);
		driver.quit();

	}
}