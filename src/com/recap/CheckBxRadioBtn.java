package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBxRadioBtn {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> radio = driver.findElements(By.name("optradio"));
		for (WebElement rad : radio) {

			System.out.println(rad.getAttribute("name"));
		}

		System.out.println(radio.size());

		boolean bValue = false;// bVlaue=false

		bValue = radio.get(0).isSelected();// false=female

		Thread.sleep(2000);

		if (bValue == false) {

			radio.get(1).click();

		} else {
			radio.get(0).click();

		}

		Thread.sleep(2000);
		driver.quit();
	}

}
