package Baseclass;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import commonUtilities.ReadConfig;
import context.TestContextUI;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import stepDefinitions.SharedClass;

public class Testbase  {
	
	
	

	static ReadConfig readprop = new ReadConfig() ;
	
	public  static String username =readprop.getUsername();
	public static String password =readprop.getPassword();
	public static  String baseurl =readprop.getURL();
	public static String browser =readprop.getBrowser();
	public static Logger logger;
	public static Logger setProperty()
	{
		logger =Logger.getLogger("SFDC");
		 PropertyConfigurator.configure("Log4j.properties");
		return logger;
	}

	   
	  
	   public static  void launchBrowser(WebDriver driver)
		{
			
		   driver.get(baseurl);
		   driver.manage().window().maximize();
		   
		  
		        
		}
	
	
//	protected WebDriver getDriver()
//		{
//			return driver = BrowserUtility.OpenBrowser(driver, browser, baseurl);
//		}
//	   public void launchBrowser()
//	   {
//		   
//		    driver.get(baseurl);
//	   }
    
	
	
	
//	public  void handleWindowPopup()
//	{
//		
//		
//		Set<String> windowhandles =driver.getWindowHandles();
//		
//		Iterator<String> it =windowhandles.iterator();
//		String parentId = it.next();
//		System.out.println("parentId :"+parentId);
//		String childId = it.next();
//		System.out.println("childId :"+childId);
//		driver.switchTo().window(childId);
//		System.out.println("switched to child window popup");
//		System.out.println("Child window popup title :"+driver.getTitle());
//		driver.close();
//		driver.switchTo().window(parentId);
//		System.out.println("switched to parent window popup");
//		System.out.println("parent window  title :"+driver.getTitle());
//		
//	}
	
	
		public static void enterText(By locator, String value , WebDriver driver) 
		{ 
			checkForElementVisibility(locator,driver);
			driver.findElement(locator).sendKeys(value);
			
		
	    }
	
		public static Boolean checkForElementVisibility(By locator ,WebDriver driver)
		{
			
			 WebDriverWait wait =new WebDriverWait(driver, 30);
			  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				return true;
			
		}
		
		
		public static Boolean checkForElementClickability(By locator,WebDriver driver)
		{
            
			 WebDriverWait wait =new WebDriverWait(driver, 20);
			 wait.until(ExpectedConditions.elementToBeClickable(locator));
			 return true;
			
		}
		
		public static void click(By locator ,WebDriver driver) 
		{
			
			checkForElementClickability(locator,driver);
			driver.findElement(locator).click();
			
			
		}
		
		 public static void clickElementByJS(By locator,WebDriver driver){
			 checkForElementClickability(locator,driver);
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	js.executeScript("arguments[0].click();", driver.findElement(locator));
		    	
		    }
		 
		 public static void selectFromDropDown( By locator , String value,WebDriver driver) throws TimeoutException {
				Select select = new Select(driver.findElement(locator));
				select.selectByVisibleText(value);
				//logger.info("Selected:" + value + " from drop-down");
			}
		

}
