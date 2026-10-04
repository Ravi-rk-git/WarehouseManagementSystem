package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DispathNoteActionScreen extends BasePage{
	
	Actions action;
	
	//Constructor:
	public DispathNoteActionScreen(WebDriver driver)
	{
		super(driver);
	}
	
	/*
	private By getSalesOrderRow(String salesOrderNo) {
	    return By.xpath(
	        "//tr[td[normalize-space()='" + salesOrderNo + "']]"
	    );
	}

	private By getSalesOrderCheckbox(String salesOrderNo) {
	    return By.xpath(
	        "//tr[td[normalize-space()='" + salesOrderNo + "']]//input[@type='checkbox']"
	    );
	}
	*/
	
	@FindBy(xpath = "//div[@class='TabHeaderCenterText' and normalize-space()='Action']")
	WebElement btnActionOnCreateDispatchNote;
	
	
	
	public void selectSalesOrder(String salesOrderNo) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    // 1. Locate the parent row containing the target sales order
	    By rowLocator = By.xpath("//tr[td[normalize-space()='" + salesOrderNo + "']]");
	    WebElement row = wait.until(ExpectedConditions.presenceOfElementLocated(rowLocator));

	    // 2. Scroll the row into view to prevent viewport clipping or sticky header blocks
	    org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", row);

	    // 3. Find the visual check box cell or wrapper inside that row
	    WebElement checkboxBox = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//tr[td[normalize-space()='" + salesOrderNo + "']]//td[1]") // Adjust index [1] if checkbox isn't in the first td
	        )
	    );

	    // 4. Click the container cell to trigger the UI event handler
	    checkboxBox.click();
	}
	
	
	public void clickBtnActionOnCreateDispatchNote() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement action  = wait.until(ExpectedConditions.elementToBeClickable(btnActionOnCreateDispatchNote));
	
		action.click();
		Thread.sleep(1000);
	}

}
