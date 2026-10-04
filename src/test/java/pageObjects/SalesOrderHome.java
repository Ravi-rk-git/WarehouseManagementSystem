package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesOrderHome extends BasePage{
	
	Actions action;
	Select select;
	
	//Constructor:
	public SalesOrderHome(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element:
	@FindBy(xpath = "//td[normalize-space()='Sales']")
	WebElement btnSales;
	
	@FindBy(xpath = "//div[@id='sales-salesOrder-buttonlabel']")
	WebElement btnSalesOrder;
	
	@FindBy(xpath = "//div[@id='sales-salesOrder-createSalesOrder-buttonlabel']")
	WebElement btnCreateSalesOrder;
	
	@FindBy(xpath = "//select[@title='Type of transaction.']")
	WebElement drpTransactionTypeApprSO;
	
	
	
	//Action Methods:
	public void clickbtnSales()
	{
		btnSales.click();
	}
	
	public void doubleclickSalesOrder()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnSalesOrder));
		
		action=new Actions(driver);
		action.doubleClick(btnSalesOrder).perform();
	}	
		
	public void doubleclickCreateSalesOrder()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnCreateSalesOrder));
		
		action=new Actions(driver);
		action.doubleClick(btnCreateSalesOrder).perform();
	}

}
