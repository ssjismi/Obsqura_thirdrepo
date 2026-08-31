package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void dropdownVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void clickElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

//	public void uploadFile(WebElement element, String filePath) {
//	    element.sendKeys(filePath);
//	}
	public void selectRadioButton(WebDriver driver, WebElement radioButton) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", radioButton);
	}
//	 public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
//
//	        Actions actions = new Actions(driver);
//
//	        actions.dragAndDrop(source, target).build().perform();
//	    }

}
