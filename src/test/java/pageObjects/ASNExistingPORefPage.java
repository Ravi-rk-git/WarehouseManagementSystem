package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ASNExistingPORefPage extends BasePage{
	
	//Constructor
	public ASNExistingPORefPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators/Elements
	@FindBy(xpath = "//div[normalize-space()='Existing Purchase Reference No']\r\n"
			+ "/following::input[@type='radio'][1]")
	WebElement rdoExistingPORefNoASN;
	
	@FindBy(xpath = "//div[normalize-space()='Purchase Order No']/following::button[1]")
	WebElement btnSearchPurchaseOrderNoASN;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement clickSearchSelectPOASN;
	
	@FindBy(xpath = "(//span[normalize-space()='Created Dt']/ancestor::td/preceding-sibling::td[1]/*)[2]")
	WebElement clickHeaderCheckBoxPurchaseOrderASN;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement btnClickOKSelectPurchaseOrder;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement clickADDBtnExistingPORef;
	
	@FindBy(xpath = "//button[normalize-space()='Next' and not(contains(@style,'display: none'))]")
	WebElement btnNextExistingPORefASN;
	
	
	//Action Methods
	public void clickRdoExistingPORefNoASN() throws InterruptedException
	{
		rdoExistingPORefNoASN.click();
		Thread.sleep(1500);
	}
	
	public void clickSearchPurchaseOrderNoASN() throws InterruptedException
	{
		btnSearchPurchaseOrderNoASN.click();
		Thread.sleep(2000);
	}

	public void clickSelectPurchaseOrder() throws InterruptedException
	{
		clickSearchSelectPOASN.click();
		Thread.sleep(1000);
	}
	
	public void clickHeaderCheckBoxSelectPurchaseOrderASN() throws InterruptedException
	{
		clickHeaderCheckBoxPurchaseOrderASN.click();
		Thread.sleep(1000);
	}
	
	public void btnClickOKSelectPurchaseOrderASN() throws InterruptedException
	{
		btnClickOKSelectPurchaseOrder.click();
		Thread.sleep(5000); //Mandatory - This sleep time Essential. 
	}
	
	public void clickADDBtnExistingPORefASN()
	{
		clickADDBtnExistingPORef.click();
	}
	
	public void clickbtnNextExistingPORefASN() throws InterruptedException
	{
		btnNextExistingPORefASN.click();
		Thread.sleep(4000);
	}
}
