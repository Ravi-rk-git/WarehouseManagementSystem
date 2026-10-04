package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleInBasicInfo extends BasePage{
	
	//Constructor
	public VehicleInBasicInfo(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Elements
	@FindBy(xpath = "//button[@title='Enter a vehicle number to search for a specific vehicle.']")
	WebElement btnSearchVehicleNo;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearchVehicleIn;

	@FindBy(xpath = "//div[@class='N54GXCD-q-c-com-sencha-gxt-theme-base-client-grid-CheckBoxColumnDefaultAppearance-CheckBoxColumnStyle-hdChecker']")
	WebElement txtHeaderCheckBoxSelectVehicleNo;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement btnOKSelectVehicleNo;
	
	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement btnNEXTBasicInfo;
	
	//ActionMethod
	public void clickSearchVehicleNo()
	{
		btnSearchVehicleNo.click();
	}
	
	public void btnSearchVehicleIn() throws InterruptedException
	{
		btnSearchVehicleIn.click();
		Thread.sleep(2000);
	}
	
	public void clickHeaderCheckBoxSelectVehicleNo() 
	{
		txtHeaderCheckBoxSelectVehicleNo.click();		
	}
	
	public void clickOKbtnSelectVehicleNo() throws InterruptedException
	{
		btnOKSelectVehicleNo.click();
		Thread.sleep(1000);
	}
	
	public void clickNEXTbtnBasicInfo() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement btnNext = wait.until(ExpectedConditions.elementToBeClickable(btnNEXTBasicInfo));
		btnNext.click();
		Thread.sleep(2000);
	}
}
