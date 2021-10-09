package Review_Classes;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown_of_courses_letskodeit_com {

	public static String username = "Tester";
	public static String password = "test";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to("https://courses.letskodeit.com/practice");
		driver.manage().window().fullscreen();

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='multiple-select-example']/option"));

		for (WebElement lists : list) {

			System.out.println("Attribute Value of Select Class = " + lists.getAttribute("value"));
			System.out.println("Text of Select Class = " + lists.getText());

		}
		WebElement element = driver.findElement(By.id("multiple-select-example"));

		Select dropdown = new Select(element);
		dropdown.selectByVisibleText("Apple");
		dropdown.selectByVisibleText("Orange");

		dropdown.deselectByVisibleText("Apple");
		dropdown.deselectByVisibleText("Orange");

		dropdown.selectByIndex(2);

		dropdown.selectByValue("peach");

		System.out.println("=================");

		List<WebElement> element_2 = driver.findElements(By.xpath("//*[@id='carselect']/option"));

		for (int i = 0; i < element_2.size(); i++) {

			System.out.println("Attribute Value of Multiple Select Class = " + element_2.get(i).getAttribute("value"));
			System.out.println("Text of Multiple Select Class = " + element_2.get(i).getText());
		}

		Select dropdown_2 = new Select(driver.findElement(By.id("carselect")));

		dropdown_2.selectByIndex(0);
		Thread.sleep(2000);
		dropdown_2.selectByValue("benz");
		Thread.sleep(2000);
		dropdown_2.selectByVisibleText("Honda");
		Thread.sleep(2000);

		driver.quit();

	}
}
