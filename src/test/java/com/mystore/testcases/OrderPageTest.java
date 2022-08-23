/**
 * 
 */
package com.mystore.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

import org.junit.Assert;

/**
 * @author renu1
 *
 */
public class OrderPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyTotalPrice() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Duration duration = Duration.ofSeconds(30);
		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("quantity_wanted")));
		addToCartPage.enterQuantity("2");	
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("quantity_wanted")));
	
		addToCartPage.selectSize("2");
		addToCartPage.addToCart();
		orderPage = addToCartPage.clickOnCheckOut();
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice*2) + 2;
		Assert.assertEquals(totalExpectedPrice, totalPrice);
		
	}
}
