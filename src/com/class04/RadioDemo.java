package com.class04;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		WebElement maleRadio = driver.findElement(By.name("sex"));
		System.out.println(maleRadio.isDisplayed());// true
		System.out.println(maleRadio.isEnabled());// true
		System.out.println(maleRadio.isSelected());// false
		// Thread.sleep(2000);
		// 1 way of clicking on the element
//		maleRadio.click();
//		System.out.println(maleRadio.isSelected());// true

		// 2 way - preffered way
		String valueToSelect = "Automation Tester";

		List<WebElement> professionList = driver.findElements(By.name("profession"));

		System.out.println("professionList size: " + professionList.size());

		for (WebElement profession : professionList) {

			if (profession.isEnabled()) {

				System.out.println(profession.getText());
				String value = profession.getAttribute("value");
				System.out.println("Value: " + value);

				if (value.equals(valueToSelect)) {

					profession.click();
				}
			}
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
