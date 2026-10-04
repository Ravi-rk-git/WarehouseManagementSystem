package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreatePurchaseOrder;
import pageObjects.PurchaseOrderCreate;
import pageObjects.SearchPurchaseOrderSKUsGride;
import pageObjects.SearchSKUPurchaseOrder;
import testBase.BaseClass;
import utilities.SharedData;

public class TC003_CreatePurchaseOrder extends BaseClass{
	
	@Test(groups= {"Master_UI_PacksFlow","Smoke_ExceptionPacks"})
	public void verify_TC003_CreatePurchaseOrder()
	{
		logger.info("********** Starting TC003_CreatePurchaseOrder Test **********");
		
		try
		{			
			//----------------------> In bound Process <---------------------------
			//----------------------> In bound Process <---------------------------		
			
			logger.info("Started Into Purchase Order Creation..");
			//PurchaseOrderCreate
			PurchaseOrderCreate purchOrder=new PurchaseOrderCreate(driver);
			purchOrder.doubleClickPurchaseOrder();
			purchOrder.doubleClickCreatePurchaseOrder();
			logger.info("Successfully navigated to Create Purchase Order Screen");
			
			/*
			PoSuppier rcpt=new PoSuppier(driver);
			boolean targetReceipts = rcpt.txtPurchaseSupplier();		
			*/
			
			logger.info("Passing supplier, TradeTerm, OrderType & ShipMode..");
			//Create PO
			CreatePurchaseOrder createPO=new CreatePurchaseOrder(driver);
			createPO.setSupplier("GGN15");
			createPO.clickSupplier();
			createPO.dropdownTradeTerm("Ex-WareHouse");
			createPO.dropdownOrderType("Planned");
			createPO.dropdownShipMode("Carried By Road");	
			logger.info("Successfully Set supplier, TradeTerm, OrderType & ShipMode..");
			
			String purchaseReferenceNo = createPO.setPurchaseRefNo();	
			SharedData.purchaseReferenceNo = purchaseReferenceNo;
			
			createPO.clickPurchaseRefNo();
			createPO.ClickDatePickerr();
			createPO.ClickDatePickerToday();
			logger.info("Successfully set Puchase RefNo and Today Date Picker");
			
			logger.info("Started.. Adding SKU Codes into the PO Gride..");
			//SearchSKUPurchaseOrder
			SearchSKUPurchaseOrder SearchSKUPO=new SearchSKUPurchaseOrder(driver);
			SearchSKUPO.btnAddPurchaseOrder();
			SearchSKUPO.btnAddPurchaseOrder();
			SearchSKUPO.setSKUCodeData("100324"); //first SKU code
			SearchSKUPO.clickSearchbtn();
			SearchSKUPO.clickCheckBoxSKUCodes();
			SearchSKUPO.clickbtnOK();
			
			SearchSKUPO.btnAddPurchaseOrder();
			SearchSKUPO.setSKUCodeData("100387"); //second SKU code
			SearchSKUPO.clickSearchbtn();
			SearchSKUPO.clickCheckBoxSKUCodes();
			SearchSKUPO.clickbtnOK();	
			
			SearchSKUPO.btnAddPurchaseOrder();
			SearchSKUPO.setSKUCodeData("100320"); //second SKU code
			SearchSKUPO.clickSearchbtn();
			SearchSKUPO.clickCheckBoxSKUCodes();
			SearchSKUPO.clickbtnOK();	
			logger.info("Successfully Added all the SKUs to Po Gride.");
			
			logger.info("Started Entering Quantity into each SKUs..");
			//SearchPurchaseOrderSKUsGride
			SearchPurchaseOrderSKUsGride purchaseOrderQty=new SearchPurchaseOrderSKUsGride(driver);		
			purchaseOrderQty.enterQuantity("100324", "3");
			purchaseOrderQty.enterQuantity("100387", "3");
			purchaseOrderQty.enterQuantity("100320", "3");
			logger.info("Successfully Entered all the Quantities and Clicked On SavePurchaseOrder.");
			purchaseOrderQty.clickBtnSavePurchaseOrder();			
			String actualMessagePO = purchaseOrderQty.txtSucessMessagePurchaseOrder();
			

			if (actualMessagePO.startsWith("Purchase Order(s)") && actualMessagePO.endsWith("created and approved Successfully."))
			    {
			        Assert.assertTrue(true);
			        System.out.println("*************** Purchase Order Creation Test Passed ****************");
			        purchaseOrderQty.clickCloseXbtnPO();
			    }
			    else
			    {
			    	Assert.fail("Unexpected success message: " + actualMessagePO);
			    }
			}		
			catch(Exception e)
			{
				e.printStackTrace(); //print the complete details of the exception/error in the console.
			    logger.error("Test Failed...", e);
			    Assert.fail("Test Failed due to Exception: " + e.getMessage());
			}
		
		logger.info("*************** Finished TC003_CreatePurchaseOrder Test ***************");
	}
}

			

		
