package pages;

import java.util.List;
import Utils.VerifyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class CreateOrder extends BasePage{

	public CreateOrder(){
		PageFactory.initElements(driver, this);
        
	}
	
	@FindBy(how= How.XPATH,using="html/body/div[2]/div[1]/ul/li[3]/a")
     public WebElement orderManage;
    
	@FindBy(how= How.XPATH,using="html/body/div[2]/div[1]/ul/li[3]/ul/li[1]/a")
	 public WebElement createFabricOrder;
	 
	@FindBy(how = How.NAME,using="supplier")
	public WebElement supplier;
	
	@FindBy(how = How.NAME,using="quality")
	public WebElement quality;
	
	@FindBy(how = How.NAME,using="buyer")
	public WebElement buyer;
	
	@FindBy(how = How.XPATH,using="//input[@name='custref']")
	public WebElement custref;
	
	@FindBy(how = How.XPATH,using="html/body/div[2]/div[2]/div/form/div[2]/div[2]/div/div[2]/div[2]/div/input")
	public WebElement orderdate;

	@FindBy(how = How.XPATH,using="html/body/div[3]/div[1]/div[2]/table/tbody/tr[2]/td[2]")
	public WebElement selectdate;

	@FindBy(how = How.XPATH,using="//input[@name='styleref']")
	public WebElement styleref;
	
	@FindBy(how = How.XPATH,using="//select[@id='season']")
	public WebElement season;
	
	@FindBy(how = How.CSS,using=".btn.btn-success")
	public WebElement proceed;    //proceed to next step->Step 2 page
	
	@FindBy(how = How.ID,using="color")
	public WebElement color;
	
	@FindBy(how = How.CSS,using="#comments")
	public WebElement comments;
	
	@FindBy(how = How.CSS,using="#quantity")
	public WebElement quantity;
	
	@FindBy(how = How.CSS,using="#units")
	public WebElement units;
	
	@FindBy(how = How.CSS,using="#uprice")
	public WebElement unitprice;
	
	@FindBy(how = How.CSS,using="#currency")
	public WebElement currency;
	
	@FindBy(how = How.CSS,using="#shipping")
	public WebElement shippingmode;
	
	@FindBy(how = How.CSS,using="#pterms")
	public WebElement paymentterms;
	
	@FindBy(how = How.XPATH,using="//select[@name='dmode']")
	public WebElement deliverymode;
	
	@FindBy(how = How.XPATH,using="//input[@id='deldate']")
	public WebElement deliverydate;
	
	@FindBy(how = How.XPATH,using="html/body/div[3]/div[1]/div[2]/table/tbody/tr[2]/td[4]/div")
	public WebElement selectdeldate;
	
	@FindBy(how = How.XPATH,using="//select[@name='daddress']")
	public WebElement deliveryaddress;
	
	@FindBy(how = How.XPATH,using="//select[@id='group']")
	public WebElement selectgroup;
	
	@FindBy(how = How.XPATH,using="//select[@id='careword']")
	public WebElement carewordings;
	
	@FindBy(how = How.CSS,using=".overSelect")
	public WebElement caresymbol;
	
	@FindBy(how = How.CSS,using="#terms")
	public List<WebElement> checkcaresymbol;
	
	
	@FindBy(how = How.CSS,using=".overSelect")
	public WebElement terms;
	
	@FindBy(how = How.CSS,using="#terms")
	public List<WebElement> selterms;
	
	@FindBy(how = How.CSS,using=".btn.btn-default")
	public WebElement ok;
	
	@FindBy(how = How.XPATH,using="html/body/div[2]/div[1]/div/div/div[1]/font")
	public WebElement actualmessage;
    
	@FindBy(how = How.XPATH,using="html/body/div[2]/div[1]/ul/li[1]/a")
	public WebElement dashboard;
	
	@FindBy(how = How.XPATH,using="html/body/div[2]/div[2]/div/div/div[1]/div/div[2]/div/a[1]")
	public WebElement verifydashboard;
	
	public void orderPage() throws InterruptedException{
	orderManage.click();
	Thread.sleep(5000);
	createFabricOrder.click();
	Thread.sleep(3000);
	}
	//Entering Valid input to create new order
	public void newOrder() throws InterruptedException{
		
	new Select(supplier).selectByIndex(4);
	Thread.sleep(5000);
	new Select(quality).selectByIndex(1);
	Thread.sleep(2000);
	new Select(buyer).selectByIndex(1);
	Thread.sleep(2000);
	custref.sendKeys("23456");
	Thread.sleep(2000);
	orderdate.click();
	Thread.sleep(1000);
	selectdate.click();
	Thread.sleep(1000);
	styleref.sendKeys("34567");
	Thread.sleep(1000);
	new Select(season).selectByVisibleText("Summer");
	Thread.sleep(1000);
	proceed.click();
	Thread.sleep(5000);
	new Select(color).selectByIndex(1);
	Thread.sleep(1000);
	comments.sendKeys("TestAutomation");
	Thread.sleep(1000);
	quantity.sendKeys("100");
	Thread.sleep(1000);
	new Select(units).selectByIndex(1);
	Thread.sleep(1000);
	unitprice.sendKeys("100");
	Thread.sleep(1000);
	new Select(currency).selectByIndex(1);
	Thread.sleep(1000);
	new Select(shippingmode).selectByIndex(1);
	Thread.sleep(1000);
	new Select(paymentterms).selectByIndex(1);
	Thread.sleep(1000);
	new Select(deliverymode).selectByIndex(1);
	Thread.sleep(1000);
	deliverydate.click();
	Thread.sleep(1000);
	selectdeldate.click();
	Thread.sleep(1000);
	new Select(deliveryaddress).selectByIndex(1);
	Thread.sleep(1000);
	new Select(selectgroup).selectByIndex(1);
	Thread.sleep(1000);
	new Select(carewordings).selectByIndex(1);
	Thread.sleep(1000);
	caresymbol.click();
	Thread.sleep(2000);
	checkcaresymbol.get(2).click();
	Thread.sleep(1000);
	caresymbol.click();
	Thread.sleep(2000);
	proceed.click();
	Thread.sleep(2000);
	terms.click();
	Thread.sleep(2000);
	selterms.get(0).click();
	Thread.sleep(2000);
	terms.click();
}
	//Submit the order
	public void submitOrder() throws InterruptedException
	{
	proceed.click();
	Thread.sleep(5000);
	}
	
	//Verifying whether order is created or not
	public void orderCreated() throws InterruptedException
	{
	String expectedresult="Order created successfully.";
	String actualresult;		
	actualresult=actualmessage.getText();
	System.out.println("ActRes :" +actualresult);
    VerifyUtils.equals(expectedresult, actualresult);    
	ok.click();
	Thread.sleep(2000);
	}
	
	//verify the order is present in dashboard
	public void verifydashboard() throws InterruptedException
	{
	 dashboard.click();
	 boolean displayorder= verifydashboard.isDisplayed();
	 VerifyUtils.True(displayorder);
	}
}
