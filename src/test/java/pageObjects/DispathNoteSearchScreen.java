package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DispathNoteSearchScreen extends BasePage{
	
	Actions action;
	
	//Constructor:
	public DispathNoteSearchScreen(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element:
	@FindBy(xpath = "//select[@title='The type of transaction for the dispatch note.']")
	WebElement drpTransactionTypeCreateDispatch;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearch;
	
	
	
	//Action Methods:
	public void setdrpTransactionTypeCreateDispatch(String setTransactionType) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(drpTransactionTypeCreateDispatch));
		
		dropDown.click();
		action=new Actions(driver);
		Thread.sleep(700);
		action.sendKeys(Keys.ENTER).perform();		
	}
	
	public void clickBtnSearch()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement btnSearchDispatch = wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
		
		btnSearchDispatch.click();
	}

}
