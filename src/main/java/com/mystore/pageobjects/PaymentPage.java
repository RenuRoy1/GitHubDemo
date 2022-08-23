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
public class PaymentPage extends BaseClass {
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	
	public OrderSummaryPage clickOnMethod() {
		
		bankWireMethod.click();
		return new OrderSummaryPage();
		
	}

}
