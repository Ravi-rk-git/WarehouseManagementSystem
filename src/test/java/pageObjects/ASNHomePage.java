package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ASNHomePage extends BasePage{
	
	public Actions action;
	
	//Constructor
	public ASNHomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators/Elements
	@FindBy(xpath = "//div[contains(@class,'MenuLink') and text()='Receipts']")
	WebElement btnReceipts;
	
	@FindBy(xpath = "//div[@class='gwt-HTML ButtonIcon receipts-advanceShippingNote-Icon']")
	WebElement btnASNote;
	
	@FindBy(xpath = "//div[@class='gwt-HTML ButtonIcon receipts-advanceShippingNote-createAdvanceShippingNotewithoutPO-Icon']")
	WebElement btnCreateASN;
	
	
	//Action Methods
	public void clickReceipts1()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnReceipts));
		btnReceipts.click();
	}
	
	
	public void doubleClickOnASN()
	{
		action=new Actions(driver);
		action.doubleClick(btnASNote).perform();
	}
	
	public void doubleClickCreateASN()
	{
		action=new Actions(driver);
		action.doubleClick(btnCreateASN).perform();
	}
	
}
