package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.CommonMethods;

public class CheckBoxTechlistic extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

		WebElement element = driver.findElement(By.name("tool"));

		System.out.println(element.isDisplayed());
		System.out.println(element.isEnabled());
		System.out.println(element.isSelected());

		List<WebElement> element1 = driver.findElements(By.name("tool"));

		int checkSize = element1.size();

		for (int i = 0; i < checkSize; i++) {
			element1.get(i).click(); // to select multiple check boxes

			String value = element1.get(i).getAttribute("value");

			System.out.println(value);

//			if (value.equalsIgnoreCase("Selenium IDE")) { // to select single check box
//				element1.get(i).click();
//				 break;
//			}

		}
		Thread.sleep(3000);
		driver.quit();

	}

}
