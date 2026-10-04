package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApproveSalesOrderHome extends BasePage{
	
	Actions action;
	Select select;
	
	//Constructor
	public ApproveSalesOrderHome(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Element:
	@FindBy(xpath = "//div[contains(@class,'MenuLink') and normalize-space()='Sales']")
	WebElement btnSales;
	
	@FindBy(xpath = "//div[@id='sales-salesOrder-buttonlabel']")
	WebElement btnSalesOrder;
	
	@FindBy(xpath = "//div[@id='sales-salesOrder-approveSalesOrder-buttonlabel']")
	WebElement btnApproveSalesOrder;
	
	@FindBy(xpath = "//select[@title='Type of transaction.']")
	WebElement drpTransactionTypeApprSO;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearchSOTransType;
	
	
	//Action Methods:
	public void clickbtnSales()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement clickHeaderSales = wait.until(ExpectedConditions.elementToBeClickable(btnSales));
		
		clickHeaderSales.click();
	}
	
	public void btnSalesOrder()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnSalesOrder));
		
		action=new Actions(driver);
		action.doubleClick(btnSalesOrder).perform();		
	}
	
	public void clickApproveSalesOrder()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnApproveSalesOrder));
		
		action=new Actions(driver);
		action.doubleClick(btnApproveSalesOrder).perform();
	}
	
	public void setTransactionTypeApprSO(String setTransTypeApprSO)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   
		    WebElement transactionTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(drpTransactionTypeApprSO));

		    transactionTypeDropdown.click();
		 
		    select = new Select(transactionTypeDropdown);
		    select.selectByVisibleText(setTransTypeApprSO);		    	
	}
	
	public void clickSearchSOTransType()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement btnSearch = wait.until(ExpectedConditions.elementToBeClickable(btnSearchSOTransType));
		
		btnSearch.click();
	}

}
