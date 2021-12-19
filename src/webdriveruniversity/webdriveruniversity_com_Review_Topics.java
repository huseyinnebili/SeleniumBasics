package webdriveruniversity;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.class6.Window;

public class webdriveruniversity_com_Review_Topics {

	static WebDriver driver;

	public static void sendText(WebElement element, String value) {

		element.clear();
		element.sendKeys(value);

	}

	public static void takescreenshot(String folder_name, String file_name) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\screenshots\\"
				+ folder_name + "/" + file_name + ".png"));
	}

	public static void broken_links() throws IOException {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("The size of links = " + links.size());

		for (int i = 0; i < links.size(); i++) {

			String url = links.get(i).getAttribute("href");

			try {

				URL link = new URL(url);

				HttpURLConnection http_connect = (HttpURLConnection) link.openConnection();

				http_connect.connect();

				int response_code = http_connect.getResponseCode();

				if (response_code >= 400) {

					System.out.println(url + " is broken link.");
				}

				else {

					System.out.println(url + " is valid link.");
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 2);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.navigate().to("http://webdriveruniversity.com/index.html");

		driver.manage().window().fullscreen();

		System.out.println("=========Handling of Broken Links========");

		System.out.println("=========Handling of Windows=========");

		System.out.println("The title of main window = " + driver.getTitle());

		String main_window = driver.getWindowHandle();

		System.out.println("The ID of main window = " + main_window);

		driver.findElement(By.xpath("//*[text()='CONTACT US']")).click();

		Set<String> windows = driver.getWindowHandles();

		for (String contact_us_window : windows) {

			if (!(contact_us_window.equals(main_window))) {

				driver.switchTo().window(contact_us_window);

				System.out.println("The title of contact us window =" + driver.getTitle());

				System.out.println("The ID of contact us window =" + driver.getWindowHandle());
			}
		}

		sendText(driver.findElement(By.name("first_name")), "Abuzer");

		sendText(driver.findElement(By.name("last_name")), "Kadayif");

		sendText(driver.findElement(By.name("email")), "akadayif@gmail.com");

		sendText(driver.findElement(By.name("message")), "Hello World! ");

		driver.findElement(By.xpath("//*[@type='submit']")).click();

		driver.close();

		driver.switchTo().window(main_window);

		System.out.println(driver.findElement(By.xpath("//*[@id='contact-us']/div/div[2]/p")).getText());

		driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

		Set<String> windows_2 = driver.getWindowHandles();

		for (String login_window : windows_2) {

			if (!(login_window.equals(main_window))) {

				driver.switchTo().window(login_window);

				System.out.println("The title of login window = " + driver.getTitle());

				System.out.println("The ID of login window = " + driver.getWindowHandle());

				sendText(driver.findElement(By.id("text")), "Abuzer");

				sendText(driver.findElement(By.id("password")), "2112522");

				driver.findElement(By.id("login-button")).click();

				System.out.println(driver.switchTo().alert().getText());

				// As we can not take screen shot an alert with TakesScreenshot() ,we used Robot
				// class.

				Robot rb = new Robot();
				rb.keyPress(KeyEvent.VK_WINDOWS);
				rb.keyPress(KeyEvent.VK_PRINTSCREEN);
				rb.keyRelease(KeyEvent.VK_PRINTSCREEN);
				rb.keyRelease(KeyEvent.VK_WINDOWS);

				driver.switchTo().alert().accept();

				// takescreenshot("webdriveruniversity", "login");

				Thread.sleep(3000);

				driver.close();

				driver.switchTo().window(main_window);

				broken_links();

			}
		}

		driver.findElement(By.xpath("//*[text()='BUTTON CLICKS']")).click();

		Set<String> windows_3 = driver.getWindowHandles();

		for (String click_Window : windows_3) {

			if (!(click_Window).equals(main_window)) {

				driver.switchTo().window(click_Window);

				System.out.println("The title of click window =" + driver.getTitle());

				System.out.println("The ID of click window = " + driver.getWindowHandle());
			}

		}
		driver.findElement(By.id("button1")).click();

		Thread.sleep(3000);

		takescreenshot("webdriveruniversity", "webElement_click");

		Thread.sleep(5000);

		System.out.println("=========Handling of the First Click=====");

		System.out.println(driver.findElement(By.xpath("//*[@id='myModalClick']/div/div/div[2]/p")).getText());

		driver.findElement(By.xpath("//*[text()='Close']")).click();

		System.out.println("=========Handling of the Second Click=====");

		driver.findElement(By.id("button2")).click();

		Thread.sleep(2000);

		System.out.println(driver.findElement(By.xpath("//*[@id='myModalJSClick']/div/div/div[2]/p")).getText());

		Thread.sleep(2000);

		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//*[@id='myModalJSClick']/div/div/div[3]/button")));

		System.out.println("=========Handling of the Third Click=====");

		driver.findElement(By.id("button3")).click();

		Thread.sleep(2000);

		System.out.println(driver.findElement(By.xpath("//*[@id='myModalMoveClick']/div/div/div[2]/p")).getText());

		System.out.println(driver.findElement(By.xpath("//*[@id='myModalMoveClick']/div/div/div[2]/ul")).getText());

		driver.findElement(By.xpath("//*[@id='myModalMoveClick']/div/div/div[3]/button")).click();

		Thread.sleep(2000);

		driver.close();

		driver.switchTo().window(main_window);

		System.out.println("======== Handling of Dropdown-Checkboxes-RadioButtons ==========");

		driver.findElement(By.xpath("//*[@id='dropdown-checkboxes-radiobuttons']/div/div[1]/h1")).click();

		Set<String> windows_4 = driver.getWindowHandles();

		for (String Dropdown_Checkboxes_RadioButtons_window : windows_4) {

			if (!Dropdown_Checkboxes_RadioButtons_window.equals(main_window)) {

				driver.switchTo().window(Dropdown_Checkboxes_RadioButtons_window);

				System.out.println("The TITLE of Dropdown_Checkboxes_RadioButtons_window = " + driver.getTitle());

				System.out.println("The ID of Dropdown_Checkboxes_RadioButtons_window = " + driver.getWindowHandle());
			}

		}

		System.out.println("=======Handling of the First Dropdowns==========");

		WebElement dropdown_menu_1 = driver.findElement(By.id("dropdowm-menu-1"));

		Select dropdown = new Select(dropdown_menu_1);

		List<WebElement> dropdown_menu_1_list = dropdown.getOptions();

		for (WebElement dropdown_menu_1_text : dropdown_menu_1_list) {

			System.out.println(dropdown_menu_1_text.getText());

		}

		dropdown.selectByVisibleText("JAVA");

		Thread.sleep(2000);

		System.out.println("=======Handling of the Second Dropdowns==========");

		WebElement dropdown_menu_2 = driver.findElement(By.id("dropdowm-menu-2"));

		Select drowdown_2 = new Select(dropdown_menu_2);

		List<WebElement> dropdown_menu_2_list = drowdown_2.getOptions();

		for (WebElement dropdown_menu_2_text : dropdown_menu_2_list) {

			System.out.println(dropdown_menu_2_text.getText());
		}

		drowdown_2.selectByIndex(2);

		Thread.sleep(2000);

		System.out.println("=======Handling of the Third Dropdowns==========");

		WebElement dropdown_menu_3 = driver.findElement(By.id("dropdowm-menu-3"));

		Select dropdown_3 = new Select(dropdown_menu_3);

		List<WebElement> dropdown_menu_3_list = dropdown_3.getOptions();

		for (WebElement dropdown_menu_3_text : dropdown_menu_3_list) {

			System.out.println(dropdown_menu_3_text.getText());
		}

		dropdown_3.selectByValue("javascript");

		Thread.sleep(2000);

		System.out.println("=======Handling of the Checkboxes==========");

		WebElement checkboxes = driver.findElement(By.id("checkboxes"));

		System.out.println(checkboxes.isDisplayed());
		System.out.println(checkboxes.isEnabled());
		System.out.println(checkboxes.isSelected());

		System.out.println("=====Handling the first checkbox=======");

		WebElement checkbox_1 = driver.findElement(By.xpath("//*[@value='option-1']"));

		System.out.println(checkbox_1.isSelected());

		checkbox_1.click();

		System.out.println(checkbox_1.isSelected());

		System.out.println("=====Handling the third checkbox=======");

		WebElement checkbox_3 = driver.findElement(By.xpath("//*[@value='option-3']"));

		System.out.println(checkbox_3.isSelected());

		checkbox_3.click();

		Thread.sleep(1000);

		System.out.println(checkbox_3.isSelected());

		checkbox_3.click();

		Thread.sleep(1000);

		System.out.println(checkbox_3.isSelected());

		System.out.println("=====Handling the fourth checkbox=======");

		WebElement checkbox_4 = driver.findElement(By.xpath("//*[@value='option-4']"));

		System.out.println(checkbox_4.isSelected());

		checkbox_4.click();

		Thread.sleep(1000);

		System.out.println(checkbox_4.isSelected());

		Thread.sleep(1000);

		System.out.println("==========Handling of RadioButtons======");

		List<WebElement> radiobuttons = driver.findElements(By.id("radio-buttons"));

		for (WebElement radiobutton : radiobuttons) {

			System.out.println(radiobutton.getText());
		}

		System.out.println("==========Handling of Orange RadioButton======");

		WebElement orange_button = driver.findElement(By.xpath("//*[@value='orange']"));

		System.out.println(orange_button.isDisplayed());
		System.out.println(orange_button.isEnabled());
		System.out.println(orange_button.isSelected());

		orange_button.click();

		System.out.println(orange_button.isSelected());

		System.out.println("==========Handling of Purple RadioButton======");

		WebElement purple_button = driver.findElement(By.xpath("//*[@value='purple']"));

		System.out.println(purple_button.isDisplayed());
		System.out.println(purple_button.isEnabled());
		System.out.println(purple_button.isSelected());

		purple_button.click();

		System.out.println(purple_button.isSelected());

		System.out
				.println("After selected purple button check status of orange button = " + orange_button.isSelected());

		System.out.println("==========Handling of Selected-Disabled RadioButtons======");

		List<WebElement> selected_disabled_radiobuttons = driver.findElements(By.id("radio-buttons-selected-disabled"));

		for (WebElement selected_disabled_radiobutton : selected_disabled_radiobuttons) {

			System.out.println(selected_disabled_radiobutton.getText());
		}

		System.out.println("==========Handling of Lettuce RadioButton======");

		WebElement lettuce = driver.findElement(By.xpath("//*[@value='lettuce']"));

		System.out.println("Is Lettuce button displayed? " + lettuce.isDisplayed());
		System.out.println("Is Lettuce button enabled? " + lettuce.isEnabled());
		System.out.println("Is Lettuce button selected? " + lettuce.isSelected());

		lettuce.click();

		System.out.println("After clicked checking status of Lettuce radio button = " + lettuce.isSelected());

		System.out.println("==========Handling of Gabbace RadioButton======");

		WebElement cabbage = driver.findElement(By.xpath("//*[@value='cabbage']"));

		System.out.println("Is Cabbage button displayed? " + cabbage.isDisplayed());
		System.out.println("Is Cabbage button enabled? " + cabbage.isEnabled());
		System.out.println("Is Cabbage button selected? " + cabbage.isSelected());

		System.out.println("After clicked checking status of Cabbage radio button = " + cabbage.isSelected());

		System.out.println("==========Handling of Pumpkin RadioButton======");

		WebElement pumpkin = driver.findElement(By.xpath("//*[@value='pumpkin']"));

		System.out.println("Is Pumpkin button displayed? " + pumpkin.isDisplayed());
		System.out.println("Is Pumpkin button enabled? " + pumpkin.isEnabled());
		System.out.println("Is Pumpkin button selected? " + pumpkin.isSelected());

		pumpkin.click();

		System.out.println("After clicked checking status of Pumpkin radio button = " + pumpkin.isSelected());

		driver.close();

		driver.switchTo().window(main_window);

		driver.findElement(By.xpath("//*[@id='actions']/div/div/h1")).click();

		Set<String> windows_5 = driver.getWindowHandles();

		for (String actions_window : windows_5) {

			if (!actions_window.equals(main_window)) {

				driver.switchTo().window(actions_window);

				System.out.println("The TITLe of actions_window = " + driver.getTitle());

				System.out.println("The ID of actions_window = " + driver.getWindowHandle());
			}
		}

		System.out.println("==========Handling of Actions Element with Actions Class=========");

		Actions action = new Actions(driver);

		action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build()
				.perform();
		;

		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0, 500)");

		Thread.sleep(1000);

		action.doubleClick(driver.findElement(By.id("double-click"))).build().perform();

		Thread.sleep(1000);

		action.moveToElement(driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"))).build().perform();

		Thread.sleep(1000);

		js.executeScript("arguments[0].click()",
				driver.findElement(By.xpath("//*[text()='Hover Over Me First!']//parent::div/div/a")));

		Thread.sleep(1000);

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		action.moveToElement(driver.findElement(By.xpath("//*[text()='Hover Over Me Second!']"))).build().perform();

		driver.findElement(By.xpath("//*[text()='Hover Over Me Second!']//parent::div/div/a")).click();

		Thread.sleep(1000);

		System.out.println(driver.switchTo().alert().getText());
		
		driver.switchTo().alert().accept();

		action.moveToElement(driver.findElement(By.xpath("//*[text()='Hover Over Me Third!']"))).build().perform();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[text()='Hover Over Me Third!']//parent::div/div/a")).click();

		Thread.sleep(1000);

		System.out.println(driver.switchTo().alert().getText());

		Thread.sleep(1000);

		driver.switchTo().alert().accept();

		action.clickAndHold(driver.findElement(By.xpath("//*[@id='click-box']"))).build().perform();
		
		Thread.sleep(1000);
		
		driver.close();
		
		driver.switchTo().window(main_window);
		
		//driver.quit();
	}
}