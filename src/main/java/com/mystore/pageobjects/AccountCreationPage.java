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
public class AccountCreationPage extends BaseClass {
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[text()='Create an account']")
	private WebElement formTitle;
	
	
	public WebElement validateFormTitle() {
		return formTitle;
	}

}
