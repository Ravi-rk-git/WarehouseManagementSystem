package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.InbounConfirmInboundInstPacksActionScreen;
import pageObjects.InbounConfirmInboundInstPacksCheckBoxsSelect;
import pageObjects.InboundConfirmInboundInstructionsPacks;
import pageObjects.InboundConfirmInboundInstructionsPacksTransactionType;
import testBase.BaseClass;
import utilities.SharedData;

public class TC007_ConfirmInboundInstructionPacks extends BaseClass{
	
	
	@Test(groups= {"Master_UI_PacksFlow","Regression_FileUpload_CSV"})
	public void verify_TC007_ConfirmInboundInstructionPacks()
	{
		logger.info("********** Starting TC007_ConfirmInboundInstructionPacks Test **********");
		
		try
		{	
			logger.info("Entering Into the Confirm Inbound Instruction Packs Screen..");			
			//InboundConfirmInboundInstructionsPacks
			InboundConfirmInboundInstructionsPacks confirmInboundPacks=new InboundConfirmInboundInstructionsPacks(driver);
			confirmInboundPacks.clickReceipts1();
			confirmInboundPacks.clickbtnInboundMovement();
			confirmInboundPacks.doubleClickOnConfirmInboundInstructionsPacks();
			logger.info("Successfully Entered Into Inbound Instruction Packs screen.");
			
			//InboundConfirmInboundInstructionsPacksTransactionType
			logger.info("Navigating To Transaction Type screen..");
			InboundConfirmInboundInstructionsPacksTransactionType confirmIboundPacksTransType=new InboundConfirmInboundInstructionsPacksTransactionType(driver);
			confirmIboundPacksTransType.selectDrpTransactionTypeInboundPacks("ConfirmSKUQAAndBinning");
			confirmIboundPacksTransType.clickbtnSearchConfirmInboundPacks();
			logger.info("Successfully Selected Transaction Type and Clicked On Search Button.");
			
			//InbounConfirmInboundInstPacksCheckBoxsSelect
			InbounConfirmInboundInstPacksCheckBoxsSelect inboundPacksCheckboxs=new InbounConfirmInboundInstPacksCheckBoxsSelect(driver);
			
			String purchaseReferenceNo = SharedData.purchaseReferenceNo;
			inboundPacksCheckboxs.selectRowsByPurchaseReference(purchaseReferenceNo);
			
			//InbounConfirmInboundInstPacksActionScreen
			logger.info("Entering Into the Action Screen of ConfirmInboundPacks and Applying Packs Status..");
			InbounConfirmInboundInstPacksActionScreen actionInboundPacks=new InbounConfirmInboundInstPacksActionScreen(driver);
			actionInboundPacks.clickActionConfirmInboundPacks();
			actionInboundPacks.selectPackStatus(0, "Found");
			actionInboundPacks.selectPackStatus(1, "Found");
			actionInboundPacks.selectPackStatus(2, "Found");
			actionInboundPacks.clickbtnSAVECHANGESInboundPacks();
			logger.info("Successfully Applied Packs Status and Confirm Inbound Pack Created Successfully.");
			String actualMessageInboundConfirm = actionInboundPacks.getSuccessMessageConfirmInboundPacks();
					
		
			if (actualMessageInboundConfirm.equals("Pack Moved successfully."))
		    {
		        Assert.assertTrue(true);
		        System.out.println();
		        System.out.println("------> "+"Confirm Inbound Instruction Packs Test Passed"+" <----------");	
		        actionInboundPacks.closeXbtnConfirmInboundPacksPopup();	
		    }
			else
		    {
		    	Assert.fail("Unexpected success message: " + actualMessageInboundConfirm);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC007_ConfirmInboundInstructionPacks Test ***************");
		
	}

}
