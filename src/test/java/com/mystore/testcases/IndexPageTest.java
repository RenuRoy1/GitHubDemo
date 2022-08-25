/**
 * 
 */
package com.mystore.testcases;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

/**
 * @author renu1
 *
 */
public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage;
	
//	@BeforeMethod
//	public void setup() {
//		initialization();
//		
//	}

	

	@Parameters("browsername")// imstead of geeting it from properties file. we can pass it through testng.xml file	
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browsername) {
		initialization(browsername);
		
	}

	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(groups="smoke")
	public void verifyLogo() {
		indexPage = new IndexPage();
		WebElement eleLogo = indexPage.validateLogo();
		Assert.assertTrue(eleLogo.isDisplayed());
		
	}
	
	@Test(groups="smoke")
	public void verifyTitle() {
		
		String  actTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals("My Store1", actTitle);
		
		
	}
}
