package pageObjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DispathNoteSaveChanagesScreen extends BasePage{
	
		
	//Constructor:
	public DispathNoteSaveChanagesScreen(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Element/Locator:
	@FindBy(xpath = "//button[@title='Vehicle number.']")
	WebElement loadSearchVehicleNO;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//div[@class='N54GXCD-q-c-com-sencha-gxt-theme-base-client-grid-CheckBoxColumnDefaultAppearance-CheckBoxColumnStyle-hdChecker']")
	WebElement HeaderCheckBoxVehicleNo;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	WebElement btnOKVehicleNo;
	
	@FindBy(xpath = "//button[normalize-space()='Save Changes']")
	WebElement btnSaveChnagesOnCreateDisaptch;
	
	@FindBy(xpath = "//div[contains(text(),'Invoice(s)') and contains(text(),'Created Successfully.')]")
	WebElement txtSuccessMessageCreateDispatchNote;
	
	@FindBy(xpath = "//button[normalize-space()='x']")
	WebElement closeXbtnCreateDispatchNote;	
	
	
	
	//Action Methods:
	public void clickBtnSearchVehicleNO() throws InterruptedException 
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	            
	    WebElement searchVehicleNo = wait.until(ExpectedConditions.elementToBeClickable(loadSearchVehicleNO));
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    // Corrected: Pass the script string as the first argument and the element as the second
	    js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});",searchVehicleNo);
	    
	    Thread.sleep(1000);
	    searchVehicleNo.click();
	}
	
	public void clickBtnSearch()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
		
		search.click();		
	}
	
	public void selectHeaderCheckBoxVehicleNo()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(HeaderCheckBoxVehicleNo));
	
		checkbox.click();
	}
	
	public void clickbtnOKVehicleNo() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement clickOKbtn = wait.until(ExpectedConditions.elementToBeClickable(btnOKVehicleNo));
		
		clickOKbtn.click();
		Thread.sleep(1000);		
	}
	
	public void clickBtnSaveChnagesOnCreateDisaptch() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    
	    WebElement saveChanges = wait.until(ExpectedConditions.elementToBeClickable(btnSaveChnagesOnCreateDisaptch));
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    // Scrolls the entire application page to the absolute bottom
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	    
	    Thread.sleep(1000);
	    saveChanges.click();
	}
	
	public String getSuccessMessageCreateDispatchNote()	
	{
		WebElement successMsg = new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[contains(text(),'Invoice(s)') and contains(text(),'Created Successfully.')]")));

		System.out.println();
		System.out.println();
				
		String SucessCreateDispatchNote= successMsg.getText();
		System.out.println("**********************************************************************");
		System.out.println();
		System.out.println(SucessCreateDispatchNote);
		System.out.println();
		System.out.println("**********************************************************************");
		
		return SucessCreateDispatchNote;
	}
	
	public void closeXbtnCreateDispatchNotePopup() throws InterruptedException
	{
		Thread.sleep(4000);
		String parentWindow = driver.getWindowHandle(); //I'm getting 1 single window here.

		closeXbtnCreateDispatchNote.click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Wait until 2 windows are available
	    wait.until(ExpectedConditions.numberOfWindowsToBe(4));//I'm getting 2 Two window here.

	    Set<String> allWindows = driver.getWindowHandles();

	    for (String window : allWindows) {
	        if (!window.equals(parentWindow)) {
	            driver.switchTo().window(window);
	            //System.out.println("Report Window Title : " + driver.getTitle());
	           // driver.close();
	            break;
	        }
	    }

	    // Switch back to parent
	    driver.switchTo().window(parentWindow);

	    // Wait until only one window remains
	    wait.until(ExpectedConditions.numberOfWindowsToBe(4)); //I Need 2 windows, why rest of below 2 methods should execute.

	    //System.out.println("Current Window Title : " + driver.getTitle());  
	    
	}
}
