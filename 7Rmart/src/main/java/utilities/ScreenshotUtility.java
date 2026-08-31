package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; // convert webdriver to screenshot mode
		// selenium webdriver cannot take screenshots directly so typecast to take
		// screenshot
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); // capture the screenshot-store it temporarly as a
																	// file
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// create data and time(date
																							// is a class to get current
																							// date)
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");

		if (!f1.exists()) { // create a folder if it does not exist
			f1.mkdirs(); // if dir not exists,make it
		}

		String destination = System.getProperty("user.dir") + "//OutputScreenShot//" + failedTestCase + timeStamp
				+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); // decide final screenshot path
	}

}
