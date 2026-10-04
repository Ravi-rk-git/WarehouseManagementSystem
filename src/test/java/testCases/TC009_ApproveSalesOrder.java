package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ApproveSalesOrderCheckBoxnAction;
import pageObjects.ApproveSalesOrderHome;
import testBase.BaseClass;
import utilities.SharedData;

public class TC009_ApproveSalesOrder extends BaseClass{
	
	
	@Test(groups= {"Master_UI_PacksFlow","Regression_FileUpload_CSV"})
	public void verify_TC009_ApproveSalesOrder()
	{
		logger.info("********** Starting TC009_ApproveSalesOrder Test **********");
		
		try
		{
				
			//ApproveSalesOrderHome
			logger.info("Entering Into The Approve Sales Order Screen..");
			ApproveSalesOrderHome approveSO=new ApproveSalesOrderHome(driver);
			approveSO.clickbtnSales();
			approveSO.btnSalesOrder();
			approveSO.clickApproveSalesOrder();
			approveSO.setTransactionTypeApprSO("Sales Order Allocation");
			approveSO.clickSearchSOTransType();
			logger.info("Successfully Entered Into Approve SO screen & Transaction Type Selected.");
			
			//ApproveSalesOrderCheckBoxnAction
			logger.info("Navigating To Action Screen Of Approve Sales Order..");
			ApproveSalesOrderCheckBoxnAction chkboxAction=new ApproveSalesOrderCheckBoxnAction(driver);
						
			String soNo = SharedData.soNo;

			if (soNo == null || soNo.isEmpty())
			{
			    soNo = chkboxAction.getSalesOrderNumberByRefSONo(SharedData.customerOrderNo);
			    SharedData.soNo = soNo;
			}

			chkboxAction.selectSalesOrder(soNo);			
			chkboxAction.clickbtnActionApprSO();
			chkboxAction.clickbtnApproveSalesOrder();
			logger.info("Successfully Navigated Action Screen and Sales Order Approved Successfully.");
			String actualMessageApproveSO = chkboxAction.getSuccessMessageApproveSalesOrder();	
		
		
			if (actualMessageApproveSO.startsWith("Sales order(s) ") && actualMessageApproveSO.endsWith(" approved successfully."))
		    {
		        Assert.assertTrue(true);
		        System.out.println();
		        System.out.println("------> "+"Approve Sales Order Test Passed"+" <----------");
		        chkboxAction.closeXbtnCreateSalesOrderPopup();
		    }		
			else
		    {
		    	Assert.fail("Unexpected success message: " + actualMessageApproveSO);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC009_ApproveSalesOrder Test ***************");
		
	}
}
