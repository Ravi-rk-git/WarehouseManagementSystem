package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleCreateVehicleOutFinalSuccessScreen extends BasePage{
	
		
	//Constructor:
	public VehicleCreateVehicleOutFinalSuccessScreen(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element:
	@FindBy(xpath = "//button[normalize-space()='Finish']")
	WebElement btnFINISHCreateVehicleOut;
	
	@FindBy(xpath = "//div[contains(text(),'Vehicle out of') and contains(text(),'registered successfully.')]")
	WebElement txtSuccessMessageCreateVehicleOut;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement closeXbtnCreateVehicleOut;
	
	
	
	//Action Method:	
	public void clickbtnFINISHCreateVehicleOut() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement btnFINISH = wait.until(ExpectedConditions.elementToBeClickable(btnFINISHCreateVehicleOut));
		
		Thread.sleep(1500);
		btnFINISH.click();
	}
	
	public String getSuccessMessageCreateVehicleOut()	
	{
		WebElement successMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(text(),'Vehicle out of') and contains(text(),'registered successfully.')]")));

		System.out.println();
		System.out.println();
		
		String SucessVehicleOutCreationMessage = successMsg.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessVehicleOutCreationMessage);
		System.out.println();
		System.out.println("**********************************************************************");
		
		return SucessVehicleOutCreationMessage;
	}
	
	public void closeXbtnCreateVehicleOutPopup() throws InterruptedException
	{
		Thread.sleep(9000);
		closeXbtnCreateVehicleOut.click();			
	}
	
	

}
