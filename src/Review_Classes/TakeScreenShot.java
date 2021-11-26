package Review_Classes;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import utils.CommonMethods;

public class TakeScreenShot extends CommonMethods {

	public static void main(String[] args) throws IOException, InterruptedException {

		setUpDriver("chrome", "http://demo.automationtesting.in/DynamicData.html");

		driver.findElement(By.id("save")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(3000);

		js.executeScript("window.scrollBy(0,200)");

		take_screnshot("demo.automationtesting","demo.automationtesting");
	}

	public static void take_screnshot(String folder_name,String file_name) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file,
				
				new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots\\"+folder_name  +"/"+ file_name + ".png" ));

		driver.quit();
	}
}
