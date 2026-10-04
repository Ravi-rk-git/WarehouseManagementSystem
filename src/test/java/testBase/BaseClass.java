package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	//The "BaseClass" Contains the Re-Usable methods.
	//What ever requires for all the TestCases, those methods we will keep in the "BaseClass".
	
	public static WebDriver driver;
	public static Logger logger;  //Log4j
	public static Properties p;
	
	@BeforeTest(groups= {"Master_UI_PacksFlow", "Regression_FileUpload_CSV","Smoke_ExceptionPacks"})
	@Parameters({"os", "browser"})
	public void setup(String or, String br) throws IOException
	{
		//Loading Config.properties file
		FileReader file=new FileReader(".//src/test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase()) 
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid Browser name.."); return;
		}		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(p.getProperty("ApplicationURL")); //Reading URL from properties file.
		driver.manage().window().maximize();
	}

	@AfterTest(groups= {"Master_UI_PacksFlow","Regression_FileUpload_CSV"})
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		
		if(driver != null) {
			driver.quit();
		}
		
	}

	// Approach - 01
	public String randomeString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomeNumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomeAlphanNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatedstring +"@" +generatednumber;
	}
	
	// Approach - 02
	/*
	 public String randomString() {
	        return RandomStringUtils.secure().nextAlphabetic(5);
	    }

	    public String randomNumber() {
	        return RandomStringUtils.secure().nextNumeric(10);
	    }

	    public String randomAlphaNumeric() {
	        String generatedString = RandomStringUtils.secure().nextAlphabetic(5);
	        String generatedNumber = RandomStringUtils.secure().nextNumeric(10);

	        return generatedString + "@" + generatedNumber;
	    }
		*/
	
	
	//CaptureScreenshot:
	public String captureScreen(String tname)
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
	
}
