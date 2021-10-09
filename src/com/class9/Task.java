package com.class9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class Task extends CommonMethods {

	// TC 1: Table headers and rows verification
//
//	Open chrome browser
//	Go to “https://the-internet.herokuapp.com/”
//	Click on “Click on the “Sortable Data Tables” link
//	Verify tables consist of 4 rows and 6 columns
//	Print name of all column headers
//	Print data of all rows

	public static void main(String[] args) throws InterruptedException {

		setUpDriver("chrome", "https://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//*[text()='Sortable Data Tables']")).click();

		System.out.println("----------rows text---------");
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));
		for (WebElement row : rows) {
			System.out.println(row.getText());

			
		}
		System.out.println("----------columns text---------");
			List<WebElement> colms = driver.findElements(By.xpath("//*[@id='table1']/thead/tr/th"));
			for (WebElement colm : colms) {
				System.out.println(colm.getText());
			}
		}
	}
