package Review_Classes;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Upload_File_And_TakesScreenshot {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait=new  WebDriverWait(driver,20);

		driver.navigate().to("http://demo.guru99.com/test/upload/");

		driver.manage().window().fullscreen();

		Thread.sleep(3000);

		String file_Path = "C:\\Postman Files\\postman.Test_1.csv";

		driver.findElement(By.id("uploadfile_0")).sendKeys(file_Path);

		driver.findElement(By.id("terms")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitbutton"))).click();

		Thread.sleep(2000);

		File file =( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file,

				new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots\\.png"));

	

		driver.quit();
	}

}
