package Review_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_Web_Page {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		String title=driver.getTitle();
		
		if(title.equalsIgnoreCase("Amazon.com. Spend less. Smile more.")) {
			
			System.out.println("This is the right title.");
		
		}else {
			
			System.out.println("Sorry, this is wrong title.");
		}
		
		driver.quit();
	}

}
