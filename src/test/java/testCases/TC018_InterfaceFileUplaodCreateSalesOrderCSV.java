package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.UploadFileCreateSalesOrder;
import testBase.BaseClass;

public class TC018_InterfaceFileUplaodCreateSalesOrderCSV extends BaseClass{
	
	@Test(groups= {"Regression_FileUpload_CSV"},
			dependsOnMethods = {"verify_TC007_ConfirmInboundInstructionPacks"})
	public void verify_TC018_InterfaceFileUplaodCreateSalesOrderCSV() 
	{
		logger.info("********** Starting TC018_InterfaceFileUplaodCreateSalesOrderCSV Test **********");
		
		try
		{			
		
		//UploadFileCreateSalesOrder
		UploadFileCreateSalesOrder uploadSalesOrder=new UploadFileCreateSalesOrder(driver);
		logger.info("Navigating to Administration Tab & Interface Screen..");
		uploadSalesOrder.clickBtnHeaderAdministration();
		uploadSalesOrder.doubleClickbtnInterface();
		logger.info("Successfully Reached to Adminsitration and Interface Screen.");
		uploadSalesOrder.doubleClickbtnUploadFile();
		
		/*
		uploadSalesOrder.readSupplierInvoiceNoFromCSV(); //This dynamically reads whatever SupplierInv No you put in the CSV.
		uploadSalesOrder.readPurchaseReferenceNoFromCSV(); //This dynamically reads whatever PurchaseRefNo you put in the CSV.
		*/
		uploadSalesOrder.readCustomerOrderNoFromCSV(); //This dynamically reads whatever CustomerOrderNo you put in the CSV.
		
		uploadSalesOrder.clickChooseFile();		
		uploadSalesOrder.clickBtnUpload();		
		logger.info("Successfully Navigated to Upload File screen And After File Uploaded Successfully, clicked on UploadButton.");
		
		
		String successMessageFileUpload = uploadSalesOrder.successMsgFileScheduled();
		if(successMessageFileUpload.equals("File Scheduled For Upload"))
		{
			Assert.assertTrue(true);
			System.out.println(successMessageFileUpload);
			uploadSalesOrder.closeXbuttonOnFileScheduled();
			uploadSalesOrder.closeXbuttonOnUploadFile();
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
		
		logger.info("*************** Finished TC018_InterfaceFileUplaodCreateSalesOrderCSV Test ***************");

  }
}
