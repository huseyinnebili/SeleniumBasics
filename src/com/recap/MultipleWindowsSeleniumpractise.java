package com.recap;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsSeleniumpractise {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://seleniumpractise.blogspot.com/search?q=multiple");

		String parent = driver.getWindowHandle();
		System.out.println("Parent window id is " + parent);

		driver.findElement(By.xpath("//*[@id=\"post-body-6170641642826198246\"]/a[1]")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//*[@id=\"post-body-6170641642826198246\"]/a[2]")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//*[@id=\"post-body-6170641642826198246\"]/a[3]")).click();
		Thread.sleep(500);

		Set<String> allWindows = driver.getWindowHandles();
		int count = allWindows.size();
		System.out.println("Total window:" + count);

//		for (String child : allWindows) {
//			if (!parent.equalsIgnoreCase(child)) {
//				driver.switchTo().window(child);
//				driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
//				Thread.sleep(3000);
//				driver.close();
//			}
//		}
//		driver.switchTo().window(parent);
//		System.out.println("Parent window title is: " + driver.getTitle());

		ArrayList<String> tabs = new ArrayList<>(allWindows);

		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.id("header-search-input")).sendKeys("Selenium");
		System.out.println("The opened window title is: " + driver.getTitle());
		Thread.sleep(1000);

		driver.switchTo().window(parent);
		System.out.println("Parent window title is: " + driver.getTitle());
		Thread.sleep(1000);

		driver.switchTo().window(tabs.get(2));
		driver.findElement(By.id("email")).sendKeys("fatihsaki@yandex.com");
		System.out.println("The opened window title is: " + driver.getTitle());
		Thread.sleep(1000);

		driver.switchTo().window(tabs.get(3));
		driver.findElement(By.name("q")).sendKeys("QA Tester Job");
		System.out.println("The opened window title is: " + driver.getTitle());
		Thread.sleep(1000);

		driver.switchTo().window(tabs.get(2));
		Thread.sleep(500);

		driver.switchTo().window(parent);
		Thread.sleep(500);

		driver.switchTo().window(tabs.get(3));
		Thread.sleep(500);

		driver.quit();
	}

}
