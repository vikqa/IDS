package com.ids.store.pom.pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.ids.store.pom.or.LoginOR;
import com.ids.store.selenium.wrapper.Helper;
import com.ids.store.selenium.wrapper.Wrapper;


public class Login extends Topnavigation {
	private WebDriver driver;
	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		Helper.waitForBrowserToLoad(driver);
	}
	public MyAccount login (String emailid, String password ) {	
		
		enteremail(emailid);
		enterPassword(password);
		checkremeberme();
		clickSubmitButton();
		return new MyAccount(driver);
		
	}
public MyAccount invalidlogin (String emailid, String password ) {	
		
		enteremail(emailid);
		enterPassword(password);
		checkremeberme();
		clickSubmitButton();
		invalidlogin();
		
		return new MyAccount(driver);
		
	}
private void enteremail(String anyValue){
		
		try {
			Wrapper.enterValueInInputBox(driver, LoginOR.TXT_Email, anyValue);
			logger.info("Entered email" );
			
		} catch (NoSuchElementException ex) {
			logger.info("not entered email", ex);
			logger.info("Error in TXT_USER_NAME  method", ex);
			throw new IllegalArgumentException("enteremail element does not exists");
		}
	}
	
private void enterPassword(String anyValue){
		
		try {
			Wrapper.enterValueInInputBox(driver, LoginOR.TXT_PASSWORD, anyValue);
			logger.info("entered password" );
		} catch (NoSuchElementException ex) {
			logger.info("password textbox does not exist", ex);
			logger.info("Error in password method", ex);
			throw new IllegalArgumentException("password textbox does not exists");
		}
}
private void checkremeberme(){
	
	try {
		Wrapper.clickElement(driver, LoginOR.Rememberme);
		logger.info("remeberme checkbox selected" );
	} catch (NoSuchElementException ex) {
		logger.info("remeberme checkbox  does not exist", ex);
		logger.info("Error in remeberme checkbox  method", ex);
		throw new IllegalArgumentException("remeberme  element does not exists");
	}
}
private void clickSubmitButton(){
	
	try {
		Wrapper.clickElement(driver, LoginOR.BTN_SUBMIT);
		logger.info("login button clicked" );
	} catch (NoSuchElementException ex) {
		logger.info("login button does not exist", ex);
		logger.info("Error in login button method", ex);
		throw new IllegalArgumentException("login button element does not exists");
	}
}
private void invalidlogin(){
	
	try {
Wrapper.getElementText(driver, LoginOR.invalidlogin);
logger.info("abc"+Wrapper.getTextByAttributeValue(driver, LoginOR.invalidlogin));
		logger.info("invalidlogin" );
	} catch (NoSuchElementException ex) {
		logger.info("invalidlogin does not exist", ex);
		logger.info("Error in invalidlogin method", ex);
		throw new IllegalArgumentException("invalidlogin element does not exists");
	}
}

}
