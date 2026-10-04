package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.InbounCreateInboundInstSupInvNoActionScreen;
import pageObjects.InbounCreateInboundInstSupInvNoCheckBoxsSelect;
import pageObjects.InbounCreateInboundInstSupInvNoTransactionType;
import pageObjects.InbounInboundMovement;
import testBase.BaseClass;
import utilities.SharedData;

public class TC006_CreateInboundInstructionBySupInvNo extends BaseClass{
	
	@Test(groups= {"Master_UI_PacksFlow", "Regression_FileUpload_CSV","Smoke_ExceptionPacks"})
	public void verify_TC006_CreateInboundInstructionBySupInvNo() {
		
		try
		{		
			logger.info("********** Starting TC006_CreateInboundInstructionBySupInvNo Test **********");
			
			//InbounInboundMovement
			logger.info("Entering into Create Inbound InstSupInvNo Screen.. ");
			InbounInboundMovement ibm=new InbounInboundMovement(driver);
			ibm.clickReceipts1();
			ibm.clickbtnInboundMovement();
			ibm.clickbtnCreateInboundInstSupInvNo();
			logger.info("Successfully Entered into Create Inbound InstSupInvNo Screen.. ");
			
			//InbounCreateInboundInstSupInvNoTransactionType
			logger.info("Navigating to Transaction Type Screen..");
			InbounCreateInboundInstSupInvNoTransactionType inboundSupInvTransType=new InbounCreateInboundInstSupInvNoTransactionType(driver);
			inboundSupInvTransType.selectDrpTransactionTypeInbound("SKUQAAndBinning");
			inboundSupInvTransType.clickSearchInbound();
			logger.info("Successfully Selected Transaction Type.");
			
			//InbounCreateInboundInstSupInvNoCheckBoxsSelect
			InbounCreateInboundInstSupInvNoCheckBoxsSelect ibmCheckBoxs=new InbounCreateInboundInstSupInvNoCheckBoxsSelect(driver);
			
			String supplierInvoiceNo = SharedData.supplierInvoiceNo;
			ibmCheckBoxs.selectRowsBySupplierInvoice(supplierInvoiceNo);
			
			
			//InbounCreateInboundInstSupInvNoActionScreen
			logger.info("Entering Into Action Screen Of Create Inbount Instruction SupIn..");
			InbounCreateInboundInstSupInvNoActionScreen actionBtn=new InbounCreateInboundInstSupInvNoActionScreen(driver);
			actionBtn.clickActionInbountInstSupIn();
			actionBtn.setToLocationInboundSupInNo("S-R01-S0-01");
			actionBtn.clickSaveChangesInbountInstSupIn();
			logger.info("Successfully Created Inbount Instruction SupIn.");
			String actualMessageInboundCreate = actionBtn.getSuccessMessageInboundInsSupInvNo();			
			
		
			if (actualMessageInboundCreate.startsWith("SKU Instruction(s) ") && actualMessageInboundCreate.endsWith(" Created Successfully."))
		    {
		        Assert.assertTrue(true);
		        System.out.println();
		        System.out.println("------> "+"Create Create Inbound Instruction By SupInvNo Test Passed"+" <----------");	
		        actionBtn.closeXbtnInboundInstSupInvNos();
		    }
			else
		    {
		    	Assert.fail("Unexpected success message: " + actualMessageInboundCreate);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC006_CreateInboundInstructionBySupInvNo Test ***************");

  }
}
