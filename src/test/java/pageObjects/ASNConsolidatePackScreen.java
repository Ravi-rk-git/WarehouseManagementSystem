package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ASNConsolidatePackScreen extends BasePage{
	
	//Constructor
	public ASNConsolidatePackScreen(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locator/Elements
	@FindBy(xpath = "//div[contains(@class,'e-hdChecker')]")
	WebElement clickHeaderCheckBoxFromPackNoASN;
	
	@FindBy(xpath = "//button[normalize-space()='Next' and not(contains(@style,'display: none'))]")
	WebElement btnNextOnConsolidatePackScrreen;
	
	
	//Action Methods:
	public void headerCheckBoxFromPackNOASN()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		WebElement headerCheckbox = wait.until(
		    ExpectedConditions.elementToBeClickable(
		        By.xpath("//div[contains(@class,'e-hdChecker')]")
		    ));

		headerCheckbox.click();
	}

	
	public void btnNextOnConsolidatePackScrreen() throws InterruptedException
	{
		btnNextOnConsolidatePackScrreen.click();
		Thread.sleep(1000);
	}
}
