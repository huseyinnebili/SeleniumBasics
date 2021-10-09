package com.class11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import utils.CommonMethods;

public class ReadingPropertyFile {

	Properties prop;

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
			
			CommonMethods.setUpDriver(prop.getProperty("browser"), prop.getProperty("url"));
			CommonMethods.driver.quit();
		}
}
