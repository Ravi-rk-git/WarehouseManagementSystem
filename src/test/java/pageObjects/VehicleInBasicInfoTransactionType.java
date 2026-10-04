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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleInBasicInfoTransactionType extends BasePage{
	
	Select select;
	Actions action;
	
	//Constructor
	public VehicleInBasicInfoTransactionType(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Elements:
	@FindBy(xpath = "//select[@title='The type of transaction or activity associated with this vehicle.']")
	WebElement drpTransactionType;
	
	@FindBy(xpath = "//input[@title='The destination or location where this vehicle is headed.']")
	WebElement txtToLocationDock;
	
	@FindBy(xpath = "//button[normalize-space()='Finish']")
	WebElement btnFINISHbtnVehicleIn;
	
	@FindBy(xpath = "//div[contains(text(),'Vehicle In of') and contains(text(),'registered successfully.')]")
	WebElement txtSuccessMessageCreateVehicleIn;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement closeXbtnCreateVehicleIn;
	
	
	//Action Methods:
	public void clickdrpTransactionType(String setTransactionType) 
	{		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement transactiontype = wait.until(ExpectedConditions.elementToBeClickable(drpTransactionType));
				
		transactiontype.click();
		select=new Select(drpTransactionType);
		drpTransactionType.sendKeys(setTransactionType);
		
		action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void setTxtToLocationDock(String toLocation) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		WebElement txtToLocationfield = wait.until(
		    ExpectedConditions.elementToBeClickable(
		        By.xpath("//input[@title='The destination or location where this vehicle is headed.']")
		    ));

		txtToLocationfield.click();
		txtToLocationfield.clear();
		txtToLocationfield.sendKeys(toLocation);
		new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();		
	}
	
	/*
	public void clickbtnFINISHVehicleIn() throws InterruptedException
	{		
		btnFINISHbtnVehicleIn.click();
		Thread.sleep(3000);		
		
	}
	*/
	
	public void clickbtnFINISHVehicleIn() {

	    String parentWindow = driver.getWindowHandle(); //I'm getting 1 single window here.

	    btnFINISHbtnVehicleIn.click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Wait until 2 windows are available
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));//I'm getting 2 Two window here.

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
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2)); //I Need 2 windows, why rest of below 2 methods should execute.

	    //System.out.println("Current Window Title : " + driver.getTitle());
	}
	
	public String getSuccessMessageCreateVehicleIn()	
	{
		WebElement successMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(text(),'Vehicle In of') and contains(text(),'registered successfully.')]")));

		System.out.println();
		System.out.println();
		
		String SucessVehicleInCreationMessage = successMsg.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessVehicleInCreationMessage);
		System.out.println();
		System.out.println("**********************************************************************");
	
		return SucessVehicleInCreationMessage;
	}
	
	public void closeXbtnCreateVehicleInPopup() throws InterruptedException
	{
		Thread.sleep(2000);
		closeXbtnCreateVehicleIn.click();			
	}
		
	
}
