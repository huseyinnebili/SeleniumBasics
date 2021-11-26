package com.class7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class TaskOne extends CommonMethods {

	public static void main(String[] args) {
		/*
		 * Task One Ahead to http://uitestpractice.com/Students/Index Click on the
		 * Actions Click on the click me ! Handle the alert and click okay Double Click
		 * Double Click Me ! Handle the alert and click okay Close the browser
		 * 
		 */
		setUpDriver("Chrome", "http://uitestpractice.com/Students/Index");
		driver.findElement(By.xpath("//a[text()='Actions']")).click();

		WebElement clickMe = driver.findElement(By.xpath("//button[text()='Click Me !']"));
		Actions action = new Actions(driver);
		action.moveToElement(clickMe).click().perform();
		Alert alertOne = driver.switchTo().alert();
		alertOne.accept();
		WebElement dc = driver.findElement(By.xpath("//button[text()='Double Click Me !']"));
		action.doubleClick(dc).perform();
		Alert alertTwo = driver.switchTo().alert();
		alertTwo.accept();
		//driver.close();

	}
}
