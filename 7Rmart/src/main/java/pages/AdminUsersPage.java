package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adm_user;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//input[@name='username']") WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']") WebElement passwordfield;
	@FindBy(xpath="//select[@id='user_type']") WebElement usertypedrop;
	@FindBy(xpath="//button[@name='Create']") WebElement submit;
	
	//validation check
	@FindBy(xpath="//i[@class='icon fas fa-check']") WebElement alerting;
	
	
	
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//	public void locateAdminUsers() {
//		adm_user.click();
//	}
	public void clickNew() {
		newbutton.click();
	}
	public void enterUsername(String username) {
		usernamefield.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordfield.sendKeys(password);
	}
	//public void 
	
	public void clickCreate() {
		submit.click();
		
	}
	public void dropdown() {
		
		pageutility.dropdownVisibleText(usertypedrop,"Admin");// change to Admin
	}
	public boolean isAlertDisplayed() {
		return alerting.isDisplayed();
}

}
