package test_script;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageLocationPage;


public class ManageLocationTest extends Base{
	LoginPage loginPage;

    @BeforeMethod
    public void loginToApplication() {

        loginPage = new LoginPage(driver);

        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin");
        loginPage.clickLogin();
    }
@Test
public void createManageLocation() {
	String delivery="500";
	String locat="Trivandrum";
	ManageLocationPage adm=new ManageLocationPage(driver);
	adm.locateManageLocation();
	adm.clickNew();
	adm.dropdowns();
	adm.enterlocation(locat);
	adm.deliveryCharge(delivery);
	adm.clickCreate();
	
	boolean alert=ManageLocationPage.isAlertDisplayed();
	Assert.assertTrue(alert);
}


}

