package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExceptionInventoryPackExceptionSearchScreen extends BasePage{
	
	Actions action;	
	Select select;
	
	//Constructor
	public ExceptionInventoryPackExceptionSearchScreen(WebDriver driver)
	{
		super(driver);
	}
	
	//Locator/Element:
	@FindBy(xpath = "//select[@title='The type of count associated with the pack exception.']")
	WebElement drpExceptionCountType;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//div[@class='N54GXCD-q-c-com-sencha-gxt-theme-base-client-grid-CheckBoxColumnDefaultAppearance-CheckBoxColumnStyle-hdChecker']")
    WebElement headerCheckBox; 	
	
	@FindBy(xpath = "//div[@class='TabHeaderCenterText' and normalize-space()='Action']")
	WebElement btnAction;	
	
	//Below Locator is for Selecting the dropDown on Shortage Approval:	
	public List<WebElement> getApprovalTransactionTypeDropdowns() {

	    return driver.findElements(By.xpath("//select[option[@value='478' and normalize-space()='SKUQAAndBinningShtgApproval']]"));
	}
	
	//Below Locator is for Selecting the dropDown on Damage Approval:	
	List<WebElement> getApprovalTransactionTypeDropdownsForDmg() {
		
		return driver.findElements(By.xpath("//select[option[@value='475' and normalize-space()='SKUQAAndBinningDmgApproval']]"));
	}
	
	
	@FindBy(xpath = "//button[normalize-space()='Save Changes']")
	WebElement btnSaveChanges;
	
	@FindBy(xpath = "//div[normalize-space()='Exceptional quantity approved successfully.']")
	WebElement successShortageExceptionMessage;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement btnXCloseOnShortageExcept;
	
	//Below Locator is for Providing To-Location on dropDown for Damage Approval:	
	List<WebElement> setToLocationDamageforAllDropDowns()
	{
	    return driver.findElements(By.xpath("//input[@title='The location where the pack exception is directed.']"));
	}
	
	@FindBy(xpath = "//div[normalize-space()='Exceptional quantity approved successfully.']")
	WebElement successDamageExceptionMessage;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement btnXCloseOnDamageExcept;
	
	
	
	//Action Methods:
	public void setdrpExceptionCountType(String eExceptionType) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(drpExceptionCountType));
		
		dropDown.click();		
		
		select=new Select(dropDown);
		select.selectByVisibleText(eExceptionType);
		Thread.sleep(800);
	}
		
	public void clickBtnSearch()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
		
		searchBtn.click();
	}
	
	public void clickHeaderCheckBox() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement chckBoxHeder = wait.until(ExpectedConditions.elementToBeClickable(headerCheckBox));
		
		chckBoxHeder.click();
		Thread.sleep(1000);
	}
	
	public void clickBtnAction()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement bttnAction = wait.until(ExpectedConditions.elementToBeClickable(btnAction));
		
		bttnAction.click();
	}
	
	
	
	//Below Method is for Selecting the dropDown on Approval TransactionType Shortage Approval:
	public void selectApprovalTransactionTypeForAllRows(String status)
	        throws InterruptedException {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(10));

	    JavascriptExecutor js =
	            (JavascriptExecutor) driver;

	    int maxAttempts = 100;

	    for (int attempt = 1; attempt <= maxAttempts; attempt++) {

	        List<WebElement> dropdowns =
	                getApprovalTransactionTypeDropdowns();

	        System.out.println("Attempt: " + attempt
	                + " | Approval dropdowns in DOM: "
	                + dropdowns.size());

	        /*
	         * Select all currently rendered Approval dropdowns
	         */
	        for (WebElement dropdown : dropdowns) {

	            try {

	                Select select = new Select(dropdown);

	                String currentValue =
	                        select.getFirstSelectedOption()
	                              .getAttribute("value");

	                if (!"478".equals(currentValue)) {

	                    js.executeScript(
	                            "arguments[0].scrollIntoView({block:'center'});",
	                            dropdown);

	                    wait.until(
	                            ExpectedConditions.elementToBeClickable(dropdown));

	                    // Re-create Select after scrolling
	                    select = new Select(dropdown);

	                    select.selectByValue("478");

	                    System.out.println(
	                            "Selected Approval TransactionType.");

	                    Thread.sleep(500);
	                }

	            } catch (StaleElementReferenceException e) {

	                System.out.println(
	                        "GXT refreshed the row. Rechecking...");
	            }
	        }

	        /*
	         * Check whether browser has reached the bottom.
	         */
	        Long currentPosition = (Long) js.executeScript(
	                "return Math.floor(window.pageYOffset);");

	        Long windowHeight = (Long) js.executeScript(
	                "return Math.floor(window.innerHeight);");

	        Long pageHeight = (Long) js.executeScript(
	                "return Math.floor(document.documentElement.scrollHeight);");

	        System.out.println(
	                "Scroll: " + currentPosition
	                + " / " + pageHeight);

	        /*
	         * Stop when we reach the bottom.
	         */
	        if (currentPosition + windowHeight >= pageHeight - 5) {

	            System.out.println(
	                    "Reached bottom of page.");

	            /*
	             * One final check for any unselected
	             * Approval dropdowns currently rendered.
	             */
	            List<WebElement> finalDropdowns =
	                    getApprovalTransactionTypeDropdowns();

	            for (WebElement dropdown : finalDropdowns) {

	                try {

	                    Select select = new Select(dropdown);

	                    String value =
	                            select.getFirstSelectedOption()
	                                  .getAttribute("value");

	                    if (!"478".equals(value)) {

	                        select.selectByValue("478");

	                        Thread.sleep(300);
	                    }

	                } catch (Exception e) {
	                    // GXT refreshed; ignore and continue
	                }
	            }

	            break;
	        }

	        /*
	         * Scroll down by a SMALL amount.
	         *
	         * Small overlapping scroll prevents rows
	         * from being skipped.
	         */
	        js.executeScript(
	                "window.scrollBy(0, 300);");

	        Thread.sleep(1000);
	    }

	    System.out.println(
	            "Finished Approval TransactionType selection.");
	}
	
	
	
	
	public void clickBtnSaveChanges()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement saveChanges = wait.until(ExpectedConditions.elementToBeClickable(btnSaveChanges));
		
		saveChanges.click();
	}
	
	public String txtSuccessShortageExceptionMessage()
	{
		String SucessShortageExceptionMssge= successShortageExceptionMessage.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println("SUCCESS: Below Given Message For Shortage Exception Approval: ");
		System.out.println(SucessShortageExceptionMssge);
		System.out.println();
		System.out.println("**********************************************************************");
		
		return SucessShortageExceptionMssge;
	}
	
	public void clickBtnXCloseOnShortageExcept() throws InterruptedException
	{
		Thread.sleep(3000);
		btnXCloseOnShortageExcept.click();
	}	
	
	
	
	//--------Below both methods works fine------but time issue issue -----------
	
	//This Method Selects only Approval TransactionType Damage:
	
	//Below Method is for Selecting the dropDown on Approval TransactionType Damage Approval:
	
	/*public void selectApprovalTransactionTypeForAllRowsDmg(String status)
	        throws InterruptedException {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(10));

	    JavascriptExecutor js =
	            (JavascriptExecutor) driver;

	    int maxAttempts = 100;

	    for (int attempt = 1; attempt <= maxAttempts; attempt++) {

	        List<WebElement> dropdowns =
	        		getApprovalTransactionTypeDropdownsForDmg();

	        System.out.println("Attempt: " + attempt
	                + " | Approval dropdowns in DOM: "
	                + dropdowns.size());

	        /*
	         * Select all currently rendered Approval dropdowns
	         */
	       /* for (WebElement dropdown : dropdowns) {

	            try {

	                Select select = new Select(dropdown);

	                String currentValue =
	                        select.getFirstSelectedOption()
	                              .getAttribute("value");

	                if (!"475".equals(currentValue)) {

	                    js.executeScript(
	                            "arguments[0].scrollIntoView({block:'center'});",
	                            dropdown);

	                    wait.until(
	                            ExpectedConditions.elementToBeClickable(dropdown));

	                    // Re-create Select after scrolling
	                    select = new Select(dropdown);

	                    select.selectByValue("475");

	                    System.out.println(
	                            "Selected Approval TransactionType.");

	                    Thread.sleep(500);
	                }

	            } catch (StaleElementReferenceException e) {

	                System.out.println(
	                        "GXT refreshed the row. Rechecking...");
	            }
	        }

	        /*
	         * Check whether browser has reached the bottom.
	         */
	      /*  Long currentPosition = (Long) js.executeScript(
	                "return Math.floor(window.pageYOffset);");

	        Long windowHeight = (Long) js.executeScript(
	                "return Math.floor(window.innerHeight);");

	        Long pageHeight = (Long) js.executeScript(
	                "return Math.floor(document.documentElement.scrollHeight);");

	        System.out.println(
	                "Scroll: " + currentPosition
	                + " / " + pageHeight);

	        /*
	         * Stop when we reach the bottom.
	         */
	     /*   if (currentPosition + windowHeight >= pageHeight - 5) {

	            System.out.println(
	                    "Reached bottom of page.");

	            /*
	             * One final check for any unselected
	             * Approval dropdowns currently rendered.
	             */
	          /*  List<WebElement> finalDropdowns =
	            		getApprovalTransactionTypeDropdownsForDmg();

	           /* for (WebElement dropdown : finalDropdowns) {

	                try {

	                    Select select = new Select(dropdown);

	                    String value =
	                            select.getFirstSelectedOption()
	                                  .getAttribute("value");

	                    if (!"478".equals(value)) {

	                        select.selectByValue("478");

	                        Thread.sleep(300);
	                    }

	                } catch (Exception e) {
	                    // GXT refreshed; ignore and continue
	                }
	            }

	            break;
	        }

	        /*
	         * Scroll down by a SMALL amount.
	         *
	         * Small overlapping scroll prevents rows
	         * from being skipped.
	         */
	       /* js.executeScript(
	                "window.scrollBy(0, 300);");

	        Thread.sleep(1000);
	    }

	    System.out.println(
	            "Finished Approval TransactionType selection.");
	}
	
	

	
	//This Method Provides only To-Location
	
	public void setToLocationDamageForAllRows(String location)
	        throws InterruptedException {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(10));

	    JavascriptExecutor js =
	            (JavascriptExecutor) driver;

	    int maxAttempts = 100;

	    for (int attempt = 1; attempt <= maxAttempts; attempt++) {

	        List<WebElement> locations =
	                setToLocationDamageforAllDropDowns();

	        System.out.println(
	                "Attempt: " + attempt
	                + " | Location inputs in DOM: "
	                + locations.size());

	        /*
	         * Set Dmg01 and press ENTER
	         * for all currently rendered rows
	         */
	      /*  for (WebElement input : locations) {

	            try {

	                js.executeScript(
	                        "arguments[0].scrollIntoView({block:'center'});",
	                        input);

	                wait.until(
	                        ExpectedConditions.elementToBeClickable(input));

	                input.click();

	                input.sendKeys(Keys.CONTROL, "a");
	                input.sendKeys(location);

	                input.sendKeys(Keys.ENTER);

	                System.out.println(
	                        "Entered Location: " + location
	                        + " and pressed ENTER.");

	                Thread.sleep(500);

	            } catch (StaleElementReferenceException e) {

	                System.out.println(
	                        "GXT refreshed the row. Rechecking...");
	            }
	        }

	        /*
	         * Check current scroll position
	         */
	       /* Long currentPosition = (Long) js.executeScript(
	                "return Math.floor(window.pageYOffset);");

	        Long windowHeight = (Long) js.executeScript(
	                "return Math.floor(window.innerHeight);");

	        Long pageHeight = (Long) js.executeScript(
	                "return Math.floor(document.documentElement.scrollHeight);");

	        System.out.println(
	                "Scroll: " + currentPosition
	                + " / " + pageHeight);

	        /*
	         * Stop when bottom is reached
	         */
	      /*  if (currentPosition + windowHeight >= pageHeight - 5) {

	            System.out.println(
	                    "Reached bottom of page.");

	            /*
	             * Final check for currently rendered rows
	             */
	          /*  List<WebElement> finalLocations =
	                    setToLocationDamageforAllDropDowns();

	            for (WebElement input : finalLocations) {

	                try {

	                    wait.until(
	                            ExpectedConditions.elementToBeClickable(input));

	                    input.click();

	                    input.sendKeys(Keys.CONTROL, "a");
	                    input.sendKeys(location);

	                    input.sendKeys(Keys.ENTER);

	                    Thread.sleep(300);

	                } catch (StaleElementReferenceException e) {

	                    // GXT refreshed; ignore and continue

	                } catch (Exception e) {

	                    System.out.println(
	                            "Unable to set location: "
	                            + e.getMessage());
	                }
	            }

	            break;
	        }

	        /*
	         * Small overlapping scroll
	         * prevents rows from being skipped
	         */
	      /*  js.executeScript(
	                "window.scrollBy(0, 300);");

	        Thread.sleep(1000);
	    }

	    System.out.println(
	            "Finished setting Location for all rows.");
	}
*/	  
	//-----Till Here it's working fine both the methods------but time issue----------
	
	            
	            
	  
	
	
	//---combine method:  		-For Both DamageTransactionType & To-Location Damage.
	
	
	public void selectApprovalTypeAndSetToLocationForAllRows(
	        String status, String location) throws InterruptedException {

	    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

	    JavascriptExecutor js =
	            (JavascriptExecutor) driver;

	    int maxAttempts = 100;

	    for (int attempt = 1; attempt <= maxAttempts; attempt++) {

	        List<WebElement> approvalDropdowns =
	                getApprovalTransactionTypeDropdownsForDmg();

	        List<WebElement> locationInputs =
	                setToLocationDamageforAllDropDowns();

	        System.out.println(
	                "Attempt: " + attempt
	                + " | Approval rows: " + approvalDropdowns.size()
	                + " | Location rows: " + locationInputs.size());

	        /*
	         * Process currently rendered rows.
	         *
	         * Approval Transaction Type
	         *          ↓
	         * To Location
	         */
	        int rows = Math.min(
	                approvalDropdowns.size(),
	                locationInputs.size());

	        for (int i = 0; i < rows; i++) {

	            try {

	                /*
	                 * Get fresh elements because GXT
	                 * can refresh the grid after selection.
	                 */
	                approvalDropdowns =
	                        getApprovalTransactionTypeDropdownsForDmg();

	                locationInputs =
	                        setToLocationDamageforAllDropDowns();

	                if (i >= approvalDropdowns.size()
	                        || i >= locationInputs.size()) {
	                    break;
	                }

	                WebElement approval =
	                        approvalDropdowns.get(i);

	                WebElement locationInput =
	                        locationInputs.get(i);

	                /*
	                 * --------------------------------
	                 * 1. Select Approval Transaction Type
	                 * --------------------------------
	                 */
	                Select select = new Select(approval);

	                String currentValue =
	                        select.getFirstSelectedOption()
	                              .getAttribute("value");

	                if (!status.equals(currentValue)) {

	                    select.selectByValue(status);

	                    System.out.println(
	                            "Row " + (i + 1)
	                            + " | Approval selected: "
	                            + status);

	                    /*
	                     * Small wait only for GXT refresh.
	                     */
	                    Thread.sleep(200);
	                }

	                /*
	                 * --------------------------------
	                 * 2. Set To Location
	                 * --------------------------------
	                 */
	                locationInput =
	                        setToLocationDamageforAllDropDowns().get(i);

	                locationInput.click();

	                locationInput.sendKeys(Keys.CONTROL, "a");
	                locationInput.sendKeys(location);
	                locationInput.sendKeys(Keys.ENTER);

	                System.out.println(
	                        "Row " + (i + 1)
	                        + " | Location entered: "
	                        + location);

	                /*
	                 * Small wait for GXT refresh.
	                 */
	                Thread.sleep(200);

	            } catch (StaleElementReferenceException e) {

	                System.out.println(
	                        "GXT refreshed row. Rechecking current rows...");

	                /*
	                 * Do not increase scroll position.
	                 * Re-process the current rendered rows.
	                 */
	                continue;

	            } catch (Exception e) {

	                System.out.println(
	                        "Unable to process row "
	                        + (i + 1)
	                        + " : "
	                        + e.getMessage());
	            }
	        }

	        /*
	         * --------------------------------
	         * Check current scroll position
	         * --------------------------------
	         */
	        Long currentPosition = (Long) js.executeScript(
	                "return Math.floor(window.pageYOffset);");

	        Long windowHeight = (Long) js.executeScript(
	                "return Math.floor(window.innerHeight);");

	        Long pageHeight = (Long) js.executeScript(
	                "return Math.floor(document.documentElement.scrollHeight);");

	        System.out.println(
	                "Scroll: "
	                + currentPosition
	                + " / "
	                + pageHeight);

	        /*
	         * --------------------------------
	         * Bottom reached
	         * --------------------------------
	         */
	        if (currentPosition + windowHeight >= pageHeight - 5) {

	            System.out.println(
	                    "Reached bottom of page.");

	            /*
	             * Final currently-rendered rows
	             */
	            List<WebElement> finalApprovals =
	                    getApprovalTransactionTypeDropdownsForDmg();

	            List<WebElement> finalLocations =
	                    setToLocationDamageforAllDropDowns();

	            int finalRows = Math.min(
	                    finalApprovals.size(),
	                    finalLocations.size());

	            for (int i = 0; i < finalRows; i++) {

	                try {

	                    /*
	                     * Final Approval check
	                     */
	                    Select select =
	                            new Select(finalApprovals.get(i));

	                    String currentValue =
	                            select.getFirstSelectedOption()
	                                  .getAttribute("value");

	                    if (!status.equals(currentValue)) {

	                        select.selectByValue(status);

	                        Thread.sleep(150);
	                    }

	                    /*
	                     * Final Location
	                     */
	                    WebElement input =
	                            setToLocationDamageforAllDropDowns()
	                            .get(i);

	                    input.click();

	                    input.sendKeys(Keys.CONTROL, "a");
	                    input.sendKeys(location);
	                    input.sendKeys(Keys.ENTER);

	                    Thread.sleep(150);

	                } catch (StaleElementReferenceException e) {

	                    System.out.println(
	                            "GXT refreshed during final check.");

	                } catch (Exception e) {

	                    System.out.println(
	                            "Final row processing failed: "
	                            + e.getMessage());
	                }
	            }

	            break;
	        }

	        /*
	         * --------------------------------
	         * Scroll DOWN only once
	         * --------------------------------
	         */
	        js.executeScript(
	                "window.scrollBy(0, 500);");

	        /*
	         * Short wait for GXT to render
	         * the newly visible rows.
	         */
	        Thread.sleep(300);
	    }

	    System.out.println(
	            "Finished Approval Transaction Type + To Location for all rows.");
	}
	            
	 
	public String txtSuccessDamageExceptionMessage()
	{
		String SucessDamageExceptionMssge= successDamageExceptionMessage.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println("SUCCESS: Below Given Message For Damage Exception Approval: ");
		System.out.println(SucessDamageExceptionMssge);
		System.out.println();
		System.out.println("**********************************************************************");
		
		return SucessDamageExceptionMssge;
	}
	
	public void clickBtnXCloseOnDamageExcept() throws InterruptedException
	{
		Thread.sleep(3000);
		btnXCloseOnDamageExcept.click();
	}
	
}
