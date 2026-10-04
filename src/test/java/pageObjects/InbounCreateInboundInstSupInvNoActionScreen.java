package pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InbounCreateInboundInstSupInvNoActionScreen extends BasePage{
	
	
	//Constructor
	public InbounCreateInboundInstSupInvNoActionScreen(WebDriver driver)
	{
		super(driver);
	}
	
		
	//Locator/Element
	@FindBy(xpath = "//div[@class='TabHeaderCenterText' and normalize-space()='Action']")
	WebElement btnActionInbountInstSupIn;
	
	@FindBy(xpath = "//input[@title='The destination location.']")
	WebElement txtToLocationInboundSupInNo;
	
	@FindBy(xpath = "//button[normalize-space()='Save Changes']")
	WebElement btnSAVECHANGESinboundInstSupInv;
	
	@FindBy(xpath = "//div[contains(text(),'SKU Instruction(s)') and contains(text(),'Created Successfully.')]")
	WebElement txtSuccessMessageInboundInsSupInv;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement closeXbtnInboundInstSupInvNo;



	//Action Method:
	public void clickActionInbountInstSupIn()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnActionInbountInstSupIn)).click();		
	}
	
	public void setToLocationInboundSupInNo(String toLocatioInbountSupInNo)
	{
		txtToLocationInboundSupInNo.sendKeys(toLocatioInbountSupInNo);
		
		Actions action=new Actions(driver);
		action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
	
	public void clickSaveChangesInbountInstSupIn()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(btnSAVECHANGESinboundInstSupInv)).click();		
	}
	
	public String getSuccessMessageInboundInsSupInvNo()	
	{
		WebElement successMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(text(),'SKU Instruction(s)') and contains(text(),'Created Successfully.')]")));

		System.out.println();
		System.out.println();
				
		String SucessInboundSupInCreationMessage= successMsg.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessInboundSupInCreationMessage);
		System.out.println();
		System.out.println("**********************************************************************");
		
		return SucessInboundSupInCreationMessage;
	}
	
	public void closeXbtnInboundInstSupInvNos() throws InterruptedException 
	{
		String parentWindow = driver.getWindowHandle(); //I'm getting 1 single window ID here.
		
		closeXbtnInboundInstSupInvNo.click();		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Wait until 2 windows are available
	    wait.until(ExpectedConditions.numberOfWindowsToBe(3));//I'm getting 2 Two window ID here.

	    Set<String> allWindows = driver.getWindowHandles();

	    for (String window : allWindows) {
	        if (!window.equals(parentWindow)) {
	            driver.switchTo().window(window);
	            //System.out.println("Report Window Title : " + driver.getTitle());
	           // driver.close();
	            break;
	        }
	    }

	    // Switch back to parent
	    driver.switchTo().window(parentWindow);

	    // Wait until only one window remains
	    wait.until(ExpectedConditions.numberOfWindowsToBe(3)); //I Need 2 windows, why rest of below 2 methods should execute.

	    //System.out.println("Current Window Title : " + driver.getTitle());
	    
	    Thread.sleep(3000);
	}
	
}