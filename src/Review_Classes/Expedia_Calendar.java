package Review_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Expedia_Calendar {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.navigate().to("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		driver.manage().window().fullscreen();

		driver.findElement(By.id("datepicker")).click();

		while (true) {

			String text_checkin = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")))
					.getText();

			if (text_checkin.equalsIgnoreCase("March 2030")) {

				break;
			} else {

				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			}
		}

		List<WebElement> days = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td"));

		for (int i = 0; i < days.size(); i++) {

			if (days.get(i).getText().equalsIgnoreCase("13")) {

				days.get(i).click();

				break;
			}
		}

		
		driver.findElement(By.id("datepicker")).click();
		
		while (true) {

			String text_checkin = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div")))
					.getText();

			if (text_checkin.equalsIgnoreCase("March 2015")) {

				break;
			} else {

				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}
		}

		List<WebElement>days_2=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td"));
		
		for (int i = 0; i < days_2.size(); i++) {

			if (days_2.get(i).getText().equalsIgnoreCase("18")) {

				days_2.get(i).click();

				break;
			}
		}

		driver.quit();
	}

}
