package uk.co.next.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingBagPage {

	private WebDriver driver;

	@FindBy(xpath = "//div[@class='sb-items desktop-mode']//span[@class='page-title']")
	private WebElement successfullyNavigateToShoppingPage;

	@FindBy(xpath = "//button[@class='btn btn-primary sbm-idCheckoutButton sb-upward-lg-none'][normalize-space()='Checkout']")
	private WebElement CheckoutBtn;

	public ShoppingBagPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String retrieveSuccessfullyNavigateToShoppingBagPage() {
		return successfullyNavigateToShoppingPage.getText();
	}

	public LoginPage clickOnCheckOutButton() {
		CheckoutBtn.click();
		return new LoginPage(driver);
	}

	public void roadToShoppingBagPage(String SearchCategory) {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnCookiesAndStayOnWebSite();
		SearchPage searchpage = new SearchPage(driver);
		searchpage.clickOnSearchTextField();
		searchpage.searchProduct(SearchCategory);
		ProductListingPage plp = new ProductListingPage(driver);
		plp = searchpage.clickOnSearchbtn();
		plp.clickAndSelectCategory();
		plp.clickAndSelectGender();
		plp.scrollUptoProduct();
		ProducDetailsPage pdp = new ProducDetailsPage(driver);
		pdp = plp.clickOnProduct();
		pdp.chooseSizeOfProduct();
		pdp.productAddToBag();
		pdp.clickOnViewBag();
	}
}
