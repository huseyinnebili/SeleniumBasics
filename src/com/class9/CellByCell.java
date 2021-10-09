package com.class9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class CellByCell extends CommonMethods {

	public static void main(String[] args) {
		setUpDriver("chrome", "https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		
		// number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));
		
		// number of columns
		List<WebElement> cols = driver.findElements(By.xpath("//*[@id='table1']/thead/tr/th"));

		for (WebElement r : rows) {
			System.out.println(r.getText());
		}

		/*
		 * how to print value cell by cell?
		 * 1. loop through all rows 
		 * 2. loop through all columns
		 * driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[rows]/td[cols]")).getText();
		 */

		// 1 way
		for (int i = 1; i <= rows.size(); i++) {
			for (int j = 1; j <= cols.size(); j++) {

				String cellText = driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
				System.out.println(cellText);
			}
		}
		// 2 way
		System.out.println("---------------------------------------");
		List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));

		System.out.println("cell size= "+cells.size());
		for (WebElement cell : cells) {
			String cellText = cell.getText();
			System.out.println(cellText);
		}
	}
}
