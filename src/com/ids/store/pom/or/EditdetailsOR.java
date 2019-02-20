package com.ids.store.pom.or;
import org.openqa.selenium.By;

public class EditdetailsOR {
	
public static final By editdetails = By.linkText("edit your password and account details");
public static final By account_first_name = By.name("account_first_name");
public static final By account_last_name = By.name("account_last_name");
public static final By woocommerce_message = By.cssSelector(".woocommerce");
public static final By save_account_details = By.name("save_account_details");
//public static final By editbillingaddress=By.linkText("shipping and billing addresses");
public static final By shop=By.linkText("Shop");
public static final By displayname=By.name("account_display_name");
public static final By updatebillingaddress=By.linkText("shipping and billing addresses");

//billing address

public static final By Editbillingaddress=By.cssSelector("#post-7 > div > div > div > div.u-columns.woocommerce-Addresses.col2-set.addresses > div.u-column1.col-1.woocommerce-Address > header > a");

public static final By billing_first_name = By.name("billing_first_name");
public static final By billing_last_name = By.name("billing_last_name");
public static final By billingcompanyname=By.id("billing_company");
public static final By billingaddress1=By.name("billing_address_1");
public static final By billingaddress2=By.name("billing_address_2");
public static final By billingcity=By.name("billing_city");
public static final By billingpostcode=By.name("billing_postcode");
public static final By billing_phone=By.name("billing_phone");
public static final By billing_save_address=By.name("save_address");
public static final By woocommerce_messagealert = By.cssSelector(".woocommerce");

//shipping address
public static final By Editshippingaddress=By.xpath("/html/body/div[1]/div/div/div[2]/main/div/div/div/div/div[1]/div[2]/header/a");
public static final By shippingcompanyname=By.id("shipping_company");
public static final By shipping_first_name = By.name("shipping_first_name");
public static final By shipping_LAST_name = By.name("shipping_last_name");
public static final By shippingaddress1=By.name("shipping_address_1");
public static final By shippingaddress2=By.name("shipping_address_2");
public static final By shippingcity=By.name("shipping_city");
public static final By shippingpostcode=By.name("shipping_postcode");
public static final By shipping_phone=By.name("shipping_phone");
public static final By shipping_save_address=By.name("save_address");
public static final By shipingwoocommerce_messagealert = By.cssSelector(".woocommerce");
}