package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsFunctionsDemoqa {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://demoqa.com/menu/");

		// WebElement element = driver.findElement(By.id("mousehover"));

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.id("ui-id-4"))).perform();
		Thread.sleep(2000);

		action.moveToElement(driver.findElement(By.id("ui-id-9"))).perform();
		Thread.sleep(2000);

		action.moveToElement(driver.findElement(By.id("ui-id-10"))).perform();
		Thread.sleep(2000);

		action.moveToElement(driver.findElement(By.id("ui-id-13"))).perform();
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.id("menu"));

		for (WebElement lists : list) {
			String text = lists.getText();
			System.out.println("Text : " + text);

			System.out.println("Values : " + lists.getAttribute("class"));
		}

		driver.quit();

	}
}