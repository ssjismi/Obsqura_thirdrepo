package test_script;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;

public class AdminUsersTest extends Base {
	  LoginPage loginPage;

	    @BeforeMethod
	    public void loginToApplication() {

	        loginPage = new LoginPage(driver);

	        loginPage.enterUsername("admin");
	        loginPage.enterPassword("admin");
	        loginPage.clickLogin();
	    }
	@Test
	public void createAdminUsers() {
		String username="Jimsi";
		String password="pass";
		AdminUsersPage adm=new AdminUsersPage(driver);
		adm.locateAdminUsers();
		adm.clickNew();
		adm.enterUsername(username);
		adm.enterPassword(password);
		adm.dropdown();
		adm.clickCreate();
		
		boolean alert=AdminUsersPage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}

}
