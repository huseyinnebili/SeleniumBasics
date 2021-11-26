package Review_Classes;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriveruniversity_com_Review_Topics {

	static WebDriver driver;

	public static void sendText(WebElement element, String value) {

		element.clear();
		element.sendKeys(value);

	}

	public static void takescreenshot(String folder_name, String file_name) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots\\"
				+ folder_name + "/" + file_name + ".png"));
	}

	public static void broken_links() throws IOException {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("The size of links = " + links.size());

		for (int i = 0; i < links.size(); i++) {

			String url = links.get(i).getAttribute("href");

			try {

				URL link = new URL(url);

				HttpURLConnection http_connect = (HttpURLConnection) link.openConnection();

				http_connect.connect();

				int response_code = http_connect.getResponseCode();

				if (response_code >= 400) {

					System.out.println(url + " is broken link.");
				}

				else {

					System.out.println(url + " is valid link.");
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.navigate().to("http://webdriveruniversity.com/index.html");

		driver.manage().window().fullscreen();

		System.out.println("=========Handling of Broken Links========");

		System.out.println("=========Handling of Windows=========");

		System.out.println("The title of main window = " + driver.getTitle());

		String main_window = driver.getWindowHandle();

		System.out.println("The ID of main window = " + main_window);

		driver.findElement(By.xpath("//*[text()='CONTACT US']")).click();

		Set<String> windows = driver.getWindowHandles();

		for (String contact_us_window : windows) {

			if (!(contact_us_window.equals(main_window))) {

				driver.switchTo().window(contact_us_window);

				System.out.println("The title of contact us window =" + driver.getTitle());

				System.out.println("The ID of contact us window =" + driver.getWindowHandle());
			}
		}

		sendText(driver.findElement(By.name("first_name")), "Abuzer");

		sendText(driver.findElement(By.name("last_name")), "Kadayif");

		sendText(driver.findElement(By.name("email")), "akadayif@gmail.com");

		sendText(driver.findElement(By.name("message")), "Hello World! ");

		driver.findElement(By.xpath("//*[@type='submit']")).click();

		driver.close();

		driver.switchTo().window(main_window);

		System.out.println(driver.findElement(By.xpath("//*[@id='contact-us']/div/div[2]/p")).getText());

		driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

		Set<String> windows_2 = driver.getWindowHandles();

		for (String login_window : windows_2) {

			if (!(login_window.equals(main_window))) {

				driver.switchTo().window(login_window);

				System.out.println("The title of login window = " + driver.getTitle());

				System.out.println("The ID of login window = " + driver.getWindowHandle());

				driver.manage().window().fullscreen();

				sendText(driver.findElement(By.id("text")), "abuzer");

				sendText(driver.findElement(By.id("password")), "2112522");

				driver.findElement(By.id("login-button")).click();

				System.out.println(driver.switchTo().alert().getText());

				// As we can not take screen shot an alert with TakesScreenshot() ,we used Robot
				// class.

				Robot rb = new Robot();
				rb.keyPress(KeyEvent.VK_WINDOWS);
				rb.keyPress(KeyEvent.VK_PRINTSCREEN);
				rb.keyRelease(KeyEvent.VK_PRINTSCREEN);
				rb.keyRelease(KeyEvent.VK_WINDOWS);

				driver.switchTo().alert().accept();

				// takescreenshot("webdriveruniversity", "login");

				Thread.sleep(3000);

				driver.close();

				driver.switchTo().window(main_window);
				
				broken_links();

			}
		}

		driver.quit();

	}
}
