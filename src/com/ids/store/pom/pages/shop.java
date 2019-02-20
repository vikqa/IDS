package com.ids.store.pom.pages;                                                      
                                                                                      
import org.openqa.selenium.NoSuchElementException;                                    
import org.openqa.selenium.WebDriver;                                                 
                                                                                      
import com.ids.store.pom.or.shopor;
import com.ids.store.selenium.wrapper.Helper;                                         
import com.ids.store.selenium.wrapper.Wrapper;                                        
                                                                                      
;                                                                                     
                                                                                      
public class shop extends Home{                                                   
	private WebDriver driver;                                                         
                                                                                      
	public shop(WebDriver driver) {                                               
		super(driver);                                                                
		this.driver = driver;                                                         
		Helper.waitForBrowserToLoad(driver);                                          
	}                                                                                 
	                                                                                  
	public Checkout shoptocart(){                                          
		Productadd();                                                            
		clickedViewcartbtn();   
	    clickedcheckout();
	 	return new Checkout(driver);                                                 
		                                                                              
	}                                                                                 
	                                                                                  
	                                                                                  
	private void Productadd(){                                                     
        
		try {                                                                             
			Wrapper.clickElement(driver, shopor.productadd);                        
			logger.info("Productadd button clicked" );                                        
		} catch (NoSuchElementException ex) {                                             
			logger.info("Productadd button does not exist", ex);                             
			logger.info("Error in Productadd method", ex);                         
			throw new IllegalArgumentException("Productadd element does not exists");   
		}                                                                                 
	}                                                                                                 
                                                                                      
                                                                                      
private void clickedViewcartbtn(){                                                     
	                                                                                  
	try {                                                                             
		Wrapper.clickElement(driver, shopor.Viewcartbtn);                        
		logger.info("Viewcart button clicked" );                                        
	} catch (NoSuchElementException ex) {                                             
		logger.info("Viewcart button does not exist", ex);                             
		logger.info("Error in Viewcart method", ex);                         
		throw new IllegalArgumentException("Viewcart element does not exists");   
	}                                                                                 
}       
private void clickedcheckout(){                                                     
    
	try {                                                                             
		Wrapper.clickElement(driver, shopor.checkoutcliked);                        
		logger.info("checkout button clicked" );                                        
	} catch (NoSuchElementException ex) {                                             
		logger.info(" checkout does not exist", ex);                             
		logger.info("Error in checkout method", ex);                         
		throw new IllegalArgumentException("checkout element does not exists");   
	}                                                                                 
}       

}