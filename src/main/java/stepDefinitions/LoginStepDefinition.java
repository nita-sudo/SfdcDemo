package stepDefinitions;


import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Baseclass.Testbase;
import context.TestContextUI;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;



public class LoginStepDefinition  {

	 WebDriver driver;


	public LoginStepDefinition(SharedClass obj) {
		driver = obj.chromeSetup();
	}



	


//dependancy injection using pico container so that we can share objects in multiple stepdefinitions file without making it static
//	public LoginStepDefinition(TestContextUI testContextUI) {
//		this.testContextUI=testContextUI;
//	}



	
	 LoginPage loginpage = new LoginPage();
	 
	  Logger logger;
	
	 
	  
	 @Given("^user is on the login page$")
		public void user_login_page()
		{
		  logger=Testbase.setProperty();
		 
		  Testbase.launchBrowser(driver);
		 
		  logger.info("browser is launched");
		   
		}
	
	
	 @When("^user enters username and password$")
	 public void user_enters_username_and_password(){
		
		 Testbase.enterText(loginpage.username, Testbase.username ,driver);
		 logger.info("username is entered");
		 Testbase.enterText(loginpage.password, Testbase.password,driver);
		 logger.info("password is entered");
		 
	 }
	
	 @When("^user clicks on login button$")
	 public void user_clicks_on_login_button() {
		
		 Testbase.click(loginpage.loginButton,driver);
		 logger.info("login  button is clicked");
	  }
	
	 @Then("^page title should be \"([^\"]*)\"$")
		public void page_title_should_be(String ltitle)  {
		
		 Testbase.checkForElementVisibility(loginpage.createMenu,driver);
		String title = driver.getTitle();
		Assert.assertEquals(title, ltitle);
		 logger.info("verified the title of homepage");
		}
	
	
	 
	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.close();
		 driver=null;
		 logger.info("browser is closed");
	 }
	
	
	

}
