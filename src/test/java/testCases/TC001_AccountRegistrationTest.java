package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistratonPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	
	{
		logger.info("************Starting TC001_AccountRegistrationTest***************************");
		
		try 
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistratonPage  regpage = new AccountRegistratonPage(driver);
		
		logger.info("Providing Customers details....");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString() + "@gmail.com"); // randomly generated email 
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphaNumberic();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validation expected message....");
		String confmsg = regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
			
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
		
			Assert.fail();
		}
		logger.info("************Finished TC001_AccountRegistrationTest***************************");
			
	}		
}
