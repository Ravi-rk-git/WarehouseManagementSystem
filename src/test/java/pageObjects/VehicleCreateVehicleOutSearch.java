package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehicleCreateVehicleOutSearch extends BasePage{
	
	
	
	//Constructor:
	public VehicleCreateVehicleOutSearch(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Element:
	@FindBy(xpath = "(//button[@type='button' and @class='gwt-Button'])[4]")
	WebElement btnSearchVehicleNo;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//div[@class='N54GXCD-q-c-com-sencha-gxt-theme-base-client-grid-CheckBoxColumnDefaultAppearance-CheckBoxColumnStyle-hdChecker']")
	WebElement txtHeaderCheckBoxSelectVehicleNo;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement btnOKOnSelectVehicleNo;
	
	@FindBy(xpath = "//button[normalize-space()='Next']")
	WebElement btnNEXTOnSearchVehicleNo;
	
	
	
	//Action Method:	
	public void clickBtnSearchVehicleNo()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement searchVehicleNo = wait.until(ExpectedConditions.elementToBeClickable(btnSearchVehicleNo));
	
		searchVehicleNo.click();
	}
	
	public void clickBtnSearch() throws InterruptedException
	{
		Thread.sleep(500);
		btnSearch.click();
	}
	
	public void selectTxtHeaderCheckBoxSelectVehicleNo()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement headerCheckBox = wait.until(ExpectedConditions.elementToBeClickable(txtHeaderCheckBoxSelectVehicleNo));
	
		headerCheckBox.click();
	}
	
	public void clickBtnOKOnSelectVehicleNo() throws InterruptedException
	{
		Thread.sleep(500);
		btnOKOnSelectVehicleNo.click();
	}
	
	public void clickbtnNEXTOnSearchVehicleNo() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement btnNext = wait.until(ExpectedConditions.elementToBeClickable(btnNEXTOnSearchVehicleNo));
		btnNext.click();
		Thread.sleep(2000);
	}

}
