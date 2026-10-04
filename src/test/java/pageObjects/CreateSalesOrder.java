package pageObjects;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSalesOrder extends BasePage{
	
	Actions action;
	Select select;
	
	//Constructor:
	public CreateSalesOrder(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Element
	@FindBy(xpath = "(//td[normalize-space()='Customer Code']/following::input[@type='text' and not(@disabled)])[1]")
	WebElement txtCustomerCodeSales;	
	
	@FindBy(xpath = "//input[@title=\"Customer's order number.\"]")
	WebElement txtCustomerOrderNoSales;	
	
	@FindBy(xpath = "//select[@title='Trade term for the sales order.']")
	WebElement drpTradeTermSales;
	
	@FindBy(xpath = "//select[@title='Type of the sales order.']")
	WebElement drpSOTypeSales;
	
	@FindBy(xpath = "//select[@title='Billing address for the sales order.']")
	WebElement drpBillToSales;
	
	@FindBy(xpath = "//td[normalize-space()='Ship To Code']/following::select[1]")
	WebElement drpShipToCodeSales;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement btnADDsales;
		
	
	//Action Methods:
	public void setCustomerCodeSales(String customerCode) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(txtCustomerCodeSales)).click();
		
		txtCustomerCodeSales.sendKeys(customerCode);
		
		action=new Actions(driver);
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).perform();			
	}
	/*
	public void settxtCustomerOrderNoSales()
	{
		String generatedStringCustomerOrderNo = RandomStringUtils.secure().nextAlphabetic(3).toUpperCase();
	    String generatedNumberCustomerOrderNo = RandomStringUtils.secure().nextNumeric(6);

	    String customerOrderNo = "CUST-ORD" + generatedStringCustomerOrderNo + "-" + generatedNumberCustomerOrderNo;

	    txtCustomerOrderNoSales.sendKeys(customerOrderNo); 
	    
	}
	*/
	
	public String settxtCustomerOrderNoSales()
	{
		String generatedStringCustomerOrderNo = RandomStringUtils.secure().nextAlphabetic(3).toUpperCase();
	    String generatedNumberCustomerOrderNo = RandomStringUtils.secure().nextNumeric(6);

	    String customerOrderNo = "CUST-ORD" + generatedStringCustomerOrderNo + "-" + generatedNumberCustomerOrderNo;

	    txtCustomerOrderNoSales.sendKeys(customerOrderNo); 
	    
	    return customerOrderNo;
	    
	}
	
	public void setdrpTradeTermSales(String tradeTermSales)
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(drpTradeTermSales));

		    dropdown.click();

		    select = new Select(dropdown);
		    select.selectByVisibleText(tradeTermSales);				
	}
	
	public void setdrpSOTypeSales(String drpSOType)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(drpSOTypeSales));
	
		dropdown.click();
		
		select = new Select(dropdown);
		select.selectByVisibleText(drpSOType);	
	}
	
	public void setdrpBillToSales(String drpBillTo)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(drpBillToSales));
		
		dropdown.click();
		
		select = new Select(dropdown);
		select.selectByVisibleText(drpBillTo);
	}
	
	public void setdrpShipToCodeSales(String ShipToCodeSales)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement drpdown = wait.until(ExpectedConditions.elementToBeClickable(drpShipToCodeSales));
		
		drpdown.click();
		
		select = new Select(drpdown);
		select.selectByVisibleText(ShipToCodeSales);
	}
	
	/* Before Code
	public void clickADDsales() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement btnADD = wait.until(ExpectedConditions.elementToBeClickable(btnADDsales));
		
		btnADD.click(); //first click
		Thread.sleep(1000);		
	}*/
	
	public void clickADDsales() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement btnADD = wait.until(ExpectedConditions.elementToBeClickable(btnADDsales));
		
		btnADD.click(); //first click
		Thread.sleep(1000);		
	}

}
