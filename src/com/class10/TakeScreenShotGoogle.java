package com.class10;


	import java.io.File;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;

	import utils.CommonMethods;

	public class TakeScreenShotGoogle extends CommonMethods{

		public static void main(String[] args) {
			
			setUpDriver("chrome", "http://google.com");
			
			TakesScreenshot camera=(TakesScreenshot)driver;
			File selfie=camera.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(selfie, new File("screenshots/Google/GoolePage.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Selfie not taken");
			}
			driver.quit();
		}
}
