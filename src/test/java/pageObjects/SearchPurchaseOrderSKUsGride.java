package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPurchaseOrderSKUsGride extends BasePage{
	
	//Constructor
		public SearchPurchaseOrderSKUsGride(WebDriver driver)
		{
			super(driver);
		}	
	
	//Locator/Elements
	//Note:- Below same Dynamic XPATH contains for multiple SKUs on the grid-level I have written like this.
	private WebElement getQtyCell(String skuCode) { //This is a method that accepts one parameter.
	    return driver.findElement(By.xpath( //It sends the found element back to the place where the method was called.
	        "//div[text()='" + skuCode + "']/ancestor::tr/td[@cellindex='5']")); //this builds the XPath dynamically for all SKUss.
	}
	
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement btnSavePO;
	
	@FindBy(xpath = "//div[contains(text(),'Purchase Order(s)') and contains(text(),'created and approved Successfully.')]")
	WebElement txtSuccessMessagePO;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement closeXbtnPO;
	

	//Action Method
	public void enterQuantity(String skuCode, String qty) {

	    WebElement qtyCell = getQtyCell(skuCode);

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].scrollIntoView({block:'center'});", qtyCell);

	    new Actions(driver)
	            .moveToElement(qtyCell)
	            .click()
	            .pause(Duration.ofMillis(400))
	            .sendKeys(qty)
	            .sendKeys(Keys.ENTER)
	            .perform();
	}	
	
	public void clickBtnSavePurchaseOrder() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement savePO = wait.until(ExpectedConditions.elementToBeClickable(btnSavePO));
		savePO.click();
		Thread.sleep(3000);
	}
	
	public String txtSucessMessagePurchaseOrder()
	{
		String SucessPOCreationMessage= txtSuccessMessagePO.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessPOCreationMessage);
		System.out.println();
		System.out.println("**********************************************************************");
		
		return SucessPOCreationMessage;
	}
	
	public void clickCloseXbtnPO() throws InterruptedException
	{
		Thread.sleep(2000);
		closeXbtnPO.click();		
	}
}
