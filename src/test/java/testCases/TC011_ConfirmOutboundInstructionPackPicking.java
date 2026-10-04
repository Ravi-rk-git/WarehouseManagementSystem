package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.OutboundConfirmOutboundInstructionPackPickingAction;
import pageObjects.OutboundConfirmOutboundInstructionPackPickingHome;
import pageObjects.OutboundConfirmOutboundInstructionPackPickingSearchScreen;
import testBase.BaseClass;

public class TC011_ConfirmOutboundInstructionPackPicking extends BaseClass{
	
	
	@Test(groups= {"Master_UI_PacksFlow","Regression_FileUpload_CSV"})
	public void verify_TC011_ConfirmOutboundInstructionPackPicking()
	{
		logger.info("********** Starting TC011_ConfirmOutboundInstructionPackPicking Test **********");
		
		try
		{	
			
			//Confirm Out bound Instruction - Pack(Picking)
			logger.info("Entering Into the Confirm Outbound & Transaction Type Screen..");
			OutboundConfirmOutboundInstructionPackPickingHome confirmPacks=new OutboundConfirmOutboundInstructionPackPickingHome(driver);
			confirmPacks.clickbtnSales();
			confirmPacks.btnOutboundSKUMovement();
			confirmPacks.clickbtnConfirmOutboundInstructionPackPickings();
			confirmPacks.setdrpTransactionTypeConfirmPacks("ConfirmPicking");
			confirmPacks.btnSearchConfirmPacks();
			logger.info("Transaction Type Selected and Search Button Clicked Successfully.");
				
			//OutboundConfirmOutboundInstructionPackPickingSearchScreen
			logger.info("Selecting Check Boxs Based On Stock Change Work Inprogress..");
			OutboundConfirmOutboundInstructionPackPickingSearchScreen checkboxSelect =new OutboundConfirmOutboundInstructionPackPickingSearchScreen(driver);
			String sciNo = checkboxSelect.getSCINo();
			checkboxSelect.selectRowsBySCINo(sciNo);
			checkboxSelect.clickbtnActionOnConfirmOutboundPacks();
			logger.info("Check Boxs Are Selected and Successfully Navigated to Action Screen of Confirm Outbound");
			
			//OutboundConfirmOutboundInstructionPackPickingAction
			logger.info("Started Applying Pack Status To The Packs Available In Action Screen grid..");
			OutboundConfirmOutboundInstructionPackPickingAction statusPacksSelect=new OutboundConfirmOutboundInstructionPackPickingAction(driver);
			statusPacksSelect.selectPackStatus(0, "Found");
			statusPacksSelect.selectPackStatus(1, "Found");
			statusPacksSelect.selectPackStatus(2, "Found");
			statusPacksSelect.clickbtnSAVECHANGESConfirmOutboundPacks();
			logger.info("Pack Status Is Applied and Save Changes Button Clicked Successfully.");
			String actualMessageOutboundConfirm = statusPacksSelect.getSuccessMessageConfirmOutboundPacks();
			
		
			if (actualMessageOutboundConfirm.equals("Pack Moved successfully."))
		    {
		        Assert.assertTrue(true);
		        System.out.println();
		        System.out.println("------> "+"Confirm Outbound Instruction - Pack(Picking) Test Passed"+" <----------");	
		        statusPacksSelect.closeXbtnConfirmOutboundPacksPopup();	
		    }
			else
		    {
		    	Assert.fail("Unexpected success message: " + actualMessageOutboundConfirm);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC011_ConfirmOutboundInstructionPackPicking Test ***************");

		
	}

}
