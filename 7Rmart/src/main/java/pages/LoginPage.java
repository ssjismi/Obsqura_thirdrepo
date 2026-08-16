package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Username']")WebElement usernamefield;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement passwordfield;
	@FindBy(xpath="//button[@type='submit']")WebElement submit;
	
	
	// for validation checking
	
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement alert;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);  //to initilaize webElements	
		
	}

	public void enterUsername(String username) {
		usernamefield.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordfield.sendKeys(password);
	}
	
	public void clickLogin() {
		submit.click();
		
	}
	
//	public void dropdown() {
//		PageUtility pageutility=new PageUtility();
//		pageutility.dropdownVisible(country,"india");
//		
//	}
//	
	//validation
	
	public boolean isDashboadDisplayed() {
		return dashboard.isDisplayed();
	}
	
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
