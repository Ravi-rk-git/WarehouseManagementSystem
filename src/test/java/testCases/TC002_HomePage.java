package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Receipts;
import testBase.BaseClass;

public class TC002_HomePage extends BaseClass{
	
	@Test(groups= {"Master_UI_PacksFlow","Smoke_ExceptionPacks"})
	public void verify_TC002_HomePage() throws InterruptedException
	{
	
	try
	{		
	
	logger.info("********** Starting TC002 HomePage Test **********");
				
	//Home Page
	HomePage hmpage=new HomePage(driver);
	hmpage.setPrimaryCompany("DJT Retailers");
	hmpage.clickReceipts1();
	hmpage.clickReceipts2();
	
	//Receipts
	Receipts rcpt=new Receipts(driver);
	boolean targetReceipts = rcpt.txtReceiptIsDisplayed();
	
	Assert.assertTrue(targetReceipts);
	System.out.println("*************** Home Page Test Passed ****************");	
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	    Assert.fail("TC002 Failed: " + e.getMessage());
	}
	
	logger.info("*************** Finished TC002 HomePage Test ***************");
	}

}
