/**
 * 
 */
package com.mystore.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author renu1
 *
 */
public class AccountCreationPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	@Test
	public void validateCreateAcoountCreationPage() {
		indexPage= new IndexPage();
		loginPage = indexPage.clickOnSignIn();		
		accountCreationPage = loginPage.createNewAccount(prop.getProperty("username1"));
		WebElement formTitle = accountCreationPage.validateFormTitle();
		String acttitle = formTitle.getText();
		String ExpTitle="CREATE AN ACCOUNT";
		Assert.assertEquals(ExpTitle, acttitle);
	}

	
	
	
}
