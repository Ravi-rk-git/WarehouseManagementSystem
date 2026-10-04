package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SetupPage extends BasePage{
	
	//Constructor
	public SetupPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Elements
	@FindBy(xpath = "//div[contains(@class,'MenuLink') and text()='Setup']")
	WebElement msgHeading;
	
	//Action Method
	public boolean isSetupPageExist()
	{
		try
		{
		Thread.sleep(5000);	
		return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
