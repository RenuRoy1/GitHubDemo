/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

import org.junit.Assert;

/**
 * @author renu1
 *
 */
public class LoginPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browsername")
	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void setup(String browsername) {
		initialization(browsername);
		
	}

	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(groups={"smoke","sanity"} )
	public void loginTest() {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to clickon Signin");
		loginPage = indexPage.clickOnSignIn();  // Page chaining method-- each page is related to another page ie the landing page
		Log.info("Enter Username and password");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("Password"));
		String actURL = homePage.getCurrURL();
		String expURL= "http://automationpractice.com/index.php?controller=my-account";
		System.out.println(actURL);
		System.out.println(expURL);
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(expURL, actURL);
		Log.info("Login is Success!!!");
		Log.endTestCase("loginTest");
		
		
	}

}
