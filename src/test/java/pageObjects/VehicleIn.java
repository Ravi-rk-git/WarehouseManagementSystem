package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class VehicleIn extends BasePage{
	
	Actions action;
	
	//Constructor
	public VehicleIn(WebDriver driver)
	{
		super(driver);
	}
			
	//Locator/Elements
	@FindBy(xpath = "//div[normalize-space()='Vehicle']")
	WebElement txtVehicleInDisplayed;
	
	@FindBy(xpath = "//div[normalize-space()='Vehicle']")
	WebElement btnHeaderVehicle;
	
	@FindBy(xpath = "//div[@id='vehicle-vehicleIn-buttonlabel']/ancestor::table[contains(@class,'MenuButton')]")
	WebElement btnVehicleIn;
	
	@FindBy(xpath = "//table[contains(@class,'MenuButton')]//div[@id='vehicle-vehicleIn-createVehicleIn-buttonlabel']")
	WebElement btnCreateVehicleIn;
		
			
	//Action Method
	public boolean txtIsVehicleIsDisplayed()
	{
		return txtVehicleInDisplayed.isDisplayed();		
	}

	public void clickBtnVehicleText() throws InterruptedException
	{
		btnHeaderVehicle.click();
		Thread.sleep(2000);
	}
	
	public void clickBtnVehicleIn()
	{
		action=new Actions(driver);
		action.doubleClick(btnVehicleIn).perform();
	}
	
	public void clickBtnCreateVehicleIn()
	{
		action=new Actions(driver);
		action.doubleClick(btnCreateVehicleIn).perform();		
	}
}
