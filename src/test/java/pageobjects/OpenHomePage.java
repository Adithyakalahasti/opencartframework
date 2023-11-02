package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenHomePage extends BasePage{

	public OpenHomePage(WebDriver driver) {
		super(driver);
	}
	//Elements
		@FindBy(xpath="//span[normalize-space()='My Account']")WebElement myacc;
		@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Register']")WebElement regacc;
		@FindBy(linkText="Login")WebElement logintoacc;
		//ActionMethods
		public void myaccount() {
			myacc.click();
		}
		
		public void register() {
			regacc.click();
		}
		public void logacc() {
			logintoacc.click();	
			}

}
