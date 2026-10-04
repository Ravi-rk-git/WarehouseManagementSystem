package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InbounConfirmInboundInstPacksCheckBoxsSelect extends BasePage{

	//Constructor
	public InbounConfirmInboundInstPacksCheckBoxsSelect(WebDriver driver)
	{
		super(driver);
	}
	
	
	//It will select row check boxes based on the no of SKUs present against the single Supplier Invoice No.
	public void selectRowsByPurchaseReference(String purchaseReferenceNo) throws InterruptedException
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    List<WebElement> purchaseRefCells = wait.until(
	            ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                    By.xpath("//td[@cellindex='50']//div[normalize-space()='" + purchaseReferenceNo + "']")));

	    //System.out.println("Purchase Reference Count = " + purchaseRefCells.size());

	    for (WebElement purchaseRefCell : purchaseRefCells)
	    {
	        WebElement checkbox = purchaseRefCell.findElement(
	                By.xpath("./ancestor::td/preceding-sibling::td[@cellindex='0']//div[contains(@class,'rowChecker')]"));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView({block:'center'});", checkbox);

	        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();

	        Thread.sleep(500);
	    }
	}
}
