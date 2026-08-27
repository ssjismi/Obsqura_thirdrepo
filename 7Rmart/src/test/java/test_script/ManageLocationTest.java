package test_script;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtilities;


public class ManageLocationTest extends Base{
	Homepage homepage;
	ManageLocationPage adm;
	
@Test(description="testcase of managelocation")
public void createManageLocation() throws IOException {
	String delivery="500";
	String locat="Trivandrum";
	String usernamevalue = ExcelUtilities.getStringData(1, 0, "loginpage");
	String passwordvalue = ExcelUtilities.getStringData(1, 1, "loginpage");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
	//loginpage.enterPassword(passwordvalue);
	homepage=loginpage.clickLogin();
	
	//ManageLocationPage adm=new ManageLocationPage(driver);
	adm=homepage.locateManageLocation();
	adm.clickNew();
	adm.dropdowns().enterlocation(locat).deliveryCharge(delivery).clickCreate();
//	adm.enterlocation(locat);
//	adm.deliveryCharge(delivery);
//	adm.clickCreate();
	
	boolean alert=adm.isAlertDisplayed();
	Assert.assertTrue(alert);
}


}

