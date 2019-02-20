package com.ids.store.pom.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.ids.store.pom.or.EditdetailsOR;
import com.ids.store.selenium.wrapper.Wrapper;


public class Editdetails  extends Topnavigation{
private WebDriver driver;
	public Editdetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}
	
	public void navigateToeditdetails(){
		clickeditaccountdetails();
				
	}
	
		
private void clickeditaccountdetails(){
		
		try {
			Wrapper.clickElement(driver,EditdetailsOR.editdetails);
			logger.info("Edit account button clicked" );
		} catch (NoSuchElementException ex) {
			logger.info("not clicked Edit account button", ex);
			logger.info("Error in Edit account button  method", ex);
			throw new IllegalArgumentException("Edit account button  element does not exists");
		}
}

}



