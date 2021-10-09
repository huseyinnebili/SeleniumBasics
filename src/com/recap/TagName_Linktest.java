package com.recap;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagName_Linktest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.lambdatest.com");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		int count = 0;

		System.out.println(links.size());

		Iterator<WebElement> it = links.iterator();
		while (it.hasNext()) {
			String linkList = it.next().getText();
			if (!linkList.isEmpty()) {
				System.out.println(linkList);
				count++;
			}
		}
		System.out.println("Total # of links with text " + count);
		driver.quit();

	}

}
