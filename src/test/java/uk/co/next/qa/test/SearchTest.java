package uk.co.next.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.next.qa.base.BaseClass;
import uk.co.next.qa.pages.HomePage;
import uk.co.next.qa.pages.LoginPage;
import uk.co.next.qa.pages.ProductListingPage;
import uk.co.next.qa.pages.SearchPage;

public class SearchTest extends BaseClass {

	public WebDriver driver;
	SearchPage searchpage;
	HomePage homepage;
	LoginPage loginpage;
	ProductListingPage plp;

	@BeforeMethod
	public void setup() {
		driver = launchBrowserAndOpenApplication();
		homepage = new HomePage(driver);
		homepage.clickOnCookiesAndStayOnWebSite();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchValidProductName() {
		searchpage = new SearchPage(driver);
		searchpage.clickOnSearchTextField();
		searchpage.searchProduct(dataprop.getProperty("SearchProduct"));
		plp = searchpage.clickOnSearchbtn();

		Assert.assertTrue(plp.displaySort(), "Sort is not Displayed");

	}

	@Test(priority = 2)
	public void verifySearchInvalidProductName() {
		searchpage = new SearchPage(driver);
		searchpage.clickOnSearchTextField();
		searchpage.searchProduct(dataprop.getProperty("InvalidProductName"));
		plp = searchpage.clickOnSearchbtn();

		Assert.assertTrue(plp.displaySort(), "Sort is not Displayed");
	}
}
