package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.TransactionLogFileUploadStatus;
import testBase.BaseClass;

public class TC019_TransactionLogStatusCheckForCreateSalesOrder extends BaseClass{
	
	@Test(groups= {"Regression_FileUpload_CSV"})
	public void verify_TC019_TransactionLogStatusCheckForCreateSalesOrder() throws InterruptedException 
	{
		logger.info("********** Starting TC019_TransactionLogStatusCheckForCreateSalesOrder Test **********");
		
		try
		{				
		
			//TransactionLogFileUploadStatus
			logger.info("Entring Into Transaction Log Screen..");
			TransactionLogFileUploadStatus transLog=new TransactionLogFileUploadStatus(driver);
			transLog.btnTransactionLog();
			transLog.btnClickSearch();
			logger.info("System Successfully Navigated To Transaction Log Page & Able to View the Records List");
			
			
			 String actualStatus = transLog.waitForFileStatus();
			 logger.info("Waiting For The File Status Changes To 'Success'");

		        if (actualStatus.equalsIgnoreCase("SUCCESS")) {

		            System.out.println("File processing completed successfully.");

		            Assert.assertEquals(actualStatus, "SUCCESS");

		            // Navigate to Receipts
		            transLog.ReceiptsClick();
		            logger.info("Now File Status is Success & Successfully Clicked On Receipts.");

		        } else if (actualStatus.equalsIgnoreCase("EXCEPTION")) {
		        	
		            System.out.println("File processing failed with EXCEPTION.");
		            System.out.println("Staying on Transaction Log screen.");

		            Assert.fail("File processing failed. Status is EXCEPTION.");
		            logger.info("File Status Thowed With Exceptions & Exception Errors Occurred");

		        } else {

		            Assert.fail("File processing did not complete within the expected time. Status: "
		                    + actualStatus);
		        }

		    } catch (Exception e) {

		        e.printStackTrace();

		        logger.error("Test Failed...", e);

		        Assert.fail("Test Failed due to Exception: " + e.getMessage());
		    }
		
			logger.info("*************** Finished TC019_TransactionLogStatusCheckForCreateSalesOrder Test ***************");

		}		
		
		
  }

