package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleCreateVehicleOut extends BasePage{
	
	Actions action;
	
	//Constructor:
	public VehicleCreateVehicleOut(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element:
	@FindBy(xpath = "//div[@id='vehicle-vehicleOut-createVehicleOut-buttonlabel']")
	WebElement btnCreateVehicleOut;
	
	
	
	//Action Method:
	
	public void clickbtnCreateVehicleOut() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement createVehicleOut = wait.until(ExpectedConditions.elementToBeClickable(btnCreateVehicleOut));
		
		action=new Actions(driver);
		Thread.sleep(1000);
		action.doubleClick(createVehicleOut).perform();
	}

}
