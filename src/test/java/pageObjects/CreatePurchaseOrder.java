package pageObjects;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePurchaseOrder extends BasePage{
	
	Select drpTradeTrem;
	Select AcdrpOrderType; 
	Select drpShipMode;
	
	// Constructor
	public CreatePurchaseOrder(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locators/Elements
	@FindBy(xpath = "//input[@title='The company or entity from which the goods or services are being purchased.']")
	WebElement txtSupplier;
	
	@FindBy(xpath = "//div[normalize-space()='Supplier']")
	WebElement btnSupplierClick;
	
	@FindBy(xpath = "//select[contains(@title,'The specific terms')]")
	WebElement ddlTradeTerm;
	
	@FindBy(xpath = "//select[contains(@title,'classification or categorization')]")
	WebElement ddlOrderType;
	
	@FindBy(xpath = "//select[contains(@title,'The method or mode')]")
	WebElement ddlShipMode;
	
	@FindBy(xpath = "//input[@tabindex='102']")
	WebElement txtPurchaseRefNo;
	
	@FindBy(xpath = "//div[normalize-space()='Purchase Ref No']")
	WebElement txtPurchaseRefLinkClick;
	
	@FindBy(xpath = "//body[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[2]/td[3]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]")
	WebElement clickDatePicker;
	
	@FindBy(xpath = "//div[@class='N54GXCD-c-r-com-sencha-gxt-theme-base-client-button-ButtonCellDefaultAppearance-ButtonCellStyle-text']")
	WebElement txtTodayDateClick;
	
		
	
	
	//Action Methods
	public void setSupplier(String Supplier)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement setSupplierCode = wait.until(ExpectedConditions.elementToBeClickable(txtSupplier));
		
		setSupplierCode.sendKeys(Supplier);
	}

	public void clickSupplier() throws InterruptedException
	{
		Thread.sleep(1000);
		btnSupplierClick.click();
	}
	
	public void dropdownTradeTerm(String tradeTermType)
	{
		drpTradeTrem=new Select(ddlTradeTerm);
		drpTradeTrem.selectByIndex(1);
	}
	
	public void dropdownOrderType(String OrderType)
	{
		AcdrpOrderType=new Select(ddlOrderType);
		AcdrpOrderType.selectByIndex(1);		
	}
	
	public void dropdownShipMode(String ShippingMode)
	{
		drpShipMode=new Select(ddlShipMode);
		drpShipMode.selectByIndex(1);		
	}
	
	public String setPurchaseRefNo()
	{
	    String generatedStringPORefNo = RandomStringUtils.secure().nextAlphabetic(3).toUpperCase();
	    String generatedNumberPORefNo = RandomStringUtils.secure().nextNumeric(8);

	    String purchaseReferenceNo = "PO-REF" + generatedStringPORefNo + "-" + generatedNumberPORefNo;

	    txtPurchaseRefNo.sendKeys(purchaseReferenceNo);

	    return purchaseReferenceNo;
	}
	
	public void clickPurchaseRefNo()
	{
		txtPurchaseRefLinkClick.click();
	}
	
	public void ClickDatePickerr()
	{
		clickDatePicker.click();		
	}
	
	public void ClickDatePickerToday()
	{
		txtTodayDateClick.click();		
	}		
	
}
