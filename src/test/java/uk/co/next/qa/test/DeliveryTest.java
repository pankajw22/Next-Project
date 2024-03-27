package uk.co.next.qa.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import uk.co.next.qa.base.BaseClass;
import uk.co.next.qa.pages.DeliveryPage;

public class DeliveryTest extends BaseClass {

	public WebDriver driver;
	DeliveryPage dp;

	@BeforeMethod
	public void setup() {
		driver = launchBrowserAndOpenApplication();
		dp = new DeliveryPage(driver);
		dp.roadToDeliveryPage(dataprop.getProperty("SearchProduct"), prop.getProperty("EmailId"),
				prop.getProperty("Password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


	@Test
	public void verifySizeAndQuantityofProduct() {
		dp = new DeliveryPage(driver);
		String sizeText = dp.retrieveProductSizeText();
		String quantityText = dp.retrieveProductQuantityText();
		System.out.println(sizeText);
		System.out.println(quantityText);

		Assert.assertEquals(sizeText, "Small");
		Assert.assertEquals(quantityText, "1");

	}
}
