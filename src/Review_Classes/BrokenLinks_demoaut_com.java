package Review_Classes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks_demoaut_com{

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.navigate().to("http://newtours.demoaut.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Thread.sleep(3000);

		System.out.println(links.size());

		for (int i = 0; i < links.size(); i++) {

			String url = links.get(i).getAttribute("href");

			URL link = new URL(url);

			HttpURLConnection http_Conn = (HttpURLConnection) link.openConnection();

			Thread.sleep(2000);

			http_Conn.connect();

			int response_code = http_Conn.getResponseCode();

			if (response_code >= 400) {

				System.out.println(url + " is broken link.");
			}

			else {

				System.out.println(url + " is valid link.");
			}

		}
		
		driver.quit();

	}

}
