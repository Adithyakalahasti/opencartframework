package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenCartLoginPage extends BasePage{

	public OpenCartLoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='input-email']")WebElement mailadd;
	@FindBy(xpath="//input[@id='input-password']")WebElement pass;
	@FindBy(xpath="//button[normalize-space()='Login']")WebElement lb;
	
	public void setEmail(String email) {
		mailadd.sendKeys(email);
	}
	
	public void setpassword(String pwd) {
		pass.sendKeys(pwd);
	}
	public void loginlinkclick() {
		lb.click();
	}

		
	}

	


