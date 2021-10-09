package com.recap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandleChandanachaitanya {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://chandanachaitanya.github.io/selenium-practice-site/?languages=Java&enterText=");

		driver.findElement(By.id("alertBox")).click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();

		String text = alert.getText();
		System.out.println("Alert box text message: " + text);

//		alert.accept();
//		Thread.sleep(2000);

		alert.dismiss();
		Thread.sleep(2000);

		driver.findElement(By.id("confirmBox")).click();
		Thread.sleep(2000);

		System.out.println("Confirm box text message : " + alert.getText());

//		alert.accept();
//		Thread.sleep(2000);

		alert.dismiss();
		Thread.sleep(2000);

		driver.findElement(By.id("promptBox")).click();
		Thread.sleep(2000);

		System.out.println("Prompt box text message: " + alert.getText());
		Thread.sleep(2000);

		driver.switchTo().alert().sendKeys("WebDriver");
		Thread.sleep(2000);

		alert.dismiss();
		Thread.sleep(2000);

		driver.quit();
	}

}
