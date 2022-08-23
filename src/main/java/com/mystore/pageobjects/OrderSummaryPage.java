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
public class OrderSummaryPage extends BaseClass{
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver,  this);
	}
	
	@FindBy(xpath="//span[text()='I confirm my order']")
	private WebElement confirmOrderBtn;
	
	public OrderConfirmationPage clickOnConfirmOrderBtn() {
		
		confirmOrderBtn.click();
		return new OrderConfirmationPage();
		
	}

}
