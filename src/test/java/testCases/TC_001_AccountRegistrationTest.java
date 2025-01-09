package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("***Starting TC_001_AccountRegistrationTest***");
		try {
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		AccountRegistrationPage regpage =  new AccountRegistrationPage(driver);
		logger.info("Providind Customer details");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");//Randomly generated email
		regpage.setTelephone(randomNumber());
			
	   String  password=randomAlphaNeumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message");
		String confmsg =regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
	}catch(Exception e){
		logger.error("Test failed...");
		//logger.debug("Debug logs...");
		Assert.fail();
	}
		logger.info("***Finished TC_001_AccountRegistrationTest***");
		
	}
	
		
}
