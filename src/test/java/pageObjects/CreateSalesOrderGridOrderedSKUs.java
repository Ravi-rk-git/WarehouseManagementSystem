package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSalesOrderGridOrderedSKUs extends BasePage{
	
	
	//Constructor:
	public CreateSalesOrderGridOrderedSKUs(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Element:
	@FindBy(xpath = "//input[@title='Code of the Stock Keeping Unit (SKU).']")
	WebElement txtSKUCodesales;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearchSO;
	
	@FindBy(xpath = "//div[@class='N54GXCD-q-c-com-sencha-gxt-theme-base-client-grid-CheckBoxColumnDefaultAppearance-CheckBoxColumnStyle-hdChecker']")
	WebElement HeaderCheckBoxSKUCodeSO;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement btnOKskuCodeSO;
	
	
	
	
	//Action Methods:
	public void setSKUCodeData(String SKUCodeSO) 
	{
		 WebElement txt = new WebDriverWait(driver, Duration.ofSeconds(10))
		            .until(ExpectedConditions.visibilityOf(txtSKUCodesales));		            		

		    txt.clear();
		    txt.sendKeys(SKUCodeSO);
	}
	
	public void clickbtnSearchSO()
	{
		btnSearchSO.click();
	}

	public void selectkHeaderCheckBoxSKUCodeSO()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(HeaderCheckBoxSKUCodeSO));
	
		checkbox.click();
	}
	
	public void clickbtnOKskuCodeSO() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement clickOKbtn = wait.until(ExpectedConditions.elementToBeClickable(btnOKskuCodeSO));
		
		clickOKbtn.click();
		Thread.sleep(1000);		
	}
}
