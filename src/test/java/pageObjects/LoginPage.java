package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	// 1)Constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	// 2)Locators/Elements
	@FindBy(xpath = "//input[@type='text']")
	WebElement txtLoginName;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btnLogin;
	
	
	// 3)Action Methods
	public void setLoginName(String loginName)
	{
		txtLoginName.sendKeys(loginName);
	}

	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
}
