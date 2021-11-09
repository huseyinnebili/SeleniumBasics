package Review_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTables_Handling_herokuapp_com {

	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to("http://the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, 10);

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='content']/ul/li"));

		System.out.println("=======Texts of the List===========");

		for (int i = 0; i < list.size(); i++) {

			String text_of_list = list.get(i).getText();

			System.out.println(text_of_list);

		}

		try {
			for (int i = 0; i < list.size(); i++) {

				if (list.get(i).getText().equals("Sortable Data Tables")) {

					js.executeScript("arguments[0].click()",
							driver.findElement(By.xpath("//*[text()='Sortable Data Tables']")));

					
				}
			}

		} catch (Exception e) {
			
			
		}
		
		System.out.println("========== The handling of first WebTable ===========");
		
		List<WebElement>rows=driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));
		System.out.println("The size of rows = "+rows.size());
		
		
		System.out.println("========== The text of Rows ===========");
		for(int i=0;i<rows.size();i++) {
			
			String text_of_rows=rows.get(i).getText();
			
			System.out.println(text_of_rows);
		}
		
		
		
		List<WebElement>columns=driver.findElements(By.xpath("//*[@id='table1']/thead/tr/th"));
		System.out.println("The size of columns = "+columns.size());
		
		System.out.println("=========The text of columns=======");
		
		for(int i=0;i<columns.size();i++) {
			
			String text_of_columns=columns.get(i).getText();		
			
		System.out.println(text_of_columns);
		
		}
		
		List<WebElement>cells=driver.findElements(By.xpath("//*[@id='table1']/tbody/tr/td"));
		
		System.out.println("===========The text of cells========= ");
		
		for(int i=0;i<cells.size();i++) {
			
			String text_of_cells=cells.get(i).getText();
			
			System.out.println(text_of_cells);
		}
		
		
		driver.quit();
	}

}
