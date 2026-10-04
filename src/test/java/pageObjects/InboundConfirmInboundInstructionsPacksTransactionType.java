package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InboundConfirmInboundInstructionsPacksTransactionType extends BasePage{
	
	Select select;
	
	//Constructor
	public InboundConfirmInboundInstructionsPacksTransactionType(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Elements
	@FindBy(xpath = "//select[@title='The type of transaction associated with the confirmation.']")
	WebElement drpTransactionTypeInboundPacks;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearchConfirmInboundPacks;
	
	
	
	//Action Methods
	public void selectDrpTransactionTypeInboundPacks(String inboundPacksTransactionType)
	{
		drpTransactionTypeInboundPacks.click();
		
		select=new Select(drpTransactionTypeInboundPacks);
		select.selectByContainsVisibleText(inboundPacksTransactionType);		
	}
	
	public void clickbtnSearchConfirmInboundPacks()
	{
		btnSearchConfirmInboundPacks.click();
	}

}
