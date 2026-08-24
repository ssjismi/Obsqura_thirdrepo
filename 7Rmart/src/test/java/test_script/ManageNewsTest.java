package test_script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base {
	
@Test(description="testcase of managenews page")
public void createManagenews() throws IOException {
	String data="Latest News are available";
	String usernamevalue = ExcelUtilities.getStringData(1, 0, "loginpage");
	String passwordvalue = ExcelUtilities.getStringData(1, 1, "loginpage");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(usernamevalue);
	loginpage.enterPassword(passwordvalue);
	loginpage.clickLogin();
	ManageNewsPage adm=new ManageNewsPage(driver);
	adm.locateManageNews();
	adm.clickNew();
	adm.enterdata(data);
	adm.clickCreate();
	
	boolean alert=adm.isAlertDisplayed();
	Assert.assertTrue(alert);
}


}
