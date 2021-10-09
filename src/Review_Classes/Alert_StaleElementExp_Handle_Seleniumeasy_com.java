package Review_Classes;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_StaleElementExp_Handle_Seleniumeasy_com {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.navigate().to("https://www.seleniumeasy.com/");
		driver.manage().window().fullscreen();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.xpath("//*[text()='Demo Website!']")).click();
		driver.findElement(By.id("at-cv-lightbox-close")).click();
		driver.findElement(By.id("btn_basic_example")).click();

		String exp_text = "Javascript Alerts";
		try {
			List<WebElement> list = driver.findElements(By.xpath("//*[@class='list-group']/a"));

			for (int i = 0; i < list.size(); i++) {

				String text = list.get(i).getText();
				System.out.println(text);

				Thread.sleep(500);

			}

			list = driver.findElements(By.xpath("//*[@class='list-group']/a"));

			for (int i = 0; i < list.size(); i++) {

				js.executeScript("window.scrollBy(0,200)");

				if (list.get(i).getText().contains(exp_text)) {

					list.get(i).click();

					js.executeScript("window.scrollBy(0,200)");

					driver.findElement(By.xpath("//*[@onclick='myAlertFunction()']")).click();
					System.out.println(driver.switchTo().alert().getText());
					driver.switchTo().alert().accept();

					driver.findElement(By.xpath("//*[@onclick='myConfirmFunction()']")).click();
					System.out.println(driver.switchTo().alert().getText());
					driver.switchTo().alert().accept();

					driver.findElement(By.xpath("//*[@onclick='myPromptFunction()']")).click();
					driver.switchTo().alert().sendKeys("Huseyin Nebili");
					driver.switchTo().alert().accept();
					System.out.println(driver.findElement(By.id("prompt-demo")).getText());

				}

			}
		} catch (Exception e) {

		}

		Thread.sleep(2000);
		driver.quit();
	}

}
