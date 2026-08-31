package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.Homepage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	Homepage homepage;
	AdminUsersPage adm;

	@Test(description = "test case of admin users page")
	public void createAdminUsers() throws IOException {
		FakerUtility faker = new FakerUtility();
		String adminusername = faker.creatARandomFirstName();
		String adminpassword = faker.creatARandomFirstName();
//		String username="Jimsi";
//		String password="pass";
		String usernamevalue = ExcelUtilities.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		homepage = loginpage.clickLogin();

		// AdminUsersPage adm=new AdminUsersPage(driver);
		adm = homepage.locateAdminUsers();
		adm.clickNew();
		adm.enterUsername(adminusername);
		adm.enterPassword(adminpassword);
		adm.dropdown();
		adm.clickCreate();

		boolean alert = adm.isAlertDisplayed();
		Assert.assertTrue(alert);
	}

}
