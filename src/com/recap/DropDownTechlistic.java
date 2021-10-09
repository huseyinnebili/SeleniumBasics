package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTechlistic {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

		// To select multi-dropdown
		System.out.println("=========To select multi-dropdown========");

		WebElement element = driver.findElement(By.id("selenium_commands"));
		Select select = new Select(element);

		boolean check1 = select.isMultiple();
		System.out.println("The checkbox is multiple. " + check1);

		select.deselectAll();
		Thread.sleep(5000);

		select.selectByVisibleText("Switch Commands");
		Thread.sleep(5000);

		select.selectByVisibleText("WebElement Commands");
		Thread.sleep(5000);

		select.deselectAll();
		Thread.sleep(5000);

		List<WebElement> options = select.getOptions();

		for (WebElement option : options) {

			String value = option.getAttribute("value");
			System.out.println(value);
			option.click();
		}

		// To select single dropdown
		System.out.println("=========To select single dropdown========");

		WebElement element2 = driver.findElement(By.id("continents"));
		Select select2 = new Select(element2);

		boolean check = select2.isMultiple();
		System.out.println("The checkbox is  multiple. " + check);

		List<WebElement> opt = select2.getOptions();

		for (WebElement opts : opt) {
			String val = opts.getAttribute("value");
			System.out.println("Values: " + val);
		}

		select2.selectByVisibleText("Antartica");
		Thread.sleep(5000);

		// select2.deselectAll(); // deselect from single DD--> we will get
		// UnsupportedOperationException:
		// Thread.sleep(5000);

		driver.quit();
	}

}
