/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

/**
 * @author renu1
 *
 */
public class AddToCartPage extends BaseClass{
	

	
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="quantity_wanted")
	private WebElement quantityBox;
	
	@FindBy(id="group_1")
	private WebElement sizeDropDown;

	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/i")
	private WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckoutBtn;
	
	
	
	public void enterQuantity(String quantity1) {
		quantityBox.clear();
		quantityBox.sendKeys(quantity1);
		
	}
	public void selectSize(String size1) {
		Select s = new Select(sizeDropDown);
		s.selectByValue(size1);
		
	}
	
	public void addToCart() {
		addToCartBtn.click();
		
	}
	
	
	public WebElement validateAddTocart() {
	
		//Duration duration = ;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2/i")));
		
		//expWait("//*[@id=\\\"layer_cart\\\"]//h2/i");
		
		return addToCartMessage;
		
		 
	}
	
	public OrderPage clickOnCheckOut()  {		
		proceedToCheckoutBtn.click();
		return new OrderPage();
		
		 
	}

}
