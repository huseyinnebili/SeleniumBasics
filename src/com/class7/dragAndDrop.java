package com.class7;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;

	import utils.CommonMethods;

	public class dragAndDrop extends CommonMethods {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			setUpDriver("chrome", "https://jqueryui.com/droppable/");
			WebElement frame = driver.findElement(By.cssSelector("iframe.demo-frame"));
			driver.switchTo().frame(frame);
			WebElement drag = driver.findElement(By.cssSelector("div#draggable"));
			WebElement drop = driver.findElement(By.cssSelector("div#droppable"));
			Actions action = new Actions(driver);
			action.dragAndDrop(drag, drop).perform();
			Thread.sleep(2000);
			driver.close();

		}
}
