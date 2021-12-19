package webdriveruniversity;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Review_Classes.TakeScreenShot;

public class webdriveruniversity_com_Review_Topics_4 {

	static WebDriver driver;

	public static void broken_link() throws IOException {

		List<WebElement> list_of_links = driver.findElements(By.tagName("a"));

		for (WebElement list_of_link : list_of_links) {

			String url = list_of_link.getAttribute("href");

			try {

				URL link = new URL(url);

				HttpURLConnection http_connect = (HttpURLConnection) link.openConnection();

				http_connect.connect();

				int broken_link_code = http_connect.getResponseCode();

				if (broken_link_code >= 400) {

					System.out.println(url + " is broken link.");
				} else {

					System.out.println(url + " is valid link.");
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public static void takescreenshot(String folder_name, String file_name) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots\\"
				+ folder_name + "/" + file_name + ".png"));

	}

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to("http://webdriveruniversity.com/index.html");

		driver.manage().window().fullscreen();

		String main_window = driver.getWindowHandle();

		System.out.println("The TITLE of the main window = " + driver.getTitle());
		System.out.println("The ID of the main window = " + main_window);

		broken_link();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='data-table']/div/div[1]/h1")))
				.click();

		Thread.sleep(2000);

		Set<String> windows = driver.getWindowHandles();

		for (String datatable_window : windows) {

			if (!datatable_window.equals(main_window)) {

				driver.switchTo().window(datatable_window);

				System.out.println("The TITLE of the datatable window = " + driver.getTitle());
				System.out.println("The ID of the datatable window = " + driver.getWindowHandle());
			}
		}

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='t01']/tbody/tr/td"));

		for (int i = 0; i < list.size(); i++) {

			System.out.println(list.get(i).getText());
		}

		driver.findElement(By.name("firstname")).sendKeys("Abuzer");

		driver.findElement(By.name("lastname")).sendKeys("Kadayif");

		driver.findElement(By.xpath("//*[@id='form-textfield']/textarea")).sendKeys("Hello World!");

		takescreenshot("webdriveruniversity", "webtable");

		Thread.sleep(2000);

		List<WebElement> list_2 = driver
				.findElements(By.xpath("//*[@class='table table-light traversal-table']/tbody/tr/td"));

		for (WebElement table_list : list_2) {

			System.out.println(table_list.getText());

		}

		System.out.println("========== Values of Attributes =========");

		List<WebElement> list_of_attributes = driver
				.findElements(By.xpath("//*[@class='table table-light traversal-table']/tbody/tr"));

		for (WebElement list_of_attribute : list_of_attributes) {

			System.out.println(list_of_attribute.getAttribute("class"));
		}

		System.out.println("========== Values of Attributes_2 =========");

		List<WebElement> list_of_attributes_2 = driver.findElements(By.xpath("//*[@class='container']/div"));

		for (WebElement list_of_attribute_2 : list_of_attributes_2) {

			System.out.println(list_of_attribute_2.getAttribute("class"));
		}

		driver.manage().window().fullscreen();

		Actions action = new Actions(driver);

		WebElement button_4 = driver.findElement(By.xpath("//*[text()='Button-4']"));

		action.clickAndHold(button_4).build().perform();

		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,-400)");

		Thread.sleep(500);

		WebElement about_us = driver.findElement(By.xpath("//*[text()='About Us']"));

		action.moveToElement(about_us).perform();

		Thread.sleep(1000);

		takescreenshot("webdriveruniversity", "About Us");

		Thread.sleep(1000);

		WebElement home = driver.findElement(By.xpath("//*[text()='Home']"));

		action.moveToElement(home).perform();

		Thread.sleep(1000);

		takescreenshot("webdriveruniversity", "Home");

		Thread.sleep(1000);

		WebElement button_1 = driver.findElement(By.xpath("//*[text()='Button-1']"));

		action.contextClick(button_1).build().perform();

		Thread.sleep(1000);

		driver.close();

		driver.switchTo().window(main_window);

	    driver.quit();

	}
}
