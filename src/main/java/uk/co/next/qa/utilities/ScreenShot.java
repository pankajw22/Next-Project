package uk.co.next.qa.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static String captureScreenShot(WebDriver driver, String testName) {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+ "\\ScreenShot\\" +testName+ ".png";
		try {
			FileHandler.copy(source, new File (destination));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return destination;
	}
}
