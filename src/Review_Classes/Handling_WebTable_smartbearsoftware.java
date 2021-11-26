package Review_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;

public class Handling_WebTable_smartbearsoftware extends CommonMethods {

	public static void main(String[] args) {

		setUpDriver("chrome",
				"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");

		sendText(driver.findElement(By.id("ctl00_MainContent_username")), "Tester");
		sendText(driver.findElement(By.id("ctl00_MainContent_password")), "test");

		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		List<WebElement> list_of_cells = driver
				.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td"));

		for (int i = 0; i < list_of_cells.size(); i++) {

			String text_of_cells = list_of_cells.get(i).getText();

			System.out.println(text_of_cells);

			if (text_of_cells.equalsIgnoreCase("Paul Brow")) {

				driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
				break;
			}

			else if (text_of_cells.equalsIgnoreCase("Mark Smith")) {

				driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector")).click();

				break;
			}

		}

		driver.findElement(By.linkText("Order")).click();

		System.out.println("============List of Dropdown=======");

		Select dropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));

		List<WebElement> list_of_dropdowns = dropdown.getOptions();

		for (WebElement list_of_dropdown : list_of_dropdowns) {

			String text_of_dropdown = list_of_dropdown.getText();

			System.out.println(text_of_dropdown);
		}

		dropdown.selectByVisibleText("ScreenSaver");

		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")), "10000");

		driver.findElement(By.cssSelector("input[value='Calculate']")).click();

		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")), "Abuzer Kadayif");
		
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")), "123 Valley Road");
		
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")), "Wellington");
		
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")), "Navada");
		
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")), "07432");
		
		WebElement radio=driver.findElement(By.xpath("//*[@type='radio']"));
		
		System.out.println("Is the radio displayed? "+radio.isDisplayed());
		System.out.println("Is the radio enabled? "+radio.isEnabled());
		System.out.println("Is the radio selected? "+radio.isSelected());
		
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
		
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")), "123456789012");
		
		sendText(driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")), "12/2025");
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		driver.findElement(By.linkText("View all orders")).click();
		
		List<WebElement>list_of_cells_updated=driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td"));
		
		for(int i=0;i<list_of_cells_updated.size();i++) {
			
			if(list_of_cells_updated.get(i).getText().equalsIgnoreCase("Abuzer Kadayif")) {
				
				driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
				
				break;
				
			}
		}
		
		System.out.println("=====The list after deleting the selected row===========");
		
	driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
	
	
	List<WebElement>list_of_cells_after_deleted=driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr/td"));
	
	for(int i=0;i<list_of_cells_after_deleted.size();i++) {
		
		System.out.println(list_of_cells_after_deleted.get(i).getText());
	}
		driver.quit();
	}

}
