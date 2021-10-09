package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import utils.CommonMethods;

public class WebTableHerokuapp extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		try {

			setUpDriver("firefox", "https://the-internet.herokuapp.com/tables");

			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr"));

			List<WebElement> cols = driver.findElements(By.xpath("//*[@id=\"table1\"]/thead/tr/th"));

//			for (int i = 1; i <= rows.size(); i++) {
//				String rowText = driver.findElement(By.xpath("//*[@summary='Sample Table']/thead/tr[" + i + "]"))
//						.getText();
//				System.out.println(rowText);
//			}

			System.out.println("======first table text=======");

			for (int i = 1; i <= rows.size(); i++) {
				for (int j = 1; j <= cols.size(); j++) {

					String cell_Text = driver
							.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")).getText();

					System.out.println("Cell Text :" + cell_Text);
				}
			}

			List<WebElement> rows2 = driver.findElements(By.xpath("//*[@id=\"table2\"]/tbody/tr"));

			List<WebElement> cols2 = driver.findElements(By.xpath("//*[@id=\"table2\"]/thead/tr/th"));

			System.out.println("======last row text=======");

			for (int i = rows2.size() - 1; i >= 0;) {
				String latsRow_Value = rows2.get(i).getText();
				System.out.println("Last row: " + latsRow_Value);
				break;
			}

			System.out.println("======second table text=======");

			for (int i = 1; i <= rows2.size(); i++) {

				for (int j = 1; j <= cols2.size(); j++) {

					String cell_Text2 = driver
							.findElement(By.xpath("//*[@id='table2']/tbody/tr[" + i + "]/td[" + j + "]")).getText();

					System.out.println("Cell Text2 :" + cell_Text2);
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		Thread.sleep(2000);
		driver.quit();
	}

}
