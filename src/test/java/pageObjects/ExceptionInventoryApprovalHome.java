package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExceptionInventoryApprovalHome extends BasePage{
	
	Actions action;	
	
	//Constructor
	public ExceptionInventoryApprovalHome(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Element:	
	@FindBy(xpath = "//div[contains(@class,'MenuLink') and normalize-space()='Inventory']")
	WebElement btnInventory;
	
	@FindBy(xpath = "//div[@id='inventory-approval-buttonlabel']")
	WebElement btnApproval;
	
	@FindBy(xpath = "//div[@id='inventory-approval-packExceptionalQuantityApprovals-buttonlabel']")
	WebElement btnPacksExceptions;
	
	
	
	//Action Methods:
	public void ClickBtnInventory()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement inventory = wait.until(ExpectedConditions.elementToBeClickable(btnInventory));
		
		inventory.click();
	}
	
	public void doubleClickApproval() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement approval = wait.until(ExpectedConditions.elementToBeClickable(btnApproval));
		
		action=new Actions(driver);
		action.doubleClick(approval).perform();
		Thread.sleep(1000);
	}
	
	public void doubleClickPacksExceptions() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement packsExceptions = wait.until(ExpectedConditions.elementToBeClickable(btnPacksExceptions));
		
		action=new Actions(driver);
		action.doubleClick(packsExceptions).perform();
		Thread.sleep(1000);
	}	

}
