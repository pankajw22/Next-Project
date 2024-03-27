package uk.co.next.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.next.qa.base.BaseClass;
import uk.co.next.qa.pages.DeliveryPage;
import uk.co.next.qa.pages.LoginPage;
import uk.co.next.qa.pages.ShoppingBagPage;

public class ShoppingBagTest extends BaseClass {

	public WebDriver driver;
	ShoppingBagPage sbp;

	@BeforeMethod
	public void setup() {
		driver = launchBrowserAndOpenApplication();
		sbp = new ShoppingBagPage(driver);
		sbp.roadToShoppingBagPage(dataprop.getProperty("SearchProduct"));

	}

	@Test(priority = 1)
	public void verifyGoToCheckOut() {
		sbp = new ShoppingBagPage(driver);
		LoginPage lp = sbp.clickOnCheckOutButton();
		lp.enterEmailID(prop.getProperty("EmailId"));
		lp.enterPassword(prop.getProperty("Password"));
		DeliveryPage dp = lp.clickOnSignINbtn();


		Assert.assertTrue(dp.retrieveSuccessfullyNavigateToDeliveryPageMessage(), "Delivery");

	}

}
