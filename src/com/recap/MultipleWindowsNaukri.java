package com.recap;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsNaukri {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");

		String parent = driver.getWindowHandle();
		System.out.println("Parent window id is " + parent);

		Set<String> allWindows = driver.getWindowHandles();

		int count = allWindows.size();
		System.out.println("Total window:" + count);
		System.out.println(allWindows);

//		for (String child : allWindows) {
//			if (!parent.equalsIgnoreCase(child)) {
//				driver.switchTo().window(child);
//				driver.manage().window().fullscreen();
//				System.out.println("Child window title is: " + driver.getTitle());
//
//				Thread.sleep(3000);
//				driver.close();
//			}
//		}

		ArrayList<String> tabs = new ArrayList<>(allWindows);

		driver.switchTo().window(tabs.get(2));
		driver.manage().window().fullscreen();
		System.out.println("2.pop up's title: " + driver.getTitle());
		Thread.sleep(3000);
		driver.close();

		driver.switchTo().window(tabs.get(1));
		driver.manage().window().fullscreen();
		System.out.println("1.pop up's title: " + driver.getTitle());
		Thread.sleep(3000);
		driver.close();

		driver.switchTo().window(parent);
		driver.manage().window().fullscreen();
		System.out.println("Paren window's title: " + driver.getTitle());

		driver.switchTo().window(tabs.get(3));
		driver.manage().window().fullscreen();
		System.out.println("3.pop up's title: " + driver.getTitle());
		Thread.sleep(3000);
		driver.close();

		Thread.sleep(3000);
		driver.quit();

	}

}
