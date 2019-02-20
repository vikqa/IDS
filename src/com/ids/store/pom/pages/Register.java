package com.ids.store.pom.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.ids.store.pom.or.RegisterOR;
import com.ids.store.selenium.wrapper.Helper;
import com.ids.store.selenium.wrapper.Wrapper;

;

public class Register extends Home{
	private WebDriver driver;

	public Register(WebDriver driver) {
		super(driver);
		this.driver = driver;
		Helper.waitForBrowserToLoad(driver);
	}
	
	public MyAccount register(String email){
		enteremail(email);
		clickSubmitButton();
		//clickedlogout();
		return new MyAccount(driver);
		
	}
	
	
private void enteremail(String anyValue){
	
	try {
		Wrapper.enterValueInInputBox(driver, RegisterOR.reg_email_TxT, anyValue);
		logger.info("entered Email in textbox on register page" );
	} catch (NoSuchElementException ex) {
		logger.info("Email textbox does not exist", ex);
		logger.info("Error in enterEmaile method", ex);
		throw new IllegalArgumentException(" emailTextbox element does not exists");
	}
}


private void clickSubmitButton(){
	
	try {
		Wrapper.clickElement(driver, RegisterOR.register_BTN);
		logger.info("Register button clicked" );
	} catch (NoSuchElementException ex) {
		logger.info("Register button does not exist", ex);
		logger.info("Error in Register method", ex);
		throw new IllegalArgumentException("RegisterButton element does not exists");
	}
}




}
