package uk.co.next.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.next.qa.base.BaseClass;
import uk.co.next.qa.pages.ProducDetailsPage;
import uk.co.next.qa.pages.ShoppingBagPage;

public class PDPTest extends BaseClass {

	public WebDriver driver;
	ProducDetailsPage pdp;

	@BeforeMethod
	public void setup() {
		driver = launchBrowserAndOpenApplication();
		pdp = new ProducDetailsPage(driver);
		pdp.roadToProductDetailsPage(dataprop.getProperty("SearchProduct"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyToChooseSizeOfProduct() {
		pdp = new ProducDetailsPage(driver);
		pdp.chooseSizeOfProduct();
	}

	@Test(priority = 2, dependsOnMethods = "verifyToChooseSizeOfProduct")
	public void verifyAddProductToBag() {
		pdp = new ProducDetailsPage(driver);
		pdp.chooseSizeOfProduct();
		pdp.productAddToBag();
		Assert.assertEquals(pdp.retrieveCheckoutButtonText(), "Checkout");
	}

	@Test(priority = 3, dependsOnMethods = "verifyAddProductToBag")
	public void verifyProductAddingInShoppingBag() {
		pdp = new ProducDetailsPage(driver);
		pdp.chooseSizeOfProduct();
		pdp.productAddToBag();
		ShoppingBagPage sbp = pdp.clickOnViewBag();

		Assert.assertEquals(sbp.retrieveSuccessfullyNavigateToShoppingBagPage(), "Shopping Bag");
	}
}
