package com.ids.store.pom.Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ids.store.pom.pages.Checkout;
import com.ids.store.pom.pages.Home;
import com.ids.store.pom.pages.Login;
import com.ids.store.pom.pages.MyAccount;
import com.ids.store.pom.pages.Register;
import com.ids.store.pom.pages.shop;
import com.ids.store.selenium.web.BrowserDriver;
import com.ids.store.selenium.wrapper.Helper;
import com.ids.store.selenium.wrapper.TestCase;

public class HomeTests<_logout> extends TestCase {
	final static Logger logger = Logger.getLogger(HomeTests.class);
	
	private WebDriver driver;
	private Home _home;
	private Register _register;
	private MyAccount _account;
	private Login _login;
	private shop _shop;
	private Checkout _checkout;

	@Parameters({ "browserVer", "baseURL" })
	@BeforeClass
	public void setup(String browserVer, String baseURL) {
		driver = BrowserDriver.launchBrowser(browserVer);
		driver.navigate().to(baseURL);
		
		_home = new Home(driver);
	}

	@AfterClass
	public void tearDown() {
		Helper.waitForBrowserToLoad(driver);
	driver.close();
	}

	@Test(groups = { "Home " }, priority = 1, description = "Default values should visible for each textbox.")
	public void To_verify_default_values_for_register() {
		_register = _home.navigateToRegister();

	}

	@Test(groups = { "Register " }, priority = 2, description = "Default values should visible for each textbox.")
	public void To_verify_default_values_for_enterregisteremail() {
		Long time = System.currentTimeMillis();
		String email = +time + "ids@idsil.com";
		_account = _register.register(email);

	}

	@Test(groups = { "Logout " }, priority = 3, description = "Default values should visible for each textbox.")
	public void To_verify_default_values_for_logout() {

		_login = _account.logout();
	}
	
	@Test(groups = { "Testinvalidlogin " }, priority = 4, description = "Default values should visible for each textbox.")
	public void To_verify_default_values_forenter_invalid_loginCredentials() {
		String emailid = "IDSwrong";
		String password = "login@123";
		_account = _login.invalidlogin(emailid, password);
		
			
	}
	

	@Test(groups = { "Login " }, priority = 5, description = "Default values should visible for each textbox.")
	public void To_verify_default_values_forloginpage() {
		String emailid = "brijbushan86@gmail.com";
		String password = "123456";
		_account = _login.login(emailid, password);
		

	}
	
	@Test(groups = { "Search" }, priority = 6, description = "Default values should visible for each textbox.")
	public void To_verify_default_values_for_Search_Box() {
		_account.navigatetosearch();
		

	}
	
	@Test(groups = { "Search" }, priority = 7, description = "Default values should visible for each textbox.")
	public void To_verify_default_values_for_Myaccount() {
		_register = _home.navigateToRegister();


	}
	
	
	@Test(groups = { "Testeditdetails " }, priority = 8, description = "Default values should visible for each textbox.")
	public void To_verify_default_values_navigatetoeditdetails() {
	
		_account.navigateToeditdetails();	
	}
	
	@Test(groups = { "Myaccount " }, priority = 9, description = "Default values should visible for each textbox.")
	public void To_verify_default_values_forMyaccountprofile() {

		String account_display_name = "QAIDS";
		String fname = "IDS Deft";
		String lname = "Team";
		_account.Myprofile(account_display_name, fname, lname);
	}

	@Test(groups = { "EditAddress " }, priority = 10, description = "Default values should visible for each textbox.")
	public void To_verify_navigatetoeditbillingaddress() {

		String fname = "IDS Deft";
		String lname = "Team";
		_account.navigatetoeditaddress();
		_account.navigatetobillingeditaddress();
		_account.Mybillingaddress(fname, lname);

	}

	@Test(groups = { "Editshippingaddress " }, priority = 11, description = "Default values should visible for each textbox.")
	public void To_verify_navigatetoshippingaddress() {

		String fname = "IDS Deft";
		String lname = "Team";
		_account.navigatetoshippingeditaddress();
		_account.Myshippingaddress(fname, lname);

	}

	@Test(groups = { "Cart " }, priority = 12, description = "Default values should visible for each textbox.")
	public void To_verify_navigatetocart() {

		_shop = _home.navigatetoshop();

	}

	@Test(groups = { "Shop " }, priority = 13, description = "Default values should visible for each textbox.")
	public void To_verify_continue_shop() {

		_shop = _home.navigatetoshop();

	}

	@Test(groups = { "Checkout " }, priority = 14, description = "Default values should visible for each textbox.")
	public void To_verify_navigatetocheckout() {

		_shop = _home.navigatetoshop();
	}

	@Test(groups = { "Shopcart " }, priority = 15, description = "Default values should visible for each textbox.")
	public void To_verify_navigatetoaddcart() {

		_checkout = _shop.shoptocart();

	}

	@Test(groups = { "checkout_billing " }, priority = 16, description = "Default values should visible for each textbox.")
	public void To_verify_navigatetocheckoutaddress() {
		String fname = "IDS Deft";
		String lname = "Team";
		_account.Mybillingaddressagain(fname, lname);

	}

	@Test(groups = { "checkou_Orderplaced " }, priority = 17, description = "Default values should visible for each textbox.")
	public void To_verify_navigatetoorderplaced() {

		_checkout.navigateToplaceorder();
		
	}

	@Test(groups = { "Navigate_to_Home " }, priority = 18, description = "Default values should visible for each textbox.")
	public void To_verify_navigatetohomeagain() {


	}

}