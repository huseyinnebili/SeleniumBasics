package com.recap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropJqueryui {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/");

		driver.findElement(By.xpath("//*[@id='sidebar']/aside/ul/li[2]")).click();
		Thread.sleep(2000);

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='demo-frame']")));

		Actions action = new Actions(driver);

		action.dragAndDrop(
				driver.findElement(By.xpath("//*[@class='ui-widget-content ui-draggable ui-draggable-handle']")),
				driver.findElement(By.xpath("//*[@class='ui-widget-header ui-droppable']"))).perform();

		String text = driver.findElement(By.xpath("//*[@class='ui-widget-header ui-droppable ui-state-highlight']"))
				.getText();

		if (text.equalsIgnoreCase("Dropped!")) {

			System.out.println("PASS: Source is dropped to target as expected");
		} else {
			System.out.println("FAIL: Source couldn't be dropped to target as expected");
		}
		Thread.sleep(2000);
		driver.quit();

	}

}
