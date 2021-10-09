package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox2Techlistic {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

		WebElement element = driver.findElement(By.name("profession"));

		System.out.println(element.isDisplayed());
		System.out.println(element.isEnabled());
		System.out.println(element.isSelected());

		List<WebElement> list = driver.findElements(By.name("profession"));

		int size = list.size();

		for (int i = 0; i < size; i++) {

			String values = list.get(i).getAttribute("value");
			System.out.println("Values : " + values);

			list.get(i).click();

			System.out.println("List Selected First Condition: " + list.get(i).isSelected());

			if (values.equalsIgnoreCase("Manual Tester")) {
				list.get(i).click();
				System.out.println("List Selected Second Condition: " + list.get(i).isSelected());
			}

			if (values.equalsIgnoreCase("Automation Tester")) {
				list.get(i).click();
				System.out.println("List Selected Third Condition: " + list.get(i).isSelected());
			}
		}

		Thread.sleep(3000);
		driver.quit();
	}

}
