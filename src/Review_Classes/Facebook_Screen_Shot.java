package Review_Classes;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Facebook_Screen_Shot {

	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		

		driver.navigate().to("https://www.facebook.com/");
		
		TakeScreenshot("FacebookScreenshot");
	}
		public static void TakeScreenshot(String file_name) throws IOException {
			
			//1-Take screenshot and store it as a file format
			
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			//2-Copy the screenshot to a desired location using copyfile method
			
			
			FileHandler.copy(file, new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots.png"+file_name));
			
			driver.quit();
			
		}
		
	}


