package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	Homepage homepage;
	ManageNewsPage adm;

	@Test(description = "testcase of managenews page")
	public void createManagenews() throws IOException {
		String data = "Latest News are available";
		String usernamevalue = ExcelUtilities.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		homepage = loginpage.clickLogin();

		// ManageNewsPage adm=new ManageNewsPage(driver);
		adm = homepage.locateManageNews();
		adm.clickNew();
		adm.enterdata(data).clickCreate();
		// adm.clickCreate();

		boolean alert = adm.isAlertDisplayed();
		Assert.assertTrue(alert);
	}

}
