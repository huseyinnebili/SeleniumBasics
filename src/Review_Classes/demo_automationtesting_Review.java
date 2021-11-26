package Review_Classes;

import java.awt.AWTException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class demo_automationtesting_Review extends CommonMethods {

	public static void main(String[] args) throws InterruptedException, AWTException {

		CommonMethods.setUpDriver("chrome", "http://demo.automationtesting.in/Index.html");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.id("email")).sendKeys("xyz@gmail.com");
		driver.findElement(By.id("enterimg")).click();
		driver.findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Abuzer");
		driver.findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Kadayif");
		driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys("Wart/NJ");
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//*[@type='tel']")).sendKeys("2014571243");

		System.out.println("==========Handling of the radio buttons=========");

		WebElement radio_male = driver.findElement(By.xpath("//*[@value='Male']"));

		System.out.println(radio_male.isSelected());
		System.out.println(radio_male.isEnabled());
		System.out.println(radio_male.isDisplayed());

		radio_male.click();
		System.out.println(radio_male.isSelected());

		WebElement radio_female = driver.findElement(By.xpath("//*[@value='FeMale']"));

		System.out.println(radio_female.isDisplayed());
		System.out.println(radio_female.isEnabled());
		System.out.println(radio_female.isSelected());

		radio_female.click();
		System.out.println(radio_female.isSelected());

		System.out.println("=====Handling of ChechBox======");

		List<WebElement> chechbox = driver.findElements(By.xpath("//*[@type='checkbox']"));

		for (int i = 0; i < chechbox.size(); i++) {

			String value_chechbox = chechbox.get(i).getAttribute("id");

			System.out.println(value_chechbox);

			System.out.println("Is chechbox selected = " + chechbox.get(i).isSelected());
			System.out.println("Is chechbox enabled = " + chechbox.get(i).isEnabled());
			System.out.println("Is chechbox displayed = " + chechbox.get(i).isDisplayed());

			if (value_chechbox.equalsIgnoreCase("checkbox1") || value_chechbox.equalsIgnoreCase("checkbox2")) {

				chechbox.get(i).click();

				System.out.println("Is chechbox selected after selected = " + chechbox.get(i).isSelected());
			}
		}

		System.out.println("========Handling of Multi-Select_List=======");

		WebElement multi_select = driver.findElement(By.id("msdd"));

		multi_select.click();

		List<WebElement> languages = driver.findElements(By.xpath("//*[@id='msdd']/following-sibling::div/ul/li"));

		for (int i = 0; i < languages.size(); i++) {

			String text_of_languages = languages.get(i).getText();

			System.out.println("List of languages = " + text_of_languages);
		}

		for (int i = 0; i < languages.size(); i++) {

			if (languages.get(i).getText().equalsIgnoreCase("Turkish")
					|| languages.get(i).getText().equalsIgnoreCase("English")
					|| languages.get(i).getText().equalsIgnoreCase("Spanish")) {

				languages.get(i).click();
			}
		}

		List<WebElement> selected_languages = driver
				.findElements(By.xpath("//*[@class='ui-autocomplete-multiselect-item']"));

		for (int i = 0; i < selected_languages.size(); i++) {

			System.out.println("Selected languages = " + selected_languages.get(i).getText());
		}

		driver.findElement(By.xpath("//*[@id=\"msdd\"]/div[2]/span")).click();

		List<WebElement> selected_languages_2 = driver
				.findElements(By.xpath("//*[@class='ui-autocomplete-multiselect-item']"));

		for (int i = 0; i < selected_languages_2.size(); i++) {

			System.out.println("Selected languages after remove Spanish = " + selected_languages_2.get(i).getText());
		}

		System.out.println("==========Handling of Dropdown==========");

		WebElement skills = driver.findElement(By.id("Skills"));

		Select dropdown = new Select(skills);

		List<WebElement> list_of_dropdown = dropdown.getOptions();

		for (int i = 0; i < list_of_dropdown.size(); i++) {

			String text_of_dropdown = list_of_dropdown.get(i).getText();

			System.out.println("List of skills = " + text_of_dropdown);

		}

		dropdown.selectByVisibleText("Java");

		List<WebElement> selected_options = dropdown.getAllSelectedOptions();

		for (WebElement selected_option : selected_options) {

			System.out.println("Selected option = " + selected_option.getText());
		}

		dropdown.selectByVisibleText("XHTML");

		List<WebElement> selected_options_2 = dropdown.getAllSelectedOptions();

		for (WebElement selected_option_1 : selected_options_2) {

			System.out.println("Selected option_2 = " + selected_option_1.getText());
		}

		System.out.println(driver.findElement(By.xpath("//*[@id='countries']")).getText());

		System.out.println("=======Handling of Countries with Select Class=====");

		List<WebElement> list_of_countries = driver.findElements(By.xpath("//*[@id='country']/option"));

		for (int i = 0; i < list_of_countries.size(); i++) {

			String text_of_countries = list_of_countries.get(i).getText();

			System.out.println("List of Countries = " + text_of_countries);
		}

		WebElement country = driver.findElement(By.id("country"));

		Select countries = new Select(country);

		countries.selectByVisibleText("United States of America");

		List<WebElement> selected_countries = countries.getAllSelectedOptions();

		for (WebElement selected_country : selected_countries) {

			System.out.println("Selected Country = " + selected_country.getText());
		}

		countries.selectByVisibleText("South Africa");

		List<WebElement> selected_countries_2 = countries.getAllSelectedOptions();

		for (WebElement selected_country_2 : selected_countries_2) {

			System.out.println("Selected Country_2 = " + selected_country_2.getText());
		}

		System.out.println("=====Handling of DOB with Select Class======");

		WebElement year = driver.findElement(By.id("yearbox"));

		Select select_year = new Select(year);

		select_year.selectByVisibleText("1981");

		WebElement month = driver.findElement(By.xpath("//*[@placeholder='Month']"));

		Select select_month = new Select(month);

		select_month.selectByVisibleText("July");

		WebElement day = driver.findElement(By.id("daybox"));

		Select select_day = new Select(day);

		select_day.selectByVisibleText("29");

		List<WebElement> selected_days = select_day.getAllSelectedOptions();

		for (WebElement selected_day : selected_days) {

			System.out.println("Selected day = " + selected_day.getText());
		}

		List<WebElement> selected_months = select_month.getAllSelectedOptions();

		for (WebElement selected_month : selected_months) {

			System.out.println("Selected month = " + selected_month.getText());
		}

		List<WebElement> selected_years = select_year.getAllSelectedOptions();

		for (WebElement selected_year : selected_years) {

			System.out.println("Selected year = " + selected_year.getText());
		}

		driver.findElement(By.id("firstpassword")).sendKeys("2112522Hn.");
		driver.findElement(By.id("secondpassword")).sendKeys("2112522Hn.");
		driver.findElement(By.id("submitbtn")).click();

		System.out.println("========Handling of Alerts========== ");

		List<WebElement> list_of_functions = driver.findElements(By.xpath("//*[@class='nav navbar-nav']/li"));

		for (int i = 0; i < list_of_functions.size(); i++) {

			String text_of_functions = list_of_functions.get(i).getText();

			System.out.println(text_of_functions);

		}

		WebElement switch_to = driver.findElement(By.xpath("//*[text()='SwitchTo']"));

		switch_to.click();

		WebElement alerts = driver.findElement(By.xpath("//*[text()='Alerts']"));

		alerts.click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();

		driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		System.out.println(driver.findElement(By.id("demo")).getText());

		driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

		driver.switchTo().alert().dismiss();

		System.out.println(driver.findElement(By.id("demo")).getText());

		driver.findElement(By.xpath("//*[@href='#Textbox']")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();

		Thread.sleep(2000);

		driver.switchTo().alert().sendKeys("Huseyin");

		Thread.sleep(2000);

		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		System.out.println(driver.findElement(By.id("demo1")).getText());

		System.out.println("========Handling of Windows========== ");

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.linkText("SwitchTo"))).perform();

		List<WebElement> list_of_swicth_to = driver.findElements(By.xpath("//*[@class='nav navbar-nav']/li[4]/ul/li"));

		for (int i = 0; i < list_of_swicth_to.size(); i++) {

			String text_of_switch_to = list_of_swicth_to.get(i).getText();

			System.out.println(text_of_switch_to);
		}

		try {
			for (int i = 0; i < list_of_swicth_to.size(); i++) {

				if (list_of_swicth_to.get(i).getText().equalsIgnoreCase("Windows")) {

					list_of_swicth_to.get(i).click();
				}
			}

		} catch (Exception e) {
		}

		System.out.println("The text of Main Window = " + driver.getTitle());

		String main_window = driver.getWindowHandle();

		System.out.println("The ID of Main  Window = " + main_window);

		driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();

		Set<String> tabbed_windows = driver.getWindowHandles();

		for (String tabbed_window : tabbed_windows) {

			if (!tabbed_window.equals(main_window)) {

				driver.switchTo().window(tabbed_window);

				System.out.println("The Title of Tabbed Window = " + driver.getTitle());

				System.out.println("The ID of Tabbed Window = " + driver.getWindowHandle());

			}
		}

		driver.close();

		driver.switchTo().window(main_window);

		driver.findElement(By.linkText("Open New Seperate Windows")).click();

		driver.findElement(By.xpath("//*[@onclick='newwindow()']")).click();

		Set<String> seperate_windows = driver.getWindowHandles();

		for (String seperate_window : seperate_windows) {

			if (!seperate_window.equals(main_window)) {

				driver.switchTo().window(seperate_window);

				System.out.println("The Title of Seperate Window = " + driver.getTitle());

				System.out.println("The ID of Seperate Window = " + driver.getWindowHandle());
			}
		}

		driver.close();

		driver.switchTo().window(main_window);

		driver.findElement(By.xpath("//*[text()='Open Seperate Multiple Windows']")).click();

		driver.findElement(By.xpath("//*[@onclick='multiwindow()']")).click();

		Set<String> multi_windows = driver.getWindowHandles();

		for (String multi_window : multi_windows) {

			if (!multi_window.equals(main_window)) {

				driver.switchTo().window(multi_window);

				System.out.println("The Text of Multi Window = " + driver.getTitle());

				System.out.println("The ID of Multi Window = " + driver.getWindowHandle());
			}
		}

		driver.close();

		driver.switchTo().window(main_window);

		System.out.println("========Handling of Frames========== ");

		action.moveToElement(driver.findElement(By.linkText("SwitchTo"))).perform();

		driver.findElement(By.linkText("Frames")).click();

		driver.switchTo().frame("singleframe");

		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Hello!");

		driver.switchTo().defaultContent();

		driver.findElement(By.linkText("Iframe with in an Iframe")).click();

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='Multiple']/iframe")));

		driver.switchTo().frame(driver.findElement(By.xpath("//*[@style='float: left;height: 250px;width: 400px']")));

		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Hello World!");

		driver.switchTo().defaultContent();

		System.out.println("=======Handling of Dynamic Elements======");

		driver.findElement(By.linkText("More")).click();

		try {

			List<WebElement> list_of_more = driver
					.findElements(By.xpath("//*[text()='More']//following-sibling::ul/li"));

			for (int i = 0; i < list_of_more.size(); i++) {

				if (list_of_more.get(i).getText().equalsIgnoreCase("Dynamic Data")) {

					list_of_more.get(i).click();
				}
			}

		} catch (Exception e) {

		}

		driver.findElement(By.xpath("//*[@id=\"save\"]")).click();

		wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loading")));

	

	//	driver.quit();

	}

}
