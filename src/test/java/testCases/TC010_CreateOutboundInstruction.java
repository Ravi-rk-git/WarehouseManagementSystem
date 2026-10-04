package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OutboundCreateOutBoundInstructionHome;
import pageObjects.OutboundCreateOutBoundInstructionSuccessMessage;
import pageObjects.OutboundCreateOutBoundInstructionTransactionType;
import testBase.BaseClass;
import utilities.SharedData;

public class TC010_CreateOutboundInstruction extends BaseClass{
	
	
	@Test(groups= {"Master_UI_PacksFlow", "Regression_FileUpload_CSV"})
	public void verify_TC010_CreateOutboundInstruction()
	{
		logger.info("********** Starting TC010_CreateOutboundInstruction Test **********");
		
		try
		{		
		
			//OutboundCreateOutBoundInstructionHome
			logger.info("Entering Into the Create Outbound Instruction Screen..");
			OutboundCreateOutBoundInstructionHome outbound=new OutboundCreateOutBoundInstructionHome(driver);
			outbound.clickbtnSales();
			outbound.btnOutboundSKUMovement();
			outbound.clickCreateOutBoundInstruction();
			logger.info("Successfully Naviagted to Create Outbound Instruction Home Page.");
			
			//OutboundCreateOutBoundInstructionTransactionType
			logger.info("Entering Into The Transaction Type Screen of Create Outbound..");
			OutboundCreateOutBoundInstructionTransactionType transType=new OutboundCreateOutBoundInstructionTransactionType(driver);
			transType.drpTransactionTypeCreateOutboundInst("Picking");
			transType.clickbtnSearchOnCreateOutbound();
			logger.info("Successfully Entered Into The Trasnaction Type & Clicked On Search Button.");
						
			
			String customerOrderNo = SharedData.customerOrderNo;
			String externalOrderRefNo = SharedData.externalOrderRefNo;

			if (customerOrderNo != null && !customerOrderNo.trim().isEmpty()) {

			    // CSV flow
			    transType.selectCheckboxByCustomerOrderNo(customerOrderNo);

			} else if (externalOrderRefNo != null && !externalOrderRefNo.trim().isEmpty()) {

			    // Master UI flow
			    transType.selectCheckboxByExternalOrderRefNo(externalOrderRefNo);

			} else {
			    Assert.fail("Both Customer Order No and External Order Ref No are null/empty.");
			}
			
			
			transType.clickbtnActionOnCreateOutbound();
			transType.setToLocationCreateOutbound("D1");
			transType.clickbtnSaveChanges();
			logger.info("Checkbox Are selected and To-Location Set, Outbound Created Successfully.");
			
			//OutboundCreateOutBoundInstructionSuccessMessage
			OutboundCreateOutBoundInstructionSuccessMessage successCreateOutbound=new OutboundCreateOutBoundInstructionSuccessMessage(driver);
			String actualMessageCreateOutbound = successCreateOutbound.getSuccessMessageCreateOutboundInst();
			
			
			if (actualMessageCreateOutbound.startsWith("\"SKU Instruction(s) ") && actualMessageCreateOutbound.endsWith(" Created Successfully.\""))
		    {
		        Assert.assertTrue(true);
		        System.out.println();
		        System.out.println("------> "+"Create Outbound Instruction Test Passed"+" <----------");	
		        successCreateOutbound.clickCloseXbtnOutboundInstCreations();
		    }
			else
		    {
		    	Assert.fail("Unexpected success message: " + actualMessageCreateOutbound);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC010_CreateOutboundInstruction Test ***************");		
	}

}
