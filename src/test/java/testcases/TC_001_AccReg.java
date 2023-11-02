package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageobjects.OpenAccRegPage;
import pageobjects.OpenHomePage;
import testbase.OpenCartBaseClass;

public class TC_001_AccReg extends OpenCartBaseClass{
	@Test(groups= {"Regression","Master"})
	public void test_account_registeration(){
		logger.debug("application logs.....");
		logger.info("*** starting TC_001_AccountRegisterationTest ***");
		
		try {
		OpenHomePage ohp=new OpenHomePage(driver);
		ohp.myaccount();
		logger.info("clicked on my account link");
		ohp.register();
		logger.info("clicked on register link");
		
		OpenAccRegPage ar=new OpenAccRegPage(driver);
		logger.info("providing details");
	
		ar.setfirstname(randomString());
		ar.setlastname(randomString());
		ar.setemail(randomString()+"@gmail.com");
		String pass=randomAlphaNumeric();
		ar.setpassword(pass);
		ar.accpolicy();
		ar.clickcontinue();
		logger.info("clicked on continue");
		String msg=ar.confirmation();
		Assert.assertEquals(msg,"Your Account Has Been Created!");
		
		
		}
		catch(Exception e) {
			logger.error("Test failed");
			
		}
		logger.info("*** Finished TC_001_AccountRegisterationTest ***");
		
		
	}

}
