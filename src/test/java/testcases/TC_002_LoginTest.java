package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.OpenCartLoginPage;
import pageobjects.OpenHomePage;
import pageobjects.OpenMyAccPage;
import testbase.OpenCartBaseClass;

public class TC_002_LoginTest extends OpenCartBaseClass{
	
	
	
	
	@Test(groups= {"Sanity","Master"})
	public void test_login() {
		try {
		logger.info("**** Starting TC_002_LoginTest ****");
		OpenHomePage ohp=new OpenHomePage(driver);
		ohp.myaccount();
		ohp.logacc();
		
		OpenCartLoginPage olp=new OpenCartLoginPage(driver);
		olp.setEmail(rb.getString("mymail"));
		olp.setpassword(rb.getString("pword"));
		olp.loginlinkclick();
		
		
		OpenMyAccPage ap=new OpenMyAccPage(driver);
		boolean targetPage=ap.ismypaex();
		
		Assert.assertEquals(targetPage,true);
		}
		catch(Exception e){
			Assert.fail();
			
		}
		logger.info("**** Finished TC_002_LoginTest ****");
	}

}
