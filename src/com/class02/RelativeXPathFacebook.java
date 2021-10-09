package com.class02;


	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	public class RelativeXPathFacebook {
	
		public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "/Users/husey/Selenium/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	//driver.get("https://www.toolsqa.com/automation-practice-form/");
	//driver.findElement(By.xpath("html/body/div/div[5]/div/div/div/div/div/div/div/div[2]/div/form/fieldset/div[8]/input[@name='firstname']")).sendKeys("name");
	driver.get("https://www.facebook.com/");
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("fatihsaki@yandex.com");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("2112522hn");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[@class='uiButton uiButtonConfirm']")).click();
Thread.sleep(2000);
	driver.close();

		}}

