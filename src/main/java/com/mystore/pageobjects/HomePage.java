/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * @author renu1
 *
 */
public class HomePage extends BaseClass{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//a[@title='My wishlists']")
	private WebElement myWishlists;

	
	@FindBy(xpath="//span[text()='Order history and details']")
	private WebElement orderHistory;

	
	
	public WebElement validateWishlist() {
		return myWishlists;
	}
	
	public WebElement validateOrderHistory() {
		return orderHistory; 
	}
	
	public String getCurrURL() {
		String homePageUrl =driver.getCurrentUrl();
		return homePageUrl;
	}
}
