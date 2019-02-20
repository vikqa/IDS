package com.ids.store.pom.or;

import org.openqa.selenium.By;

public class shopor {
	public static final By productadd = By.xpath("//*[@id='main']/div[2]/ul/li[1]/a[2]");
	public static final By Viewcartbtn = By.linkText("View cart");
	public static final By checkoutcliked = By.xpath("//*[@id='post-5']/div/div/div[2]/div/div/a");
	// public static final By cashonorder = By.xpath("");

	// public static final By cashorder=By.xpath(".//*[normalize-space(text())
	// and normalize-space(.)='Direct bank transfer'])[1]/following::label[1]");
	public static final By cashorder = By.xpath("(//label[text()='Cash on delivery')");

	public static final By ordersbmit = By.xpath("//*[@id='place_order']");

	public static final By orderdone = By.xpath("//*[@id='post-6']/div/div/div/p");

	public static final By getordersummary = By.xpath("//*[@id='post-6']/div/div/div/ul");
	public static final By getordersummary1 = By.xpath("//*[@id='post-6']/div/div/div/section[1]");
	public static final By getordersummary2 = By.xpath("//*[@id='post-6']/div/div/div/section[2]/section/div[1]");
	public static final By getordersummary3 = By.xpath("//*[@id='post-6']/div/div/div/section[2]/section/div[2]");

}
