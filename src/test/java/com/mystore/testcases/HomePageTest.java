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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author renu1
 *
 */
public class HomePageTest extends BaseClass{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
		@Test(priority=1)
		public void wishListTest() {
			indexPage = new IndexPage();
			loginPage = indexPage.clickOnSignIn();
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("Password"));
			WebElement wishlist =homePage.validateWishlist();
			Assert.assertTrue(wishlist.isDisplayed());
			
			
		}
		
		@Test(priority=2)
		public void orderHistory() {
			indexPage = new IndexPage();
			loginPage = indexPage.clickOnSignIn();
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("Password"));
			WebElement orderHistory =homePage.validateOrderHistory();
			Assert.assertTrue(orderHistory.isDisplayed());
			
			
		}
	
}
