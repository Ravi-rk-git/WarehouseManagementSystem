package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OutboundCreateOutBoundInstructionSuccessMessage extends BasePage{
		
	
	//Constructor
	public OutboundCreateOutBoundInstructionSuccessMessage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element
	@FindBy(xpath = "//div[contains(@class,'LabelStyle') and contains(normalize-space(.),'SKU Instruction(s)') and contains(normalize-space(.),'Created Successfully.')]")
	WebElement txtSuccessMessageCreateOutbound;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement closeXbtnOutboundInstCreations;
	
	
	//Action Method
	public String getSuccessMessageCreateOutboundInst()	
	{
		WebElement successMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(@class,'LabelStyle') and contains(normalize-space(.),'SKU Instruction(s)') and contains(normalize-space(.),'Created Successfully.')]")));

		System.out.println();
		System.out.println();
				
		String SucessOutboundCreationMessage= successMsg.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessOutboundCreationMessage);
		System.out.println();
		System.out.println("**********************************************************************");
	
		return SucessOutboundCreationMessage;
	}
	
	public void clickCloseXbtnOutboundInstCreations() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement btnClose = wait.until(ExpectedConditions.elementToBeClickable(closeXbtnOutboundInstCreations));
		Thread.sleep(4000);
		btnClose.click();
	}
	
	
	

}
