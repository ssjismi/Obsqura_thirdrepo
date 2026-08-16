package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.PageUtility;

public class CategoryPage {
	public WebDriver driver;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='nav-link']") WebElement manage_category;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath="//input[@id='category']") WebElement category;
	@FindBy(xpath="//li[@id='1-selectable']") WebElement sourcedrop;
	@FindBy(xpath="//div[@class='ms-selection']") WebElement targetdrop;
	@FindBy(xpath="//input[@id='main_img']") WebElement library;
	@FindBy(xpath="//input[@value='yes' and @name='top_menu']") WebElement first_radio;
	@FindBy(xpath="//input[@value='yes' and @name='show_home']") WebElement second_radio;
	@FindBy(xpath="//button[@type='submit']") WebElement submit;
	
	//validation check
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	static WebElement alert;
	
	
	
	
	public CategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void locateCategory() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", manage_location);
//		manage_news.click();
		PageUtility pageutil = new PageUtility();
		pageutil.clickElement(driver, manage_category);
	}
	public void clickNew() {
		newbutton.click();
	}
	public void clickCategory(String word) {
		category.sendKeys(word);
	}
	public void listselect() {
		sourcedrop.click();
	}

	public void fileupload() {
		PageUtility pageutility = new PageUtility();
	    pageutility.uploadFile(library,Constant.TESTDATA);
	    pageutility.selectRadioButton(driver, first_radio);
	    pageutility.selectRadioButton(driver, second_radio); 
	}
//	public void radioButtons() {
//		first_radio.click();
//		second_radio.click();
//	}

	public void clickCreate() {
		PageUtility pageutility = new PageUtility();
		pageutility.clickElement(driver, submit);
		//submit.click();	
	}
	public static boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}


}
