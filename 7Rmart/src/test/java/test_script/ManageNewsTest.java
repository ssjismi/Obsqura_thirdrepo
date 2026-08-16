package test_script;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends Base {
	LoginPage loginPage;

    @BeforeMethod
    public void loginToApplication() {

        loginPage = new LoginPage(driver);

        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin");
        loginPage.clickLogin();
    }
@Test
public void createManagenews() {
	String data="Latest News are available";
	ManageNewsPage adm=new ManageNewsPage(driver);
	adm.locateManageNews();
	adm.clickNew();
	adm.enterdata(data);
	adm.clickCreate();
	
	boolean alert=ManageNewsPage.isAlertDisplayed();
	Assert.assertTrue(alert);
}


}
