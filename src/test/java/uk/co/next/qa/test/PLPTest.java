package uk.co.next.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.next.qa.base.BaseClass;
import uk.co.next.qa.pages.ProducDetailsPage;
import uk.co.next.qa.pages.ProductListingPage;

public class PLPTest extends BaseClass {

	public WebDriver driver;
	ProductListingPage plp;

	@BeforeMethod
	public void setup() {
		driver = launchBrowserAndOpenApplication();
		plp = new ProductListingPage(driver);
		plp.roadToProductListingPage(dataprop.getProperty("SearchProduct"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyProductDisplayNameAndPrice() {
		plp = new ProductListingPage(driver);
		plp.scrollUptoProduct();
		Assert.assertEquals(plp.retriveProductName(), "Myleene Klass Green Co-Ord Shirt");
		Assert.assertEquals(plp.retriveProductPrice(), "£80");
	}

	@Test(priority = 2)
	public void verifyFilterProductByCategoryAndGender() {
		plp = new ProductListingPage(driver);
		plp.clickAndSelectCategory();
		plp.clickAndSelectGender();
	}

	@Test(priority = 3, dependsOnMethods = "verifyFilterProductByCategoryAndGender")
	public void verifyByClickingOnProduct() {
		plp = new ProductListingPage(driver);
		plp.clickAndSelectCategory();
		plp.clickAndSelectGender();
		plp.scrollUptoProduct();
		ProducDetailsPage pdp = plp.clickOnProduct();

		Assert.assertTrue(pdp.retrievePDPSuccessMessage(), "Successful Message is not Display");

	}

}
