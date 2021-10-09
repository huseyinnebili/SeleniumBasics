package Review_Classes;

import java.util.Set;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class Handling_Multi_Windows_With_Common_Methods extends CommonMethods {

	public static void main(String[] args) {

		CommonMethods.setUpDriver("chrome", "https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

		System.out.println("===========Parent Window's Info==========");

		String title = driver.getTitle();
		System.out.println("The title of parent window = " + title);
		String parent_window = driver.getWindowHandle();
		System.out.println("The ID of parent window = " + parent_window);

		System.out.println("============Twitter Window=========");

		driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Twitter']")).click();

		Set<String> multi_windows = driver.getWindowHandles();

		for (String twitter : multi_windows) {

			if (!twitter.equals(parent_window)) {

				driver.switchTo().window(twitter);

				System.out.println("The title of Twitter window = " + (driver.getTitle()));

				System.out.println("The ID of Twitter window = " + (driver.getWindowHandle()));
				driver.close();
				driver.switchTo().window(parent_window);

			}
		}

		System.out.println("============Facebook Window=========");

		driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Facebook']")).click();

		Set<String> multi_windows_2 = driver.getWindowHandles();

		for (String facebook : multi_windows_2) {

			if (!facebook.equals(parent_window)) {

				driver.switchTo().window(facebook);

				System.out.println("The title of Facebook window = " + (driver.getTitle()));
				System.out.println("The ID of Facebook window = " + (driver.getWindowHandle()));
				driver.close();
				driver.switchTo().window(parent_window);
			}
		}

		System.out.println("=======Multi Windows=========");

		driver.findElement(By.xpath("//*[text()='Follow Twitter & Facebook']")).click();

		Set<String> multi_windows_3 = driver.getWindowHandles();

		for (String child_windows : multi_windows_3) {

			if (!child_windows.equals(parent_window)) {

				driver.switchTo().window(child_windows);
				System.out.println(driver.getWindowHandle());
				System.out.println(driver.getTitle());
			}

		}

		driver.switchTo().window(parent_window);

		System.out.println("==========Three Windows=========");
		driver.findElement(By.id("followall")).click();

		Set<String> multi_windows_4 = driver.getWindowHandles();

		for (String child_window_3 : multi_windows_4) {

			if (!child_window_3.equals(parent_window)) {

				driver.switchTo().window(child_window_3);

				System.out.println(driver.getTitle());
				System.out.println(driver.getWindowHandle());
			}
		}

		driver.quit();

	}

}
