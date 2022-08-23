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
public class ShippingPage extends BaseClass {
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutbtn;
	
	
	public void clickOnCheck() {
		checkbox.click();
	}
 
	public PaymentPage clickOnProceedToCheckOut() {
		proceedToCheckOutbtn.click();
		return new PaymentPage();
	}

	

}
