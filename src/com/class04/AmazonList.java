package com.class04;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonList {
	public static void main(String[] args) {
		// go to walmart and get# of links and print ONLY links that have text
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.amazon.com/");

		// capture all links

		List<WebElement> links = driver.findElements(By.tagName("span"));
		int count = 0;
		System.out.println(links.size());

		Iterator<WebElement> linksIt = links.iterator();
		while (linksIt.hasNext()) {
			String linkText = linksIt.next().getText();
			if (!linkText.isEmpty()) {
				System.out.println(linkText);
				count++;
			}
		}
		System.out.println("Total # of links with text " + count);
		// driver.quit();

	}
}
