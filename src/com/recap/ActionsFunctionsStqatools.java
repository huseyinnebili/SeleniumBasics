package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsFunctionsStqatools {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demo.stqatools.com/");

		driver.findElement(By.xpath("//*[@id=\"navbarColor02\"]/ul/li[4]")).click();
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"navbarColor02\"]/ul/li[4]"));

		for (WebElement lists : list) {

			// System.out.println("Values: " + lists.getAttribute("class"));
			String text = lists.getText();
			System.out.println("Text : " + text);
		}

		driver.findElement(By.xpath("//*[@id=\"navbarColor02\"]/ul/li[4]/div/a[3]")).click();
		Thread.sleep(2000);

		Actions action = new Actions(driver);

		WebElement element = driver.findElement(By.xpath("//*[@class='container']/div/div[2]/p/button"));

		action.doubleClick(element).perform();

		String text1 = element.getText();
		System.out.println("Text1 :" + text1);
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/nav/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"navbarColor02\"]/ul/li[4]")).click();
		Thread.sleep(2000);

		WebElement element1 = driver.findElement(By.xpath("//*[@id='navbarColor02']/ul/li[4]/div/a[2]"));
		element1.click();
		Thread.sleep(2000);

		action.moveToElement(driver.findElement(By.xpath("//*[@class='dropbtn']"))).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/nav/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"navbarColor02\"]/ul/li[4]")).click();
		Thread.sleep(2000);

		WebElement element2 = driver.findElement(By.xpath("//*[@class='dropdown-menu dropdown-menu-right show']/a[1]"));
		element2.click();
		Thread.sleep(2000);

		driver.quit();
	}

}
