package features;

import org.openqa.selenium.*;

import pages.CreateOrder;
import pages.LoginPage;
import Utils.AutomationConstants;
import Utils.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class CreateOrderStepDef {
	
	  public WebDriver driver;
	  LoginPage loginPage;
	  CreateOrder createorder;
	 
		
	 
    @Before
    public void start()
    {
        driver = BrowserFactory.getDriver();
    }

@Given("^I am on create order page$")
public void createorderpage() throws Throwable 
	{
	loginPage = new LoginPage();
	//loginPage.logoutcheck();
	loginPage.login(AutomationConstants.USERNAME,AutomationConstants.PASSWORD );
	Thread.sleep(5000);
	createorder = new CreateOrder();
    createorder.orderPage();
      
	}

@When("^I provide all the required valid data$")
public void validdatainput() throws Throwable 
	{
 
	createorder.newOrder();
    
	}

@When("^I submit the order$")
public void ordersubmit() throws Throwable 
	{
	createorder.submitOrder();
	}

@Then("^order should be successfully created with a message$")
public void successorder() throws Throwable 
	{
    createorder.orderCreated();

	}

@Then("^order should appear in Dashboard$")
public void verifyorderDashboard() throws Throwable 
	{
	createorder.verifydashboard();
 
	}
    
    @After
  
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }

    }
}
