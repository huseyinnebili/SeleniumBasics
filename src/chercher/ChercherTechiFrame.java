package chercher;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChercherTechiFrame {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://chercher.tech/practice/frames");

		driver.switchTo().frame("frame1");

		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Frame");
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		driver.switchTo().frame("frame2");
		Thread.sleep(2000);

		WebElement animal = driver.findElement(By.id("animals"));

		Select select = new Select(animal);

		System.out.println("Target select box multiple? " + select.isMultiple());

		List<WebElement> options = select.getOptions();

		for (WebElement allOptions : options) {
			System.out.println("Animals: " + allOptions.getText());

		}

		select.selectByIndex(3);

		WebElement selectedOption = select.getFirstSelectedOption();
		String currentOption = selectedOption.getText();
		System.out.println("First selected option is " + currentOption);
		Thread.sleep(2000);

		select.selectByIndex(2);

		WebElement selectedOption2 = select.getFirstSelectedOption();
		String currentOption2 = selectedOption2.getText();
		System.out.println("Second selected option is " + currentOption2);
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		Thread.sleep(2000);

//		driver.findElement(By.xpath("//*[@id='a']")).click();
//		Thread.sleep(2000);

		driver.quit();
	}

}
