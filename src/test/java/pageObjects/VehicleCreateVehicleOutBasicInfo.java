package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleCreateVehicleOutBasicInfo extends BasePage{
	
		
	//Constructor:
	public VehicleCreateVehicleOutBasicInfo(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element:
	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement btnNEXTonVehicleOutBasicInfo;	
	
	
	
	//Action Method:	
	public void clickBtnNEXTonVehicleOutBasicInfo() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement btnNEXT = wait.until(ExpectedConditions.elementToBeClickable(btnNEXTonVehicleOutBasicInfo));
		
		Thread.sleep(1500);
		btnNEXT.click();
	}
	
	

}
