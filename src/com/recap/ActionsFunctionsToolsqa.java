package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsFunctionsToolsqa {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoqa.com/tooltip-and-double-click/");

		// WebElement element = driver.findElement(By.id("rightClickBtn"));

		Actions action = new Actions(driver);

		action.contextClick(driver.findElement(By.id("rightClickBtn"))).perform();
		System.out.println("Right click action is displayed");
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.className("contextMenuItem"));

		for (WebElement lists : list) {
			String clicks = lists.getAttribute("onclick");
			System.out.println("Click Items : " + clicks);

		}

		driver.findElement(By.xpath("//*[@id=\"rightclickItem\"]/div[1]")).click();

		Alert alert = driver.switchTo().alert();

		System.out.println("Edit Alert Message : " + alert.getText());

		alert.accept();
		Thread.sleep(2000);

		action.contextClick().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@class='contextMenuItem'][3]")).click();
		System.out.println("Tag Alert Message : " + alert.getText());

		alert.accept();
		Thread.sleep(2000);

		action.contextClick().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@class='contextMenuItem'][4]")).click();
		System.out.println("Favourites Alert Message : " + alert.getText());

		alert.accept();
		Thread.sleep(2000);

		action.contextClick().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@class='contextMenuItem'][5]")).click();
		System.out.println("Export Alert Message : " + alert.getText());

		alert.accept();
		Thread.sleep(2000);

		action.doubleClick(driver.findElement(By.id("doubleClickBtn"))).perform();
		Thread.sleep(2000);

		System.out.println("DoubleClick Alert Message : " + alert.getText());

		alert.accept();
		Thread.sleep(2000);

		WebElement element1 = driver.findElement(By.id("tooltipDemo"));
		action.moveToElement(element1).perform();
		System.out.println("Mouse Hover Messasge : " + element1.getText());
		Thread.sleep(2000);

		driver.quit();
	}

}
