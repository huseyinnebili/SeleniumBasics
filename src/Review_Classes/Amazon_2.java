package Review_Classes;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		driver.manage().window().fullscreen();
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());

		String exp_Text = "All";
		String exp_Text_2 = "Best Sellers";

		for (WebElement lists : list) {

			try {
				if (lists.getText().contains(exp_Text)) {

					driver.findElement(By.xpath("//*[@id='nav-main']/div/a/span")).click();
				}

				if (lists.getText().contains(exp_Text_2)) {

					driver.findElement(By.xpath("//*[@class='hmenu hmenu-visible']/li/a[text()='Best Sellers']"))
							.click();
					System.out.println("Tne number of the texts = " + lists.getText());
				}

				driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).click();
				driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Adidas");
				driver.findElement(By.xpath("//*[@id='nav-search-submit-text']")).click();

				List<WebElement> checkbox = driver.findElements(By.xpath("//*[@type='checkbox']"));

				for (int i = 0; i < checkbox.size(); i++) {

					String text_of_checkbox = checkbox.get(i).getTagName();

					System.out.println(text_of_checkbox);
				}

			} catch (Exception e) {

			}
		}
		driver.quit();

	}

}
