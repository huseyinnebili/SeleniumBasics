package com.class6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class setUpDriver {

	public static WebDriver driver1;
	public static void main(String[] args) {
		setUpDriver("chrome", "hptt://www.amazon.com/");
	}

	public static void setUpDriver(String browser, String url) {
	
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
			driver1 = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/husey/Selenium/geckodriver.exe");
			driver1 = new FirefoxDriver();
		} else {
			System.out.println("browser given is wrong");
		}
		driver1.get(url);
		driver1.manage().window().maximize();

	}
}