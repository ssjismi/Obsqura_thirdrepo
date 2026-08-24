package test_script;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;
//import org.testng.annotations.Parameters;


public class Base {
	WebDriver driver;
	public Properties prop;
	public FileInputStream fileip;// to access in every class
	@BeforeMethod(alwaysRun=true)   //alwaysRun=true
	@Parameters("browser")
	
	public void browserInitialization(String browser) throws Exception{  //@Optional("chrome")
		try {
			prop=new Properties();
			fileip=new FileInputStream(Constant.CONFIGFILE);
			prop.load(fileip);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		//driver=new ChromeDriver();
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("invalid");
		}
		//driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.get(prop.getProperty("url"));//key from config.properties
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize(); 
		
	}
	@AfterMethod(alwaysRun=true)   //alwaysRun=true
//	public void browserQuitandClose() {
//		driver.quit();
//	}
	public void browserQuitandClose(ITestResult iTestResult) throws IOException {  //for screenshot utility
		if (iTestResult.getStatus() == ITestResult.FAILURE) {   //if status is failure method inside screenshot is called
			ScreenshotUtility scrShot = new ScreenshotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());  //getName=failure testcase name
		}

	}


}
