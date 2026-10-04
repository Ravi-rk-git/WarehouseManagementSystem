package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleInBasicInfoOperation extends BasePage{
	
	Select select;
	Actions action;
	
	//Constructor
	public VehicleInBasicInfoOperation(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Element
	@FindBy(xpath = "//select[@title='The type of operation or purpose of this vehicle (e.g., delivery, transport).']")
	WebElement drpOperationType;
	
	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement btnNEXTOperationTypescreen;
	
	@FindBy(xpath = "(//div[contains(@class,'CheckBoxColumnStyle-hdChecker')])[1]")
	WebElement chbSelectASNnoHeader;
	
	@FindBy(xpath = "//button[normalize-space()='Next' and not(contains(@style,'display: none'))]")
	WebElement btnNEXTinSelectASNGrid;
	
	
	
	
	//Action Method
	public void clickdrpOperationType(String setOperationType)
	{
		drpOperationType.click();
		select=new Select(drpOperationType);
		drpOperationType.sendKeys(setOperationType);
		
		action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void clickNEXTTwiceOperationTypescreen() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnNEXTOperationTypescreen)).click();
		
		Thread.sleep(1500);
		
		wait.until(ExpectedConditions.elementToBeClickable(btnNEXTOperationTypescreen)).click();
		
	}
	
	public void clickchbSelectASNnoHeader()
	{
		chbSelectASNnoHeader.click();
	}
	
	public void clickbtnNEXTinSelectASNGrid() throws InterruptedException
	{
		btnNEXTinSelectASNGrid.click();
		Thread.sleep(1500);
	}
	

}
