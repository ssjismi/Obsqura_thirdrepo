package test_script;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	@Test(priority=1,groups="regression",retryAnalyzer=retry.Retry.class,description="testcase of loginpage")
	public void verifyUserIsabletologinwithvalidcredentials() throws IOException {
//		String username="admin";
//		String password="admin";
		
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		
		//validation
		
		boolean homepage=loginpage.isDashboadDisplayed();
		Assert.assertTrue(homepage);
		
		
	}
	@Test(priority=2)
	public void verifyUserIsabletologinwithInvalidcredentials() throws IOException {
//		String username="Admin1";
//		String password="Admin2";
		String username=ExcelUtilities.getStringData(2, 0, "loginpage");
		String password=ExcelUtilities.getStringData(2, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
	@Test(priority=3)
	public void verifyUserIsabletologinwithValidUsernameAndInValidPassWord() throws IOException {
//		String username="admin";
//		String password="Admin2";
		String username=ExcelUtilities.getStringData(3, 0, "loginpage");
		String password=ExcelUtilities.getStringData(3, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
	@Test(priority=4)
	public void verifyUserIsabletologinwithInvalidUsernameAndValidPassword() throws IOException {
//		String username="Admin12@";
//		String password="admin";
		String username=ExcelUtilities.getStringData(4, 0, "loginpage");
		String password=ExcelUtilities.getStringData(4, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		
		boolean alert=loginpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
	

}
