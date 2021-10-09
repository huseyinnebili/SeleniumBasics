package com.recap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class AuthenticationPopupHerokuapp extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		try {

			// http://username:password@url
			setUpDriver("chrome", "http://admin:admin@the-internet.herokuapp.com/basic_auth");

			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			System.out.println(driver.findElement(By.cssSelector("p")).getText());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		Thread.sleep(2000);
		driver.quit();

	}

}
