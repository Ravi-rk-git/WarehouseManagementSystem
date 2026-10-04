package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	//1)Constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//2)Locators/Elements
	@FindBy(xpath = "(//input[@type='text' and contains(@class,'Widget-Control-Textbox')])[2]")
	WebElement txtPrimaryCompany;
	
	@FindBy(xpath = "//div[contains(@class,'MenuLink') and text()='Receipts']")
	WebElement btnReceipts1;
	
	@FindBy(xpath = "//div[contains(@class,'MenuLink') and text()='Receipts']")
	WebElement btnReceipts2;	
	
	
	//3)Action Methods
	public void setPrimaryCompany(String primaryCompany)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(txtPrimaryCompany));
		
		txtPrimaryCompany.sendKeys(primaryCompany);
	}
	
	public void clickReceipts1()
	{
		btnReceipts1.click();
	}
	
	public void clickReceipts2() throws InterruptedException
	{
		Thread.sleep(1500);
		btnReceipts2.click();
	}	
		
}
