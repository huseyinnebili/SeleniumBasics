package com.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;

public class doubleClick extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		setUpDriver("chrome", "https://www.saucedemo.com");
		
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("double");
		
		Actions action = new Actions(driver);
		
		action.doubleClick(driver.findElement(By.cssSelector("input#user-name"))).perform();
		
		Thread.sleep(5000);
		
		driver.close();

	}
}
