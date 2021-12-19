package Review_Classes;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriveruniversity_com_Review_Topics_2 {

	static WebDriver driver;

	public static void broken_link() throws IOException {

		List<WebElement> list_of_links = driver.findElements(By.tagName("a"));

		for (int i = 0; i < list_of_links.size(); i++) {

			String url = list_of_links.get(i).getAttribute("href");

			try {

				URL link = new URL(url);

				HttpURLConnection http_connect = (HttpURLConnection) link.openConnection();

				http_connect.connect();

				int broken_link_code = http_connect.getResponseCode();

				if (broken_link_code >= 400) {

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

	public static void takescreenshot(String folde_name, String file_name) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots\\"
				+ folde_name + "/" + file_name + ".png"));

	}

	public static void takescreen_throug_robot(String folde_name, String file_name) throws AWTException, IOException {

		BufferedImage sc = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(sc, "png", new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots\\"
				+ folde_name + "/" + file_name + ".png"));

	}

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to("http://webdriveruniversity.com/index.html");

		driver.manage().window().fullscreen();

		driver.findElement(By.xpath("//*[@id='popup-alerts']/div/div/h1")).click();

		String main_window = driver.getWindowHandle();

		System.out.println("The TITLE of main window = " + driver.getTitle());

		System.out.println("The ID of main window = " + main_window);

		Set<String> windows = driver.getWindowHandles();

		for (String alert_window : windows) {

			if (!alert_window.equals(main_window)) {

				driver.switchTo().window(alert_window);

				System.out.println("The TITLE of alert window = " + driver.getTitle());

				System.out.println("The ID of alert window = " + driver.getWindowHandle());

				driver.manage().window().fullscreen();

				broken_link();

				Thread.sleep(1000);

				takescreenshot("webdriveruniversity", "alert_window");

				Thread.sleep(1000);

			}

		}

		driver.findElement(By.id("button1")).click();

		Thread.sleep(1000);

		takescreen_throug_robot("webdriveruniversity", "JavaScript_Alert");

		Thread.sleep(1000);

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		driver.findElement(By.id("button2")).click();

		Thread.sleep(1000);

		takescreenshot("webdriveruniversity", "modal_popup");

		Thread.sleep(2000);

		System.out.println(driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/p")).getText());

		Thread.sleep(1000);

		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")));

		Thread.sleep(1000);

		driver.findElement(By.id("button3")).click();

		Thread.sleep(1000);

		takescreenshot("webdriveruniversity", "ajax_loader");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='button1']/p"))).click();

		Thread.sleep(2000);

		System.out.println(driver.findElement(By.xpath("//*[@id='myModalClick']/div/div/div[2]/p")).getText());

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='myModalClick']/div/div/div[3]/button")).click();

		Thread.sleep(1000);

		driver.navigate().back();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='button4']/p")).click();

		Thread.sleep(1000);

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		driver.quit();
	}

}
