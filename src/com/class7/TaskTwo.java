package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class TaskTwo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/*
		 * Task Two Ahead to http://uitestpractice.com/Students/Index Click on the
		 * Actions Handle the drag and drop Close the browser
		 * 
		 */
		setUpDriver("Chrome", "http://uitestpractice.com/Students/Index");

		driver.findElement(By.xpath("//a[text()='Actions']")).click();
		WebElement drag = driver.findElement(By.cssSelector("div#draggable"));
		WebElement drop = driver.findElement(By.cssSelector("div#droppable"));
		Actions action = new Actions(driver);
		action.clickAndHold(drag).moveToElement(drop).release(drag).perform();
		Thread.sleep(2000);
		driver.close();
	}
}