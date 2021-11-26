package Review_Classes;

import java.io.File;
import java.io.IOException;

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

public class sample_gwtproject_org_Upload_Screenshot {

	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.navigate().to("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload");

		String path = "C:\\Users\\husey\\fatih\\fatih.txt";

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gwt-debug-cwFileUpload"))).sendKeys(path);

		WebElement upload_button = driver.findElement(By.xpath("//*[@type='button']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", upload_button);

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		driver.manage().window().fullscreen();

		Thread.sleep(2000);

		takescreenshot("samples_gwtprojec_org", "check_upload_file");

	}

	public static void takescreenshot(String folder_name, String file_name) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File(
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots" + folder_name + "/" + file_name+".png"));

		driver.quit();

	}
}
