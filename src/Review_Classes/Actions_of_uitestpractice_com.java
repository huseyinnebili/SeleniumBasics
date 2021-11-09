package Review_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;

public class Actions_of_uitestpractice_com extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		CommonMethods.setUpDriver("chrome", "http://uitestpractice.com/Students/Index");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@class='navbar-header']/button")));

		List<WebElement> list = driver.findElements(By.xpath("//*[@class='navbar-collapse in']/ul/li"));

		for (int i = 0; i < list.size(); i++) {

			String text_of_list = list.get(i).getText();

			System.out.println(text_of_list);
		}

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().equalsIgnoreCase("Actions")) {

				list.get(i).click();
			}
		}

		System.out.println("===== Handling of Single Click ===========");

		WebElement single_click = driver.findElement(By.xpath("//*[@name='click']"));

		Actions action = new Actions(driver);

		action.click(single_click).perform();

		driver.switchTo().alert().accept();

		Thread.sleep(3000);

		System.out.println("===== Handling of Double Click ===========");

		WebElement double_click = driver.findElement(By.xpath("//*[@name='dblClick']"));

		action.doubleClick(double_click).perform();

		driver.switchTo().alert().accept();

		Thread.sleep(3000);

		System.out.println("===== Handling of Drug and Drop ===========");

		WebElement source = driver.findElement(By.id("draggable"));

		WebElement target = driver.findElement(By.id("droppable"));

		action.dragAndDrop(source, target).perform();

		Thread.sleep(3000);

		
		System.out.println("===== Handling of Move to Element ===========");

		WebElement move_to_element = driver.findElement(By.id("div2"));

		action.moveToElement(move_to_element).perform();

		Thread.sleep(3000);

		
		System.out.println("===== Handling of Right Click ===========");

		action.contextClick(double_click).perform();

		Thread.sleep(3000);

		
		System.out.println("===== Handling of Selectable ===========");

		WebElement one = driver.findElement(By.xpath("//*[@id='selectable']/li[1]"));
		WebElement two = driver.findElement(By.xpath("//*[@id='selectable']/li[2]"));
		WebElement three = driver.findElement(By.xpath("//*[@id='selectable']/li[3]"));
		WebElement four = driver.findElement(By.xpath("//*[@id='selectable']/li[4]"));

		action.clickAndHold(one).clickAndHold(two).clickAndHold(three).clickAndHold(four).perform();

		Thread.sleep(3000);

		
		
		System.out.println("===== Handling of Dropdown with Select Class ===========");
		
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@class='navbar-header']/button")));

		List<WebElement> list_2 = driver.findElements(By.xpath("//*[@class='navbar-collapse in']/ul/li"));

		try {
			for (int i = 0; i < list_2.size(); i++) {

				if (list_2.get(i).getText().equalsIgnoreCase("Select")) {

					list_2.get(i).click();
				}
			}

		} catch (Exception e) {

		}
		
		WebElement multi_select_box=driver.findElement(By.id("countriesMultiple"));
		
		Select dropdown=new Select(multi_select_box);
		
		System.out.println(dropdown.isMultiple());
		
		
		List<WebElement>dropdown_lists=dropdown.getOptions();
		
		for(WebElement dropdown_list:dropdown_lists) {
			
			String text_of_dropdown=dropdown_list.getText();
			
			System.out.println(text_of_dropdown);
		}
		
		dropdown.selectByVisibleText("England");
		dropdown.selectByVisibleText("United states of America");
		
		dropdown.deselectByVisibleText("England");
		
		Thread.sleep(3000);
		
		dropdown.selectByVisibleText("India");
		
		Thread.sleep(3000);
		
		List<WebElement>lists_of_selected=dropdown.getAllSelectedOptions();
		
		for(WebElement list_of_selected:lists_of_selected) {
			
			System.out.println("Selected countries = "+list_of_selected.getText());
		}
		
		
		WebElement single_dropdown=driver.findElement(By.id("countriesSingle"));
		
		Select dropdown_2=new Select(single_dropdown);
		
		System.out.println(dropdown_2.isMultiple());
		
		List<WebElement>lists_of_single_dropdown=dropdown_2.getOptions();
		
		for(WebElement list_of_single_dropdown:lists_of_single_dropdown) {
			
			System.out.println(list_of_single_dropdown.getText());
		}
				
		
		dropdown_2.selectByVisibleText("United states of America");
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
