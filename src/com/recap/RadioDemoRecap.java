package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioDemoRecap {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");

		WebElement radio = driver.findElement(By.name("optradio"));

		System.out.println(radio.isDisplayed());
		System.out.println(radio.isEnabled());
		System.out.println(radio.isSelected());
		Thread.sleep(2000);
		// radio.click();
		Thread.sleep(2000);

		String valueClick = "MalE";

		List<WebElement> radio2 = driver.findElements(By.name("optradio"));

		for (WebElement radio3 : radio2) {
			System.out.println("Radio Attribute: " + radio3.getAttribute("value"));

//			if (radio3.isEnabled()) {
//				String value = radio3.getAttribute("value");
//				System.out.println(value);
//				if (value.equalsIgnoreCase(valueClick)) {
//					radio3.click();
//				}
		}
		boolean value = false;

		value = radio2.get(1).isSelected();

		if (value == false) {

			radio2.get(1).click();

		} else {
			radio2.get(0).click();
		}

		Thread.sleep(2000);
		driver.quit();
	}

}
