package com.recap;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class BrokenLinkHerokuapp extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		try {

			setUpDriver("chrome", "https://the-internet.herokuapp.com/");

			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Total links=" + links.size());

			for (WebElement link : links) {
				String linkURL = link.getAttribute("href");
				System.out.println("Links : " + linkURL);

				URL url = new URL(linkURL);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				int code = conn.getResponseCode();
				if (code == 200) {
					System.out.println("Link is valid " + link.getText());
				} else {
					System.out.println("Link is NOT valid " + link.getText());
				}

			}
		} catch (

		Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		Thread.sleep(2000);
		driver.quit();

	}
}
