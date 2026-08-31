package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class Homepage {
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logout;
	//@FindBy(xpath="//a[@class='dropdown-item'and @href='https://groceryapp.uniqassociates.com/admin/logout']") WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='nav-link']") WebElement manage_news;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and @class=' nav-link']") WebElement manage_location;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='nav-link']") WebElement manage_category;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'and @class=' nav-link']") WebElement manage_deliveryboy;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adm_user;
	WebDriver driver;
	PageUtility pageutility = new PageUtility();
	
	public Homepage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public Homepage clickAdmin() {
		admin.click();
		return this;
	}
	public LoginPage clickLogout() {
		logout.click();
		return new LoginPage(driver);
	}
	public ManageNewsPage locateManageNews() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", manage_news);
		//manage_news.click();
		return new ManageNewsPage(driver);
	}
	public ManageLocationPage locateManageLocation() {		
		pageutility.clickElement(driver, manage_location);
		return new ManageLocationPage(driver);
	}
	public CategoryPage locateCategory() {
		pageutility.clickElement(driver, manage_category);
		return new CategoryPage(driver);
	}
    public ManageDeliveryBoyPage locateManageDeliveryBoy() {
		
		pageutility.clickElement(driver, manage_deliveryboy);
		return new ManageDeliveryBoyPage(driver);
	}

	public AdminUsersPage locateAdminUsers() {
		adm_user.click();
		return new AdminUsersPage(driver);
	}

}
