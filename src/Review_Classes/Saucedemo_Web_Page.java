package Review_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Saucedemo_Web_Page {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("huseyinnebili36@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("input#pass")).sendKeys("2112522Hn.");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("a[class='_42ft _4jy0 _82go _4jy6 _517h _51sy']")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.cssSelector("div[class='VfPpkd-RLmnJb']")).click();
		Thread.sleep(3000);
		

		driver.quit();
	}

}
