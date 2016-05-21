package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;


	public class LoginPage extends BasePage {
		
		
		
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		
			
		}
		
		@FindBy(how= How.ID,using="username")
		public WebElement userName;
		
		@FindBy(how= How.ID,using="password")
		public WebElement passWord;
		

		@FindBy(how= How.XPATH,using="//*[@id='log']/button")
		public WebElement submitButton;
		
		@FindBy(how = How.XPATH,using="//a[@id='drop2']")
		public WebElement loginuser;
		
		@FindBy(how = How.XPATH,using="//a[contains(.,'Logout')]")
		public WebElement logout;
		
		public void login(String UserName,String PassWord) throws InterruptedException
		{
		
	        userName.sendKeys(UserName);
	        passWord.sendKeys(PassWord);
	        Thread.sleep(5000);
	        submitButton.click();
			
		}
		
		
		 public boolean logoutcheck() throws InterruptedException
		 {
			 	
			 if(loginuser.isEnabled())
			 {
				 loginuser.click();
				 Thread.sleep(2000);
				 logout.click();
				 Thread.sleep(5000);
			
			 }
			return false;
		    
		}
		
		
		

}
