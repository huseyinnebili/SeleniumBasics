package Review_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Xpath_Demo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.ebay.com/");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='gh-ac-box2']/input[@class='gh-tb ui-autocomplete-input']")).sendKeys("adidas");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='gh-p-2']//a")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='mainContent']//div[2]//a")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='s0-0-0-30-9-keyword-box-input-textbox']")).sendKeys("shoes");
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//*[@class='suggest-body']//button[@aria-label='Go to list an item page']//span")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='se-category-picker-done-btn']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='None selected']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div[2]/div/div/div[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='View possible matches']")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//*[@aria-label='Select - Size 10 - adidas Matchbreak Super Core Black 2020']//span")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='s0-0-0-30-13-3-6-condition-1750']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class='prelist__next-container']/button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class='gh-td']")).click();
		Thread.sleep(2000);
		
       driver.findElement(By.xpath("//*[@id='gh-ac-box2']/input[@class='gh-tb ui-autocomplete-input']")).sendKeys("skechers");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='gh-btn']")).click();
		Thread.sleep(2000);
		
		
	        driver.quit();
	}

}
