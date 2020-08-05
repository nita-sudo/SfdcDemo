package stepDefinitions;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import context.TestContextUI;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SharedClass 
{
	WebDriver driver;
	
	 @Before("@chrome")
	    public WebDriver chromeSetup()
	    {
	        if(driver==null)
	        {
	        	
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");       
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(options);
					//driver.get(url);
					
					
				
			    
	        }
			return driver;
	    }
	
}	
	
	
//	public static WebDriver OpenBrowser(WebDriver driver,String browserName,String url) 
//	{
//		if(driver==null)
//		
//		{	if(browserName.equals("Chrome"))
//			{
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--disable-notifications");       
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver(options);
//				//driver.get(url);
//				
//				return driver;	
//			
//		    }	else if(browserName.equals("IE"))
//		       {
////			InternetExplorerOptions options = new InternetExplorerOptions();
////			options.addArguments("--disable-notifications");       
////			WebDriverManager.iedriver().setup();
////			driver = new InternetExplorerDriver(options);
////			driver.get(url);
////			return driver;	
//				
//		     } else 
//		      if(browserName.equals("Firefox"))
//		      {FirefoxOptions options = new FirefoxOptions();
//		      options.addArguments("--disable-notifications");       
//		      WebDriverManager.firefoxdriver().setup();
//		      driver = new FirefoxDriver(options);
//		      driver.get(url);
//		      return driver;
//		      }
//		}
//		return driver;			
//	}
//
//}
