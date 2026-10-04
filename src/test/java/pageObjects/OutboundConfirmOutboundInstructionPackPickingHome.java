package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutboundConfirmOutboundInstructionPackPickingHome extends BasePage{
	
	Actions action;
	Select select;
	
	//Constructor
	public OutboundConfirmOutboundInstructionPackPickingHome(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element
	@FindBy(xpath = "//td[normalize-space()='Sales']")
	WebElement btnSales;
	
	@FindBy(xpath = "//div[@id='sales-outBoundSKUMovement-buttonlabel']")
	WebElement btnOutboundSKUMovement;
	
	@FindBy(xpath = "//div[@id='sales-outBoundSKUMovement-confirmOutBoundPackMovementSlip-buttonlabel']")
	WebElement btnConfirmOutboundInstructionPackPicking;
	
	@FindBy(xpath = "//select[@title='The type of transaction associated with the pack movement.']")
	WebElement drpTransactionTypeConfirmOutboundPacks;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearchConfirmPacks;
	
	
	
	//Action Method
	public void clickbtnSales()
	{
		btnSales.click();
	}
	
	public void btnOutboundSKUMovement()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement btnOutboundMoveMent = wait.until(ExpectedConditions.elementToBeClickable(btnOutboundSKUMovement));
	
		action=new Actions(driver);
		action.doubleClick(btnOutboundMoveMent).perform();
	}
	
	public void clickbtnConfirmOutboundInstructionPackPickings()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement doubleClickConfirmOutboundInstructionPackPicking = wait.until(ExpectedConditions.elementToBeClickable(btnConfirmOutboundInstructionPackPicking));
	
		action=new Actions(driver);
		action.doubleClick(doubleClickConfirmOutboundInstructionPackPicking).perform();
	}
	
	public void setdrpTransactionTypeConfirmPacks(String setTransactionType)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(drpTransactionTypeConfirmOutboundPacks));

		 dropdown.click();

		 select = new Select(dropdown);
		 select.selectByVisibleText(setTransactionType);				
	}
	
	public void btnSearchConfirmPacks() 
	{
		btnSearchConfirmPacks.click();
	}

}
