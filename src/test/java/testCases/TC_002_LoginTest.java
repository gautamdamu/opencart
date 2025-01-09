package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("***Starting TC002_LoginTest***");
		try {
		//Home Page
		HomePage hp = new HomePage(driver);
		    hp.clickMyAccount();
		    hp.clickLogin();
		  
		//Login    
		LoginPage lp = new LoginPage(driver);
		   lp.setEmail(p.getProperty("email"));
		   lp.setPassword(p.getProperty("password"));
		   lp.clickLogin();
		   
		//My Account
		MyAccountPage macc = new MyAccountPage(driver);
		boolean    targetPage = macc.isMyAccountPageExists();
	  //  Assert.assertEquals(targetPage, true, "Login failed");
		  Assert.assertTrue(targetPage);
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("***Finsished TC002_LoginTest*****");
	  
	   

}
}
