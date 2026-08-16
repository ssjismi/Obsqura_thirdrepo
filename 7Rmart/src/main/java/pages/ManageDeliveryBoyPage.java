package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'and @class=' nav-link']") WebElement manage_deliveryboy;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//input[@id='name']") WebElement name;
	@FindBy(xpath="//input[@id='email']") WebElement email;
	@FindBy(xpath="//input[@id='phone']") WebElement phone;
	@FindBy(xpath="//textarea[@id='address']") WebElement address;
	@FindBy(xpath="//input[@id='username']") WebElement username;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement submit;
	
	//validation check
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	static WebElement alert;
	
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void locateManageDeliveryBoy() {
		PageUtility pageutil = new PageUtility();
		pageutil.clickElement(driver, manage_deliveryboy);
	}
	public void clickNew() {
		newbutton.click();
	}
	public void Usename(String uname) {
		name.sendKeys(uname);
	}
	
	public void Enteremail(String mail) {
		email.sendKeys(mail);
	}
	public void Usephone(String phn) {
		phone.sendKeys(phn);
	}
	public void Enteraddress(String add) {
		address.sendKeys(add);
	}
	public void EnterUsername(String name2) {
		username.sendKeys(name2);
	}
	public void passcode(String pass) {
		password.sendKeys(pass);
	}
	public void clickCreate() {
		PageUtility pageutil = new PageUtility();
		pageutil.clickElement(driver, submit);
		//submit.click();	
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}



}
