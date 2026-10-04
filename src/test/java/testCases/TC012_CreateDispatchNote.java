package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DispathNoteActionScreen;
import pageObjects.DispathNoteHome;
import pageObjects.DispathNoteSaveChanagesScreen;
import pageObjects.DispathNoteSearchScreen;
import testBase.BaseClass;
import utilities.SharedData;

public class TC012_CreateDispatchNote extends BaseClass{
	
	
	@Test(groups= {"Master_UI_PacksFlow", "Regression_FileUpload_CSV"})
	public void verify_TC012_CreateDispatchNote()
	{
		logger.info("********** Starting TC012_CreateDispatchNote Test **********");
		
		try
		{		
		
			//DispathNoteHome
			logger.info("Entering Into the Create Dispatch Note Screen..");
			DispathNoteHome dispatchHome=new DispathNoteHome(driver);
			dispatchHome.clickSales();
			dispatchHome.doubleClickbtnDispatchNote();
			dispatchHome.doubleClickbtnCreateDisaptchNote();
			logger.info("Successfully Entered Into the Create Dispatch Note Screen.");
			
			//DispathNoteSearchScreen
			logger.info("Navigating into the Transaction Type Screen..");
			DispathNoteSearchScreen searchScreen=new DispathNoteSearchScreen(driver);
			searchScreen.setdrpTransactionTypeCreateDispatch("DispatchNoteFromPicking");
			searchScreen.clickBtnSearch();
			logger.info("Transaction Type Set And Search Button Clicked Successfully.");
			
			//DispathNoteActionScreen
			DispathNoteActionScreen selectCheckbox=new DispathNoteActionScreen(driver);
			String soNo=SharedData.soNo;
			selectCheckbox.selectSalesOrder(soNo);
			
			selectCheckbox.clickBtnActionOnCreateDispatchNote();
			logger.info("Successfully Clicked On Action Screen Of Dispatch Note.");
			
			//DispathNoteSaveChanagesScreen
			logger.info("Searching For Existing Vehicle Number to select...");
			DispathNoteSaveChanagesScreen vehicleNoSave=new DispathNoteSaveChanagesScreen(driver);
			vehicleNoSave.clickBtnSearchVehicleNO();
			vehicleNoSave.clickBtnSearch();
			vehicleNoSave.selectHeaderCheckBoxVehicleNo();
			vehicleNoSave.clickbtnOKVehicleNo();
			vehicleNoSave.clickBtnSaveChnagesOnCreateDisaptch();
			logger.info("Vehicle Number Is Selected and Successfully Clicked On Save Chnages Button.");
			String actualMessageCreateDispatch = vehicleNoSave.getSuccessMessageCreateDispatchNote();
			
			
			if (actualMessageCreateDispatch.startsWith("Invoice(s) ") && actualMessageCreateDispatch.endsWith(" Created Successfully."))
		    {
		        Assert.assertTrue(true);
		        System.out.println();
		        System.out.println("------> "+"Create Dispatch Note Test Passed"+" <----------");	
		        vehicleNoSave.closeXbtnCreateDispatchNotePopup();	
		    }
			else
		    {
		    	Assert.fail("Unexpected success message: " + actualMessageCreateDispatch);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC012_CreateDispatchNote Test ***************");
		
	}

}
