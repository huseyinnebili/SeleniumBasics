package com.class05;


	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class AlertTask {

	    public static void main(String[] args) throws InterruptedException {

	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\husey\\Selenium\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
	        driver.findElement(By.xpath("//*[@class = 'btn btn-default']")).click();
	        Thread.sleep(5000);
	        Alert alert = driver.switchTo().alert();
	        String text = alert.getText();
	        if (text.equals("I am an alert box!")) {
	            System.out.println("'“I am an alert box!”' text presents.");
	        } else {
	            System.out.println("'“I am an alert box!”' text not presents.");
	        }
	        alert.accept();
	        
	        driver.findElement(By.xpath("//*[@class = 'btn btn-default btn-lg']")).click();    
	        Thread.sleep(5000);
	        Alert alert1 = driver.switchTo().alert();
	        String text1 = alert1.getText();
	        if (text1.equals("Press a button!")) {
	            System.out.println("'“Press a button!”' is present.");
	        } else {
	            System.out.println("'“Press a button!”' isnt present.");
	        }
	        alert.accept();
	    
	        driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']")).click();    
	        Thread.sleep(5000);
	        Alert alert2 = driver.switchTo().alert();
	        String text2 = alert2.getText();
	        if (text2.equals("Please enter your name")) {
	            System.out.println("'“Please enter your name”' is present.");
	        } else {
	            System.out.println("'“Please enter your name”' isnt present.");
	        }
	        alert.accept();
	        
	        driver.quit();
	    }
}
