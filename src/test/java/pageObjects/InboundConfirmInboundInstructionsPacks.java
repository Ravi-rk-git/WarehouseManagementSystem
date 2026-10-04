package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class InboundConfirmInboundInstructionsPacks extends BasePage{
	
	Actions action;
	
	//Constructor
	public InboundConfirmInboundInstructionsPacks(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Elements
	@FindBy(xpath = "//div[contains(@class,'MenuLink') and text()='Receipts']")
	WebElement btnReceipts;
	
	@FindBy(xpath = "//div[@class='gwt-HTML ButtonIcon receipts-inboundSKUMovement-Icon']")
	WebElement btnInboundMovement;
	
	@FindBy(xpath = "//div[@id='receipts-inboundSKUMovement-confirmInboundPackMovement-buttonlabel']")
	WebElement btnConfirmInboundPacks;
	
	
	
	//Action Methods
	public void clickReceipts1()
	{
		btnReceipts.click();
	}
	
	public void clickbtnInboundMovement()
	{
		action=new Actions(driver);
		action.doubleClick(btnInboundMovement).perform();
	}
	
	public void doubleClickOnConfirmInboundInstructionsPacks()
	{
		action=new Actions(driver);
		action.doubleClick(btnConfirmInboundPacks).perform();
	}

}
