package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.VehicleIn;
import pageObjects.VehicleInBasicInfo;
import pageObjects.VehicleInBasicInfoOperation;
import pageObjects.VehicleInBasicInfoTransactionType;
import testBase.BaseClass;

public class TC005_CreateVehicleIn extends BaseClass{
	
	@Test(groups= {"Master_UI_PacksFlow","Regression_FileUpload_CSV","Smoke_ExceptionPacks"})
	public void verify_TC005_CreateVehicleIn() {
		
		try
		{			
			logger.info("********** Starting TC005_CreateVehicleIn Test **********");
			
			//VehicleIn
			logger.info("Entering To Create Vehicle In Screen..");
			VehicleIn statusVehicleIn=new VehicleIn(driver);
			statusVehicleIn.txtIsVehicleIsDisplayed();
			statusVehicleIn.clickBtnVehicleText();
			statusVehicleIn.clickBtnVehicleIn();
			statusVehicleIn.clickBtnCreateVehicleIn();
			logger.info("Successfully Entered Into Vehicle In Screen.");
			
			//VehicleInBasicInfo
			logger.info("Searching.. for Vehicle Number..");
			VehicleInBasicInfo vehicleBasicInfo=new VehicleInBasicInfo(driver);
			vehicleBasicInfo.clickSearchVehicleNo();
			vehicleBasicInfo.btnSearchVehicleIn();
			vehicleBasicInfo.clickHeaderCheckBoxSelectVehicleNo();
			vehicleBasicInfo.clickOKbtnSelectVehicleNo();
			vehicleBasicInfo.clickNEXTbtnBasicInfo();
			logger.info("Vehicle Number Is Successfully Selected.");
			
			//VehicleInBasicInfoOperation
			logger.info("Entered Into Operation Type Selection Section..");
			VehicleInBasicInfoOperation vehicleOpeType=new VehicleInBasicInfoOperation(driver);
			vehicleOpeType.clickdrpOperationType("Offload And Load"); //Operation Type
			vehicleOpeType.clickNEXTTwiceOperationTypescreen();
			vehicleOpeType.clickchbSelectASNnoHeader();
			vehicleOpeType.clickbtnNEXTinSelectASNGrid();
			logger.info("Successfully Selected Operation Type and Navigated to Next screen.");
			
			//VehicleInBasicInfoTransactionType
			logger.info("Enter Into the Transaction Type Section..");
			VehicleInBasicInfoTransactionType vehicleTranstype=new VehicleInBasicInfoTransactionType(driver);
			vehicleTranstype.clickdrpTransactionType("UnloadToDock"); //Transaction Type
			vehicleTranstype.setTxtToLocationDock("D1");
			logger.info("Successfully Selected Transaction Type and To-Location.");
			vehicleTranstype.clickbtnFINISHVehicleIn();
			String actualMessageVehicleIn = vehicleTranstype.getSuccessMessageCreateVehicleIn();		
		
		
			if (actualMessageVehicleIn.startsWith("Vehicle In of ") && actualMessageVehicleIn.endsWith(" registered successfully."))
		    {
		        Assert.assertTrue(true);
		        System.out.println();		       
		        System.out.println("------> "+"Create Vehicle In Test Passed"+" <----------");
		        vehicleTranstype.closeXbtnCreateVehicleInPopup();
		    }
			else
		    {
		    	Assert.fail("Unexpected success message: " + actualMessageVehicleIn);
		    }
		}	
		catch(Exception e)
		{
			e.printStackTrace(); //print the complete details of the exception/error in the console.
			logger.error("Test Failed...", e);
			Assert.fail("Test Failed due to Exception: " + e.getMessage());
		}	
		
		logger.info("*************** Finished TC005_CreateVehicleIn Test ***************");
  }
}
