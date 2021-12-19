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

public class webdriveruniversity_com_Review_Topics_5 {

	static WebDriver driver;

	public static void broken_links() throws MalformedURLException {

		List<WebElement> list_of_links = driver.findElements(By.tagName("a"));

		for (WebElement list_of_link : list_of_links) {

			String url = list_of_link.getAttribute("href");

			try {
				URL link = new URL(url);

				HttpURLConnection http_connect = (HttpURLConnection) link.openConnection();

				http_connect.connect();

				int link_http_codes = http_connect.getResponseCode();

				if (link_http_codes >= 400) {

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

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to("http://webdriveruniversity.com/index.html");

		driver.manage().window().fullscreen();

		String main_windwow = driver.getWindowHandle();

		System.out.println("The ID of main window = " + main_windwow);
		System.out.println("The TITLE of main window = " + driver.getTitle());

		broken_links();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='hidden-elements']/div/div/h1")).click();

		Thread.sleep(500);

		Set<String> windows = driver.getWindowHandles();

		for (String hidden_elements_window : windows) {

			if (!hidden_elements_window.equals(main_windwow)) {

				driver.switchTo().window(hidden_elements_window);

				System.out.println("The ID of hidden elements window = " + driver.getWindowHandle());
				System.out.println("The TITLE of hidden elements window = " + driver.getTitle());
			}

		}

		js.executeScript("arguments[0].click();", driver.findElement(By.id("button1")));

		Thread.sleep(500);

		System.out.println(driver.findElement(By.xpath("//*[@id='myModalClick']/div/div/div[2]/p")).getText());

		Thread.sleep(500);

		takescreenshot("webdriveruniversity", "Not Displayed");

		Thread.sleep(500);

		driver.findElement(By.xpath("//*[@id='myModalClick']/div/div/div[3]/button")).click();

		js.executeScript("arguments[0].click();", driver.findElement(By.id("button2")));

		Thread.sleep(500);

		System.out.println(driver.findElement(By.xpath("//*[@id='myModalJSClick']/div/div/div[2]/p")).getText());

		takescreenshot("webdriveruniversity", "Visibility Hidden");

		Thread.sleep(500);

		driver.findElement(By.xpath("//*[@id='myModalJSClick']/div/div/div[3]/button")).click();

		js.executeScript("arguments[0].click();", driver.findElement(By.id("button3")));

		Thread.sleep(500);

		System.out.println(driver.findElement(By.xpath("//*[@id='myModalMoveClick']/div/div/div[2]/p")).getText());

		Thread.sleep(500);

		List<WebElement> action_move_clicks = driver
				.findElements(By.xpath("//*[@id='myModalMoveClick']/div/div/div[2]/ul/li"));

		for (WebElement action_move_click : action_move_clicks) {

			System.out.println(action_move_click.getText());
		}

		takescreenshot("webdriveruniversity", "Zero Opacity");

		Thread.sleep(500);

		driver.findElement(By.xpath("//*[@id='myModalMoveClick']/div/div/div[3]/button")).click();

		driver.close();

		driver.switchTo().window(main_windwow

		 driver.quit();
	}

}
