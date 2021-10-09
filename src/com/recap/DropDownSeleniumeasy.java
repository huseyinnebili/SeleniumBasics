package com.recap;

import java.util.List;

import javax.crypto.spec.DESedeKeySpec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSeleniumeasy {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");

		// To select single dropdown
		System.out.println("=========To select single dropdown========");

		WebElement days = driver.findElement(By.id("select-demo"));

		Select select = new Select(days);

		List<WebElement> options = select.getOptions();

		System.out.println("The size of days: " + options.size());

		for (WebElement option : options) {

			// String text = option.getText();

			System.out.println("Values: " + option.getAttribute("value"));
			System.out.println("Days texts: " + option.getText());

		}

		select.selectByVisibleText("Monday");

		WebElement selectedOpt = select.getFirstSelectedOption();
		String currentOpt = selectedOpt.getText();
		System.out.println("Selected option is " + currentOpt);
		Thread.sleep(2000);

		select.selectByIndex(4);

		WebElement selectedOpt1 = select.getFirstSelectedOption();
		String currentOpt1 = selectedOpt1.getText();
		System.out.println("Selected option is " + currentOpt1);
		Thread.sleep(2000);

		// select.deselectAll();
		// Thread.sleep(3000);
		// deselect from single DD--> we will get UnsupportedOperationException:

		select.selectByValue("Thursday");

		WebElement selectedOpt2 = select.getFirstSelectedOption();
		String currentOpt2 = selectedOpt2.getText();
		System.out.println("Selected option is " + currentOpt2);
		Thread.sleep(2000);

		// To select multi-dropdown
		System.out.println("=========To select multi-dropdown========");

		WebElement days2 = driver.findElement(By.id("multi-select"));

		Select select2 = new Select(days2);

		List<WebElement> list = select2.getOptions();

		for (WebElement lists : list) {

			System.out.println("Values: " + lists.getAttribute("value"));
			System.out.println("Texts: " + lists.getText());

			lists.click();

		}

		List<WebElement> selAllOpt = select2.getAllSelectedOptions();
		for (WebElement selAllOption : selAllOpt) {
			String currentOptions = selAllOption.getText();
			System.out.println(currentOptions + " is selected.");
		}

		select2.deselectAll();
		Thread.sleep(2000);

		select2.selectByIndex(2);
		WebElement selectOpt = select2.getFirstSelectedOption();
		String curOpt = selectOpt.getText();
		System.out.println(curOpt + " is selected.");
		Thread.sleep(2000);

		select2.selectByValue("Pennsylvania");
		Thread.sleep(2000);

		List<WebElement> selOpt1 = select2.getAllSelectedOptions();
		for (WebElement sellOpt1 : selOpt1) {
			String curOpt1 = sellOpt1.getText();
			System.out.println(curOpt1 + " is selected.");
		}

		

		select2.deselectAll();
		Thread.sleep(2000);

		driver.quit();
	}

}
