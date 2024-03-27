package uk.co.next.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.next.qa.base.BaseClass;
import uk.co.next.qa.pages.HomePage;
import uk.co.next.qa.pages.LoginPage;
import uk.co.next.qa.pages.MyAccountPage;

public class LoginTest extends BaseClass {

	public WebDriver driver;
	LoginPage loginpage;

	@BeforeMethod
	public void setup() {
		driver = launchBrowserAndOpenApplication();
		HomePage homepage = new HomePage(driver);
		homepage.roadToLogin();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmailID(prop.getProperty("EmailId"));
		loginpage.enterPassword(prop.getProperty("Password"));
		loginpage.clickOnSignINbtn();

		MyAccountPage myaccount = new MyAccountPage(driver);
		Assert.assertTrue(myaccount.displayMyAccountSuccessHeading(), "My Account Heading is Not Displayed");
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		loginpage = new LoginPage(driver);
		loginpage.enterEmailID(dataprop.getProperty("InvalidEmail"));
		loginpage.enterPassword(dataprop.getProperty("InvalidPassword"));
		loginpage.clickOnSignINbtn();

		Assert.assertEquals(loginpage.retrieveInCorrectSignINDetailsMessage(),
				"Please check your sign in details are correct and try again.");

	}
}
