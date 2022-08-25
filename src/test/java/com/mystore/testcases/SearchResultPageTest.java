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
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author renu1
 *
 */
public class SearchResultPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
	
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browsername) {
		initialization(browsername);
		
	}

	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(groups="sanity")
	public void productAvailabilityTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("tshirt");
		WebElement pdt= searchResultPage.isProductAvailable();
		Assert.assertTrue(pdt.isDisplayed());
	}

}
