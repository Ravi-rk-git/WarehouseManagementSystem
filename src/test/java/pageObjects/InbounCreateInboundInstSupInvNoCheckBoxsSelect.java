package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InbounCreateInboundInstSupInvNoCheckBoxsSelect extends BasePage{
	
	
	//Constructor
	public InbounCreateInboundInstSupInvNoCheckBoxsSelect(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	//Action Method
	
	//It will select row check boxes based on the no of SKUs present against the single Supplier Invoice No.
	public void selectRowsBySupplierInvoice(String supplierInvoiceNo) throws InterruptedException
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    List<WebElement> invoiceCells = wait.until(
	            ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                    By.xpath("//td[@cellindex='12']//div[normalize-space()='" + supplierInvoiceNo + "']")));

	   // System.out.println("Invoice Cells = " + invoiceCells.size());

	    for (WebElement invoiceCell : invoiceCells)
	    {
	        WebElement checkbox = invoiceCell.findElement(
	                By.xpath("./ancestor::td/preceding-sibling::td[@cellindex='0']//div[contains(@class,'rowChecker')]"));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView({block:'center'});", checkbox);

	        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();

	        Thread.sleep(500);
	    }
	}
	}


