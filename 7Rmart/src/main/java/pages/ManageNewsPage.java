package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ManageNewsPage {
	public WebDriver driver;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='nav-link']") WebElement manage_news;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']") WebElement text_area;
	@FindBy(xpath="//button[@type='submit']") WebElement submit;
	
	//validation check
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	static WebElement alert;
	
	
	
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void locateManageNews() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", manage_news);
		//manage_news.click();
	}
	public void clickNew() {
		newbutton.click();
	}
	public void enterdata(String username) {
		text_area.sendKeys(username);
	}
	
	public void clickCreate() {
		submit.click();
		
	}
	public static boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
