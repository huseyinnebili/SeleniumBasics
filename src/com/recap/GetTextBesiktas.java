package com.recap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextBesiktas {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://en.wikipedia.org/wiki/Be%C5%9Fikta%C5%9F_J.K.");
		WebElement element = driver.findElement(By.xpath("//table[@border='0']"));
		System.out.println(element.getText());
		driver.quit();
	}

}
