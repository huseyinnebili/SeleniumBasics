package Review_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Para_Bank {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=6AAB6E40702D36DA111142142AA610F9");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("customer.firstName")).sendKeys("Ahmet");
		Thread.sleep(2000);
		
		driver.findElement(By.id("customer.lastName")).sendKeys("Veli");
		Thread.sleep(2000);
		
		driver.findElement(By.id("customer.address.street")).sendKeys("Wayne/NJ");
		Thread.sleep(2000);
		
		driver.findElement(By.id("customer.address.city")).sendKeys("Wayne");
		Thread.sleep(2000);
		
		driver.findElement(By.id("customer.address.state")).sendKeys("NJ");
		Thread.sleep(2000);
		
		
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("07470");
		Thread.sleep(2000);
		
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("2017574732");
		Thread.sleep(2000);
		
		driver.findElement(By.id("customer.ssn")).sendKeys("06521232");
		Thread.sleep(2000);
		
		driver.findElement(By.id("customer.username")).sendKeys("AliRiza");
		Thread.sleep(2000);
		
		driver.findElement(By.id("customer.password")).sendKeys("abcd123.");
		Thread.sleep(2000);
		
		driver.findElement(By.id("repeatedPassword")).sendKeys("abcd123.");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@value='Register']")).click();
		Thread.sleep(200);
		
		driver.quit();
	}

}
