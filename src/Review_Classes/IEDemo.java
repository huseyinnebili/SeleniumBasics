package Review_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDemo {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.ie.driver", "C:\\Users\\husey\\eclipse-workspace\\SeleniumBasics\\src\\driver\\IEDriverServer.exe");
		
		driver=new InternetExplorerDriver();
		
		driver.get("https://demoqa.com/");	
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("EnableNativeEvents", false);
		caps.setCapability("ignoreZoomSetting", true);

	}

}
