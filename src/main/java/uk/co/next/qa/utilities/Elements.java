package uk.co.next.qa.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {

	WebDriver driver;

	public Elements(WebDriver driver) {
		this.driver = driver;
	}

	public void visibilityOfWebelement(WebElement element, long durationInSec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSec));
			WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void staticWait(long duratinInSec) {
		try {
			Thread.sleep(duratinInSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
