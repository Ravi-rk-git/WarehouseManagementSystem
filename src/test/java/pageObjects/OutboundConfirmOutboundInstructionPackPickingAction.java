package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutboundConfirmOutboundInstructionPackPickingAction extends BasePage{
	
	Actions action;
	Select select;
	
	//Constructor
	public OutboundConfirmOutboundInstructionPackPickingAction(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element
	@FindBy(xpath = "//div[normalize-space()='Pack Status']/ancestor::tr/following-sibling::tr//select")
	List<WebElement> packStatusDropdowns;
	
	@FindBy(xpath = "//button[normalize-space()='Save Changes']")
	WebElement btnSAVECHANGESConfirmOutboundPacks;
	
	@FindBy(xpath = "//div[contains(text(),'Pack Moved successfully.')]")
	WebElement txtSuccessMessageConfirmOutboundPacks;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement btnCloseConfirmOutboundPacks;
	
	
	
	//Action Method
	public void selectPackStatus(int packIndex, String status) throws InterruptedException {

	    WebElement dropdown = packStatusDropdowns.get(packIndex);

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait until the drop down is click able
	    wait.until(ExpectedConditions.elementToBeClickable(dropdown));

	    // Click the drop down first
	    dropdown.click();

	    Thread.sleep(700);   
	    
	    Select select = new Select(dropdown);
	    select.selectByVisibleText(status);
	}
	
	public void clickbtnSAVECHANGESConfirmOutboundPacks() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnSAVECHANGESConfirmOutboundPacks)).click();		
	}
	
	public String getSuccessMessageConfirmOutboundPacks()	
	{
		WebElement successMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(text(),'Pack Moved successfully.')]")));

		System.out.println();
		System.out.println();
				
		String SucessConfirmOutboundPacks= successMsg.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessConfirmOutboundPacks);
		System.out.println();
		System.out.println("**********************************************************************");
		
		return SucessConfirmOutboundPacks;
	}
	
	public void closeXbtnConfirmOutboundPacksPopup() throws InterruptedException
	{
		Thread.sleep(5000);
		btnCloseConfirmOutboundPacks.click();			
	}

}
