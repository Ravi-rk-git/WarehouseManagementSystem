package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PurchaseOrderCreate extends BasePage{
	
	public Actions action;
	
	//Constructor
	public PurchaseOrderCreate(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Elements
	@FindBy(xpath = "//div[@class='gwt-HTML ButtonIcon receipts-purchaseOrders-Icon']")
	WebElement btnPurchaseOrder;
	
	@FindBy(xpath = "//div[@id='receipts-purchaseOrders-createPurchaseOrder-buttonlabel']")
	WebElement btnCreatePurchaseOrder;
	
	
	//Action Methods
	public void doubleClickPurchaseOrder()
	{
		action=new Actions(driver);
		action.doubleClick(btnPurchaseOrder).perform();
	}
	
	public void doubleClickCreatePurchaseOrder()
	{
		action=new Actions(driver);
		action.doubleClick(btnCreatePurchaseOrder).perform();
	}
	


}
