package Review_Classes;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alert_Handle_of_uitestpractice_com {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.navigate().to("http://uitestpractice.com/Students/Switchto");
		driver.manage().window().fullscreen();

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirm")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		WebElement element_2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='row']/button[@id='alert']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_2);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		WebElement element_3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("prompt")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_3);
		driver.switchTo().alert().sendKeys("Huseyin Nebili");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("demo")).getText());

		WebElement element_4 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='row']/button[@type='button']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_4);

		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

		driver.quit();
	}
}
