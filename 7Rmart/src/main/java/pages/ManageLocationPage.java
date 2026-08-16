package pages;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageLocationPage {
	public WebDriver driver;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and @class=' nav-link']") WebElement manage_location;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//select[@id='country_id']") WebElement country;
	@FindBy(xpath="//select[@id='st_id']") WebElement state;
	@FindBy(xpath="//input[@id='location']") WebElement location;
	@FindBy(xpath="//input[@id='delivery']") WebElement delivery_charge;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement submit;
	
	//validation check
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	static WebElement alert;
	
	
	
	
	public ManageLocationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void locateManageLocation() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", manage_location);
//		manage_news.click();
		PageUtility pageutil = new PageUtility();
		pageutil.clickElement(driver, manage_location);
	}
	public void clickNew() {
		newbutton.click();
	}
	public void dropdowns() {
		PageUtility pageutility = new PageUtility();
	    pageutility.dropdownVisibleText(country, "United Kingdom");
	    pageutility.dropdownVisibleText(state, "Brechin");
	}
	public void enterlocation(String lname) {
		location.sendKeys(lname);
	}
	public void deliveryCharge(String charge) {
		delivery_charge.sendKeys(charge);
	}
	public void clickCreate() {
		submit.click();	
	}
	public void dropdown() {
		PageUtility pageutility=new PageUtility();
		pageutility.dropdownVisibleText(country,"United Kingdom"); 
		pageutility.dropdownVisibleText(state,"Brechin");
		
	}
	public static boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}


}
