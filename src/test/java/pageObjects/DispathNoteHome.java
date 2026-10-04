package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DispathNoteHome extends BasePage{
	
	Actions action;
	
	//Constructor:
	public DispathNoteHome(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element:
	@FindBy(xpath = "//td[normalize-space()='Sales']")
	WebElement btnSales;
	
	@FindBy(xpath = "//div[@id='sales-dispatchNote-buttonlabel']")
	WebElement btnDispatchNote;
	
	@FindBy(xpath = "//div[@id='sales-dispatchNote-createDispatchNote-buttonlabel']")
	WebElement btnCreateDispatchNote;
	
	
	
	
	//Action Methods:
	public void clickSales()
	{
		btnSales.click();
	}
	
	public void doubleClickbtnDispatchNote()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement dispatchNote = wait.until(ExpectedConditions.elementToBeClickable(btnDispatchNote));
		
		action=new Actions(driver);
		action.doubleClick(dispatchNote).perform();		
	}
	
	public void doubleClickbtnCreateDisaptchNote() 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement createDispatchNote = wait.until(ExpectedConditions.elementToBeClickable(btnCreateDispatchNote));
	
		action=new Actions(driver);
		action.doubleClick(createDispatchNote).perform();
	}

}
