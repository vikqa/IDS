package com.ids.store.selenium.wrapper;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionBuilder {
public static	WebDriver driver;


	public static void dragAndDropElement(WebDriver driver, String src, String dest) {
		Actions action = new Actions(driver);	
		WebElement source = Wrapper.findWebElement(driver, src);
		WebElement destination = Wrapper.findWebElement(driver, dest);
		action.dragAndDrop(source, destination).build().perform();
	}
	
	public static void moveElement(WebDriver driver, String src) {
		Actions action = new Actions(driver);	
		WebElement source = Wrapper.findWebElement(driver, src);
		action.clickAndHold(source).moveByOffset(565, 173).release(source).click().build().perform();
	}
}