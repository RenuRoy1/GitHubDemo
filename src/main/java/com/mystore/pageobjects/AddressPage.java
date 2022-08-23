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
public class AddressPage extends BaseClass {
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOutBtn;
	
	
	public ShippingPage clickonCheckOut() {
		proceedToCheckOutBtn.click();
		return new ShippingPage();
		
	}
	

}
