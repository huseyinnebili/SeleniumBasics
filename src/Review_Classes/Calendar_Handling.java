package Review_Classes;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_Handling {

	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		String month_checkin = "January 2025";
		String day_checkin = "1";

		String mont_checkout="February 2026";
		String day_checkout="13";
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.navigate().to("https://phptravels.net/");

		driver.manage().window().fullscreen();

		driver.findElement(By.id("checkin")).click();

		while (true) {

			String text_checkin = driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[2]")).getText();

			if (text_checkin.equals(month_checkin)) {

				break;

			} else {

				driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[3]")).click();
			}

		}

		List<WebElement> days_checkin = driver.findElements(By.xpath(" /html/body/div[3]/div[1]/table/tbody/tr/td"));

		for (int i = 0; i < days_checkin.size(); i++) {

			String text_days = days_checkin.get(i).getText();

			System.out.print(text_days+" ");
		}

		for (int i = 0; i < days_checkin.size(); i++) {

			if (days_checkin.get(i).getText().equalsIgnoreCase(day_checkout)) {

				days_checkin.get(i).click();

				break;
			}
		}
		
		while(true) {
			
			String text_checkout=driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[2]")).getText();
			
			if(text_checkout.equalsIgnoreCase(mont_checkout)) {
				
				break;
			}
			
			else {
				
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[3]")).click();
			}
		}
		
		List<WebElement>days_checkout=driver.findElements(By.xpath("/html/body/div[4]/div[1]/table/tbody/tr/td"));
		
		for(int i=0;i<days_checkout.size();i++) {
			
			
			if(days_checkout.get(i).getText().equalsIgnoreCase(day_checkin)) {
				
				days_checkout.get(i).click();
				
				break;
				
			}
		}
		
		driver.manage().window().fullscreen();
		
		Thread.sleep(2000);
		
		takescreenshot("phptravels", "check_calendar");
		
		
	}
		public static void takescreenshot(String folder_name,String file_name) throws IOException {
			
			
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(file, new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots\\"+folder_name  +"/"+ file_name + ".png"));
			
			driver.quit();
		}

		
	}
