package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	PageUtility pageutil = new PageUtility();
//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'and @class=' nav-link']") WebElement manage_deliveryboy;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//input[@id='name']") WebElement name;
	@FindBy(xpath="//input[@id='email']") WebElement email;
	@FindBy(xpath="//input[@id='phone']") WebElement phone;
	@FindBy(xpath="//textarea[@id='address']") WebElement address;
	@FindBy(xpath="//input[@id='username']") WebElement username;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement submit;
	
	//validation check
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//	public void locateManageDeliveryBoy() {
//		
//		pageutil.clickElement(driver, manage_deliveryboy);
//	}
	public ManageDeliveryBoyPage clickNew() {
		newbutton.click();
		return this;
	}
	public ManageDeliveryBoyPage Usename(String uname) {
		name.sendKeys(uname);
		return this;
	}
	
	public ManageDeliveryBoyPage Enteremail(String mail) {
		email.sendKeys(mail);
		return this;
	}
	public ManageDeliveryBoyPage Usephone(String phn) {
		phone.sendKeys(phn);
		return this;
	}
	public ManageDeliveryBoyPage Enteraddress(String add) {
		address.sendKeys(add);
		return this;
	}
	public ManageDeliveryBoyPage EnterUsername(String name2) {
		username.sendKeys(name2);
		return this;
	}
	public ManageDeliveryBoyPage passcode(String pass) {
		password.sendKeys(pass);
		return this;
	}
	public ManageDeliveryBoyPage clickCreate() {
		pageutil.clickElement(driver, submit);
		//submit.click();	
		return this;
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}



}
