package uk.co.next.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;

	@FindBy(xpath = "//div[@class = 'account-menu']//h2")
	private WebElement myAccountSuccessHeading;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean displayMyAccountSuccessHeading() {
		boolean mash = myAccountSuccessHeading.isDisplayed();
		return mash;
	}
}
