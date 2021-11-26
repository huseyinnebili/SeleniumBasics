package com.class9;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import utils.CommonMethods;

public class FluentWaitDemo extends CommonMethods {

	public static void main(String[] args) {

	//	setUpDriver("chrome", "\"https://the-internet.herokuapp.com/");
System.setProperty("webdriver.chrome.driver", "C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

        WebDriver driver =new ChromeDriver();
        
        driver.navigate().to("https://the-internet.herokuapp.com/");

		String text = "Dynamic Controls";
		driver.findElement(By.linkText(text)).click();

		FluentWait wait = new FluentWait(driver);
		wait.ignoring(NoSuchElementException.class);

		String buttonXpath = "//button[text()='Enable']";
		driver.findElement(By.xpath(buttonXpath)).click();
	}

}
