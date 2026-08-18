package test_script;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import utilities.ScreenshotUtility;
//import org.testng.annotations.Parameters;


public class Base {
	WebDriver driver;
	@BeforeMethod(alwaysRun=true)   //alwaysRun=true
	//@Parameters("browser")
	
	public void browserInitialization(@Optional("chrome")String browser) throws Exception{
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
		driver.get("https://groceryapp.uniqassosiates.com/admin");
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
