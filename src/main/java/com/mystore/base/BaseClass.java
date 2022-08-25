package com.mystore.base;

import java.io.File;
import java.io.FileInputStream;

//https://www.youtube.com/watch?v=PcWBIYfwMWY&list=PLsGOlyTzNH6dQREgTsqPy6C79wWyouEcu&index=7 

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	//public static Duration duration = Duration.ofSeconds(20);
	
	
	@BeforeSuite(groups= {"smoke","sanity","regression"})
	public void beforeSuite() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml"); // this is reading .xml file  and understands how logging works for this project
		
		
		
		
		try {
			prop = new Properties();
					FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties" );
					prop.load(fis);
					System.out.println("Driver : " + driver);
					
				}
				catch (FileNotFoundException e) {
					
					e.printStackTrace();
				} 
				catch (IOException e) {
					
					e.printStackTrace();
				}
		
	}
	
	@AfterSuite(groups= {"smoke","sanity","regression"})
	public void afterSuite() {
		ExtentManager.endReport();
		
	}
//	
//	@BeforeTest(groups= {"smoke","sanity","regression"})
//	public  void loadConfig() {
//		
//		
//		try {
//	prop = new Properties();
//			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties" );
//			prop.load(fis);
//			System.out.println("Driver : " + driver);
//			
//		}
//		catch (FileNotFoundException e) {
//			
//			e.printStackTrace();
//		} 
//		catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		
//		
//				
//	}
//	
	public static void initialization(String browserName) {
		
		//wait = new WebDriverWait(driver, Duration.ofSeconds(120,1));
		//WebDriverManager.chromedriver().setup();
		//String browserName= prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
		
		if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // other method deprecated--newly introduced 
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		//return newImageString;
		return destination;
	}
 
//	public static void expWait(String s) {
//	   
//	   wait = new WebDriverWait(driver, duration);
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(s)));
//	   
//   }
//	


}
