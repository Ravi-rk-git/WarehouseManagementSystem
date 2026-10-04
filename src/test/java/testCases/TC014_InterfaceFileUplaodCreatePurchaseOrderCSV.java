package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UploadFileCreatePurchaseOrderCSV;
import testBase.BaseClass;

public class TC014_InterfaceFileUplaodCreatePurchaseOrderCSV extends BaseClass{
	
	@Test(groups= {"Regression_FileUpload_CSV"}, 
			dependsOnMethods ="verify_TC001_LoginTest")
	public void verify_TC014_InterfaceFileUplaodCreatePurchaseOrderCSV() 
	{
		logger.info("********** Starting TC014_InterfaceFileUplaodCreatePurchaseOrderCSV Test **********");
		
		try
		{				
		
		HomePage hmpage=new HomePage(driver);
		logger.info("Setting Primary Company Code..");
		hmpage.setPrimaryCompany("DJT Retailers");
		hmpage.clickReceipts1();
		logger.info("Successfully Set Primary Company And Clicked On Receipts.");
		
		
		//UploadFileCreatePurchaseOrderCSV
		UploadFileCreatePurchaseOrderCSV uploadPurchaseOrderCSV=new UploadFileCreatePurchaseOrderCSV(driver);
		logger.info("Navigating to Administration Tab & Interface Screen..");
		uploadPurchaseOrderCSV.clickBtnHeaderAdministration();
		uploadPurchaseOrderCSV.doubleClickbtnInterface();
		logger.info("Successfully Reached to Adminsitration and Interface Screen.");
		uploadPurchaseOrderCSV.doubleClickbtnUploadFile();
		uploadPurchaseOrderCSV.clickChooseFile();		
		uploadPurchaseOrderCSV.clickBtnUpload();		
		logger.info("Successfully Navigated to Upload File screen And After File Uploaded Successfully, clicked on UploadButton.");
		
		
		String successMessageFileUpload = uploadPurchaseOrderCSV.successMsgFileScheduled();
		if(successMessageFileUpload.equals("File Scheduled For Upload"))
		{
			Assert.assertTrue(true);
			System.out.println(successMessageFileUpload);
			uploadPurchaseOrderCSV.closeXbuttonOnFileScheduled();
			uploadPurchaseOrderCSV.closeXbuttonOnUploadFile();
		}
		else 
		{		
		    Assert.fail("Unexpected success message: " + successMessageFileUpload);		    
		}
		}
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC014_InterfaceFileUplaodCreatePurchaseOrderCSV Test ***************");

  }
}
