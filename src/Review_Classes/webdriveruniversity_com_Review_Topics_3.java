package Review_Classes;

import java.io.File;
import java.io.IOException;
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
import org.openqa.selenium.remote.server.handler.SendKeys;

public class webdriveruniversity_com_Review_Topics_3 {

	static WebDriver driver;

	public static void takescreenshot(String folder_name, String file_name) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots\\"
				+ folder_name + "/" + file_name + ".png"));
	}

	public static void broken_links() {

		List<WebElement> list_of_links = driver.findElements(By.tagName("a"));

		for (int i = 0; i < list_of_links.size(); i++) {

			String url = list_of_links.get(i).getAttribute("href");

		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to("http://webdriveruniversity.com/index.html");

		driver.manage().window().fullscreen();

		String main_window = driver.getWindowHandle();

		System.out.println("The ID of the main window = " + main_window);
		System.out.println("The TITLE of main window = " + driver.getTitle());

		driver.findElement(By.xpath("//*[@id='iframe']/div/div/h1")).click();

		System.out.println("=====The handling of the Frame Window==========");

		Set<String> windows = driver.getWindowHandles();

		for (String frame_window : windows) {

			if (!frame_window.equals(main_window)) {

				driver.switchTo().window(frame_window);

				System.out.println("The ID of frame window = " + driver.getWindowHandle());
				System.out.println("The TITLE of frame window = " + driver.getTitle());

				Thread.sleep(1000);

				driver.manage().window().fullscreen();

				takescreenshot("webdriveruniversity", "IFrame_1");

				Thread.sleep(500);

				driver.switchTo().frame("frame");

				Thread.sleep(500);

				driver.findElement(By.cssSelector("span[class='glyphicon glyphicon-chevron-right']")).click();

				Thread.sleep(500);

				takescreenshot("webdriveruniversity", "IFrame_2");

				Thread.sleep(500);

				driver.findElement(By.cssSelector("span[class='glyphicon glyphicon-chevron-right']")).click();

				Thread.sleep(500);

				takescreenshot("webdriveruniversity", "IFrame_3");

				Thread.sleep(500);

				List<WebElement> list = driver.findElements(By.xpath("//*[@class='nav navbar-nav']/li"));

				for (int i = 0; i < list.size(); i++) {

					if (list.get(i).getText().equalsIgnoreCase("Our Products")) {

						list.get(i).click();

						break;
					}
				}

				driver.findElement(By.xpath("//*[@id='container-special-offers']/div")).click();

				Thread.sleep(1000);

				System.out.println(driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/p")).getText());

				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button")).click();

				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id='container-product1']/div[1]")).click();

				Thread.sleep(1000);

				takescreenshot("webdriveruniversity", "cameras");

				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/p")).getText();

				Thread.sleep(1000);

				js.executeScript("arguments[0].click()",
						driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button[2]")));

				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id='used-laptops']/a/div/div[1]")).click();

				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[2]/p")).click();

				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id='myModal']/div/div/div[3]/button[2]")).click();

				Thread.sleep(1000);

				List<WebElement> list_2 = driver.findElements(By.xpath("//*[@class='nav navbar-nav']/li"));

				for (int i = 0; i < list_2.size(); i++) {

					if (list_2.get(i).getText().equalsIgnoreCase("Contact Us")) {

						list_2.get(i).click();

						break;
					}
				}

				Thread.sleep(500);

				driver.findElement(By.name("first_name")).sendKeys("Abuzer");
				Thread.sleep(500);

				driver.findElement(By.name("last_name")).sendKeys("Kadayif");
				Thread.sleep(500);

				driver.findElement(By.name("email")).sendKeys("akadayif@gmail.com");
				Thread.sleep(500);

				driver.findElement(By.name("message")).sendKeys("Today is coding day");
				Thread.sleep(500);

				driver.findElement(By.cssSelector("input[type='submit']")).click();
				Thread.sleep(500);
				
				takescreenshot("webdriveruniversity", "contact_form");
				Thread.sleep(500);
				
				driver.close();
				
				driver.switchTo().window(main_window);
				
				

				driver.quit();

			}
		}

	}

}
