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
public class LoginPage extends BaseClass {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement userName;
	

	@FindBy(id = "passwd")
	private WebElement password;
	
	@FindBy(id = "SubmitLogin")
	private WebElement signInBtn;

	@FindBy(id = "email_create")
	private WebElement emailForNewAccount;
	

	@FindBy(id = "SubmitCreate")
	private WebElement createNewAccountBtn;
	
	
	
	public HomePage login(String username, String Password) {
		userName.sendKeys(username);
		password.sendKeys(Password);
		signInBtn.click();
		return new HomePage();
		
	}
	
	public AddressPage login1(String username, String Password) {
		userName.sendKeys(username);
		password.sendKeys(Password);
		signInBtn.click();
		return new AddressPage();
		
	}
	
	
	public AccountCreationPage createNewAccount(String newEmail) {
		emailForNewAccount.sendKeys(newEmail);
		createNewAccountBtn.click();
		System.out.println("***************");
		return new AccountCreationPage();
		
	}
	
}
