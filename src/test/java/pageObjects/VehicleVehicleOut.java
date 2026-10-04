package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleVehicleOut extends BasePage{
	
	Actions action;
	
	//Constructor:
	public VehicleVehicleOut(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element:
	@FindBy(xpath = "//div[normalize-space()='Vehicle']")
	WebElement btnHeaderVehicle;
	
	@FindBy(xpath = "//div[@id='vehicle-vehicleOut-buttonlabel']")
	WebElement btnVehicleOut;
	
	
	
	
	//Action Method:
	public void clickBtnHeaderVehicle()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement vehicle = wait.until(ExpectedConditions.elementToBeClickable(btnHeaderVehicle));
		
		vehicle.click();
	}
	
	public void clickBtnVehicleOut() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement vehicleOut = wait.until(ExpectedConditions.elementToBeClickable(btnVehicleOut));
		
		action=new Actions(driver);
		Thread.sleep(1000);
		action.doubleClick(vehicleOut).perform();
	}

}
