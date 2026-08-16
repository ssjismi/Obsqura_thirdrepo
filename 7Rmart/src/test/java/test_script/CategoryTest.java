package test_script;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.LoginPage;


public class CategoryTest extends Base{
	LoginPage loginPage;

    @BeforeMethod
    public void loginToApplication() {

        loginPage = new LoginPage(driver);

        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin");
        loginPage.clickLogin();
    }
@Test
public void createCategoryTest() {
	String n1="healthy option";
	CategoryPage adm=new CategoryPage(driver);
	adm.locateCategory();
	adm.clickNew();
	adm.clickCategory(n1);
	adm.listselect();
	adm.fileupload();
	//adm.radioButtons();
	adm.clickCreate();
	
	boolean alert=CategoryPage.isAlertDisplayed();
	Assert.assertTrue(alert);
}


}
