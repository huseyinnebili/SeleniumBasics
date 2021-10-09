package com.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");

//		TC 1: Amazon Department List Verification
//		Open chrome browser
//		Go to “http://amazon.com/”
//		Verify how many department options available.
//		Print each department
//		Select Computers
//		Quit browser

		WebElement list = driver.findElement(By.id("searchDropdownBox"));
		Select select = new Select(list);

		List<WebElement> listText = select.getOptions();
		System.out.println(listText.size());

		for (WebElement list1 : listText) {

			System.out.println(list1.getText());

		}
		select.selectByVisibleText("Computers");
		select.selectByIndex(49);  
		

		Thread.sleep(7000);
		driver.quit();

	}
}