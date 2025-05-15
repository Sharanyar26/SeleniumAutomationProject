package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utilities.Extentmanager;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() 
	{
			extent = Extentmanager.getInstance();
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-features=PasswordManagerEnabled,AutofillServerCommunication");
		    options.addArguments("--incognito");

		    Map<String, Object> prefs = new HashMap<>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    options.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(options);
			driver.get("https://automationexercise.com/");
			driver.manage().window().maximize();
			
			
			driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
	}
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
		extent.flush();
		
	}
	
	public void CaptureScreen(String testName)
	{
		   
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    
	 
	    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    
	
	    String dest = System.getProperty("/Ecommerce_EndToEnd/src/test/java/Screenshots") + testName + "_" + timestamp + ".png";

	    try {
	        FileUtils.copyFile(src, new File(dest));
	        System.out.println("Screenshot saved: " + dest);
	    } catch (IOException e) {
	        System.out.println("Failed to save screenshot: " + e.getMessage());
	    }
	    
	    

	}
	
//	public void CaptureScreen(String tname) 
//	{
//		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		
//		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
//		
//		String Targetpath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp+".png";
//		File targetfile=new File(Targetpath);
//		
//		sourcefile.renameTo(targetfile);
//		return Targetpath;
//		
//	}
	
}
