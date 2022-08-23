/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

/**
 * @author renu1
 *
 */
public class SearchResultPage extends BaseClass{
	
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	

	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	
	public WebElement isProductAvailable() {
		return productResult;
		
	}
	
	
	public AddToCartPage clickOnProduct() {
//		Duration duration = Duration.ofSeconds(20);
//		wait = new WebDriverWait(driver, duration);
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Top sellers']")));
		productResult.click();
		return new AddToCartPage();
	}
	

}
