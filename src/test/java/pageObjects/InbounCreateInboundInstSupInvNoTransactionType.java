package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InbounCreateInboundInstSupInvNoTransactionType extends BasePage{
	
	Select select;
	
	//Constructor
	public InbounCreateInboundInstSupInvNoTransactionType(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Elements
	@FindBy(xpath = "//select[@title='The type or category of the transaction associated with the instruction.']")
	WebElement drpTransactionTypeInbound;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearchInbound;
	
	
	//Action Method
	public void selectDrpTransactionTypeInbound(String inboundTransactionType)
	{
		select=new Select(drpTransactionTypeInbound);
		select.selectByContainsVisibleText(inboundTransactionType);		
	}
	
	public void clickSearchInbound()
	{
		btnSearchInbound.click();
	}

}
