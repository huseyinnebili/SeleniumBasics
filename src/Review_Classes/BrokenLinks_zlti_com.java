package Review_Classes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks_zlti_com {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.navigate().to("http://www.zlti.com");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());

		try {

			for (int i = 0; i < links.size(); i++) {

				String url = links.get(i).getAttribute("href");

				URL link = new URL(url);

				HttpURLConnection http_connect = (HttpURLConnection) link.openConnection();

				http_connect.connect();

				int response_code = http_connect.getResponseCode();

				if (response_code >= 400) {

					System.out.println(url + " is a broken link.");
				}

				else {

					System.out.println(url + " is a valid link.");
				}
			}
		} catch (Exception e) {
		}

		driver.quit();
	}

}
