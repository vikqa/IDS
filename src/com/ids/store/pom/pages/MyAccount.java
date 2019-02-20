package com.ids.store.pom.pages;

import java.util.NoSuchElementException;

//import com.deftsoft.demo.pom.or.HomeOR;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ids.store.pom.or.EditdetailsOR;
import com.ids.store.pom.or.HomeOR;
import com.ids.store.pom.or.RegisterOR;
import com.ids.store.selenium.wrapper.Helper;
import com.ids.store.selenium.wrapper.Wrapper;

public class MyAccount extends Topnavigation {

	private WebDriver driver;

	final static Logger logger = Logger.getLogger(MyAccount.class);

	public MyAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
		Helper.waitForBrowserToLoad(driver);

	}
	public Login logout(){                      
		                                  
		clickedlogout();                                        
		return new Login(driver);                             
		                                                          
	}       
	private void clickedlogout()
	
	{                                                              
        
        
		try {                                                                                  
			Wrapper.clickElement(driver, RegisterOR.logoutbtn);                                
			logger.info("logout from my account clicked" );                                           
		} catch (NoSuchElementException ex) {                                                  
			logger.info("logout does not exist", ex);                                  
			logger.info("Error in logout method", ex);                              
			throw new IllegalArgumentException("logout element does not exists");        
		}                                                                                      
	}                                                                                       
	public void navigateToeditdetails(){
		clickeditaccountdetails();
				
	}
	public void navigatetosearch(){
		entersearchText("shirt");
				
		textverifysearch("Search results: “”");
			}
	private void entersearchText(String anyValue) {

		try {
			Wrapper.clickElement(driver,HomeOR.search_box);
			driver.findElement(By.cssSelector("#woocommerce-product-search-field-0")).sendKeys(Keys.ENTER);
			logger.info(" searchText in textbox");
		} catch (NoSuchElementException ex) {
			logger.info("not searchText textbox", ex);
			logger.info("Error in searchText  method", ex);
			throw new IllegalArgumentException("searchText textbox element does not exists");
		}
	}
	private void textverifysearch(String anyValue) {

		try {
			Helper.verifyTextPresent("Search results: “”", driver);
			logger.info(" searchText in textbox");
		} catch (NoSuchElementException ex) {
			logger.info("not searchText textbox", ex);
			logger.info("Error in searchText  method", ex);
			throw new IllegalArgumentException("searchText textbox element does not exists");
		}
	}
				
	public void navigatetoeditaddress(){
		clickeditaaddressdetails();
		
				
	}
	public void navigatetoshippingeditaddress(){
		clickeditshippingdetails();
		
				
	}
	
private void clickeditshippingdetails(){
		
		try {
			Wrapper.clickElement(driver,EditdetailsOR.Editshippingaddress);
			logger.info("editshippingdetails clicked" );
		} catch (NoSuchElementException ex) {
			logger.info("not editshippingdetails", ex);
			logger.info("Error in editshippingdetails  method", ex);
			throw new IllegalArgumentException("editshippingdetails element does not exists");
		}
}        
	
	public void navigatetobillingeditaddress(){
		Helper.waitForBrowserToLoad(driver);
		clickonbillingaddress();
				
	}
	
		
private void clickeditaccountdetails(){
		
		try {
			Wrapper.clickElement(driver,EditdetailsOR.editdetails);
			logger.info("editaccountdetails clicked" );
		} catch (NoSuchElementException ex) {
			logger.info("not clicked editaccountdetails", ex);
			logger.info("Error in editaccountdetails  method", ex);
			throw new IllegalArgumentException("editaccountdetails element does not exists");
		}
}        

private void clickeditaaddressdetails(){
	
	try {
		Wrapper.clickElement(driver,EditdetailsOR.updatebillingaddress);
		logger.info("editaaddressdetails clicked" );
	} catch (NoSuchElementException ex) {
		logger.info("not clicked button", ex);
		logger.info("Error in editaaddressdetails  method", ex);
		throw new IllegalArgumentException("editaaddressdetails element does not exists");
	}
}
private void clickonbillingaddress(){
	
	try {
		Wrapper.clickElement(driver,EditdetailsOR.Editbillingaddress);
		logger.info("billingaddress clicked" );
	} catch (NoSuchElementException ex) {
		logger.info("not billingaddress button", ex);
		logger.info("Error in billingaddress  method", ex);
		throw new IllegalArgumentException("button clicked element does not exists");
	}
}       
	                                                                                           

public void Myshippingaddress(String fname, String lname) {

	Helper.waitForBrowserToLoad(driver);

	// return new MyAccount(driver);

	enterfirstnameshipping(fname);
	enterlastnameshipping(lname);
	entershippingcompanyname("IDS Infotech");
	entershippingaddress1("abc abc acba street 1 hp");
	entershippingaddress2("abc abc acba street 1 hp");
	entershippingcity("chandigarh");
	entershippingpostcode("121212");
	entershipping_phone("321654789");
	entershipping_save_address();
	
		
}

private void enterfirstnameshipping(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver, EditdetailsOR.shipping_first_name, anyValue);
		logger.info(" firstnameshipping in textbox");
	} catch (NoSuchElementException ex) {
		logger.info("not edit firstnameshipping textbox", ex);
		logger.info("Error in firstnameshipping  method", ex);
		throw new IllegalArgumentException("firstnameshipping textbox element does not exists");
	}
}

private void enterlastnameshipping(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver, EditdetailsOR.shipping_LAST_name, anyValue);
		logger.info("Edit lastnameshipping");
	} catch (NoSuchElementException ex) {
		logger.info("not lastnameshipping", ex);
		logger.info("Error in lastnameshipping method", ex);
		throw new IllegalArgumentException("lastnameshipping element does not exists");
	}
}

private void entershippingcompanyname(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.shippingcompanyname, anyValue);
		logger.info("edit shippingcompanyname");
	} catch (NoSuchElementException ex) {
		logger.info("not edit shippingcompanyname", ex);
		logger.info("Error in edit shippingcompanyname", ex);
		throw new IllegalArgumentException("edit entershippingcompanyname element does not exists");
	}
}
private void entershippingaddress1(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.shippingaddress1, anyValue);
		logger.info("edit shippingaddress1");
	} catch (NoSuchElementException ex) {
		logger.info("not edit shippingaddress1", ex);
		logger.info("Error in edit shippingaddress1", ex);
		throw new IllegalArgumentException("edit shippingaddress1 element does not exists");
	}
}
private void entershippingaddress2(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.shippingaddress2, anyValue);
		logger.info("edit shippingaddress2");
	} catch (NoSuchElementException ex) {
		logger.info("not edit shippingaddress2", ex);
		logger.info("Error in edit shippingaddress2", ex);
		throw new IllegalArgumentException("edit shippingaddress2 element does not exists");
	}
}
private void entershippingcity(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.shippingcity, anyValue);
		logger.info("edit shippingcity");
	} catch (NoSuchElementException ex) {
		logger.info("not edit shippingcity", ex);
		logger.info("Error in edit shippingcity", ex);
		throw new IllegalArgumentException("edit shippingcity element does not exists");
	}
}
private void entershippingpostcode(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.shippingpostcode, anyValue);
		logger.info("edit shippingpostcode");
	} catch (NoSuchElementException ex) {
		logger.info("not edit shippingpostcode", ex);
		logger.info("Error in edit shippingpostcode", ex);
		throw new IllegalArgumentException("edit shippingpostcode element does not exists");
	}
}
private void entershipping_phone(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.shipping_phone, anyValue);
		logger.info("edit shipping_phone");
	} catch (NoSuchElementException ex) {
		logger.info("not edit shipping_phone", ex);
		logger.info("Error in edit shipping_phone", ex);
		throw new IllegalArgumentException("edit shipping_phone element does not exists");
	}
}


private void entershipping_save_address() {

	try {
		Wrapper.clickElement(driver, EditdetailsOR.shipping_save_address);
		logger.info("shipping_save_address button clicked");
	} catch (NoSuchElementException ex) {
		logger.info("shipping_save_address button does not exist", ex);
		logger.info("Error in shipping_save_address method", ex);
		throw new IllegalArgumentException("shipping_save_address element does not exists");
	}
}
public void Mybillingaddressagain(String fname, String lname) {

	Helper.waitForBrowserToLoad(driver);

	// return new MyAccount(driver);

	enterfirstnamebilling(fname);
	enterlastnamebilling(lname);
	enterbillingcompanyname("IDS Infotech");
	enterbillingaddress1("abc abc acba street 1 hp");
	enterbillingaddress2("abc abc acba street 1 hp");
	enterbillingcity("chandigarh");
	enterbillingpostcode("121212");
	enterbilling_phone("321654789");
}

public void Mybillingaddress(String fname, String lname) {

	Helper.waitForBrowserToLoad(driver);

	// return new MyAccount(driver);

	enterfirstnamebilling(fname);
	enterlastnamebilling(lname);
	enterbillingcompanyname("IDS Infotech");
	enterbillingaddress1("abc abc acba street 1 hp");
	enterbillingaddress2("abc abc acba street 1 hp");
	enterbillingcity("chandigarh");
	enterbillingpostcode("121212");
	enterbilling_phone("321654789");
	enterbilling_save_address();
	
		
}

private void enterfirstnamebilling(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver, EditdetailsOR.billing_first_name, anyValue);
		logger.info("Edit firstnamebilling");
	} catch (NoSuchElementException ex) {
		logger.info("not edit firstnamebilling textbox", ex);
		logger.info("Error in firstnamebilling  method", ex);
		throw new IllegalArgumentException("firstnamebilling textbox element does not exists");
	}
}

private void enterlastnamebilling(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver, EditdetailsOR.billing_last_name, anyValue);
		logger.info("Edit lastnamebilling");
	} catch (NoSuchElementException ex) {
		logger.info("not edited lastnamebilling", ex);
		logger.info("Error in lastnamebilling method", ex);
		throw new IllegalArgumentException("elastnamebilling element does not exists");
	}
}

private void enterbillingcompanyname(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.billingcompanyname, anyValue);
		logger.info("edit billingcompanyname");
	} catch (NoSuchElementException ex) {
		logger.info("not edit billingcompanyname", ex);
		logger.info("Error in edit billingcompanyname", ex);
		throw new IllegalArgumentException("edit billingcompanyname element does not exists");
	}
}
private void enterbillingaddress1(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.billingaddress1, anyValue);
		logger.info("edit billingaddress1");
	} catch (NoSuchElementException ex) {
		logger.info("not edit billingaddress1", ex);
		logger.info("Error in edit billingaddress1", ex);
		throw new IllegalArgumentException("edit billingaddress1 element does not exists");
	}
}
private void enterbillingaddress2(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.billingaddress2, anyValue);
		logger.info("edit billingaddress2");
	} catch (NoSuchElementException ex) {
		logger.info("not edit billingaddress2", ex);
		logger.info("Error in edit billingaddress2", ex);
		throw new IllegalArgumentException("edit billingaddress2 element does not exists");
	}
}
private void enterbillingcity(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.billingcity, anyValue);
		logger.info("edit billingcity");
	} catch (NoSuchElementException ex) {
		logger.info("not edit billingcity", ex);
		logger.info("Error in edit billingcity", ex);
		throw new IllegalArgumentException("edit billingcity element does not exists");
	}
}
private void enterbillingpostcode(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.billingpostcode, anyValue);
		logger.info("edit billingpostcode");
	} catch (NoSuchElementException ex) {
		logger.info("not edit billingpostcode", ex);
		logger.info("Error in edit billingpostcode", ex);
		throw new IllegalArgumentException("billingpostcode element does not exists");
	}
}
private void enterbilling_phone(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.billing_phone, anyValue);
		logger.info("edit billing_phone");
		Helper.waitForBrowserToLoad(driver);
	} catch (NoSuchElementException ex) {
		logger.info("not edit billing_phone", ex);
		logger.info("Error in billing_phone ", ex);
		throw new IllegalArgumentException("edit billing_phone element does not exists");
	}
}


private void enterbilling_save_address() {

	try {
		Wrapper.clickElement(driver, EditdetailsOR.billing_save_address);
		logger.info("Submit billing_save_address clicked");
	} catch (NoSuchElementException ex) {
		logger.info("Submit billing_save_address does not exist", ex);
		logger.info("Error in billing_save_address method", ex);
		throw new IllegalArgumentException("billing_save_address element does not exists");
	}
}
public void Myprofile(String fname, String lname, String account_display_name) {

	Helper.waitForBrowserToLoad(driver);

	// return new MyAccount(driver);

	enterfirstname(fname);
	enterlastname(lname);
	enteraccount_display_name(account_display_name);
	clickedsavedetails();
	
}

private void enterfirstname(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver, EditdetailsOR.account_first_name, anyValue);
		logger.info("Edit firstname");
	} catch (NoSuchElementException ex) {
		logger.info("not edit firstname textbox", ex);
		logger.info("Error in firstname  method", ex);
		throw new IllegalArgumentException("firstname textbox element does not exists");
	}
}

private void enterlastname(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver, EditdetailsOR.account_last_name, anyValue);
		logger.info("Edit lastname");
	} catch (NoSuchElementException ex) {
		logger.info("not lastname", ex);
		logger.info("Error in lastname method", ex);
		throw new IllegalArgumentException("lastname element does not exists");
	}
}

private void enteraccount_display_name(String anyValue) {

	try {
		Wrapper.enterValueInInputBox(driver,EditdetailsOR.displayname, anyValue);
		logger.info("edit account_display_name");
	} catch (NoSuchElementException ex) {
		logger.info("not edit account_display_name", ex);
		logger.info("Error in edit account_display_name", ex);
		throw new IllegalArgumentException("edit account_display_name element does not exists");
	}
}


private void clickedsavedetails() {

	try {
		Wrapper.clickElement(driver, EditdetailsOR.save_account_details);
		logger.info("clickedsavedetails button clicked");
	} catch (NoSuchElementException ex) {
		logger.info("clickedsavedetails sbutton does not exist", ex);
		logger.info("Error in clickedsavedetails method", ex);
		throw new IllegalArgumentException("clickedsavedetails element does not exists");
	}
}


}
