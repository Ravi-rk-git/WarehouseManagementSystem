package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransactionLogFileUploadStatus extends BasePage{
	
	Actions action;
	
	//Constructor
	public TransactionLogFileUploadStatus(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Element/Locator:
	@FindBy(xpath ="//div[@id='administration-Interface-log-buttonlabel']")
	WebElement btnTransactionLog; 
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearch;
	
	@FindBy(xpath = "(//img[contains(@src,'clear.cache.gif')])[5]") 
	WebElement btnRefresh;
	
	@FindBy(xpath = "//div[contains(@class,'MenuLink') and text()='Receipts']")
	WebElement btnReceiptsClick;
	
	
	
	
	//Action Methods:
	public void btnTransactionLog() throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement btnClickTransactionLog = wait.until(ExpectedConditions.elementToBeClickable(btnTransactionLog));
	
		action=new Actions(driver);
		action.doubleClick(btnClickTransactionLog).perform();		
	}
	
	public void btnClickSearch()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
		
		btnSearch.click();	
	}
	
	public String getTopRowStatus() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("(//div[contains(@class,'cellInner') and " +
	                 "(normalize-space()='PROCESSING' or " +
	                 "normalize-space()='SUCCESS' or " +
	                 "normalize-space()='EXCEPTION')])[1]")));

	    return status.getText().trim();
	}
	
	
		
	public String waitForFileStatus() {
	    int maxAttempts = 60; // 60 x ~10 seconds = 10 minutes

	    for (int i = 1; i <= maxAttempts; i++) {
	        try {
	            // Ensure getTopRowStatus() finds elements fresh (avoid cached @FindBy fields)
	            String status = getTopRowStatus();
	            System.out.println("Attempt " + i + " - Current File Status: " + status);

	            if (status.equalsIgnoreCase("SUCCESS")) {
	                return "SUCCESS";
	            }

	            if (status.equalsIgnoreCase("EXCEPTION")) {
	                return "EXCEPTION";
	            }

	            Thread.sleep(8000);

	            // If btnRefresh goes stale after a page update, re-locate it or catch the exception
	            btnRefresh.click();

	        } catch (org.openqa.selenium.StaleElementReferenceException e) {
	            System.out.println("Stale element detected on attempt " + i + ". Retrying...");
	            // Decrement 'i' so this attempt doesn't count against your 60 max attempts
	            i--; 
	            try {
	                Thread.sleep(2000); // Short pause before retrying the failed interaction
	            } catch (InterruptedException ie) {
	                Thread.currentThread().interrupt();
	            }
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            throw new RuntimeException(e);
	        }
	    }

	    return "TIMEOUT";
	}
	
	
	public void ReceiptsClick()
	{
		btnReceiptsClick.click();
	}

}
