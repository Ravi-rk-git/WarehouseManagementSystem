package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutboundConfirmOutboundInstructionPackPickingSearchScreen extends BasePage{	
	
	
	//Constructor
	public OutboundConfirmOutboundInstructionPackPickingSearchScreen(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	
	//Locator/Element
	public By sciNoCell = By.xpath(
	        "//td[@cellindex='11']//div[normalize-space()]"
	);	
	
	@FindBy(xpath = "//div[@class='TabHeaderCenterText' and normalize-space()='Action']")
	WebElement btnActionOnConfirmOutboundPacks;
	
	
	//Action Method
	public String getSCINo() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement sciCell = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(sciNoCell));

	    return sciCell.getText().trim();
	}
	
	public void selectRowsBySCINo(String sciNo) throws InterruptedException {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    List<WebElement> sciCells = wait.until(
	            ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                    By.xpath("//td[@cellindex='11']//div[normalize-space()='" + sciNo + "']")));

	    for (WebElement sciCell : sciCells) {

	        WebElement checkbox = sciCell.findElement(
	                By.xpath("./ancestor::td/preceding-sibling::td[@cellindex='0']//div[contains(@class,'rowChecker')]"));

	        ((JavascriptExecutor) driver)
	                .executeScript(
	                        "arguments[0].scrollIntoView({block:'center'});",
	                        checkbox);

	        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();

	        Thread.sleep(500);
	    }
	}
	
	public void clickbtnActionOnConfirmOutboundPacks()
	{		
		btnActionOnConfirmOutboundPacks.click();
	}
	

}
