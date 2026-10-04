package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoSuppier extends BasePage{
	
	//Constructor
	public PoSuppier(WebDriver driver)
	{
		super(driver);
	}
			
	//Locator/Elements
	@FindBy(xpath = "//div[normalize-space()='Supplier']")
	WebElement txtPOSupplier;
		
			
	//Action Method
	public boolean txtPurchaseSupplier()
	{
		return txtPOSupplier.isDisplayed();
	}

}
