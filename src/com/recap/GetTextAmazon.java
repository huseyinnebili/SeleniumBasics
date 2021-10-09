package com.recap;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextAmazon {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.amazon.com/");

		driver.findElement(By.xpath("//*[@id=\"nav-link-prime\"]/span[2]")).click();
		List<WebElement> list = driver.findElements(By.tagName("div"));

		int count = 0;
		System.out.println(list.size());
		Iterator<WebElement> it = list.iterator();
		while (it.hasNext()) {
			String listText = it.next().getText();
			if (!listText.isEmpty()) {
				System.out.println(listText);
				count++;
			}
		}

//		List<WebElement> links = driver.findElements(By.tagName("div"));
//		int count = 0;
//		System.out.println(links.size());
//
//		Iterator<WebElement> linksIt = links.iterator();
//		while (linksIt.hasNext()) {
//			String linkText = linksIt.next().getText();
//			if (!linkText.isEmpty()) {
//				System.out.println(linkText);
//				count++;
//			}
//		}
//		System.out.println("Total # of links with text " + count);
		driver.quit();

	}
}
