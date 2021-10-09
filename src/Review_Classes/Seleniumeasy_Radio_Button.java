package Review_Classes;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumeasy_Radio_Button {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.seleniumeasy.com/");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Demo Website!']")).click();
		driver.findElement(By.xpath("//*[text()='No, thanks!']")).click();
	
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='tree-branch']"));

		try {

			for (int i = 0; i < list.size(); i++) {

				System.out.println(list.get(i).getText());

				if (list.get(i).getText().equalsIgnoreCase("Input Forms")) {

					driver.findElement(By.xpath("//*[text()='Input Forms']")).click();
					driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[3]/a")).click();
				}
			}
		} catch (Exception e) {
		}

		List<WebElement> radio = driver.findElements(By.xpath("//*[@type='radio']"));

		for (int j = 0; j < radio.size(); j++) {

			System.out.println("Display = " + radio.get(j).isDisplayed());
			System.out.println("Selected = " + radio.get(j).isSelected());
			System.out.println("Enabled = " + radio.get(j).isEnabled());

		}

		driver.findElement(By.xpath("//*[@value='Male' and @name='optradio']")).click();
		driver.findElement(By.id("buttoncheck")).click();
		System.out.println(driver.findElement(By.xpath("//*[@class='radiobutton']")).getText());

		driver.findElement(By.xpath("//*[@value='Female']")).click();
		driver.findElement(By.id("buttoncheck")).click();
		System.out.println(driver.findElement(By.xpath("//*[@class='radiobutton']")).getText());

		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[1]/input")).click();

		driver.findElement(By.xpath("//*[@value='0 - 5']")).click();
		driver.findElement(By.xpath("//*[text()='Get values']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@class='groupradiobutton']")).getText());

		driver.quit();

	}
}
