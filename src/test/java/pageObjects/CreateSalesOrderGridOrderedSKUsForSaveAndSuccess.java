package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateSalesOrderGridOrderedSKUsForSaveAndSuccess extends BasePage{
	
	
	//Constructor:
	public CreateSalesOrderGridOrderedSKUsForSaveAndSuccess(WebDriver driver){
		
		super(driver);
	}
	
	
	//Action Methods:	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSAVEsalesOrder;
	
	@FindBy(xpath = "//div[contains(text(),'Sales Order(s)') and contains(text(),'created successfully.')]")
	WebElement txtSuccessMessageCreateSalesOrder;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement closeXbtnCreateSalesOrder;
	
	
	
	//Action Methods:
	public void clickSAVEsalesOrder()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement btnSaveSO = wait.until(ExpectedConditions.elementToBeClickable(btnSAVEsalesOrder));
		
		btnSaveSO.click();
	}
	
	/* @Before
	public void getSuccessMessageCreateSalesOrder()	
	{
		WebElement successMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(text(),'Sales Order(s)') and contains(text(),'created successfully.')]")));

		System.out.println();
		System.out.println();
				
		String SucessSalesOrderCreationMessage= successMsg.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessSalesOrderCreationMessage);
		System.out.println();
		System.out.println("**********************************************************************");
	}*/
	
	public String getSuccessMessageCreateSalesOrder()	
	{
		WebElement successMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(text(),'Sales Order(s)') and contains(text(),'created successfully.')]")));

		System.out.println();
		System.out.println();
				
		String SucessSalesOrderCreationMessage= successMsg.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessSalesOrderCreationMessage);
		System.out.println();
		System.out.println("**********************************************************************");
		
		 // I'm Extracting SO Number
	    String soNo = SucessSalesOrderCreationMessage
	            .replace("Sales Order(s)", "")
	            .replace("created successfully.", "")
	            .trim();

	    return soNo;
	}
	
	
	public void closeXbtnCreateSalesOrderPopup() throws InterruptedException
	{
		Thread.sleep(5000);
		closeXbtnCreateSalesOrder.click();			
	}

}
