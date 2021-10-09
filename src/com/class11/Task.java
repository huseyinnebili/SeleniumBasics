package com.class11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Task extends CommonMethods {

	Properties prop;
	/*
	 * TC 1: OrangeHRM Login
       Navigate to “https://opensource-demo.orangehrmlive.com/”
       Login to the application
       Verify user is successfully logged in
       Note: must use properties file
	 */
	
	@Test
	public void readFile() {
		
		String filePath="src/configs/credentials.properties";
		
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		
	    setUpDriver(prop.getProperty("browser"), prop.getProperty("url"));
	    sendText(driver.findElement(By.cssSelector("input#txtUsername")),"login");
	    sendText(driver.findElement(By.cssSelector("input#txtPassword")),"username");
        driver.findElement(By.cssSelector("input#btnLogin")).click();
		driver.quit();
	}
	
}
