package test_script;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.Homepage;
import pages.LoginPage;
import utilities.ExcelUtilities;


public class CategoryTest extends Base{
	Homepage homepage;
	CategoryPage adm;

 
@Test(description="test case of category page")
public void createCategoryTest() throws IOException {
	String n1="healthy option";
	String usernamevalue = ExcelUtilities.getStringData(1, 0, "loginpage");
	String passwordvalue = ExcelUtilities.getStringData(1, 1, "loginpage");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(usernamevalue).enterPassword(passwordvalue);
	//loginpage.enterPassword(passwordvalue);
	homepage=loginpage.clickLogin();
	
	
//	 LoginPage loginPage = new LoginPage(driver);
//
//     loginPage.enterUsername("admin");
//     loginPage.enterPassword("admin");
//     loginPage.clickLogin();
	
	
//	CategoryPage adm=new CategoryPage(driver);
	adm=homepage.locateCategory();
	adm.clickNew().clickCategory(n1).listselect().fileupload().clickCreate();
//	adm.clickCategory(n1);
//	adm.listselect();
//	adm.fileupload();
//	//adm.radioButtons();
//	adm.clickCreate();
	
	boolean alert=adm.isAlertDisplayed();
	Assert.assertTrue(alert);
}


}
