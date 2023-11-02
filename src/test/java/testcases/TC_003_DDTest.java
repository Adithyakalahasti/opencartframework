package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.OpenCartLoginPage;
import pageobjects.OpenHomePage;
import pageobjects.OpenMyAccPage;
import testbase.OpenCartBaseClass;
import utilities.DataProviders;

public class TC_003_DDTest extends OpenCartBaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email,String password,String result) {
		logger.info("**** Starting TC_003_DDTest ****");
		try {
		OpenHomePage ohp=new OpenHomePage(driver);
		ohp.myaccount();
		ohp.logacc();
		
		OpenCartLoginPage olp=new OpenCartLoginPage(driver);
		olp.setEmail(email);
		olp.setpassword(password);
		olp.loginlinkclick();
		
		OpenMyAccPage ap=new OpenMyAccPage(driver);
		boolean targetPage=ap.ismypaex();
		
		
		if(result.equals("Valid")) {
			if(targetPage==true) {
				ap.logoutclick();
				Assert.assertTrue(true);
			}
			
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(result.equals("Invalid")) {
			if(targetPage==true) {
				ap.logoutclick();
				Assert.assertTrue(false);
				
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
	
		logger.info("**** Finished TC_003_DDTest");
		
		
		
		

		
	}

}
