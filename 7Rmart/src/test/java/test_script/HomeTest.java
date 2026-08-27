package test_script;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.Homepage;
import utilities.ExcelUtilities;

public class HomeTest extends Base{
	Homepage logoutpage;
	@Test(description="testcase of logout page")
	public void logout() throws IOException {
		String username=ExcelUtilities.getStringData(1, 0, "loginpage");
		String password=ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(username).enterPassword(password);
		//loginpage.enterPassword(password);
		loginpage.clickLogin();
		
		//Homepage logoutpage=new Homepage(driver);
		logoutpage.clickAdmin();
		logoutpage.clickLogout();
	}

}
