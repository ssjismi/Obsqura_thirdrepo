package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.Homepage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	Homepage homepage;

	@Test(priority = 1, groups = "regression", retryAnalyzer = retry.Retry.class, description = "testcase of loginpage")
	public void verifyUserIsabletologinwithvalidcredentials() throws IOException {
//		String username="admin";
//		String password="admin";

		String username = ExcelUtilities.getStringData(1, 0, "loginpage");
		String password = ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);// chaining of method
		// loginpage.enterPassword(password);
		homepage = loginpage.clickLogin(); // cannot used chaining here as it is moved to homepage ie another page

		// validation

		boolean homepage = loginpage.isDashboadDisplayed();
		Assert.assertTrue(homepage, Constant.LOGINVALIDCREDENTIALS);// printed in report

	}

	@Test(priority = 2)
	public void verifyUserIsabletologinwithInvalidcredentials() throws IOException {
//		String username="Admin1";
//		String password="Admin2";
		String username = ExcelUtilities.getStringData(2, 0, "loginpage");
		String password = ExcelUtilities.getStringData(2, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password).clickLogin();// here as password is wrong not going to
																				// next page so we can chain clicklogin
																				// here itself
		// loginpage.enterPassword(password);
		loginpage.clickLogin();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.LOGININVALIDCREDENTIALS);
	}

	@Test(priority = 3)
	public void verifyUserIsabletologinwithValidUsernameAndInValidPassWord() throws IOException {
//		String username="admin";
//		String password="Admin2";
		String username = ExcelUtilities.getStringData(3, 0, "loginpage");
		String password = ExcelUtilities.getStringData(3, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password).clickLogin();
//		loginpage.enterPassword(password);
//		loginpage.clickLogin();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.LOGININVALIDCREDENTIALS);
	}

	@Test(priority = 4)
	public void verifyUserIsabletologinwithInvalidUsernameAndValidPassword() throws IOException {
//		String username="Admin12@";
//		String password="admin";
		String username = ExcelUtilities.getStringData(4, 0, "loginpage");
		String password = ExcelUtilities.getStringData(4, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password).clickLogin();
//		loginpage.enterPassword(password);
//		loginpage.clickLogin();

		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert, Constant.LOGININVALIDCREDENTIALS);
	}

}
