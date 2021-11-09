package Review_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_Windows {

	static WebDriver driver;
	
	
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.navigate().to("https://courses.letskodeit.com/practice");
		

		
		System.out.println("========Handling of Rows==========");
		
		List<WebElement>rows=driver.findElements(By.xpath("//*[@id='product']/tbody/tr"));
		System.out.println("The number of rows = "+rows.size());
		
		
		System.out.println("========The text of Rows=======");
		for(int i=0;i<rows.size();i++) {
			
			String text_of_rows=rows.get(i).getText();
			
			System.out.println(text_of_rows);
		}
		
		
		System.out.println("======== Handling of Columns ==========");
		
		List<WebElement>columns=driver.findElements(By.xpath("//*[@id='product']/tbody/tr/td"));
		System.out.println("The number of columns = "+columns.size());
		
		System.out.println("========The text of Columns=======");
		
		for(int i=0;i<columns.size();i++) {
			
			String text_of_columns=columns.get(i).getText();
			
			System.out.println(text_of_columns);
		}
		
		driver.quit();

	}

}
