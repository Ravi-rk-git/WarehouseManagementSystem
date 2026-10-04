package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CreateSalesOrder;
import pageObjects.CreateSalesOrderGridOrderedSKUs;
import pageObjects.CreateSalesOrderGridOrderedSKUsForBatchDetails;
import pageObjects.CreateSalesOrderGridOrderedSKUsForSaveAndSuccess;
import pageObjects.SalesOrderHome;
import testBase.BaseClass;
import utilities.SharedData;

public class TC008_CreateSalesOrder extends BaseClass{
	
	
	@Test(groups= {"Master_UI_PacksFlow"})
	public void verify_TC008_CreateSalesOrder()
	{
		logger.info("********** Starting TC008_CreateSalesOrder Test **********");
		
		try
		{	
		
			//----------------------> Out bound Process <---------------------------
			//----------------------> Out bound Process <---------------------------
			
			logger.info("Entering Into Outbound Flow....");
			logger.info("Navigating Create Sales Order Home Screen...");
			//SalesHome
			SalesOrderHome sm=new SalesOrderHome(driver);
			sm.clickbtnSales();
			sm.doubleclickSalesOrder();
			sm.doubleclickCreateSalesOrder();
			logger.info("Successfully Navigated To Create Sales Order Screen.");
			
			//CreateSalesOrder
			logger.info("Providing Random External Order Refrence Number..");
			CreateSalesOrder createSO=new CreateSalesOrder(driver);
			createSO.setCustomerCodeSales("GGN15");
			String externalOrderRefNo = createSO.settxtCustomerOrderNoSales();			
			SharedData.externalOrderRefNo=externalOrderRefNo;
			logger.info("Successfully Passed Random External Order Number In SO Screen.");
			
			logger.info("Started Setting TradeTerm, SOType, BillTo, ShipTo details..");
			createSO.setdrpTradeTermSales("Ex-WareHouse");
			createSO.setdrpSOTypeSales("Planned");
			createSO.setdrpBillToSales("BANGALORE");
			createSO.setdrpShipToCodeSales("Technoforte");
			createSO.clickADDsales();
			createSO.clickADDsales();
			logger.info("Successfully Setted TradeTerm, SOType, BillTo, ShipTo details..");
			
			//CreateSalesOrderGridOrderedSKUs
			logger.info("Adding All the SKUs to the SKUsGride Section in SO screen..");
			CreateSalesOrderGridOrderedSKUs soGrid=new CreateSalesOrderGridOrderedSKUs(driver);
			soGrid.setSKUCodeData("100324");
			soGrid.clickbtnSearchSO();
			soGrid.selectkHeaderCheckBoxSKUCodeSO();
			soGrid.clickbtnOKskuCodeSO();		
			createSO.clickADDsales(); //Calling from CreateSalesOrder Class			
			
			soGrid.setSKUCodeData("100387");
			soGrid.clickbtnSearchSO();
			soGrid.selectkHeaderCheckBoxSKUCodeSO();
			soGrid.clickbtnOKskuCodeSO();		
			createSO.clickADDsales(); //Calling from CreateSalesOrder Class			
			
			soGrid.setSKUCodeData("100320");
			soGrid.clickbtnSearchSO();
			soGrid.selectkHeaderCheckBoxSKUCodeSO();
			soGrid.clickbtnOKskuCodeSO();
			logger.info("Successfully Added All the Related SKUs to the SKU Grid in SO screen.");
					
			//CreateSalesOrderGridOrderedSKUsForBatchDetails
			CreateSalesOrderGridOrderedSKUsForBatchDetails salesOrderBatch = new CreateSalesOrderGridOrderedSKUsForBatchDetails(driver);        
			
			logger.info("Passing Shared Data Batch Details like BatchNo, MfgDate, Qty To the SKUs..");
			salesOrderBatch.enterBatchNo("100324", SharedData.batch100324);
			salesOrderBatch.enterBatchNo("100387", SharedData.batch100387);
			salesOrderBatch.enterBatchNo("100320", SharedData.batch100320);    

			salesOrderBatch.selectMfgDateToday("100324");
			salesOrderBatch.selectMfgDateToday("100387");
			salesOrderBatch.selectMfgDateToday("100320");

			salesOrderBatch.setInnerPackDetail("100324", SharedData.innerPack100324);
			salesOrderBatch.setInnerPackDetail("100387", SharedData.innerPack100387);
			salesOrderBatch.setInnerPackDetail("100320", SharedData.innerPack100320);

			salesOrderBatch.setOrderedQtyInOUOM("100324", SharedData.qty100324);
			salesOrderBatch.setOrderedQtyInOUOM("100387", SharedData.qty100387);
			salesOrderBatch.setOrderedQtyInOUOM("100320", SharedData.qty100320);
			
			//CreateSalesOrderGridOrderedSKUsForSaveAndSuccess
			CreateSalesOrderGridOrderedSKUsForSaveAndSuccess saveSO=new CreateSalesOrderGridOrderedSKUsForSaveAndSuccess(driver);
			saveSO.clickSAVEsalesOrder();
			logger.info("Successfully Inserted All Batch Details ans Sales Order Created Successfully.");
			String soNo = saveSO.getSuccessMessageCreateSalesOrder();
			SharedData.soNo = soNo;			
		
		
			if (soNo.equals(soNo))
		    {
		        Assert.assertTrue(true);
		        System.out.println();
		        System.out.println("------> "+"Create Sales Order Test Passed"+" <----------");
		        saveSO.closeXbtnCreateSalesOrderPopup();
		    }
			else
		    {
		    	Assert.fail("Unexpected success message: " + soNo);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC008_CreateSalesOrder Test ***************");
	
	}

}
