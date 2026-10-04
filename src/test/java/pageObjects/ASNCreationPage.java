package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ASNCreationPage extends BasePage{
	
	Select ShipFromASN;
	Select tradeTermASN;
	Select shipModeASN;
	JavascriptExecutor jsToScroll;
	Actions act;
	
	//Constructor
	public ASNCreationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Elements
	/*
	@FindBy(xpath = "//div[text()='Supplier']/ancestor::tr/following-sibling::tr[1]//input[@type='text']")
	WebElement txtSupplierName;
	*/
	
	@FindBy(xpath = "//div[normalize-space()='Supplier']/ancestor::tr/following-sibling::tr[1]//button[@type='button']")
	WebElement clickSupplierName;
	
	@FindBy(xpath = "//div[normalize-space()='Supplier Code']/following::input[1]")
	WebElement txtSupplierCodeASN;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btbSearchSelectSupplier;
	
	@FindBy(xpath = "(//span[normalize-space()='Created Dt']/ancestor::td/preceding-sibling::td[1]/*)[2]")
	WebElement clickHeaderCheckBoxSelectSupplier;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement btnOKSelectSupplierASN;
	
	@FindBy(xpath = "//div[normalize-space()='Ship From']/parent::td/following::select[1]") 
	WebElement drpShipFrom;	
	
	@FindBy(xpath = "//div[normalize-space()='Supplier']")
	WebElement clickSupplierxtbtn;
	
	//ignored this
	//@FindBy(xpath = "//div[normalize-space()='Ship From']/parent::td/following::select[1]") 
	//WebElement drpShipFrom;
	
	@FindBy(xpath = "//td[contains(normalize-space(),'Trade Term')]/following::select[1]")
	WebElement drpTradeTerm;
	
	@FindBy(xpath = "//div[normalize-space()='Ship Mode']/following::select[1]")
	WebElement drpShipModeASN;
	
	@FindBy(xpath = "//div[@class='OptionalDateTextBox-CalanderIcon']")
	WebElement clickbtnDatePickerASN;
	
	@FindBy(xpath = "//div[@class='N54GXCD-c-r-com-sencha-gxt-theme-base-client-button-ButtonCellDefaultAppearance-ButtonCellStyle-text']")
	WebElement clickTodayDatePickerASN;
	
	@FindBy(xpath = "//div[normalize-space()='Supplier Invoice No']/following::input[1]")
	WebElement txtSupplierInvoiceNoASN;
	
	@FindBy(xpath = "//button[normalize-space()='Enter Vehicle Details']")
	WebElement btnEnterVehicleDetailsASN;
	
	
	//Vehicle Info Screen:	
	@FindBy(xpath = "//div[normalize-space()='New Vehicle No']/following::input[1]")
	WebElement txtNewVehicleNoASN;
	
	@FindBy(xpath = "//div[normalize-space()='Vehicle Name']/following::input[1]")
	WebElement txtVehicleNameASN;
	
	@FindBy(xpath= "//div[normalize-space()='Driver Name']/following::input[1]")
	WebElement txtDriverNameASN;
	
	@FindBy(xpath = "//div[normalize-space()='Driver Mobile No.']/following::input[1]")
	WebElement txtDriverMobileNoASN;
	
	@FindBy(xpath = "//div[normalize-space()='Container No']/following::input[1]")
	WebElement txtContainerNoASN;
	
	@FindBy(xpath = "//div[normalize-space()='Container No']/following::input[2]")
	WebElement txtContainerTypeASN;
	
	@FindBy(xpath = "//div[normalize-space()='Trailer No.']/following::input[1]")
	WebElement txtTrailerNoANS;
	
	@FindBy(xpath = "//div[normalize-space()='Trailer No.']/following::input[2]")
	WebElement txtTrailertypeANS;
		
	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement btnNextInASNVehicleInfoScreen;
		
	
	
	
	//Action Methods
	/*
	public void setSupplierCode(String SupplierName) //We have warehouses with this name hence "GGN15" NOT selected.
	{
		txtSupplierName.sendKeys(SupplierName);
	}
	*/	
	
	public void clickSupplierCode() //We have warehouses with this name hence "GGN15" NOT selected.
	{
		clickSupplierName.click();
	}
	
	public void setSupplierCodeASN(String supplierCode)
	{
		txtSupplierCodeASN.sendKeys(supplierCode);
	}
	
	public void clickSearchSupplier()
	{
		btbSearchSelectSupplier.click();
	}
	
	public void clickHeaderFirstCheckBoxSelectSupplier()
	{
		clickHeaderCheckBoxSelectSupplier.click();
	}
	
	public void btnClickOKSelectSupplierASN()
	{
		btnOKSelectSupplierASN.click();
	}
	
	public void setdrpShipFrom()
	{		
		ShipFromASN=new Select(drpShipFrom);
		ShipFromASN.selectByIndex(1);		
	}	
	
	public void clickSuppliertxt() 
	{		
		clickSupplierxtbtn.click();		
	}
	
	//ignored this
	/*public void setdrpShipFrom()
	{		
		ShipFromASN=new Select(drpShipFrom);
		ShipFromASN.selectByIndex(1);		
	}*/	
	
	public void setTradeTermASN()
	{
		tradeTermASN=new Select(drpTradeTerm);
		tradeTermASN.selectByIndex(1);
	}

	public void setShipModedrp()
	{
		shipModeASN=new Select(drpShipModeASN);
		shipModeASN.selectByIndex(3);		
		
	}
	
	public void clickDatePickerASN()
	{
		clickbtnDatePickerASN.click();
	}
	
	public void clickTodayDatePickrASN()
	{
		clickTodayDatePickerASN.click();		
	}
	
	/*
	public void setSupplierInvoiceNoASN()
	{
		String generatedStringASNSupInvNumber = RandomStringUtils.secure().nextAlphabetic(3).toUpperCase();
	    String generatedNumberASNSupInvNumber = RandomStringUtils.secure().nextNumeric(6);

	        txtSupplierInvoiceNoASN.sendKeys("SUP-"+"INV"+generatedStringASNSupInvNumber + "-" + generatedNumberASNSupInvNumber.toUpperCase());
	        //return "PO-"+generatedStringPORefNo + "@" + generatedNumberPORefNo;		
	}
	*/
	
	public String setSupplierInvoiceNoASN()
	{
	    String generatedStringASNSupInvNumber = RandomStringUtils.secure().nextAlphabetic(3).toUpperCase();
	    String generatedNumberASNSupInvNumber = RandomStringUtils.secure().nextNumeric(6);

	    String supplierInvoiceNo = "SUP-INV" + generatedStringASNSupInvNumber + "-" + generatedNumberASNSupInvNumber;

	    txtSupplierInvoiceNoASN.sendKeys(supplierInvoiceNo);

	    return supplierInvoiceNo;
	}
	
	public void clickbtnEnterVehicleDetailsASN() throws InterruptedException
	{
		JavascriptExecutor jsToScroll= (JavascriptExecutor) driver;
		jsToScroll.executeScript("arguments[0].scrollIntoView(true);", btnEnterVehicleDetailsASN);		
		
		btnEnterVehicleDetailsASN.click();
		Thread.sleep(1500);
	}
	
	
	
	//Vehicle Info Screen:	
	public void setNewVehicleNo()
	{		
		String generatedNumberASNNewVehicleNumber = RandomStringUtils.secure().nextNumeric(4);
		txtNewVehicleNoASN.sendKeys("KA51BE"+generatedNumberASNNewVehicleNumber);
	}
	
	public void setVehicleName() throws InterruptedException
	{
		String generatedStringASNSVehicleName = RandomStringUtils.secure().nextAlphabetic(8).toUpperCase();
		String generatedStringASNSVehicleNameSpace = RandomStringUtils.secure().nextAlphabetic(16).toUpperCase();
		txtVehicleNameASN.sendKeys(generatedStringASNSVehicleName+"  "+ generatedStringASNSVehicleNameSpace);
		Thread.sleep(1000);
	}
	
	public void setDriverNameASNtxt()
	{
		String generatedStringASNSVehicleName = RandomStringUtils.secure().nextAlphabetic(7).toUpperCase();
		txtDriverNameASN.sendKeys("RAVI "+generatedStringASNSVehicleName);		
	}
	
	public void setDriverMobileNo()
	{
		 String generatedDriverMobileNumberASN = RandomStringUtils.secure().nextNumeric(7);
		 txtDriverMobileNoASN.sendKeys("+91 90"+generatedDriverMobileNumberASN);		
	}
	
	public void setContainerNoASN()
	{
		String generatedContainerNumberASN = RandomStringUtils.secure().nextNumeric(6);
		txtContainerNoASN.sendKeys("CONTAINER-"+generatedContainerNumberASN);
	}
	
	public void setContainerTypeASN(String containerType) throws InterruptedException
	{
		txtContainerTypeASN.sendKeys(containerType);
		Thread.sleep(500);
		
		act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void setTrailerNoASN() throws InterruptedException
	{
		String generatedTrailerNumberASN = RandomStringUtils.secure().nextNumeric(6);
		txtTrailerNoANS.sendKeys("TRAILER-"+generatedTrailerNumberASN);
		Thread.sleep(1000);
	}
	
	public void setTrailerType(String trailerType) throws InterruptedException
	{
		txtTrailertypeANS.sendKeys(trailerType);
		Thread.sleep(500);
		
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();		
	}	
	
	public void clickNextBtnInASNVehicleInfo() throws InterruptedException
	{
		jsToScroll= (JavascriptExecutor) driver;
		jsToScroll.executeScript("arguments[0].scrollIntoView(true);", btnNextInASNVehicleInfoScreen);

		btnNextInASNVehicleInfoScreen.click();
		Thread.sleep(1500);
	}
	
}
