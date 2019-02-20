package com.ids.store.pom.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.ids.store.pom.or.HomeOR;
import com.ids.store.selenium.wrapper.Helper;
import com.ids.store.selenium.wrapper.Wrapper;



public class Topnavigation {
	final static Logger logger = Logger.getLogger(Topnavigation.class);
	private WebDriver driver;

	public Topnavigation(WebDriver driver) {
		this.driver = driver;
	}
	
	public Register navigateToRegister(){
		clickMyAccount();
		Helper.holdon(2);
		return new Register(driver);
		
	}
	public shop navigatetoshop(){
		clickonshoponmenubar();
		Helper.holdon(2);
		return new shop(driver);
		
	}
	
	private void clickMyAccount() {
		try {
			Wrapper.clickElement(driver, HomeOR.LBL_MY_ACCOUNT);
			logger.info("Verify click Myaccount on menu bar for Register" );
		} catch (NoSuchElementException ex) {
			logger.info("Myaccount link on menu bar does not exist", ex);
			logger.info("Error in Myaccount method", ex);
			throw new IllegalArgumentException("MyAccount element does not exists");
		} 
	}
	private void clickonshoponmenubar() {
		try {
			Wrapper.clickElement(driver, HomeOR.shoponmenubar);
			logger.info("MyAccount button clicked" );
		} catch (NoSuchElementException ex) {
			logger.info("MyAccount button does not exist", ex);
			logger.info("Error in clickMyAccount method", ex);
			throw new IllegalArgumentException("MyAccount element does not exists");
		} 
	} 
	
}
