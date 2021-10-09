package com.recap;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowsToolsqa {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");

		WebElement childWindow1 = driver.findElement(By.id("win1"));
		childWindow1.click();
		Thread.sleep(3000);

		WebElement childWindow2 = driver.findElement(By.id("win2"));
		childWindow2.click();
		Thread.sleep(3000);

		String mainWindow = driver.getWindowHandle();
		System.out.println("window handle: " + mainWindow);

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> it = s1.iterator();
		while (it.hasNext()) {
			String childWindow = it.next();
			System.out.println("ChildWindow id : " + childWindow);

			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);

			}

		}
		driver.switchTo().window(mainWindow);

		Thread.sleep(2000);
		driver.quit();

	}
}
