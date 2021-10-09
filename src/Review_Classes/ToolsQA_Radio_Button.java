package Review_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolsQA_Radio_Button {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://demoqa.com/");
		driver.manage().window().fullscreen();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(2000);

		try {

			WebElement button = driver.findElement(By.xpath("//*[@class='card-body']/h5[text()='Elements']"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", button);

			driver.findElement(By.xpath("//*[text()='Radio Button']")).click();

			List<WebElement> radio_button = driver.findElements(By.name("like"));

			for (int i = 0; i < radio_button.size(); i++) {
				System.out.println(radio_button.get(i).isDisplayed());
				System.out.println(radio_button.get(i).isEnabled());
				System.out.println(radio_button.get(i).isSelected());

			}

			js.executeScript("arguments[0].click()", driver.findElement(By.id("yesRadio")));
			String text = driver.findElement(By.xpath("//*[@class='mt-3']")).getText();
			System.out.println("Text_1 = " + text);
			Thread.sleep(3000);
			js.executeScript("arguments[0].click()", driver.findElement(By.id("impressiveRadio")));
			String text_1 = driver.findElement(By.xpath("//*[@class='mt-3']")).getText();
			System.out.println("Text_2 = " + text_1);
			Thread.sleep(3000);

		} catch (Exception e) {
		}

	//	driver.quit();

	}
}
