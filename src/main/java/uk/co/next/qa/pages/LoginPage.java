package uk.co.next.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	@FindBy(id = "EmailOrAccountNumber")
	private WebElement emailID;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(id = "SignInNow")
	private WebElement signINbtn;

	@FindBy(xpath = "//div[text() = 'Please check your sign in details are correct and try again.']")
	private WebElement incorrectSignINMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterEmailID(String email) {
		emailID.sendKeys(email);
	}

	public void enterPassword(String passwordText) {
		password.sendKeys(passwordText);
	}

	public DeliveryPage clickOnSignINbtn() {
		signINbtn.click();
		return new DeliveryPage(driver);
	}

	public String retrieveInCorrectSignINDetailsMessage() {
		String ism = incorrectSignINMessage.getText();
		return ism;
	}

}
