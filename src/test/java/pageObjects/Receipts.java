package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Receipts extends BasePage{
	
	//Constructor
		public Receipts(WebDriver driver)
		{
			super(driver);
		}
		
	//Locator/Elements
	@FindBy(xpath = "//div[@class='gwt-HTML Breadcrumb_ActionItem']")
	WebElement txtReceiptsDisplayed;
	
		
	//Action Method
	public boolean txtReceiptIsDisplayed()
	{
		return txtReceiptsDisplayed.isDisplayed();
	}

}
