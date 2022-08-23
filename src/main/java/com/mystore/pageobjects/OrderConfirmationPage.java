package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage  extends BaseClass{
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver,  this);
	}
	
	
	@FindBy(xpath="//p/strong [text()='Your order on My Store is complete.']")
	private WebElement confirmMessage;

	
	
	public WebElement validateConfirmMessage() {
		return confirmMessage;
	}
}
