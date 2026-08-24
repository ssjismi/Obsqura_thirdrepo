package test_script;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtilities;

public class LogoutTest extends Base{
	@Test(description="testcase of logout page")
	public void logout() throws IOException {
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
		
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.clickAdmin();
		logoutpage.clickLogout();
	}

}
