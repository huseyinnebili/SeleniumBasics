package com.class11;


	import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import utils.CommonMethods;

	/*
	 * TC675765: New Tour registration Pafe broken links verification
	 */

	public class BrokenLinksDemo extends CommonMethods{

		
		@BeforeMethod
		public void setUp() {
			setUpDriver("chrome", "http://newtours.demoaut.com/");
		}
		
		@Test
		public void brokenLinksVerification() {
			//1. grab all links
			List<WebElement> links=driver.findElements(By.tagName("a"));
			System.out.println("Total links="+links.size());
			//2. get href attribute
			
			for (WebElement link: links) {
				String linkURL=link.getAttribute("href");
				
				try {
					URL url=new URL (linkURL);
					HttpURLConnection conn=(HttpURLConnection)url.openConnection();
					int code=conn.getResponseCode();
					if (code==200) {
						System.out.println("Link is valid "+link.getText());
					}else {
						System.out.println("Link is NOT valid "+link.getText());
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}
