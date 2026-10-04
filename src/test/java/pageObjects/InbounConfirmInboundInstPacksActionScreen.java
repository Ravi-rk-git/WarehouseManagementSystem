package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InbounConfirmInboundInstPacksActionScreen extends BasePage{

	//Constructor
	public InbounConfirmInboundInstPacksActionScreen(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Element
	@FindBy(xpath = "//div[@class='TabHeaderCenterText' and normalize-space()='Action']")
	WebElement btnActionConfirmInboundPacks;
	
	@FindBy(xpath = "//div[normalize-space()='Pack Status']/ancestor::tr/following-sibling::tr//select")
	List<WebElement> packStatusDropdowns;
	
	@FindBy(xpath = "//button[normalize-space()='Save Changes']")
	WebElement btnSAVECHANGESInboundPacks;
	
	@FindBy(xpath = "//div[contains(text(),'Pack Moved successfully.')]")
	WebElement txtSuccessMessageConfirmInboundPacks;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement btnCloseConfirmInboundPacks;
	
	
	
	
	
	//Action Methods
	public void clickActionConfirmInboundPacks()
	{
		btnActionConfirmInboundPacks.click();
	}
	
	public void selectPackStatus(int packIndex, String status) throws InterruptedException {

	    WebElement dropdown = packStatusDropdowns.get(packIndex);

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait until the drop down is click able
	    wait.until(ExpectedConditions.elementToBeClickable(dropdown));

	    // Click the drop down first
	    dropdown.click();

	    Thread.sleep(500);   
	    
	    Select select = new Select(dropdown);
	    select.selectByVisibleText(status);
	}
	
	
	public void clickbtnSAVECHANGESInboundPacks() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnSAVECHANGESInboundPacks)).click();		
	}
	
	public String getSuccessMessageConfirmInboundPacks()	
	{
		WebElement successMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(text(),'Pack Moved successfully.')]")));

		System.out.println();
		System.out.println();
				
		String SucessConfirmInboundPacks= successMsg.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessConfirmInboundPacks);
		System.out.println();
		System.out.println("**********************************************************************");
		
		return SucessConfirmInboundPacks;
	}
	
	
	public void closeXbtnConfirmInboundPacksPopup() throws InterruptedException
	{
		Thread.sleep(5000);
		btnCloseConfirmInboundPacks.click();			
	}
	
	
}
