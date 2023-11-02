package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenMyAccPage extends BasePage{

	public OpenMyAccPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']")WebElement myAccAppearMsg;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")WebElement logoutbtn;
    public boolean ismypaex() {
		try {
			return(myAccAppearMsg.isDisplayed());
		}
		catch(Exception e) {
			return(false);
		}
    	
    }
    public void logoutclick() {
    	logoutbtn.click();
    }
		
		
	}

	


