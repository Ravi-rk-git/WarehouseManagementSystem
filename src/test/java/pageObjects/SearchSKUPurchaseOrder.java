package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchSKUPurchaseOrder extends BasePage{
	
	//Constructor
	public SearchSKUPurchaseOrder(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locators/Element
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement btnAddPO;	
	
	By skuTextbox = By.xpath("//input[@title='The unique code assigned to the Stock Keeping Unit (SKU) for identification purposes.']");
	//WebElement txtSKUCode;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchbtn;
	
	@FindBy(xpath = "//div[@class='N54GXCD-q-c-com-sencha-gxt-theme-base-client-grid-CheckBoxColumnDefaultAppearance-CheckBoxColumnStyle-hdChecker']")
	WebElement chkSKUsPO;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement btnOK;	
	
	
	
	//Action Methods
	public void btnAddPurchaseOrder()
	{
		btnAddPO.click();
	}
		
	public void setSKUCodeData(String SKUCode) 
	{
		 WebElement txt = new WebDriverWait(driver, Duration.ofSeconds(10))
		            .until(ExpectedConditions.visibilityOfElementLocated(skuTextbox));

		    txt.clear();
		    txt.sendKeys(SKUCode);
	}
	
	public void clickSearchbtn()
	{
		searchbtn.click();
	}
	
	public void clickCheckBoxSKUCodes()
	{
		chkSKUsPO.click();
	}
	
	public void clickbtnOK() throws InterruptedException
	{
		Thread.sleep(1000);
		btnOK.click();
		Thread.sleep(2000);
	}	

}
