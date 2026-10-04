package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutboundCreateOutBoundInstructionTransactionType extends BasePage{
	
	Actions action;
	Select select;
	
	//Constructor
	public OutboundCreateOutBoundInstructionTransactionType(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element
	@FindBy(xpath = "//select[@title='The type of transaction associated with the SKU movement (e.g., transfer, return, etc.).']")
	WebElement drpTransactionTypeCreateOutbound;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearchOnCreateOutbound;	
	
	@FindBy(xpath = "//div[@class='TabHeaderCenterText' and normalize-space()='Action']")
	WebElement btnActionOnCreateOutbound;
	
	@FindBy(xpath = "//input[@title='The destination location where the SKU movement is directed.']")
	WebElement txtSetToLocationCreateOutbound;
	
	@FindBy(xpath = "//button[normalize-space()='Save Changes']")
	WebElement btnSaveChanges;
	
	
	
	//Action Method
	public void drpTransactionTypeCreateOutboundInst(String drpTransactionType) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement drpTransType = wait.until(ExpectedConditions.elementToBeClickable(drpTransactionTypeCreateOutbound));
	
		drpTransType.click();
		
		Thread.sleep(500);
		select=new Select(drpTransType);
		select.selectByContainsVisibleText(drpTransactionType);
	}
	
	public void clickbtnSearchOnCreateOutbound()
	{
		btnSearchOnCreateOutbound.click();
	}
	
	
	/*
	public void selectCheckboxByExternalOrderRefNo(String externalOrderRefNo) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Find the row using External Order Reference
	    By rowLocator = By.xpath(
	        "//tr[.//td[contains(normalize-space(.),'" + externalOrderRefNo + "')]]"
	    );

	    WebElement row = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(rowLocator)
	    );

	    System.out.println("External Order Ref found: " + externalOrderRefNo);

	    // First column of the matching row = checkbox column
	    WebElement checkboxCell = row.findElement(
	        By.xpath("./td[1]")
	    );

	    // Scroll the checkbox cell into view
	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({block:'center'});",
	        checkboxCell
	    );

	    // Click checkbox cell
	    wait.until(ExpectedConditions.elementToBeClickable(checkboxCell));

	    checkboxCell.click();

	    System.out.println("Checkbox selected for: " + externalOrderRefNo);
	}
	*/
	
	

	//Note: With Below method Check box selection for Proper ExternalOrderNo issue resolved.
	//Note: Method for SO UI Upload ExternalReference Order Number reading:
	public void selectCheckboxByExternalOrderRefNo(String externalOrderRefNo) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Reusing the exact proven pattern from your selectSalesOrder method
	    By checkboxLocator = By.xpath(
	        "//td[.//*[normalize-space()='" + externalOrderRefNo + "']]"
	        + "/preceding-sibling::td[@cellindex='0']"
	        + "//div[contains(@class,'rowChecker')]"
	    );

	    Thread.sleep(600);

	    try {
	        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxLocator));
	        
	        // Optional: scroll into view to ensure it's clickable if it's outside the viewport
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", checkbox);
	        Thread.sleep(300);

	        checkbox.click();
	        Thread.sleep(800);

	        System.out.println("Successfully selected checkbox for External Order Ref: " + externalOrderRefNo);

	    } catch (Exception e) {
	        System.err.println("Failed to select checkbox for External Order Ref: " + externalOrderRefNo);
	        throw new RuntimeException(e);
	    }
	}
	
	//Note: Method for SO CSV Upload Customer Order Number reading:
	public void selectCheckboxByCustomerOrderNo(String customerOrderNo) throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    By checkboxLocator = By.xpath(
	        "//td[.//*[normalize-space()='" + customerOrderNo + "']]"
	        + "/preceding-sibling::td[@cellindex='0']"
	        + "//div[contains(@class,'rowChecker')]"
	    );

	    Thread.sleep(600);

	    try {
	        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxLocator));

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(
	            "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",
	            checkbox
	        );

	        Thread.sleep(300);

	        checkbox.click();
	        Thread.sleep(800);

	        System.out.println(
	            "Successfully selected checkbox for Customer Order No: " + customerOrderNo
	        );

	    } catch (Exception e) {
	        System.err.println(
	            "Failed to select checkbox for Customer Order No: " + customerOrderNo
	        );
	        throw new RuntimeException(e);
	    }
	}	
	
	
	public void clickbtnActionOnCreateOutbound() throws InterruptedException
	{
		Thread.sleep(1000);
		btnActionOnCreateOutbound.click();
	}
	
	public void setToLocationCreateOutbound(String toLocationDispacth) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement toLocation = wait.until(ExpectedConditions.elementToBeClickable(txtSetToLocationCreateOutbound));
				
		toLocation.click();
		Thread.sleep(500);
		toLocation.sendKeys(toLocationDispacth);		
		
		toLocation.sendKeys(Keys.TAB);
	}
	
	public void clickbtnSaveChanges() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;	    
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", btnSaveChanges);

	    Thread.sleep(1000);
	    btnSaveChanges.click();
	}

}
