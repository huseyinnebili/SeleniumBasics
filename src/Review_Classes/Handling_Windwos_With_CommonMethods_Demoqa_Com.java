package Review_Classes;

import java.util.Set;
import org.openqa.selenium.By;
import utils.CommonMethods;

public class Handling_Windwos_With_CommonMethods_Demoqa_Com extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		CommonMethods.setUpDriver("chrome", "http://uitestpractice.com/Students/Switchto");

		System.out.println("======Parent Window=========");
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		System.out.println(driver.getTitle());

		System.out.println("==========Child Window========");

		driver.findElement(By.xpath("//*[text()='Opens in a new window']")).click();
		Set<String> list = driver.getWindowHandles();

		for (String child_window : list) {

			if (!child_window.equals(parent)) {

				driver.switchTo().window(child_window);
				System.out.println(driver.getWindowHandle());
				System.out.println(driver.getTitle());

				driver.switchTo().window(parent);
			}
		}
		driver.quit();

	}

}
