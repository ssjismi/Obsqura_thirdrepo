package pages;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageLocationPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and @class=' nav-link']") WebElement manage_location;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//select[@id='country_id']")
	WebElement country;
	@FindBy(xpath = "//select[@id='st_id']")
	WebElement state;
	@FindBy(xpath = "//input[@id='location']")
	WebElement location;
	@FindBy(xpath = "//input[@id='delivery']")
	WebElement delivery_charge;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement submit;

	// validation check
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	public void locateManageLocation() {
//		
//		pageutility.clickElement(driver, manage_location);
//	}
	public ManageLocationPage clickNew() {
		newbutton.click();
		return this;
	}

	public ManageLocationPage dropdowns() {
		pageutility.dropdownVisibleText(country, "United Kingdom");
		pageutility.dropdownVisibleText(state, "Brechin");
		return this;
	}

	public ManageLocationPage enterlocation(String lname) {
		location.sendKeys(lname);
		return this;
	}

	public ManageLocationPage deliveryCharge(String charge) {
		delivery_charge.sendKeys(charge);
		return this;
	}

	public ManageLocationPage clickCreate() {
		submit.click();
		return this;
	}

	public ManageLocationPage dropdown() {
		pageutility.dropdownVisibleText(country, "United Kingdom");
		pageutility.dropdownVisibleText(state, "Brechin");
		return this;

	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
