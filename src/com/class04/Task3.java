package com.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		List<WebElement> yearsExp = driver.findElements(By.name("exp"));

		for (WebElement exper : yearsExp) {
			if (exper.isEnabled()) {
				exper.click();
				Thread.sleep(2000);
			}

		}

		List<WebElement> toolList = driver.findElements(By.name("tool"));

		for (WebElement tool : toolList) {
			System.out.println(tool.isEnabled());// true

			System.out.println(tool.getAttribute("value"));
			Thread.sleep(2000);

		}

		driver.quit();
	}
}