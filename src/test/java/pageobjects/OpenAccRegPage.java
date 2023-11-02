package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccRegPage extends BasePage{

	public OpenAccRegPage(WebDriver driver) {
		super(driver);
	}
	//Elements
		@FindBy(name="firstname")WebElement firstname;
		@FindBy(name="firstname")WebElement lastname;
		@FindBy(name="email")WebElement email;
		@FindBy(name="password")WebElement password;

		@FindBy(name="agree")WebElement policy;
		@FindBy(xpath="//button[normalize-space()='Continue']")WebElement continuebtn;
		@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement accregcmpltd;
		
		//Action Methods
		public void setfirstname(String fname) {
			firstname.sendKeys(fname);
		}
		
		public void setlastname(String lname) {
			lastname.sendKeys(lname);
		}
		
		public void setemail(String mail) {
			email.sendKeys(mail);
		}
		
		public void setpassword(String pword) {
			password.sendKeys(pword);
		}
		
		public void accpolicy() {
			policy.click();
		}
		
		public void clickcontinue() {
			continuebtn.click();
		}
		
		public String confirmation() {
			try {
				return accregcmpltd.getText();
				
				
			}
			catch(Exception e) {
				return e.getMessage();
				
			}
			
		}

}
