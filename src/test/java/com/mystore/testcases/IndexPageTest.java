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
import com.mystore.pageobjects.IndexPage;

/**
 * @author renu1
 *
 */
public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyLogo() {
		indexPage = new IndexPage();
		WebElement eleLogo = indexPage.validateLogo();
		Assert.assertTrue(eleLogo.isDisplayed());
		
	}
	
	@Test
	public void verifyTitle() {
		
		String  actTitle = indexPage.getMyStoreTitle();
		Assert.assertEquals("My Store", actTitle);
		
		
	}
}
