package Review_Classes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class ToolQA_Review extends CommonMethods {

	public static void main(String[] args) throws InterruptedException, IOException {

		CommonMethods.setUpDriver("chrome", "https://demoqa.com/");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());

	

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

			}
			catch(Exception e) {}
		

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		Actions action = new Actions(driver);
//
//		System.out.println("=========First List======");
//
//		List<WebElement> list = driver.findElements(By.xpath("//*[@id='app']//div[@class='category-cards']/div"));
//
//		for (int i = 0; i < list.size(); i++) {
//
//			String text = list.get(i).getText();
//
//			System.out.println(text);
//
//		}
//
//		String exp_text = "Elements";
//
//		for (int i = 0; i < list.size(); i++) {
//
//			String text = list.get(i).getText();
//
//			if (text.equalsIgnoreCase(exp_text)) {
//
//				js.executeScript("arguments[0].click();", list.get(i));
//
//				break;
//			}
//		}
//
//		System.out.println("=======Second List =========");
//
//		List<WebElement> list_2 = driver.findElements(By.xpath("//*[@class='element-list collapse show']/ul/li"));
//
//		String exp_text_2 = "Text Box";
//
//		for (int i = 0; i < list_2.size(); i++) {
//
//			String text = list_2.get(i).getText();
//
//			System.out.println(text);
//
//			if (list_2.get(i).getText().contains(exp_text_2)) {
//
//				js.executeScript("arguments[0].click();", list_2.get(i));
//
//			}
//		}
//
//		// Text Box Handling
//
//		driver.findElement(By.id("userName")).sendKeys("Huseyin");
//		driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
//		driver.findElement(By.id("currentAddress")).sendKeys("Wayne/NJ");
//		driver.findElement(By.id("permanentAddress")).sendKeys("Wayne/NJ");
//		js.executeScript("arguments[0].click();", driver.findElement(By.id("submit")));
//
//		// Check Box Handling
//
//		String exp_text_3 = "Check Box";
//
//		for (int i = 0; i < list_2.size(); i++) {
//
//			if (list_2.get(i).getText().equalsIgnoreCase(exp_text_3)) {
//
//				js.executeScript("arguments[0].click();", list_2.get(i));
//
//			}
//		}
//
//		driver.findElement(By.xpath("//*[@title='Expand all']")).click();
//
//		js.executeScript("window.scrollBy(0,1000)");
//
//		List<WebElement> check_box = driver.findElements(By.xpath("//*[@class='rct-checkbox']"));
//
//		int size = check_box.size();
//
//		System.out.println("Size of check-box = " + size);
//
//		for (WebElement ckbox : check_box) {
//
//			js.executeScript("scroll(0,400)");
//
//			if (ckbox.isDisplayed() || ckbox.isEnabled() || !ckbox.isSelected()) {
//				ckbox.click();
//
//			}
//
//			System.out.println(driver.findElement(By.id("result")).getText());
//		}
//
//		// Radio Button Handling
//
//		String exp_text_4 = "Radio Button";
//
//		for (int i = 0; i < list_2.size(); i++) {
//
//			if (list_2.get(i).getText().equalsIgnoreCase(exp_text_4)) {
//
//				js.executeScript("arguments[0].click()", list_2.get(i));
//
//			}
//		}
//
//		List<WebElement> radio_list = driver.findElements(By.xpath("//*[@type='radio']"));
//
//		System.out.println("Size of the radio button = " + radio_list.size());
//
//		WebElement yes_radio = driver.findElement(By.id("yesRadio"));
//
//		if (!yes_radio.isSelected() || yes_radio.isDisplayed() || yes_radio.isEnabled()) {
//
//			js.executeScript("arguments[0].click()", yes_radio);
//
//			System.out.println(driver.findElement(By.xpath("//*[@class='mt-3']")).getText());
//
//		}
//
//		WebElement impressive_radio = driver.findElement(By.id("impressiveRadio"));
//
//		if (!impressive_radio.isSelected() || impressive_radio.isDisplayed() || impressive_radio.isSelected()) {
//
//			js.executeScript("arguments[0].click()", impressive_radio);
//
//			System.out.println(driver.findElement(By.xpath("//*[@class='mt-3']")).getText());
//
//		}
//
//		for (int i = 0; i < list_2.size(); i++) {
//
//			if (list_2.get(i).getText().equalsIgnoreCase("Dynamic Properties")) {
//
//				js.executeScript("arguments[0].click()", list_2.get(i));
//			}
//		}
//
//		driver.findElement(By.id("enableAfter")).click();
//
//		wait = new WebDriverWait(driver, 30);
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
//
//		WebElement visible_after = driver.findElement(By.id("visibleAfter"));
//
//		if (visible_after.isDisplayed()) {
//
//			System.out.println(visible_after.getText());
//		}
//
//		driver.findElement(By.id("colorChange")).click();
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("colorChange")));
//
//		List<WebElement> list_3 = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div"));
//
//		String exp_text_5 = "Alerts, Frame & Windows";
//
//		for (int i = 0; i < list_3.size(); i++) {
//
//			String text = list_3.get(i).getText();
//
//			System.out.println(text);
//
//			js.executeScript("scroll(0,800)");
//
//			if (text.contains(exp_text_5)) {
//
//				System.out.println("==============");
//
//				list_3.get(i).click();
//
//			}
//		}
//
//		System.out.println("=======List of Frames ,Alerts , Windows ,etc. ========");
//
//		List<WebElement> btn_light = driver.findElements(By.xpath("//*[@class='element-list collapse show']/ul/li"));
//
//		for (int i = 0; i < btn_light.size(); i++) {
//
//			String text_of_btn_light = btn_light.get(i).getText();
//
//			System.out.println(text_of_btn_light);
//
//			if (text_of_btn_light.equalsIgnoreCase("Browser Windows")) {
//
//				js.executeScript("arguments[0].click()", btn_light.get(i));
//			}
//
//		}
//
//		System.out.println("==========Handling of the windows========");
//
//		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[text()='New Tab']")));
//
//		String main_window = driver.getWindowHandle();
//		System.out.println("The ID of the main window = " + main_window);
//		System.out.println("The title of the main window = " + driver.getTitle());
//
//		Set<String> multi_window = driver.getWindowHandles();
//
//		for (String sample_window : multi_window) {
//
//			if (!sample_window.equals(main_window)) {
//
//				driver.switchTo().window(sample_window);
//				System.out.println("The ID of smaple window = " + driver.getWindowHandle());
//				System.out.println("The title of the sample window = " + driver.getTitle());
//				driver.close();
//
//			}
//		}
//
//		driver.switchTo().window(main_window);
//
//		driver.findElement(By.xpath("//*[text()='New Window']")).click();
//
//		Set<String> multi_window_2 = driver.getWindowHandles();
//
//		for (String sec_sample_window : multi_window_2) {
//
//			if (!sec_sample_window.equals(main_window)) {
//
//				driver.switchTo().window(sec_sample_window);
//
//				System.out.println("The ID of the second sample window = " + driver.getWindowHandle());
//				System.out.println("The title of the second window = " + driver.getTitle());
//
//				driver.close();
//			}
//		}
//
//		driver.switchTo().window(main_window);
//
//		driver.findElement(By.xpath("//*[text()='New Window Message']")).click();
//
//		Set<String> multi_window_3 = driver.getWindowHandles();
//
//		for (String message_window : multi_window_3) {
//
//			if (!message_window.equals(main_window)) {
//
//				driver.switchTo().window(message_window);
//
//				System.out.println("The ID of message window = " + driver.getWindowHandle());
//
//				driver.close();
//			}
//		}
//
//		driver.switchTo().window(main_window);
//
//		System.out.println("========== Handling of the Alerts ========");
//
//		for (int i = 0; i < btn_light.size(); i++) {
//
//			if (btn_light.get(i).getText().equalsIgnoreCase("Alerts")) {
//
//				js.executeScript("arguments[0].click()", btn_light.get(i));
//			}
//		}
//
//		WebElement alert_button = driver.findElement(By.id("alertButton"));
//		js.executeScript("arguments[0].click()", alert_button);
//		Thread.sleep(2000);
//		String text_of_first_alert = driver.switchTo().alert().getText();
//		System.out.println("The message of first alert = " + text_of_first_alert);
//
//		driver.switchTo().alert().accept();
//
//		driver.findElement(By.id("timerAlertButton")).click();
//
//		Thread.sleep(6000);
//		String text_of_timer_alert = driver.switchTo().alert().getText();
//		System.out.println("The message of the timer alert = " + text_of_timer_alert);
//
//		driver.switchTo().alert().accept();
//
//		driver.findElement(By.id("confirmButton")).click();
//		String text_confirm_alert = driver.switchTo().alert().getText();
//		System.out.println("The message of the confirm button alert = " + text_confirm_alert);
//
//		driver.switchTo().alert().accept();
//		Thread.sleep(2000);
//
//		WebElement prompt_alert_button = driver.findElement(By.id("promtButton"));
//		js.executeScript("arguments[0].click()", prompt_alert_button);
//		driver.switchTo().alert().sendKeys("Huseyin");
//		driver.switchTo().alert().accept();
//		System.out.println("Prompt alert's result = " + driver.findElement(By.id("promptResult")).getText());
//
//		System.out.println("========== Handling of the Frames ========");
//
//		for (int i = 0; i < btn_light.size(); i++) {
//
//			if (btn_light.get(i).getText().equalsIgnoreCase("Frames")) {
//
//				js.executeScript("arguments[0].click()", btn_light.get(i));
//			}
//		}
//
//		driver.switchTo().frame("frame1");
//
//		System.out.println(
//				"The text inside of the first frame = " + driver.findElement(By.id("sampleHeading")).getText());
//
//		driver.switchTo().defaultContent();
//
//		driver.switchTo().frame("frame2");
//
//		System.out.println(
//				"The text inside of the second frame = " + driver.findElement(By.id("sampleHeading")).getText());
//
//		driver.switchTo().defaultContent();
//
//		System.out.println("========== Handling of Nested Frames ========");
//
//		for (int i = 0; i < btn_light.size(); i++) {
//
//			if (btn_light.get(i).getText().equalsIgnoreCase("Nested Frames")) {
//
//				js.executeScript("arguments[0].click()", btn_light.get(i));
//			}
//		}
//
//		driver.switchTo().frame("frame1");
//
//		WebElement child_frame = driver.findElement(By.xpath("//*[@srcdoc='<p>Child Iframe</p>']"));
//
//		driver.switchTo().frame(child_frame);
//
//		System.out.println(
//				"The text of child frame = " + driver.findElement(By.xpath("//*[text()='Child Iframe']")).getText());
//
//		driver.switchTo().defaultContent();
//
//		System.out.println("========== Handling of Modal Dialogs ========");
//
//		for (int i = 0; i < btn_light.size(); i++) {
//
//			if (btn_light.get(i).getText().equalsIgnoreCase("Modal Dialogs")) {
//
//				js.executeScript("arguments[0].click()", btn_light.get(i));
//
//			}
//		}
//
//		driver.findElement(By.id("showSmallModal")).click();
//		System.out.println(
//				"The text inside Small Modal = " + driver.findElement(By.xpath("//*[@class='modal-body']")).getText());
//		driver.findElement(By.id("closeSmallModal")).click();
//
//		driver.findElement(By.id("showLargeModal")).click();
//		System.out.println("The text inside Large Modal = "
//				+ driver.findElement(By.xpath("//*[@class='modal-body']/p")).getText());
//		driver.findElement(By.id("closeLargeModal")).click();
//
//		System.out.println("=======WebTable Handle========");
//
//		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
//
//		List<WebElement> list_4 = driver.findElements(By.xpath("//*[@class='element-list collapse show']/ul/li"));
//
//		System.out.println("========Fourth List=========");
//
//		for (int i = 0; i < list_4.size(); i++) {
//
//			String text_of_list = list_4.get(i).getText();
//
//			System.out.println(text_of_list);
//
//		}
//
//		for (int i = 0; i < list_4.size(); i++) {
//
//			if (list_4.get(i).getText().contains("Web Tables")) {
//
//				js.executeScript("arguments[0].click()", list_4.get(i));
//
//			}
//		}
//
//		List<WebElement> rows = driver.findElements(By.xpath("//*[@class='rt-tr-group']/div"));
//
//		System.out.println("=====List of Rows=======");
//
//		for (int i = 0; i < rows.size(); i++) {
//
//			String text_of_rows = rows.get(i).getText();
//
//			System.out.println(text_of_rows);
//		}
//
//		List<WebElement> cells = driver.findElements(By.xpath("//*[@class='rt-tr-group']/div/div"));
//
//		System.out.println("=====List of Cells======");
//
//		for (int i = 0; i < cells.size(); i++) {
//
//			String text_of_cells = cells.get(i).getText();
//
//			System.out.println(text_of_cells);
//		}
//
//		driver.findElement(By.id("addNewRecordButton")).click();
//
//		driver.findElement(By.id("firstName")).sendKeys("Alex");
//		driver.findElement(By.id("lastName")).sendKeys("Firlex");
//		driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
//		driver.findElement(By.id("age")).sendKeys("40");
//		driver.findElement(By.id("salary")).sendKeys("8000");
//		driver.findElement(By.id("department")).sendKeys("IT Department");
//		driver.findElement(By.id("submit")).click();
//
//		driver.findElement(By.id("searchBox")).sendKeys("Alex");
//		driver.findElement(By.id("basic-addon2")).click();
//
//		List<WebElement> cells_update = driver.findElements(By.xpath("//*[@class='rt-tr-group']/div/div"));
//
//		System.out.println("=====List of _Updated_Cells======");
//
//		for (int i = 0; i < cells_update.size(); i++) {
//
//			String text_of_cells_update = cells_update.get(i).getText();
//
//			System.out.println(text_of_cells_update);
//		}
//
//		System.out.println("======Handling of Buttons with Actions Class========");
//
//		for (int i = 0; i < list_2.size(); i++) {
//
//			if (list_2.get(i).getText().equalsIgnoreCase("Buttons")) {
//
//				js.executeScript("arguments[0].click()", list_2.get(i));
//			}
//		}
//
//		WebElement double_click_button = driver.findElement(By.id("doubleClickBtn"));
//
//		action.doubleClick(double_click_button).perform();
//
//		System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());
//
//		Thread.sleep(2000);
//
//		WebElement right_click_button = driver.findElement(By.id("rightClickBtn"));
//
//		action.contextClick(right_click_button).perform();
//
//		System.out.println(driver.findElement(By.id("rightClickMessage")).getText());
//
//		Thread.sleep(2000);
//
//		WebElement click_button = driver.findElement(By.xpath("//*[text()='Click Me']"));
//
//		action.click(click_button).perform();
//
//		System.out.println(driver.findElement(By.id("dynamicClickMessage")).getText());
//
//		Thread.sleep(2000);
//
//		js.executeScript("window.scrollBy(0,900)");
//
//		js.executeScript("arguments[0].click()",
//				driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[5]/span/div")));
//
//		List<WebElement> list_of_interactions = driver
//				.findElements(By.xpath("//*[@class='element-list collapse show']/ul/li"));
//
//		for (int i = 0; i < list_of_interactions.size(); i++) {
//
//			if (list_of_interactions.get(i).getText().equalsIgnoreCase("Droppable")) {
//
//				js.executeScript("arguments[0].click()", list_of_interactions.get(i));
//			}
//		}
//
//		WebElement drag = driver.findElement(By.id("draggable"));
//
//		WebElement drop = driver.findElement(By.id("droppable"));
//
//		action.dragAndDrop(drag, drop).perform();
//
//		driver.findElement(By.id("droppableExample-tab-accept")).click();
//
//		WebElement drag_2 = driver.findElement(By.id("acceptable"));
//		WebElement drop_2 = driver.findElement(By.xpath("//*[@id='acceptDropContainer']/div[2]"));
//
//		action.dragAndDrop(drag_2, drop_2).build().perform();
//
//		Thread.sleep(3000);
//
//		driver.findElement(By.id("droppableExample-tab-preventPropogation")).click();
//
//		WebElement drag_3 = driver.findElement(By.id("dragBox"));
//		WebElement drop_3 = driver.findElement(By.id("notGreedyDropBox"));
//		WebElement drop_3_1 = driver.findElement(By.id("notGreedyInnerDropBox"));
////
////		WebElement drop_4 = driver.findElement(By.id("notGreedyDropBox"));
////		WebElement drop_4_1 = driver.findElement(By.id("notGreedyInnerDropBox"));
////		
////		action.dragAndDrop(drag_3, drop_3).build().perform();
////
////		Thread.sleep(3000); , 
////
////		action.dragAndDrop(drag_3, drop_3_1).build().perform();
////
////		Thread.sleep(3000);
////
//		action.dragAndDrop(drag_3, drop_3_1).build().perform();
//
//		Thread.sleep(3000);
//
//		action.dragAndDrop(drag_3, drop_3).build().perform();
//
//		Thread.sleep(3000);

		
}
			
			driver.quit();
			
	}}
