package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutboundCreateOutBoundInstructionHome extends BasePage{
	
	Actions action;
	
	//Constructor
	public OutboundCreateOutBoundInstructionHome(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element
	@FindBy(xpath = "//td[normalize-space()='Sales']")
	WebElement btnSales;
	
	@FindBy(xpath = "//div[@id='sales-outBoundSKUMovement-buttonlabel']")
	WebElement btnOutboundSKUMovement;
	
	@FindBy(xpath = "//div[@id='sales-outBoundSKUMovement-createOutBoundSKUMovement-buttonlabel']")
	WebElement btnCreateOutBoundInstruction;
	
	
	
	
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
	
	public void clickCreateOutBoundInstruction()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement clickCreateOutboundInstruction = wait.until(ExpectedConditions.elementToBeClickable(btnCreateOutBoundInstruction));
	
		action=new Actions(driver);
		action.doubleClick(clickCreateOutboundInstruction).perform();
	}

}
