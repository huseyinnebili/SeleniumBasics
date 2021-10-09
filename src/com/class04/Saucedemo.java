package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Saucedemo {

	String userName = "standard_user";
	String password = "secret_sauce";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");

		// login to the application
		WebElement userName = driver.findElement(By.xpath("//input[(@type='text')]"));
		userName.sendKeys("standard_user");
		WebElement passWord = driver.findElement(By.xpath("//input[(@type='password')]"));
		passWord.sendKeys("secret_sauce");

		// logo verification
		WebElement login = driver.findElement(By.cssSelector("input[type='submit']"));
		login.click();

		boolean logo = driver.findElement(By.cssSelector("div[id='page_wrapper']")).isDisplayed();

		if (logo) {
			System.out.println("Robot  logo is displayed");
		} else {
			System.out.println("Robot  logo is NOT displayed");
		}

		// verify product text
		WebElement product = driver.findElement(By.cssSelector("div.product_label"));

		boolean displayP = product.isDisplayed();
		String productText = product.getText();

		String expectedText = "Products";

		if (displayP && productText.equals(expectedText)) {
			System.out.println("Element is displayed and texts is " + productText);
		} else {
			System.out.println("Element is NOT displayed OR textis NOT=" + productText);
		}
		Thread.sleep(3000);
		 driver.quit();

	}
}