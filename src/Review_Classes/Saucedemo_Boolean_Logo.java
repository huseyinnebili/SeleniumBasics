package Review_Classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Saucedemo_Boolean_Logo {


		public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			driver.navigate().to("https://www.saucedemo.com/");
			driver.manage().window().fullscreen();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			Thread.sleep(2000);

			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();

			boolean logo = driver.findElement(By.xpath("//*[@class='peek']")).isDisplayed();

			if (logo) {
				System.out.println("Logo is displayed");

			} else {

				System.out.println("Logo is not be displayed");
			}

	WebElement product=driver.findElement(By.xpath("//*[text()='Products']"));

			boolean display=product.isDisplayed();
			System.out.println(display);
			String pro_text=product.getText();
				
			System.out.println(pro_text);
				
			if(display) {
				
				driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();
				
				driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
				
				driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();
				
				WebElement element=driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
				String text=element.getText();
				
				if(text.equalsIgnoreCase("Sauce Labs Backpack")) {
					
					driver.findElement(By.id("remove-sauce-labs-backpack")).click();
				}
			}
			
			driver.quit();

	}

}
