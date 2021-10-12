package Review_Classes;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class ToolQA_Review extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		CommonMethods.setUpDriver("chrome", "https://demoqa.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		System.out.println("=========First List======");

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='app']//div[@class='category-cards']/div"));

		for (int i = 0; i < list.size(); i++) {

			String text = list.get(i).getText();

			System.out.println(text);

		}

		String exp_text = "Elements";

		for (int i = 0; i < list.size(); i++) {

			String text = list.get(i).getText();

			if (text.equalsIgnoreCase(exp_text)) {

//				WebElement element = driver
//						.findElement(By.xpath("//*[@id='app']//div[@class='category-cards']/div[1]"));

				js.executeScript("arguments[0].click();", list.get(i));
				break;
			}
		}

		System.out.println("=======Second List =========");

		List<WebElement> list_2 = driver.findElements(By.xpath("//*[@class='element-list collapse show']/ul/li"));

		String exp_text_2 = "Text Box";

		for (int i = 0; i < list_2.size(); i++) {

			String text = list_2.get(i).getText();

			System.out.println(text);

			if (list_2.get(i).getText().contains(exp_text_2)) {

				js.executeScript("arguments[0].click();", list_2.get(i));

			}
		}

		// Text Box Handling

		driver.findElement(By.id("userName")).sendKeys("Huseyin");
		driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Wayne/NJ");
		driver.findElement(By.id("permanentAddress")).sendKeys("Wayne/NJ");
		js.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));

		// Check Box Handling

		String exp_text_3 = "Check Box";

		for (int i = 0; i < list_2.size(); i++) {

			if (list_2.get(i).getText().equalsIgnoreCase(exp_text_3)) {

				js.executeScript("arguments[0].click();", list_2.get(i));

			}
		}

		driver.findElement(By.xpath("//*[@title='Expand all']")).click();

		js.executeScript("window.scrollBy(0,1000)");

		List<WebElement> check_box = driver.findElements(By.xpath("//*[@class='rct-checkbox']"));

		int size = check_box.size();

		System.out.println("Size of check-box = " + size);

		for (WebElement ckbox : check_box) {

			js.executeScript("scroll(0,400)");

			if (ckbox.isDisplayed() || ckbox.isEnabled() || !ckbox.isSelected()) {
				ckbox.click();

			}

			System.out.println(driver.findElement(By.id("result")).getText());
		}

		// Radio Button Handling

		String exp_text_4 = "Radio Button";

		for (int i = 0; i < list_2.size(); i++) {

			if (list_2.get(i).getText().equalsIgnoreCase(exp_text_4)) {

				js.executeScript("arguments[0].click()", list_2.get(i));

			}
		}

		List<WebElement> radio_list = driver.findElements(By.xpath("//*[@type='radio']"));

		System.out.println("Size of the radio button = " + radio_list.size());

		WebElement yes_radio = driver.findElement(By.id("yesRadio"));

		if (!yes_radio.isSelected() || yes_radio.isDisplayed() || yes_radio.isEnabled()) {

			js.executeScript("arguments[0].click()", yes_radio);

			System.out.println(driver.findElement(By.xpath("//*[@class='mt-3']")).getText());

		}

		WebElement impressive_radio = driver.findElement(By.id("impressiveRadio"));

		if (!impressive_radio.isSelected() || impressive_radio.isDisplayed() || impressive_radio.isSelected()) {

			js.executeScript("arguments[0].click()", impressive_radio);

			System.out.println(driver.findElement(By.xpath("//*[@class='mt-3']")).getText());

		}

		List<WebElement> list_3 = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div"));

		String exp_text_5 = "Alerts, Frame & Windows";

		for (int i = 0; i < list_3.size(); i++) {

			String text = list_3.get(i).getText();

			System.out.println(text);

			js.executeScript("scroll(0,800)");

			if (text.contains(exp_text_5)) {

				System.out.println("==============");

				list_3.get(i).click();

			}
		}

		System.out.println("=======List of Frames ,Alerts , Windows ,etc. ========");

		List<WebElement> btn_light = driver.findElements(By.xpath("//*[@class='element-list collapse show']/ul/li"));

		for (int i = 0; i < btn_light.size(); i++) {

			String text_of_btn_light = btn_light.get(i).getText();

			System.out.println(text_of_btn_light);

			if (text_of_btn_light.equalsIgnoreCase("Browser Windows")) {

				js.executeScript("arguments[0].click()", btn_light.get(i));
			}

		}

		System.out.println("==========Handling of the windows========");

		js.executeScript("arguments[0].click()",driver.findElement(By.xpath("//*[text()='New Tab']")));

		String main_window = driver.getWindowHandle();
		System.out.println("The ID of the main window = " + main_window);
		System.out.println("The title of the main window = " + driver.getTitle());

		Set<String> multi_window = driver.getWindowHandles();

		for (String sample_window : multi_window) {

			if (!sample_window.equals(main_window)) {

				driver.switchTo().window(sample_window);
				System.out.println("The ID of smaple window = " + driver.getWindowHandle());
				System.out.println("The title of the sample window = " + driver.getTitle());
				driver.close();

			}
		}

		driver.switchTo().window(main_window);

		driver.findElement(By.xpath("//*[text()='New Window']")).click();

		Set<String> multi_window_2 = driver.getWindowHandles();

		for (String sec_sample_window : multi_window_2) {

			if (!sec_sample_window.equals(main_window)) {

				driver.switchTo().window(sec_sample_window);

				System.out.println("The ID of the second sample window = " + driver.getWindowHandle());
				System.out.println("The title of the second window = " + driver.getTitle());

				driver.close();
			}
		}

		driver.switchTo().window(main_window);

		driver.findElement(By.xpath("//*[text()='New Window Message']")).click();

		Set<String> multi_window_3 = driver.getWindowHandles();

		for (String message_window : multi_window_3) {

			if (!message_window.equals(main_window)) {

				driver.switchTo().window(message_window);

				System.out.println("The ID of message window = " + driver.getWindowHandle());

				driver.close();
			}
		}

		driver.switchTo().window(main_window);
		
		

		System.out.println("========== Handling of the Alerts ========");

		for (int i = 0; i < btn_light.size(); i++) {

			if (btn_light.get(i).getText().equalsIgnoreCase("Alerts")) {

				js.executeScript("arguments[0].click()", btn_light.get(i));
			}
		}
		
		WebElement alert_button=driver.findElement(By.id("alertButton"));
		js.executeScript("arguments[0].click()", alert_button);
		Thread.sleep(2000);
		String text_of_first_alert=driver.switchTo().alert().getText();
		System.out.println("The message of first alert = "+text_of_first_alert);
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("timerAlertButton")).click();
		
		Thread.sleep(6000);
		String text_of_timer_alert=driver.switchTo().alert().getText();
		System.out.println("The message of the timer alert = "+text_of_timer_alert);
		
		driver.switchTo().alert().accept();

		
		driver.findElement(By.id("confirmButton")).click();
		String text_confirm_alert=driver.switchTo().alert().getText();
		System.out.println("The message of the confirm button alert = "+text_confirm_alert);
		
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		WebElement prompt_alert_button=driver.findElement(By.id("promtButton"));
		js.executeScript("arguments[0].click()", prompt_alert_button);
		driver.switchTo().alert().sendKeys("Huseyin");
		driver.switchTo().alert().accept();
		System.out.println("Prompt alert's result = "+driver.findElement(By.id("promptResult")).getText());
		
		
		System.out.println("========== Handling of the Frames ========");
		
		for(int i=0;i<btn_light.size();i++) {
			
			if(btn_light.get(i).getText().equalsIgnoreCase("Frames")) {
				
				js.executeScript("arguments[0].click()", btn_light.get(i));
			}
		}
		
		driver.switchTo().frame("frame1");
		
		System.out.println("The text inside of the first frame = "+driver.findElement(By.id("sampleHeading")).getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		
		System.out.println("The text inside of the second frame = "+driver.findElement(By.id("sampleHeading")).getText());
		
		
		//driver.quit();
	}
}
