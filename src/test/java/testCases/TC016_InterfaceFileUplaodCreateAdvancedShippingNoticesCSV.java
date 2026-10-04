package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.UploadFileCreateAdvancedShippingNotices;
import testBase.BaseClass;

public class TC016_InterfaceFileUplaodCreateAdvancedShippingNoticesCSV extends BaseClass{
	
	@Test(groups= {"Regression_FileUpload_CSV"},
			dependsOnMethods = {"verify_TC015_TransactionLogStatusCheckForCreatePurchaseOrder"})
	public void verify_TC016_InterfaceFileUplaodCreateAdvancedShippingNoticesCSV() 
	{
		logger.info("********** Starting TC016_InterfaceFileUplaodCreateAdvancedShippingNoticesCSV Test **********");
		
		try
		{				
		
		//Note: Below commented code would be enabled only if test wants to start from ASN CSV, Not from PO.
		/*
		HomePage hmpage=new HomePage(driver);
		logger.info("Setting Primary Company Code..");
		hmpage.setPrimaryCompany("DJT Retailers");
		hmpage.clickReceipts1();
		*/
		
		
		//UploadFileCreatePurchaseOrderCSV
		UploadFileCreateAdvancedShippingNotices uploadASNCSV=new UploadFileCreateAdvancedShippingNotices(driver);
		logger.info("Navigating to Administration Tab & Interface Screen..");
		uploadASNCSV.clickBtnHeaderAdministration();
		uploadASNCSV.doubleClickbtnInterface();
		logger.info("Successfully Reached to Adminsitration and Interface Screen.");
		uploadASNCSV.doubleClickbtnUploadFile();
		
		uploadASNCSV.readSupplierInvoiceNoFromCSV();
		uploadASNCSV.readPurchaseReferenceNoFromCSV();
		
		uploadASNCSV.clickChooseFile();		
		uploadASNCSV.clickBtnUpload();		
		logger.info("Successfully Navigated to Upload File screen And After File Uploaded Successfully, clicked on UploadButton.");
		
		
		String successMessageFileUpload = uploadASNCSV.successMsgFileScheduled();
		if(successMessageFileUpload.equals("File Scheduled For Upload"))
		{
			Assert.assertTrue(true);
			System.out.println(successMessageFileUpload);
			uploadASNCSV.closeXbuttonOnFileScheduled();
			uploadASNCSV.closeXbuttonOnUploadFile();
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
		
		logger.info("*************** Finished TC016_InterfaceFileUplaodCreateAdvancedShippingNoticesCSV Test ***************");

  }
}
