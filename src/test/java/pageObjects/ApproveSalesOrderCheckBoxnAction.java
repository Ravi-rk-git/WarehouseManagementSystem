package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApproveSalesOrderCheckBoxnAction extends BasePage{
	
	//Constructor
	public ApproveSalesOrderCheckBoxnAction(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element
	@FindBy(xpath = "//div[@class='TabHeaderCenterText' and normalize-space()='Action']")
	WebElement btnActionApprSO;
	
	@FindBy(xpath = "//button[normalize-space()='Approve']")
	WebElement btnApproveSO;
	
	@FindBy(xpath = "//div[@class='LabelStyle' and contains(.,'approved successfully.')]")
	WebElement txtSuccessMessageApproveSalesOrder;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement closeXbtnApproveSalesOrder;
	
	
	public void selectSalesOrder(String soNo) throws InterruptedException
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    By checkboxLocator = By.xpath(
	        "//td[.//*[normalize-space()='" + soNo + "']]"
	        + "/preceding-sibling::td[@cellindex='0']"
	        + "//div[contains(@class,'rowChecker')]"
	    );
	    
	    Thread.sleep(600);

	    wait.until(
	        ExpectedConditions.elementToBeClickable(checkboxLocator)
	    ).click();
	    
	    Thread.sleep(800);	    
	    
	}	
	
	
	public void clickbtnActionApprSO()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement btnAction = wait.until(ExpectedConditions.elementToBeClickable(btnActionApprSO));
		
		btnAction.click();
	}
	
	
	public void clickbtnApproveSalesOrder() 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));			
		
		WebElement btnApprove = wait.until(ExpectedConditions.elementToBeClickable(btnApproveSO));		
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");		 
		
		btnApprove.click(); 	
	}
	
	
	public String getSuccessMessageApproveSalesOrder()
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement successMsg = wait.until(
	            ExpectedConditions.visibilityOf(txtSuccessMessageApproveSalesOrder));

	    String successSalesOrderApprovedMessage = successMsg.getText();
	    System.out.println();
	    System.out.println();
	    System.out.println("**********************************************************************");
	    System.out.println();
	    System.out.println(successSalesOrderApprovedMessage);
	    System.out.println();
	    System.out.println("**********************************************************************");
	    
	    return successSalesOrderApprovedMessage;
	}
	
	public String getSalesOrderNumberByRefSONo(String customerOrderNo) //For capturing customerOrderNo in CSV File Upload.
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    By soNoLocator = By.xpath(
	        "//td[@cellindex='15' and normalize-space()='" + customerOrderNo + "']"
	        + "/preceding-sibling::td[@cellindex='14']"
	    );

	    WebElement soNoElement = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(soNoLocator)
	    );

	    String soNo = soNoElement.getText().trim();

	    System.out.println("RefSO No = " + customerOrderNo);
	    System.out.println("SO No = " + soNo);

	    return soNo;
	}
	
	public void closeXbtnCreateSalesOrderPopup() throws InterruptedException
	{
		Thread.sleep(4500);
		closeXbtnApproveSalesOrder.click();	
		Thread.sleep(4000);
	}

}
