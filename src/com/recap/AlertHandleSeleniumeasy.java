package com.recap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandleSeleniumeasy {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

		driver.findElement(By.xpath("//*[@class='btn btn-default']")).click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		String text = alert.getText();
		System.out.println("Alert box pops up message: " + text);
		Thread.sleep(2000);

		alert.dismiss();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@class='btn btn-default btn-lg'][1]")).click();
		Thread.sleep(2000);

		String text1 = alert.getText();
		System.out.println("Confirm box pops up message: " + text1);

//		alert.dismiss();
//		Thread.sleep(2000);

		alert.accept();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]/button")).click();
		Thread.sleep(2000);

		alert.sendKeys("Huseyin");
		Thread.sleep(2000);

		String text3 = alert.getText();
		System.out.println("Prompt box pops up message: " + text3);

		alert.accept();
		Thread.sleep(2000);

		driver.quit();

	}

}
