package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utils.VerifyUtils;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateQuality extends BasePage{

	public CreateQuality(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using="html/body/div[2]/div[1]/ul/li[4]/a")
	public WebElement qualitymanagement;
	
	@FindBy(how = How.XPATH,using="html/body/div[2]/div[1]/ul/li[4]/ul/li[2]/a")
	public WebElement newquality;
	
	@FindBy(how = How.CSS,using="#supplier")
	public WebElement selsupplier;
	
	@FindBy(how = How.CSS,using="#qrc")
	public WebElement qualityref;
	
	@FindBy(how = How.CSS,using="#weight")
	public WebElement weight;
	
	@FindBy(how = How.CSS,using="#construction")
	public WebElement construction;
	
	@FindBy(how = How.CSS,using="#width")
	public WebElement width;
	
	@FindBy(how = How.CSS,using="#fabric_type")
	public WebElement fabrictype;
	
	@FindBy(how = How.CSS,using="#Cloth_Type")
	public WebElement clothtype;
	
	@FindBy(how = How.CSS,using="#Percentage")
	public WebElement percentage;
	
	@FindBy(how = How.CSS,using="#getpercentage")
	public WebElement getpercentage;
	
	@FindBy(how = How.CSS,using="#submit")
	public WebElement addquality;
	
	@FindBy(how = How.XPATH,using="html/body/div[2]/div[1]/ul/li[4]/ul/li[1]/a")
	public WebElement qualitylibrary;
	
	@FindBy(how = How.XPATH,using="//th[contains(.,'Last Updated')]")
	public WebElement lastupdated;
	
	@FindBy(how = How.XPATH,using="html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div/table/tbody")
	public List<WebElement> selectquality; 
	
	public void qualityPage() throws InterruptedException
	{
		qualitymanagement.click();
		Thread.sleep(5000);
		newquality.click();
		Thread.sleep(5000);
	}
	public void createQuality() throws InterruptedException
	{
		new Select(selsupplier).selectByIndex(1);
		Thread.sleep(2000);
		qualityref.sendKeys("AnaCotton");
		Thread.sleep(2000);
		weight.sendKeys("300");
		Thread.sleep(2000);
		construction.sendKeys("100");
		Thread.sleep(2000);
		width.sendKeys("30");
		Thread.sleep(2000);
		new Select(fabrictype).selectByIndex(1);
		Thread.sleep(5000);
		new Select(clothtype).selectByIndex(1);
		Thread.sleep(2000);
		percentage.sendKeys("100");
		Thread.sleep(2000);
		getpercentage.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
        alert.accept();
		Thread.sleep(2000);

	}
	public void submitQuality() throws InterruptedException
	{
        addquality.click();
        Thread.sleep(5000);
        
	}	
	public void verifyQualityLibrary() throws InterruptedException
	{
		String expectedres = "AnaCotton Fabman 300 Cotton 30 100% - Cotton";
		qualitymanagement.click();
		Thread.sleep(2000);
		qualitylibrary.click();
		Thread.sleep(2000);
		lastupdated.click();
		Thread.sleep(2000);
		lastupdated.click();
		Thread.sleep(2000);
		String selectquality1 = selectquality.iterator().next().getText();
		System.out.println("Get the text of newlycreated quality" +selectquality1);
		VerifyUtils.contains(expectedres, selectquality1);
		Thread.sleep(2000);
	}
	
}

