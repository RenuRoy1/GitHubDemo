package com.mystore.actiondriver;

import org.openqa.selenium.WebDriver;

// all the common operations required for the classes for ex..is diaplayed..click, sendkeys are stored in actions class
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mystore.base.BaseClass;

public class Action extends BaseClass {
	
	
	public static void click(WebDriver driver, WebElement ele) {
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		
	}

	public static boolean findElement(WebDriver driver, WebElement ele) throws Exception{
		
		boolean flag = false;
		
		try {
		flag =ele.isDisplayed();
		
		}
		catch(Exception e) {
			System.out.println("element not displayed : " +ele);
			flag= false;
		}
		
		finally {
			if(flag) {
				System.out.println("Succesfully found element");
			}
			else {
				System.out.println("unable to locate element");
			}
		}
		return flag;
	}
}
