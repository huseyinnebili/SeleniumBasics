package Review_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class herokuapp_com_Review {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to("http://the-internet.herokuapp.com/");

		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, 10);

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='content']/ul/li"));

		System.out.println("=======Texts of the List===========");

		for (int i = 0; i < list.size(); i++) {

			String text_of_list = list.get(i).getText();

			System.out.println(text_of_list);

		}

		try {
			for (int i = 0; i < list.size(); i++) {

				if (list.get(i).getText().equals("Sortable Data Tables")) {

					js.executeScript("arguments[0].click()",
							driver.findElement(By.xpath("//*[text()='Sortable Data Tables']")));
				}
			}

		} catch (Exception e) {

		}

		System.out.println("========== The handling of first WebTable ===========");

		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));
		System.out.println("The size of rows = " + rows.size());

		System.out.println("========== The text of Rows ===========");
		for (int i = 0; i < rows.size(); i++) {

			String text_of_rows = rows.get(i).getText();

			System.out.println(text_of_rows);
		}

		List<WebElement> columns = driver.findElements(By.xpath("//*[@id='table1']/thead/tr/th"));
		System.out.println("The size of columns = " + columns.size());

		System.out.println("=========The text of columns=======");

		for (int i = 0; i < columns.size(); i++) {

			String text_of_columns = columns.get(i).getText();

			System.out.println(text_of_columns);

		}

		List<WebElement> cells = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr/td"));

		System.out.println("===========The text of cells========= ");

		for (int i = 0; i < cells.size(); i++) {

			String text_of_cells = cells.get(i).getText();

			System.out.println(text_of_cells);
		}

		System.out.println("========Handling Dynmaic Elements with Explicit Wait===========");

		driver.navigate().to("http://the-internet.herokuapp.com/");

		driver.findElement(By.xpath("//*[text()='Dynamic Content']")).click();

		WebElement dynamic_element = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]"));

		String text_dynamic_element = dynamic_element.getText();

		System.out.println("The text of the first text = " + text_dynamic_element);

		WebElement click_here = driver.findElement(By.xpath("//*[text()='click here']"));

		click_here.click();

		String tetx_dynamic_element_2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[3]/div[2]"))).getText();

		System.out.println("The text of the second text = " + tetx_dynamic_element_2);

		System.out.println(text_dynamic_element.equalsIgnoreCase(tetx_dynamic_element_2));

		WebElement static_element = driver.findElement(By.xpath("//*[@id='content']/div[1]/div[2]"));

		String text_static_element = static_element.getText();

		System.out.println("The first time of the text of the static element = " + text_static_element);

		Thread.sleep(3000);

		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[text()='click here']")));

		String text_static_element_2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[1]/div[2]"))).getText();

		System.out.println("The second time of the text of the static element =" + text_static_element_2);

		System.out.println(text_static_element.equalsIgnoreCase(text_static_element_2));

		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[text()='click here']")));

		String tetx_dynamic_element_3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[1]/div[2]"))).getText();

		System.out.println("The third time of the text of the dynamic element =" + tetx_dynamic_element_3);

		System.out.println(tetx_dynamic_element_3.equalsIgnoreCase(tetx_dynamic_element_2));

		driver.navigate().back();
		
		driver.navigate().back();

		driver.findElement(By.linkText("Dynamic Controls")).click();

		WebElement checkbox = driver.findElement(By.id("checkbox"));

		System.out.println("======Checking of Checkbox before clicking on Remove Button=====");

		System.out.println(checkbox.isSelected());
		System.out.println(checkbox.isDisplayed());
		System.out.println(checkbox.isEnabled());

		WebElement checkbox_button = driver.findElement(By.xpath("//*[@type='checkbox']"));

		checkbox_button.click();

		Thread.sleep(3000);

		System.out.println("Checking of checkbox after clicking = " + checkbox_button.isSelected());

		driver.findElement(By.xpath("//*[@autocomplete='off' and @onclick='swapCheckbox()']")).click();
		
		System.out.println("======Checking of Checkbox after clicking on Remove Button=====");

		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]"))).getText());

		driver.findElement(By.xpath("//*[@id='checkbox-example']/button")).click();
		
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message"))).getText());

		WebElement checkbox_button_back = driver.findElement(By.xpath("//*[@id='checkbox-example']/div/input"));

		System.out.println("Checking before clicking on checkboc back box = " + checkbox_button_back.isSelected());

		checkbox_button_back.click();

		System.out.println("Checking after clicking on checkboc back box = " + checkbox_button_back.isSelected());

		System.out.println(driver.findElement(By.xpath("//*[@id='input-example']/input")).isEnabled());
		
		driver.findElement(By.xpath("//*[@id='input-example']/button")).click();
		
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']"))).getText());
		
		System.out.println(driver.findElement(By.xpath("//*[@id='input-example']/input")).isEnabled());
		
		driver.findElement(By.xpath("//*[@id='input-example']/input")).sendKeys("Hello World!");
		
		driver.navigate().back();
		
		driver.findElement(By.linkText("Dynamic Loading")).click();
		
		driver.findElement(By.xpath("//*[text()='Example 1: Element on page that is hidden']")).click();
		
		driver.findElement(By.xpath("//*[@id='start']/button")).click();
		
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4"))).getText());
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[text()='Example 2: Element rendered after the fact']")).click();
		
		driver.findElement(By.xpath("//*[@id='start']/button")).click();
		
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='finish']/h4"))).getText());
		
		driver.quit();
	}

}
