package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ASNConsolidatePackScreen;
import pageObjects.ASNCreationPage;
import pageObjects.ASNExistingPORefPage;
import pageObjects.ASNFinalCreateASNSunInvandVehicleInfo;
import pageObjects.ASNHomePage;
import pageObjects.ASNSKUDetailsWithPOGrid;
import testBase.BaseClass;
import utilities.SharedData;


public class TC004_CreateAdvancedShippingNotices extends BaseClass {
	
	@Test(groups= {"Master_UI_PacksFlow","Smoke_ExceptionPacks"})
	public void verify_TC004_CreateAdvancedShippingNotices() {
		
		logger.info("********** Starting TC004_CreateAdvancedShippingNotices Test **********");
	
		try
		{	
			logger.info(" Started Navigating to Create ASN Screen..");
			//ASNHomePage
			ASNHomePage ASNPage=new ASNHomePage(driver);
			ASNPage.clickReceipts1();	
			ASNPage.doubleClickOnASN();
			ASNPage.doubleClickCreateASN();
			logger.info(" Successfully Navigated to Create ASN Screen.");
		
			//ASNCreationPage
			ASNCreationPage ASNcreate=new ASNCreationPage(driver);
			//ASNcreate.setSupplierCode("DJT RETAILER PVT LTD (ESR WAREHOUSE SOHNA)"); //We have warehouses with this name hence "GGN15" NOT selected.
			ASNcreate.clickSupplierCode();
			logger.info("Started Set SupplierCode and Clicking on Header Checkbox..");
			ASNcreate.setSupplierCodeASN("GGN15");
			ASNcreate.clickSearchSupplier();
			ASNcreate.clickHeaderFirstCheckBoxSelectSupplier();
			logger.info("Successfully Set SupplierCode and Clicking on Header Checkbox..");
			ASNcreate.btnClickOKSelectSupplierASN();
			logger.info("Started Set ShipForm, TradeTerm, ShipMode, TodayDatePicker..");
			ASNcreate.setdrpShipFrom();
			
			ASNcreate.clickSuppliertxt();		
			ASNcreate.setTradeTermASN();
			ASNcreate.setShipModedrp();
			ASNcreate.clickDatePickerASN();
			ASNcreate.clickTodayDatePickrASN();		
			logger.info("Successfully Set ShipForm, TradeTerm, ShipMode, TodayDatePicker.");
		
			String supplierInvoiceNo = ASNcreate.setSupplierInvoiceNoASN();
			System.out.println("Supplier Invoice No = " + supplierInvoiceNo);			
			// Save it globally for your other test case
			SharedData.supplierInvoiceNo = supplierInvoiceNo;
			
			logger.info("Started Providing Details To Vehicle Detail Page..");
			ASNcreate.clickbtnEnterVehicleDetailsASN();
			ASNcreate.setNewVehicleNo();
			ASNcreate.setVehicleName();
			ASNcreate.setDriverNameASNtxt();
			ASNcreate.setDriverMobileNo();
			ASNcreate.setContainerNoASN();
			ASNcreate.setContainerTypeASN("Shelf Bin Containers"); //Container Type
			ASNcreate.setTrailerNoASN();
			ASNcreate.setTrailerType("YardDock Trailer"); //Trailer Type
			ASNcreate.clickNextBtnInASNVehicleInfo();
			logger.info("Successfully Set VehicleNo, VehicleName, ContainerDetails, TrailerDetails etc..");
			
			//ASNExistingPORefPage
			ASNExistingPORefPage ASNExistPO=new ASNExistingPORefPage(driver);
			logger.info("Started Chossing Existing PO Details...");
			ASNExistPO.clickRdoExistingPORefNoASN();
			ASNExistPO.clickSearchPurchaseOrderNoASN();
			ASNExistPO.clickSelectPurchaseOrder();
			ASNExistPO.clickHeaderCheckBoxSelectPurchaseOrderASN();
			ASNExistPO.btnClickOKSelectPurchaseOrderASN();
			ASNExistPO.clickADDBtnExistingPORefASN();
			ASNExistPO.clickbtnNextExistingPORefASN();
			logger.info("Successfully Chossen Existing PO Details...");

			//ASNSKUDetailsWithPOGrid
			ASNSKUDetailsWithPOGrid ASNskuBatch=new ASNSKUDetailsWithPOGrid(driver);		
			logger.info("Started Providing Random Batch Details into ASN Grid Like BatchNo, MfgDate, InnerPacks Detail & ExpiryDate details..");
			String batch100324 = ASNskuBatch.enterBatchNo("100324");
			String batch100387 = ASNskuBatch.enterBatchNo("100387");
			String batch100320 = ASNskuBatch.enterBatchNo("100320");
			/*
			System.out.println("100324 Batch = " + batch100324);
			System.out.println("100387 Batch = " + batch100387);
			System.out.println("100320 Batch = " + batch100320);
			*/
		
			ASNskuBatch.selectMfgDateToday("100324");
			ASNskuBatch.selectMfgDateToday("100387");
			ASNskuBatch.selectMfgDateToday("100320");		
			
			ASNskuBatch.enterExpiryDate("100324", "27/10/2027"); //ExpiryDate
			ASNskuBatch.enterExpiryDate("100387", "28/11/2028"); //ExpiryDate
			ASNskuBatch.enterExpiryDate("100320", "29/12/2029"); //ExpiryDate
			
			String qty100324 = ASNskuBatch.setShippedQtyBillingUOM("100324", "3"); //ShippedQty
			String qty100387 = ASNskuBatch.setShippedQtyBillingUOM("100387", "3"); //ShippedQty
			String qty100320 = ASNskuBatch.setShippedQtyBillingUOM("100320", "3"); //ShippedQty		
			
			String innerPack100324 = ASNskuBatch.setInnerPackDetail("100324"); //InnerPack-No
			String innerPack100387 = ASNskuBatch.setInnerPackDetail("100387"); //InnerPack-No
			String innerPack100320 = ASNskuBatch.setInnerPackDetail("100320"); //InnerPack-No	
			
			SharedData.batch100324 = batch100324;
			SharedData.batch100387 = batch100387;
			SharedData.batch100320 = batch100320;

			SharedData.innerPack100324 = innerPack100324;
			SharedData.innerPack100387 = innerPack100387;
			SharedData.innerPack100320 = innerPack100320;

			SharedData.qty100324 = qty100324;
			SharedData.qty100387 = qty100387;
			SharedData.qty100320 = qty100320;
			
			ASNskuBatch.setInnerPackType("100324", "Box1"); //InnerPack-Type
			ASNskuBatch.setInnerPackType("100387", "Generic"); //InnerPack-Type
			ASNskuBatch.setInnerPackType("100320", "Cardboard"); //InnerPack-Type
			
			ASNskuBatch.clickNextInSKUPOGridASN();
			logger.info("Successfully Provided Random Batch Details into ASN Grid Like BatchNo, MfgDate, InnerPacks Detail & ExpiryDate details..");
			
			//ASNConsolidatePackScreen
			ASNConsolidatePackScreen fromPackNo=new ASNConsolidatePackScreen(driver);
			fromPackNo.headerCheckBoxFromPackNOASN();
			fromPackNo.btnNextOnConsolidatePackScrreen();
			logger.info("Successfully Clicked on NEXT button & Navigated to Next page of Create ASN.");
			
			//ASNFinalCreateASNSunInvandVehicleInfo
			ASNFinalCreateASNSunInvandVehicleInfo finishASN=new ASNFinalCreateASNSunInvandVehicleInfo(driver);
			finishASN.clickFINISHbtnFinalOnCreateASN();
			String actualMessageASN = finishASN.txtSuccessMessageAdvancedShippingNote();
				
		
			if (actualMessageASN.startsWith("Advance Shipping Note(s)") && actualMessageASN.endsWith("created Successfully."))
		    {
		        Assert.assertTrue(true);
		        System.out.println();
		        System.out.println("------> "+"Advanced ShippingNotices Test Passed"+" <----------");
		        finishASN.clickCloseXbtnASN();
		    }
			else
		    {
		    	Assert.fail("Unexpected success message: " + actualMessageASN);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC004_CreateAdvancedShippingNotices Test ***************");	
}

}




	




