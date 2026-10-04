package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.VehicleCreateVehicleOut;
import pageObjects.VehicleCreateVehicleOutBasicInfo;
import pageObjects.VehicleCreateVehicleOutFinalSuccessScreen;
import pageObjects.VehicleCreateVehicleOutSearch;
import pageObjects.VehicleVehicleOut;
import testBase.BaseClass;

public class TC013_CreateVehicleOut extends BaseClass{
	
	
	@Test(groups= {"Master_UI_PacksFlow", "Regression_FileUpload_CSV"})
	public void verify_TC013_CreateVehicleOut()
	{
		logger.info("********** Starting TC013_CreateVehicleOut Test **********");
		
		try
		{			
		
			//VehicleVehicleOut
			logger.info("Entering Into The Create Vehicle Out Screen..");
			VehicleVehicleOut vehicle=new VehicleVehicleOut(driver);
			vehicle.clickBtnHeaderVehicle();
			vehicle.clickBtnVehicleOut();
			
			//VehicleCreateVehicleOut
			VehicleCreateVehicleOut createVehicleOut=new VehicleCreateVehicleOut(driver);
			createVehicleOut.clickbtnCreateVehicleOut();
			logger.info("Successfully Navigated To Home Screen Of Create Vehicle Out..");
			
			//VehicleCreateVehicleOutSearch
			logger.info("Searching & Selecting For Existing Vehicle Number..");
			VehicleCreateVehicleOutSearch searchVehicleNo=new VehicleCreateVehicleOutSearch(driver);
			searchVehicleNo.clickBtnSearchVehicleNo();
			searchVehicleNo.clickBtnSearch();
			searchVehicleNo.selectTxtHeaderCheckBoxSelectVehicleNo();
			searchVehicleNo.clickBtnOKOnSelectVehicleNo();
			searchVehicleNo.clickbtnNEXTOnSearchVehicleNo();
			logger.info("Successfully Selected Vehicle No And On Next button To Navigate Next screen.");
			
			//VehicleCreateVehicleOutBasicInfo			
			VehicleCreateVehicleOutBasicInfo btnNext=new VehicleCreateVehicleOutBasicInfo(driver);
			btnNext.clickBtnNEXTonVehicleOutBasicInfo();
			logger.info("Successfully Navigated To Basic Info Screen.");
			
			//VehicleCreateVehicleOutFinalSuccessScreen
			VehicleCreateVehicleOutFinalSuccessScreen successVehicleOut=new VehicleCreateVehicleOutFinalSuccessScreen(driver);
			successVehicleOut.clickbtnFINISHCreateVehicleOut();
			logger.info("Success: Clicked On FINISH Button And Vehicle Out is Created.");
			String actualMessageVehicleOut = successVehicleOut.getSuccessMessageCreateVehicleOut();
			//successVehicleOut.closeXbtnCreateVehicleOutPopup();
			
			if (actualMessageVehicleOut.startsWith("Vehicle out of ") && actualMessageVehicleOut.endsWith(" registered successfully."))
		    {
		        Assert.assertTrue(true);
		        System.out.println();
		        System.out.println("------> "+"Create Vehicle Out Test Passed"+" <----------");	
		        successVehicleOut.closeXbtnCreateVehicleOutPopup();	
		    }
			else
		    {
		    	Assert.fail("Unexpected success message: " + actualMessageVehicleOut);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC013_CreateVehicleOut Test ***************");		
	}

}
