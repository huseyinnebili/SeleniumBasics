package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonSeleniumEasy {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");

		WebElement femaleRadio = driver.findElement(By.name("gender"));

		System.out.println(femaleRadio.isDisplayed());
		System.out.println(femaleRadio.isEnabled());
		System.out.println(femaleRadio.isSelected());

		List<WebElement> radio = driver.findElements(By.name("optradio"));

		for (WebElement radios : radio) {

			String value = radios.getAttribute("value");

			System.out.println(value);

			if (radios.isEnabled() && value.equals("Male")) {

				radios.click();
			}

		}

		driver.findElement(By.id("buttoncheck")).click();
		WebElement text = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]"));
		System.out.println(text.getText());

		WebElement elmt = driver.findElement(By.name("ageGroup"));

		System.out.println(elmt.isDisplayed());
		System.out.println(elmt.isEnabled());
		System.out.println(elmt.isSelected());

		String valueXML = "5 - 15";

		List<WebElement> el = driver.findElements(By.name("ageGroup"));

		for (WebElement elm : el) {

			String valueReal = elm.getAttribute("value");

			System.out.println(valueReal);

			if (valueReal.equalsIgnoreCase(valueXML)) {
				elm.click();
			}
		}

		driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/button")).click();
		WebElement elmntt = driver.findElement(By.className("groupradiobutton"));
		System.out.println(elmntt.getText());

		Thread.sleep(3000);
		driver.quit();
	}
}