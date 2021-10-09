package com.recap;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorGuru99 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://canvas.instructure.com/login/canvas#view_start=2019-02-09&view_name=month");

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.getElementById('email--3').value='huseyinnebili@hotmail.com';");
//		js.executeScript("document.getElementById('id_password').value='2112522';");

		js.executeScript("document.getElementById('pseudonym_session_unique_id').value='huseyinnebili36@gmail.com';");
		js.executeScript("document.getElementById('pseudonym_session_password').value='2112522hn';");

		WebElement element = driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[3]/div[2]/button"));
		element.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,-250)");
		Thread.sleep(2000);

		driver.get("https://www.yahoo.com/");

		WebElement element1 = driver.findElement(By.id("header-search-input"));

		element1.sendKeys(Keys.RETURN);
		Thread.sleep(2000);

		element1.sendKeys("QA");
		Thread.sleep(2000);

		element1.sendKeys(Keys.TAB);
		Thread.sleep(2000);

		element1.sendKeys("Tester");
		Thread.sleep(2000);

		element1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		driver.quit();
	}

}
