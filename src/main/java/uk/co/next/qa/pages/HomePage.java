package uk.co.next.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	@FindBy(xpath = "//div[@class = 'header-1n6kbbr']//img")
	private WebElement myAccount;

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement allowCookies;

	@FindBy(xpath = "//span[text() = 'Stay on Next.co.uk']")
	private WebElement stayOnWebsite;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCookiesAndStayOnWebSite() {
		allowCookies.click();
		//stayOnWebsite.click();
	}

	public LoginPage clickOnMyAccount() {
		myAccount.click();
		return new LoginPage(driver);
	}

	public void roadToLogin() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnCookiesAndStayOnWebSite();
		homepage.clickOnMyAccount();
	}
}
