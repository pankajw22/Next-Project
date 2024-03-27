package uk.co.next.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryPage {

	private WebDriver driver ;

	@FindBy (xpath = "//*[text() = 'Delivery']")
	private WebElement successfullyNavigate;

	@FindBy (xpath = "//td[normalize-space()='Small']")
	private WebElement checkSize;

	@FindBy (xpath = "//td[normalize-space()='1']")
	private WebElement quantity;

	public DeliveryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean retrieveSuccessfullyNavigateToDeliveryPageMessage() {
		return successfullyNavigate.isDisplayed();
	}

	public String retrieveProductSizeText() {
		return checkSize.getText();
	}

	public String retrieveProductQuantityText() {
		return quantity.getText();
	}

	public void roadToDeliveryPage(String SearchCategory, String email, String password) {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnCookiesAndStayOnWebSite();
		SearchPage searchpage = new SearchPage(driver);
		searchpage.clickOnSearchTextField();
		searchpage.searchProduct(SearchCategory);
		searchpage.clickOnSearchbtn();
		ProductListingPage plp = new ProductListingPage(driver);
		plp.clickAndSelectCategory();
		plp.clickAndSelectGender();
		plp.scrollUptoProduct();
		plp.clickOnProduct();
		ProducDetailsPage pdp = new ProducDetailsPage(driver);
		pdp.chooseSizeOfProduct();
		pdp.productAddToBag();
		pdp.clickOnViewBag();
		ShoppingBagPage sbp = new ShoppingBagPage(driver);
		sbp.clickOnCheckOutButton();
		LoginPage lp = new LoginPage(driver);
		lp.enterEmailID(email);
		lp.enterPassword(password);
		lp.clickOnSignINbtn();
	}
}
