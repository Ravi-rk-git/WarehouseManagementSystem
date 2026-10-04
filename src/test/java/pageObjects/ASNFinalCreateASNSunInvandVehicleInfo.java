package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ASNFinalCreateASNSunInvandVehicleInfo extends BasePage{
	
	// 1)Constructor
		public ASNFinalCreateASNSunInvandVehicleInfo(WebDriver driver)
		{
			super(driver);
		}
	
	
	//Locator/Elements:
	@FindBy(xpath = "//button[normalize-space()='Finish' and not(contains(@style,'display: none'))]")
	WebElement bytFINISHCreateASN;
	
	@FindBy(xpath = "//div[contains(text(),'Advance Shipping Note(s)') and contains(text(),'created Successfully.')]")
	WebElement txtSuccessMessageASN;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement closeXbtnASN;
	
	//Action Method:
	public void clickFINISHbtnFinalOnCreateASN()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		WebElement bytFINISHCreateASN = wait.until(
		    ExpectedConditions.elementToBeClickable(
		        By.xpath("//button[normalize-space()='Finish' and not(contains(@style,'display: none'))]")
		    ));

		bytFINISHCreateASN.click();		
	}
	
	
	public String txtSuccessMessageAdvancedShippingNote()	
	{
		WebElement successMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(text(),'Advance Shipping Note(s)') and contains(text(),'created Successfully.')]")));

		System.out.println();
		System.out.println();
				
		String SucessASNCreationMessage= successMsg.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessASNCreationMessage);
		System.out.println();
		System.out.println("**********************************************************************");
	
		return SucessASNCreationMessage;
	}

	
	public void clickCloseXbtnASN() throws InterruptedException
	{
		Thread.sleep(2000);
		closeXbtnASN.click();		
	}
}
