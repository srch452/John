package features;

import org.openqa.selenium.*;

import pages.CreateOrder;
import pages.CreateQuality;
import pages.LoginPage;
import Utils.AutomationConstants;
import Utils.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateQualityStepDef {
	 public WebDriver driver;
	 LoginPage loginPage;
	 CreateQuality createquality;
     
	 @Before
	    public void start()
	    {
	        driver = BrowserFactory.getDriver();
	    }

	 @Given("^I am in Create Quality page$")
	 public void Create_Quality_page() throws Throwable {
		
		 loginPage = new LoginPage();
		 loginPage.logoutcheck();
		 loginPage.login(AutomationConstants.USERNAME,AutomationConstants.PASSWORD );
		 Thread.sleep(5000);
		 createquality = new CreateQuality();	 
		 createquality.qualityPage();
	 }

	 @When("^I enter the valid data$")
	 public void i_enter_the_valid_data() throws Throwable 
	 {
	     
	     createquality.createQuality();
	 }

	 @When("^I submit all the valid data$")
	 public void i_submit_all_the_valid_data() throws Throwable {
	     
	     createquality.submitQuality();
	 }

	 @Then("^quality should be created successfully in quality library$")
	 public void quality_should_be_created_successfully_in_quality_library() throws Throwable {
	     createquality.verifyQualityLibrary();	     
	 }
	 @After
	  
	    public void embedScreenshot(Scenario scenario) {

	        if (scenario.isFailed()) {
	            try {
	                scenario.write("Current Page URL is " + driver.getCurrentUrl());
//	            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
	                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	                scenario.embed(screenshot, "image/png");
	            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
	                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
	            }

	        }

	    }
}



