package Review_Classes;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Multi_Dropdown_seleniumeasy_com {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		driver.manage().window().fullscreen();

		driver.findElement(By.id("at-cv-lightbox-close")).click();

		driver.findElement(By.id("btn_basic_example")).click();

		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='list-group']/a")));

			List<WebElement> list = driver.findElements(By.xpath("//*[@class='list-group']/a"));

			for (int i = 0; i < list.size(); i++) {

				System.out.println(list.get(i).getText());
			}

			for (int i = 0; i < list.size(); i++) {

				if (list.get(i).getText().contains("Select Dropdown List")) {

					driver.findElement(By.xpath("//*[@class='list-group']//a[text()='Select Dropdown List']")).click();
				}

			}

		} catch (Exception e) {
		}

		List<WebElement> dropdown_list = driver.findElements(By.xpath("//*[@id='select-demo']/option"));

		for (int i = 0; i < dropdown_list.size(); i++) {

			System.out.println("Atribute Value of Select List Demo = " + dropdown_list.get(i).getAttribute("value"));
			System.out.println("Text of Select List Demo = " + dropdown_list.get(i).getText());

		}

		driver.findElement(By.xpath("//*[@id='select-demo']")).click();

		Select dropdown = new Select(driver.findElement(By.id("select-demo")));

		dropdown.selectByIndex(0);
		dropdown.selectByValue("Sunday");
		dropdown.selectByVisibleText("Monday");

		String selected_value = driver.findElement(By.xpath("//*[@class='selected-value']")).getText();

		System.out.println("Selected Value = " + selected_value);

		Select multi_dropdown = new Select(driver.findElement(By.id("multi-select")));

		multi_dropdown.selectByIndex(0);
		multi_dropdown.selectByValue("Florida");
		multi_dropdown.selectByValue("New Jersey");
		multi_dropdown.selectByVisibleText("New York");
		multi_dropdown.selectByVisibleText("Ohio");
		multi_dropdown.selectByIndex(5);
		multi_dropdown.selectByIndex(6);
		multi_dropdown.selectByIndex(7);

		multi_dropdown.getAllSelectedOptions();

		List<WebElement> multi_select_list = multi_dropdown.getAllSelectedOptions();

		for (int i = 0; i < multi_select_list.size(); i++) {

			String multi_select_text = multi_select_list.get(i).getText();

			System.out.println("Multi select text list = " + multi_select_text);
		}

		multi_dropdown.deselectAll();

		driver.quit();
	}
}
