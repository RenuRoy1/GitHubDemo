package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{  // without extend baseclass we cannot use driver in page factory

	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//a[@class='login']")
	private WebElement signInBtn;
	

	@FindBy(xpath="//img[@class='img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	
	public LoginPage clickOnSignIn() {
	signInBtn.click();	  // after signin it goes to Login page  we need to link that page with index page..so create login page first	
	return new LoginPage();
	}
	
	
	public WebElement validateLogo() {
		return myStoreLogo;
	}
	
	
	public String getMyStoreTitle() {
		String myStoreTitle = driver.getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		searchProductBox.sendKeys(productName);
		searchButton.click();
		Duration duration = Duration.ofSeconds(20);
		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[text()='Top sellers']")));
		return new SearchResultPage();
	}
	
	
	
}
