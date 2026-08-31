package test_script;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtilities;

@Test
public class ManageDeliveryBoyTest extends Base {
	Homepage homepage;
	ManageDeliveryBoyPage pag;

	@Test(description = "testcase of managedelivers")
	public void createDeliveryBoy() throws IOException {
		String name1 = "jismi";
		String mail = "jis@gmail.com";
		String address = "House number1";
		String number = "678908760";
		String user = "asm";
		String pass = "asm";

		String usernamevalue = ExcelUtilities.getStringData(1, 0, "loginpage");
		String passwordvalue = ExcelUtilities.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
		// loginpage.enterPassword(passwordvalue);
		homepage = loginpage.clickLogin();

		// ManageDeliveryBoyPage pag=new ManageDeliveryBoyPage(driver);
		pag = homepage.locateManageDeliveryBoy();
		pag.clickNew();
		pag.Usename(name1).Enteremail(mail).Enteraddress(address).Usephone(number).EnterUsername(user).passcode(pass)
				.clickCreate();
//		pag.Enteremail(mail);
//		pag.Enteraddress(address);
//		pag.Usephone(number);
//		pag.EnterUsername(user);
//		pag.passcode(pass);
//		pag.clickCreate();
		pag.isAlertDisplayed();
	}

}
