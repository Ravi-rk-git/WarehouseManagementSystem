package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ExceptionInventoryApprovalHome;
import pageObjects.ExceptionInventoryPackExceptionSearchScreen;
import testBase.BaseClass;

public class TC021_ExceptionsPacksMovementsInInventory extends BaseClass{
	
	
	@Test(groups= {"Smoke_ExceptionPacks"})
	public void verify_TC021_ExceptionsPacksMovementsInInventory() throws InterruptedException
	{
		logger.info("********** Starting TC021_ExceptionsPacksMovementsInInventory Test **********");
		
		try
		{
		//ExceptionInventoryApprovalHome
		ExceptionInventoryApprovalHome exceptionHome=new ExceptionInventoryApprovalHome(driver);
		logger.info("Started Clicking On Inventory Header & Create Packs Exceptions..");
		exceptionHome.ClickBtnInventory();
		exceptionHome.doubleClickApproval();
		exceptionHome.doubleClickPacksExceptions();
		logger.info("Successfully Clicked On Inventory Header & Create Packs Exceptions.");
		
		//ExceptionInventoryPackExceptionSearchScreen
		ExceptionInventoryPackExceptionSearchScreen exceptionSearch=new ExceptionInventoryPackExceptionSearchScreen(driver);
		exceptionSearch.setdrpExceptionCountType("Shortage");
		logger.info("Successfully selected Exception Type: Shortage.");
		exceptionSearch.clickBtnSearch();
		exceptionSearch.clickHeaderCheckBox();
		logger.info("Successfully Clicked On Header Checkbox.");
		exceptionSearch.clickBtnAction();	
		logger.info("Successfully Navigated To Action Screen.");
		
		exceptionSearch.selectApprovalTransactionTypeForAllRows("SKUQAAndBinningShtgApproval");		
		exceptionSearch.clickBtnSaveChanges();
		logger.info("Successfully Selected All DropDowns for SKUQAAndBinningShtgApproval & Clicked Save-Changes.");
		exceptionSearch.txtSuccessShortageExceptionMessage();
		exceptionSearch.clickBtnXCloseOnShortageExcept();		
		//--------------Above: Shortage Exception Reporting.--------------
		
		logger.info("Started Reporting Damage Approval..");
		exceptionHome.ClickBtnInventory();
		exceptionHome.doubleClickApproval();
		exceptionHome.doubleClickPacksExceptions();
		exceptionSearch.setdrpExceptionCountType("Damaged");
		logger.info("Successfully selected Exception Type: Damage. ");
		exceptionSearch.clickBtnSearch();
		exceptionSearch.clickHeaderCheckBox();
		logger.info("Successfully Clicked On Header Checkbox.");
		exceptionSearch.clickBtnAction();
		logger.info("Successfully Navigated To Action Screen.");
		
		//Below Line Selects Damage Approve-Transaction Type & Provides Damage-To-Location: 
		exceptionSearch.selectApprovalTypeAndSetToLocationForAllRows("475","Dmg01");
		
		exceptionSearch.clickBtnSaveChanges();
		logger.info("Successfully Set All the Damage-Approval TransactionTypes & Save Changes Is Clicked.");
		String SuccessMessageDamageApprovalExcption = exceptionSearch.txtSuccessDamageExceptionMessage();
		//exceptionSearch.clickBtnXCloseOnDamageExcept();
		//--------------Above: Damage Exception Reporting.--------------
		
		
		if (SuccessMessageDamageApprovalExcption.equals("Exceptional quantity approved successfully."))
	    {
	        Assert.assertTrue(true);
	        System.out.println();
	        System.out.println("------> "+"TC021_ExceptionsPacksMovementsInInventory Test Passed"+" <----------");	
	        exceptionSearch.clickBtnXCloseOnDamageExcept();
	    }
		else
	    {
	    	Assert.fail("Unexpected success message: " + SuccessMessageDamageApprovalExcption);
	    }
	}
	catch(Exception e)
	{
		e.printStackTrace(); //print the complete details of the exception/error in the console.
		logger.error("Test Failed...", e);
		Assert.fail("Test Failed due to Exception: " + e.getMessage());
	}	
	
	logger.info("*************** Finished TC021_ExceptionsPacksMovementsInInventory Test ***************");
	
}

}
