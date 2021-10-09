package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayList {

	public static void main(String[] args) {
		// go to walmart and get# of links and print ONLY links that have text
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.ebay.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links " + links.size());
		int count = 0;
		for (WebElement link : links) {
			String linkText = link.getText();
			if (!linkText.isEmpty()) {
				System.out.println(linkText);
				count++;
			}
		}
		System.out.println("Total number of links with text " + count);
		driver.quit();
	}

}
