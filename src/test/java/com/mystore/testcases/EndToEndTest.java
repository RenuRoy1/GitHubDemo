/**
 * 
 */
package com.mystore.testcases;

import java.time.Duration;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author renu1
 *
 */
public class EndToEndTest extends BaseClass{
	
		IndexPage indexPage;
		SearchResultPage searchResultPage;
		AddToCartPage addToCartPage;
		OrderPage orderPage;
		LoginPage loginPage;
		AddressPage addressPage;
		ShippingPage shippingPage;
		PaymentPage paymentPage;
		OrderSummaryPage orderSummaryPage;
		OrderConfirmationPage orderConfirmationPage;
		
		@Parameters("browsername")// imstead of geeting it from properties file. we can pass it through testng.xml file
		@BeforeMethod(groups= {"smoke","sanity","regression"})
		public void setup(String browsername) {
			initialization(browsername);
			
		}

		@AfterMethod(groups= {"smoke","sanity","regression"})
		public void tearDown() {
			driver.quit();
		}
		
		
		@Test(groups="regression")
		public void endToendTest() {
			
			indexPage= new IndexPage();
			searchResultPage = indexPage.searchProduct("t-shirt");
			addToCartPage = searchResultPage.clickOnProduct();
			//Duration duration = Duration.ofSeconds(30);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("quantity_wanted")));
			addToCartPage.enterQuantity("2");	
		    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("quantity_wanted")));
		
			addToCartPage.selectSize("2");
			addToCartPage.addToCart();
			orderPage = addToCartPage.clickOnCheckOut();
			loginPage = orderPage.clickOnProceedToCheckOut();
			addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("Password"));
			shippingPage= addressPage.clickonCheckOut();
			shippingPage.clickOnCheck();
			paymentPage = shippingPage.clickOnProceedToCheckOut();
			orderSummaryPage = paymentPage.clickOnMethod();
			orderConfirmationPage = orderSummaryPage.clickOnConfirmOrderBtn();
			WebElement ele = orderConfirmationPage.validateConfirmMessage();
			String S = ele.getText();
			String act= "Your order on My Store is complete.";
			Assert.assertEquals(S, act);
			
		}

}
