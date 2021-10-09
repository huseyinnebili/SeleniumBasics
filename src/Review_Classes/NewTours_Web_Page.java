package Review_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours_Web_Page {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.lightspeed.com/efutures-platform-demo-request/?utm_source=Google&utm_medium=WSI-PPC&utm_campaign=10K-with-Futures-Demo&utm_term=Trading-Demo&gclid=EAIaIQobChMI_rePutCI8gIVCb3ICh1olwozEAAYASAAEgIJbfD_BwE");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"gdpr_ok\"]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("demo_request_fname")).sendKeys("Huseyin");
		Thread.sleep(2000);
		
		driver.findElement(By.id("demo_request_lname")).sendKeys("Nebili");
		Thread.sleep(2000);
		
		driver.findElement(By.id("demo_request_email")).sendKeys("huseyinnebili36@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.name("popup_phone")).sendKeys("2015431233");
		Thread.sleep(2000);
		
//		driver.findElement(By.name("demo_request_refquestion")).sendKeys("LinkedIn");
//		Thread.sleep(2000);
		driver.quit();

	}

}
