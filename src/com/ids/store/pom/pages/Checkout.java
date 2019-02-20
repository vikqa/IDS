package com.ids.store.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ids.store.pom.or.shopor;
import com.ids.store.selenium.wrapper.Helper;
import com.ids.store.selenium.wrapper.Wrapper;

;

public class Checkout extends Home {
	private WebDriver driver;

	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		Helper.waitForBrowserToLoad(driver);
	}

	public void navigateToplaceorder() {
		Selectcashondelivery();
		Helper.waitForBrowserToLoad(driver);
		selectorderplaced();
		Helper.waitForBrowserToLoad(driver);
		Ordersummaary();
		
	}

	private void Selectcashondelivery() {

		try {
			WebElement element = driver.findElement(By.xpath("//*[@id='payment']/ul/li[2]/label"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			System.out.println("cash on deleivry");
			//Helper.waitForBrowserToLoad(driver);
			logger.info("Select Cash on delivery button clicked");
		} catch (NoSuchElementException ex) {
			logger.info("Cash on delivery  sbutton does not exist", ex);
			logger.info("Error in Cash on delivery  method", ex);
			throw new IllegalArgumentException("Cash on delivery  element does not exists");
		}
	}

	private void selectorderplaced() {

		try {
			Thread.sleep(3000);
			WebElement element1 = driver.findElement(By.xpath("//*[@id='place_order']"));
			Actions actions1 = new Actions(driver);
			actions1.moveToElement(element1).click().perform();
			System.out.println("system order placed");
			logger.info("Order Placed button clicked");
		} catch (NoSuchElementException | InterruptedException ex) {
			logger.info("Order Placed button does not exist", ex);
			logger.info("Error in Order Placed Button method", ex);
			throw new IllegalArgumentException("Order Placed Button element does not exists");
		}
	}
	private void Ordersummaary() {

		try {
			Wrapper.waitForPageActive(driver, shopor.orderdone);     
			logger.info("Ordersummaary Done");
		} catch (NoSuchElementException  ex) {
			logger.info("Ordersummaary does not exist", ex);
			logger.info("Error in Ordersummaarymethod", ex);
			throw new IllegalArgumentException("Ordersummaary element does not exists");
		}
	}
	

}
