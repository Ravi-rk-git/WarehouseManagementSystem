package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.SetupPage;
import testBase.BaseClass;

public class TC001_LoginTest extends BaseClass{
	
	
	@Test(groups= {"Master_UI_PacksFlow", "Regression_FileUpload_CSV","Smoke_ExceptionPacks"})
	public void verify_TC001_LoginTest()
	{
		logger.info("********** Starting TC001_LoginPage Test **********");	
		
		try
		{			
		//Login Page
		LoginPage lgnpage=new LoginPage(driver);
		lgnpage.setLoginName(p.getProperty("LoginName"));
		logger.info("********** UserName is Entered **********");	
		lgnpage.setPassword(p.getProperty("Password"));
		logger.info("********** Password Entered **********");	
		lgnpage.clickLogin();
		logger.info("********** Successfully Clicked On Login Button **********");	
		
		//Setup Page
		SetupPage sepage=new SetupPage(driver);
		boolean targetPage = sepage.isSetupPageExist();
		
		//Assert.assertEquals(targetPage, true, "Login Failed");
		logger.info("********** Validating Expected Message.. **********");	
		Assert.assertTrue(targetPage); //Assert.assertEquals(targetPage, true, "Login Failed");
		System.out.println("*************** Login Test Passed ****************");
		}
		catch(Exception e)
		{			
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			Assert.fail();		
		}	
		
		logger.info("*************** Finished TC001_LoginTest ***************");
		
	}
}
