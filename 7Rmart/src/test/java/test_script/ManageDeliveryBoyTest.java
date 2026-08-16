package test_script;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
@Test
public class ManageDeliveryBoyTest extends Base{
	LoginPage loginPage;
	@BeforeMethod
	public void loginToApplication() {
		loginPage=new LoginPage(driver);
		loginPage.enterUsername("admin");
        loginPage.enterPassword("admin");
        loginPage.clickLogin();
	}
	@Test
	public void createDeliveryBoy() {
		String name1="jismi";
		String mail="jis@gmail.com";
		String address="House number1";
		String number="678908760";
	    String user="asm";
	    String pass="asm";
		ManageDeliveryBoyPage pag=new ManageDeliveryBoyPage(driver);
		pag.locateManageDeliveryBoy();
		pag.clickNew();
		pag.Usename(name1);
		pag.Enteremail(mail);
		pag.Enteraddress(address);
		pag.Usephone(number);
		pag.EnterUsername(user);
		pag.passcode(pass);
		pag.clickCreate();
		pag.isAlertDisplayed();
	}

}
