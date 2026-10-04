package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import utilities.SharedData;

public class UploadFileCreateSalesOrder extends BasePage{
	
	Actions action;
	
	//Constructor:
	public UploadFileCreateSalesOrder(WebDriver driver) 
	{
		super(driver);
	}
	
	
	//Locator/Elements:
	@FindBy(xpath = "//div[normalize-space()='Administration']")
	WebElement btnHeaderAdministration;
	
	@FindBy(xpath = "//div[@id='administration-Interface-buttonlabel']")
	WebElement btnInterface;
	
	@FindBy(xpath = "//div[@id='administration-Interface-fileUpload-buttonlabel']")
	WebElement btnUploadFile;
	
	@FindBy(xpath = "//input[@name='fileName']")  ////button[contains(text(), 'Choose File')]
	WebElement popBtnChooseFile;
	
	@FindBy(xpath = "//button[contains(text(),'Upload')]")
	WebElement btnUpload;
	
	@FindBy(xpath = "//input[@type='file']")
	WebElement fileInput; //important
	
	@FindBy(xpath = "//div[normalize-space()='File Scheduled For Upload']")
	WebElement successFileScheduled;
	
	@FindBy(xpath = "(//button[normalize-space()='x'])[2]")
	WebElement closeXbuttonOnFileScheduled;
	
	@FindBy(xpath = "(//button[normalize-space()='x'])[1]")
	WebElement closeXbuttonOnUploadFile;
	
	
	public void clickBtnHeaderAdministration() throws InterruptedException
	{
		Thread.sleep(1000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement administration = wait.until(ExpectedConditions.elementToBeClickable(btnHeaderAdministration));
		
		administration.click();		
	}
	
	public void doubleClickbtnInterface()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement dblClickInterface = wait.until(ExpectedConditions.elementToBeClickable(btnInterface));
	
		Actions action=new Actions(driver);
		action.doubleClick(dblClickInterface).perform();		
	}	
	
	public void doubleClickbtnUploadFile()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement dblClickUploadFile = wait.until(ExpectedConditions.elementToBeClickable(btnUploadFile));
	
		Actions action=new Actions(driver);
		action.doubleClick(dblClickUploadFile).perform();
		action.pause(Duration.ofMillis(500));
	}	
	
	public void clickChooseFile()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement chooseFile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
		
		//Note: For Selenium file uploads, you normally do not click the native "Choose File" window. Instead, 
		//send the absolute file path directly to the <input type="file">.
		
		String filePath = System.getProperty("user.dir")+"\\testData\\SalesOrder.csv";
		
		chooseFile.sendKeys(filePath);
	}	
	
	public void clickBtnUpload() throws InterruptedException
	{		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement UploadButton = wait.until(ExpectedConditions.elementToBeClickable(btnUpload));
		
		Thread.sleep(1500);
		UploadButton.click();	
	}
	
	
	public void readCustomerOrderNoFromCSV()
	{
	    String filePath = System.getProperty("user.dir") + "\\testData\\SalesOrder.csv";

	    try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
	    {
	        String headerLine = br.readLine();

	        if (headerLine == null)
	        {
	            throw new RuntimeException("SalesOrder.csv is empty.");
	        }

	        String[] headers = headerLine.split(",");

	        int customerOrderIndex = -1;

	        for (int i = 0; i < headers.length; i++)
	        {
	            if (headers[i].trim().equalsIgnoreCase("CustomerOrderNo"))
	            {
	                customerOrderIndex = i;
	                break;
	            }
	        }

	        if (customerOrderIndex == -1)
	        {
	            throw new RuntimeException("CustomerOrderNo column not found in SalesOrder.csv.");
	        }

	        String dataLine = br.readLine();

	        if (dataLine == null)
	        {
	            throw new RuntimeException("No data found in SalesOrder.csv.");
	        }

	        String[] data = dataLine.split(",", -1);

	        if (customerOrderIndex >= data.length)
	        {
	            throw new RuntimeException("CustomerOrderNo value is missing in SalesOrder.csv.");
	        }

	        SharedData.customerOrderNo = data[customerOrderIndex].trim();

	        System.out.println("Customer Order No from CSV = "
	                + SharedData.customerOrderNo);
	    }
	    catch (IOException e)
	    {
	        throw new RuntimeException("Unable to read SalesOrder.csv", e);
	    }
	}	
	
	
	public String successMsgFileScheduled() //successFileScheduled
	{
		String MessageFileUpload = successFileScheduled.getText();
		
		return MessageFileUpload;		
	}

	public void closeXbuttonOnFileScheduled() throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.elementToBeClickable(closeXbuttonOnFileScheduled)).click();
	}
	
	public void closeXbuttonOnUploadFile() throws InterruptedException
	{
		Thread.sleep(1500);
		closeXbuttonOnUploadFile.click();
	}
}
