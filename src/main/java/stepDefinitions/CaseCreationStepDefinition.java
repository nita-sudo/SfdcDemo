package stepDefinitions;




import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Baseclass.Testbase;
import context.TestContextUI;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CaseCreationPage;

public class CaseCreationStepDefinition {
	WebDriver driver;
	
	public CaseCreationStepDefinition(SharedClass obj) {
		
		driver = obj.chromeSetup();
	}

	
	 


	CaseCreationPage casePage = new CaseCreationPage();
	Logger logger;
	
	@When("^user selects \"([^\"]*)\" from app launcher$")
	public void user_selects_from_app_launcher(String value) {
		logger=Testbase.setProperty();
		Testbase.click(casePage.appLauncher,driver);
		//clickElementByJS(casePage.appLauncher);
		logger.info("app launcher is clicked");
		Testbase.enterText(casePage.searchBar, value,driver);
		logger.info("entered value "+value);
		Testbase.click(casePage.serviceConsole,driver);
		logger.info("service console is selected");
	    
	}

	@When("^user clicks on new case create button$")
	public void user_clicks_on_new_case_create_button() {
	   
		Testbase.click(casePage.casesTab,driver);
		logger.info("cases tab clicked");
		Testbase.click(casePage.newButton,driver);
		logger.info("new button clicked");
		
	    
	}

	@When("^user enters all the mandatory fields$")
	public void user_enters_all_the_mandatory_fields() {
		
		Testbase.click(casePage.selectDropdown("Case Origin"),driver);
		Testbase.click(casePage.selectDroptdownValue("Phone"),driver);
		logger.info("selected Case Origin");
		Testbase.click(casePage.selectDropdown("Type"),driver);
		Testbase.click(casePage.selectDroptdownValue("Structural"),driver);
		logger.info("selected Type");
		Testbase.click(casePage.selectDropdown("Case Reason"),driver);
		Testbase.click(casePage.selectDroptdownValue("Performance"),driver);
		logger.info("selected Case Reason");
		Testbase.click(casePage.selectDropdown("Product"),driver);
		Testbase.click(casePage.selectDroptdownValue("GC1060"),driver);
		logger.info("selected Product");
		Testbase.enterText(casePage.selectfieldValue("Subject"), "Laptop software issue",driver);
		logger.info("enetered subject");
		Testbase.enterText(casePage.description, "some softwares are not working",driver);
		logger.info("enetered description");
		
	   
	    
	}

	@When("^user clicks on save button$")
	public void user_clicks_on_save_button() {
	   
		Testbase.click(casePage.saveButton,driver);
	    logger.info("Saved");
	       
	    
	}

	@Then("^new case should be created$")
	public void new_case_should_be_created() {
		Testbase.checkForElementVisibility(casePage.CaseCreationMessage,driver);
		
		String actualMessage=driver.findElement(casePage.CaseCreationMessage).getText();
		Assert.assertTrue(actualMessage.contains("was created"), "new case is not created");
		logger.info("verifies "+actualMessage);
		
		
	    
	}
	
	
	

}
