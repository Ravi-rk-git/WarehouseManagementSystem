package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSalesOrderGridOrderedSKUsForBatchDetails extends BasePage{
	
	
	//Constructor:
	public CreateSalesOrderGridOrderedSKUsForBatchDetails(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Element:
	private By getBatchNoCellLocator(String skuCode) {

	    return By.xpath(
	        "//div[normalize-space()='" + skuCode + "']/ancestor::tr/td[@cellindex='6']");
	}
	
	private By getMfgDateLocator(String skuCode) {

	    return By.xpath(
	        "//div[normalize-space()='" + skuCode + "']/ancestor::tr/td[@cellindex='8']");
	}
	
	private By mfgDateCalendarTrigger = By.xpath(
	        "//div[contains(@class,'DateCellStyle-trigger')]");
	
	private By getInnerPackNoLocator(String skuCode) {
	    return By.xpath("//div[normalize-space()='" + skuCode
	        + "']/ancestor::tr/td[@cellindex='10']");
	}
	
	private By getOrderedQuantityLocator(String skuCode) {
	    return By.xpath("//div[normalize-space()='" + skuCode
	        + "']/ancestor::tr/td[@cellindex='11']");
	}
		
	
	//Action Methods:	
	
	public void enterBatchNo(String skuCode, String batchNo) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    By batchCellLocator = getBatchNoCellLocator(skuCode);
	    By batchInputLocator = By.xpath("//input[contains(@id,'input')]");

	    for (int attempt = 1; attempt <= 3; attempt++) {

	        try {

	            // Step 1: Check whether Batch input is already active
	            WebElement input = null;

	            List<WebElement> inputs = driver.findElements(batchInputLocator);

	            for (WebElement element : inputs) {

	                try {
	                    if (element.isDisplayed() && element.isEnabled()) {
	                        input = element;
	                        break;
	                    }
	                } catch (StaleElementReferenceException e) {
	                    // DOM refreshed - ignore this element and retry
	                }
	            }

	            // Step 2: If input is not active, click Batch cell
	            if (input == null) {

	                WebElement batchCell = wait.until(
	                        ExpectedConditions.presenceOfElementLocated(
	                                batchCellLocator));

	                ((JavascriptExecutor) driver).executeScript(
	                        "arguments[0].scrollIntoView({block:'center', inline:'center'});",
	                        batchCell);

	                wait.until(
	                        ExpectedConditions.elementToBeClickable(
	                                batchCellLocator));

	                // Re-find after scroll/wait because grid may have refreshed
	                batchCell = driver.findElement(batchCellLocator);

	                batchCell.click();

	                // Wait for input to appear
	                wait.until(
	                        ExpectedConditions.visibilityOfElementLocated(
	                                batchInputLocator));
	            }

	            // Step 3: IMPORTANT - Re-find the input before typing
	            input = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            batchInputLocator));

	            // Step 4: Enter Batch No.
	            input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	            input.sendKeys(batchNo);

	            // Re-find input before pressing ENTER
	            input = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            batchInputLocator));

	            input.sendKeys(Keys.ENTER);           
	           

	            System.out.println(
	                    "Batch entered successfully | SKU = "
	                    + skuCode + " | Batch = " + batchNo);

	            return;

	        } catch (StaleElementReferenceException e) {

	            System.out.println(
	                    "Stale element encountered for SKU "
	                    + skuCode
	                    + ". Retrying... Attempt "
	                    + attempt);

	        } catch (ElementClickInterceptedException e) {

	            System.out.println(
	                    "Click intercepted for SKU "
	                    + skuCode
	                    + ". Retrying... Attempt "
	                    + attempt);
	        }
	    }

	    throw new RuntimeException(
	            "Unable to enter Batch No. for SKU "
	            + skuCode
	            + " after 3 attempts.");
	}
	
	
	
	public void selectMfgDateToday(String skuCode) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    By mfgDateLocator = getMfgDateLocator(skuCode);

	    for (int attempt = 1; attempt <= 3; attempt++) {

	        try {

	            wait.until(
	                    ExpectedConditions.presenceOfElementLocated(
	                            mfgDateLocator));

	            WebElement mfgDateCell = driver.findElement(mfgDateLocator);

	            ((JavascriptExecutor) driver).executeScript(
	                    "arguments[0].scrollIntoView({block:'center', inline:'center'});",
	                    mfgDateCell);

	            mfgDateCell = driver.findElement(mfgDateLocator);

	            mfgDateCell.click();

	            WebElement calendarIcon = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(
	                            mfgDateCalendarTrigger));

	            calendarIcon.click();

	            WebElement todayButton = wait.until(
	                    ExpectedConditions.elementToBeClickable(
	                            By.xpath("//div[normalize-space()='Today']")));

	            todayButton.click();

	            return;

	        } catch (StaleElementReferenceException e) {

	            System.out.println(
	                    "MFG Date stale element for SKU "
	                    + skuCode
	                    + ". Retrying... Attempt " + attempt);

	        } catch (ElementClickInterceptedException e) {

	            System.out.println(
	                    "MFG Date click intercepted for SKU "
	                    + skuCode
	                    + ". Retrying... Attempt " + attempt);
	        }
	    }

	    throw new RuntimeException(
	            "Unable to select MFG Date for SKU "
	            + skuCode + " after 3 attempts.");
	}
	
	
	public void setInnerPackDetail(String skuCode, String innerPackNo) {

	    WebElement innerPackCell = driver.findElement(
	            getInnerPackNoLocator(skuCode));

	    Actions act = new Actions(driver);

	    act.moveToElement(innerPackCell)
	    .click()
	    .pause(Duration.ofMillis(350))
	    .sendKeys(innerPackNo)
	    .sendKeys(Keys.ENTER)
	    .pause(Duration.ofMillis(350))
	    .perform();
	}
	
	public void setOrderedQtyInOUOM(String skuCode, String quantity) {

	    WebElement quantityCell = driver.findElement(
	    		getOrderedQuantityLocator(skuCode));

	    Actions act = new Actions(driver);

	    act.moveToElement(quantityCell)
	    .click()
	    .pause(Duration.ofMillis(350))
	    .sendKeys(quantity)
	    .sendKeys(Keys.ENTER)
	    .pause(Duration.ofMillis(350))
	    .perform();
	}

}

