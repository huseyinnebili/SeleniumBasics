package com.recap;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.seleniumhq.jetty9.server.HttpConnection;

import utils.CommonMethods;

public class BrokenLinkNewtours extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		try {

			setUpDriver("chrome", "http://demo.guru99.com/test/newtours/");

			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Links : " + links.size());
			
			for(WebElement link:links) {
				String link_Text=link.getAttribute("href");
				//System.out.println("Name of the Links :"+link_Text);
				
				URL url_link=new URL(link_Text);
				
				HttpURLConnection connect=(HttpURLConnection)url_link.openConnection();
				int code=connect.getResponseCode();
				
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
