package pageObjects;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ASNSKUDetailsWithPOGrid extends BasePage{
	
	//Constructor
		public ASNSKUDetailsWithPOGrid(WebDriver driver)
		{
			super(driver);
		}
		
	//Locators/Element
		
		public WebElement getBatchNo(String skuCode) {
	        return driver.findElement(By.xpath(
	            "//div[normalize-space()='" + skuCode + "']/ancestor::tr/td[count(//td[normalize-space()='Batch No']/preceding-sibling::td)+4]"
	        ));
	    }
		
		
		public WebElement getMfgDateCell(String skuCode) {
		    return driver.findElement(By.xpath(
		        "//div[normalize-space()='" + skuCode + "']/ancestor::tr/td[count(//td[normalize-space()='Mfg Dt']/preceding-sibling::td)+5]"
		    ));
		}
		
		public WebElement getExpiryDtCell(String skuCode) {
		    return driver.findElement(By.xpath(
		        "//div[normalize-space()='" + skuCode + "']/ancestor::tr/td[count(//td[normalize-space()='Mfg Dt']/preceding-sibling::td)+4]"
		    ));
		}
		
		public WebElement getShippedQtyBillingUOMCell(String skuCode) {
		    return driver.findElement(By.xpath(
		        "//div[normalize-space()='" + skuCode + "']/ancestor::tr/td[count(//td[normalize-space()='Shipped Qty(Billing UOM)']/preceding-sibling::td)+9]"
		    ));
		}
		
		public WebElement getInnerPackNoCell(String skuCode) {
		    return driver.findElement(By.xpath(
		        "//div[normalize-space()='" + skuCode + "']/ancestor::tr/td[count(//td[normalize-space()='Inner Pack No']/preceding-sibling::td)+19]"
		    ));
		}
		
		public WebElement getInnerPackTypeCell(String skuCode) {
		    return driver.findElement(By.xpath(
		        "//div[normalize-space()='" + skuCode + "']/ancestor::tr/td[count(//td[normalize-space()='Inner Pack Type']/preceding-sibling::td)+18]"
		    ));
		}
		
		@FindBy(xpath = "//button[normalize-space()='Next' and not(contains(@style,'display: none'))]")
		WebElement btnNextInSKUPOGridASN;
		
		
		
		//Adding "ExpiryDate" hidden Column.
		@FindBy(xpath = "//span[normalize-space()='SKU Code']") //Mouse Over on SKUCode
		WebElement skuCodeHeader;
		
		@FindBy(xpath = "//span[normalize-space()='SKU Code']/following-sibling::a")
		WebElement skuCodeDownArrow;
		
		@FindBy(xpath = "//span[normalize-space()='Columns']")
		WebElement columnsMenu;
		
		@FindBy(xpath = "//span[normalize-space()='Expiry Dt']")
		WebElement expiryDateOption;
		
		@FindBy(xpath = "//div[normalize-space()='Vehicle No']")
		WebElement clickingAwayAfterExpiryColumn;
		
		

		 //Action Methods
//----------------------------------------------------------------------------------------------------
		 /* before Method
		 public void enterBatchNo(String skuCode) {

			    String batchNo = "BTCH-" + RandomStringUtils.secure().nextNumeric(5);

			    WebElement cell = new WebDriverWait(driver, Duration.ofSeconds(10))
			            .until(ExpectedConditions.elementToBeClickable(getBatchNo(skuCode)));

			    cell.click();

			    new Actions(driver)
			            .sendKeys(batchNo)
			            .perform();
			}
		 */
		
		public String enterBatchNo(String skuCode) {

		    String batchNo = "BTCH-" + RandomStringUtils.secure().nextNumeric(5);

		    WebElement cell = new WebDriverWait(driver, Duration.ofSeconds(10))
		            .until(ExpectedConditions.elementToBeClickable(getBatchNo(skuCode)));

		    cell.click();

		    new Actions(driver)
		            .sendKeys(batchNo)
		            .perform();

		    return batchNo;
		}
//---------------------------------------------------------------------------------------------------
		
		 /*
		 public void selectMfgDateToday(String skuCode) {

			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			    // Step 1: Click the MFG Date cell
			    WebElement mfgDateCell = wait.until(
			            ExpectedConditions.elementToBeClickable(getMfgDateCell(skuCode)));
			    mfgDateCell.click();

			    // Step 2: Click the Calendar icon
			    WebElement calendarIcon = wait.until(
			            ExpectedConditions.elementToBeClickable(
			                    By.xpath("//div[contains(@class,'trigger')]")));
			    calendarIcon.click();

			    // Step 3: Click the Today button
			    WebElement todayButton = wait.until(
			            ExpectedConditions.elementToBeClickable(
			                    By.xpath("//div[normalize-space()='Today']")));
			    todayButton.click();
			}
		 */
		
		
		 public void selectMfgDateToday(String skuCode) {

			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			    // Step 1: Click the MFG Date cell
			    WebElement mfgDateCell = wait.until(
			            ExpectedConditions.elementToBeClickable(getMfgDateCell(skuCode)));
			    mfgDateCell.click();

			    // Step 2: Click the Calendar icon
			    WebElement calendarIcon = wait.until(
			            ExpectedConditions.elementToBeClickable(
			                    By.xpath("//div[contains(@class,'trigger')]")));
			    calendarIcon.click();

			    // Step 3: Click the Today button
			    WebElement todayButton = wait.until(
			            ExpectedConditions.elementToBeClickable(
			                    By.xpath("//div[normalize-space()='Today']")));
			    todayButton.click();
			}
		 
//-------------------------------------------------------------------------------------------------

		 
		 public void enterExpiryDate(String skuCode, String expiryDate) {

			    WebElement expiryCell = getExpiryDtCell(skuCode);

			    Actions act = new Actions(driver);

			    act.moveToElement(expiryCell)
			       .click()
			       .pause(Duration.ofMillis(500))
			       .sendKeys(expiryDate)
			       .pause(Duration.ofMillis(200))
			       .sendKeys(Keys.TAB)
			       .perform();
			}
		 
		 
//---------------------------------------------------------------------------------------------------
		 /*Before
		 public void setShippedQtyBillingUOM(String skuCode, String shippedQty) {

			    WebElement shippedQtyCell = getShippedQtyBillingUOMCell(skuCode);

			    Actions act = new Actions(driver);

			    act.moveToElement(shippedQtyCell)
			       .click()
			       .pause(Duration.ofMillis(500))
			       .sendKeys(shippedQty)
			       .perform();
			}*/
		 
		 public String setShippedQtyBillingUOM(String skuCode, String shippedQty) {

			    WebElement shippedQtyCell = getShippedQtyBillingUOMCell(skuCode);

			    Actions act = new Actions(driver);

			    act.moveToElement(shippedQtyCell)
			       .click()
			       .pause(Duration.ofMillis(500))
			       .sendKeys(shippedQty)
			       .perform();
			    
			    return shippedQty;
			}
		 
//---------------------------------------------------------------------------------------------------
		 /* Before
		 public void setInnerPackDetail(String skuCode) {

			    String generatedStringInnerPackASN = RandomStringUtils.secure()
			            .nextAlphabetic(3)
			            .toUpperCase();

			    String generatedNumberInnerPackASN = RandomStringUtils.secure()
			            .nextNumeric(5);

			    String innerPackNo = "PACK-" + generatedStringInnerPackASN + generatedNumberInnerPackASN;

			    WebElement innerPackCell = getInnerPackNoCell(skuCode);

			    Actions act = new Actions(driver);

			    act.moveToElement(innerPackCell)
			       .click()
			       .pause(Duration.ofMillis(500))
			       .sendKeys(innerPackNo)
			       .perform();
			}
			*/
		 
		 public String setInnerPackDetail(String skuCode) {

			    String generatedStringInnerPackASN = RandomStringUtils.secure()
			            .nextAlphabetic(3)
			            .toUpperCase();

			    String generatedNumberInnerPackASN = RandomStringUtils.secure()
			            .nextNumeric(5);

			    String innerPackNo = "PACK-" + generatedStringInnerPackASN + generatedNumberInnerPackASN;

			    WebElement innerPackCell = getInnerPackNoCell(skuCode);

			    Actions act = new Actions(driver);

			    act.moveToElement(innerPackCell)
			       .click()
			       .pause(Duration.ofMillis(500))
			       .sendKeys(innerPackNo)
			       .perform();
			    
			    System.out.println(
			            "Inner Pack generated | SKU = "
			            + skuCode + " | Inner Pack = " + innerPackNo);

			    return innerPackNo;
			}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 public void setInnerPackType(String skuCode, String innerPackType) throws InterruptedException {

			    WebElement innerPackTypeCell = getInnerPackTypeCell(skuCode);

			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.elementToBeClickable(innerPackTypeCell));

			    new Actions(driver)
			    .moveToElement(innerPackTypeCell)
			    .doubleClick()
			    .perform();

			Thread.sleep(500);

			new Actions(driver)
			    .sendKeys(innerPackType)
			    .sendKeys(Keys.ENTER)
			    .perform();
			}
		 
		 
		 public void clickNextInSKUPOGridASN() throws InterruptedException
		 {
			 JavascriptExecutor jsToScroll= (JavascriptExecutor) driver;
				jsToScroll.executeScript("arguments[0].scrollIntoView(true);", btnNextInSKUPOGridASN);

				btnNextInSKUPOGridASN.click();
				Thread.sleep(1500);
		 }
		 
		 
		 /*
		 // Note:
		 // I have to use this Code only "If Expiry-Date Column NOT added to the Grid by default".(my reference).
		 
		 public void enableExpiryDateColumn() throws InterruptedException {

			    // Check if Expiry Dt column is already visible in the grid
			    if (driver.findElements(By.xpath("//span[normalize-space()='Expiry Dt' and contains(@class,'gxt-columnheader')]")).isEmpty()) {

			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        Actions actions = new Actions(driver);

			        // Step 1 - Move mouse over SKU Code header
			        actions.moveToElement(skuCodeHeader).perform();

			        // Step 2 - Wait for Down Arrow to become visible and click it
			        wait.until(ExpectedConditions.visibilityOf(skuCodeDownArrow));
			        wait.until(ExpectedConditions.elementToBeClickable(skuCodeDownArrow)).click();

			        Thread.sleep(500);

			        // Step 3 - Click Columns
			        wait.until(ExpectedConditions.elementToBeClickable(columnsMenu)).click();

			        Thread.sleep(500);

			        // Step 4 - Click Expiry Dt
			        wait.until(ExpectedConditions.elementToBeClickable(expiryDateOption)).click();

			        // Step 5 - Click outside to close the menu
			        wait.until(ExpectedConditions.elementToBeClickable(clickingAwayAfterExpiryColumn)).click();
			    }
			    */
		 
		 

}



