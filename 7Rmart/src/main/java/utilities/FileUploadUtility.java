package utilities;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void uploadFile(WebElement element, String filePath) {
	    element.sendKeys(filePath);
	}

}
