package com.recap;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextBesyBuy {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.bestbuy.com/");
		driver.findElement(By.xpath("//*[@class='modal fade email-submission-modal in']/div/div/div[1]/button/span[2]"))
				.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"header-block\"]/div[2]/div[2]/div/nav[1]/ul/li[1]/button")).click();
		// WebElement element = driver.findElement(By.xpath("//*[@id='menu_wrapper']"));
		List<WebElement> element = driver.findElements(By.xpath("//*[@class='byCategories']"));

		for (WebElement el : element) {
			System.out.println(el.getSize());
			System.out.println(el.getText());

			System.out.println("======================");

			System.out.println("Attribute name is :" + el.getAttribute("class"));

		}

//		System.out.println(element.getSize());
//		System.out.println(element.getText());

		driver.quit();

	}

}
