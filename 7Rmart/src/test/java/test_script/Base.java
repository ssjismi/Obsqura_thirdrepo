package test_script;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Base {
	WebDriver driver;
	@BeforeMethod(alwaysRun=true)
	
	public void browserInitialization(){
		driver=new ChromeDriver();
		
//		if(browser.equalsIgnoreCase("chrome")) {
//			driver=new ChromeDriver();
//			
//		}
//		else if(browser.equalsIgnoreCase("edge")) {
//			driver=new EdgeDriver();
//		}
//		else
//		{
//			throw new Exception("invalid");
//		}
		driver.get("https://groceryapp.uniqassosiates.com/admin");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize(); 
		
	}
	//@AfterMethod()
//	public void browserQuitandClose() {
//		driver.quit();
//	}


}
