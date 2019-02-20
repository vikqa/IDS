package com.ids.store.pom.pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.ids.store.selenium.wrapper.Helper;

public class Home extends Topnavigation{
	
private WebDriver driver;
	
	final static Logger logger = Logger.getLogger(Home.class);

	public Home(WebDriver driver) {
		super(driver);
		this.driver = driver;		
		Helper.waitForBrowserToLoad(driver);
		

	}
}
	