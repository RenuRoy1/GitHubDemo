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
public class OrderPage extends BaseClass {
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	private WebElement unitPrice;
	
	@FindBy(id="total_price")
	private WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckBtn;
	
	
	public double getUnitPrice() {
		String s =unitPrice.getText();
		String unitPrice=s.replaceAll("[^a-zA-Z0-9]", "");
		double unitPrice1=Double.parseDouble(unitPrice);
		return unitPrice1/100;
	}

	public double getTotalPrice() {
		String s =totalPrice.getText();
		String totalPrice=s.replaceAll("[^a-zA-Z0-9]", "");
		double totalPrice1=Double.parseDouble(totalPrice);
		return totalPrice1/100;
	}
	
	public LoginPage clickOnProceedToCheckOut() {
		proceedToCheckBtn.click();
		return new LoginPage();
		
	}

}
