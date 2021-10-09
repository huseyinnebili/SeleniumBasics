package com.class04;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GittigidiyorList {
	public static void main(String[] args) {
		// go to walmart and get# of links and print ONLY links that have text
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.gittigidiyor.com/");

		List<WebElement> listText = driver.findElements(By.tagName("a"));
		System.out.println(listText.size());
		int count = 0;
		
		
		Iterator<WebElement> listIt = listText.iterator();

		while (listIt.hasNext()) {
			String list = listIt.next().getText();
		

			if (!list.isEmpty()) {
				System.out.println(list);
				count++;
			}

		}
		System.out.println("Total # of links with text "+count);
		driver.quit();
	}
}