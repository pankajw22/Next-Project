package uk.co.next.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uk.co.next.qa.utilities.Elements;

public class ProducDetailsPage {

	private WebDriver driver;
	private Elements element;

	@FindBy(xpath = "//div[@class='formControls']//label[@for='Size-D28-839']")
	private WebElement displaySuccessMessage;

	@FindBy(xpath = "(//*[text() = 'Choose Size'])[1]")
	private WebElement clickOnChooseBtn;

	@FindBy(xpath = "//a[normalize-space()='Small']")
	private WebElement chooseSize;

	@FindBy(xpath = "//a[normalize-space()='ADD TO BAG']")
	private WebElement clickAddToBag;

	@FindBy(xpath = "//div[@class = 'header-adaptive-checkout header-1yhi8dp']//a[normalize-space () = 'Checkout']")
	private WebElement displayCheckoutbtn;

	@FindBy(xpath = "//a[normalize-space() = 'View Bag']")
	private WebElement ViewBag;

	public ProducDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean retrievePDPSuccessMessage() {
		return displaySuccessMessage.isDisplayed();
	}

	public void chooseSizeOfProduct() {
		clickOnChooseBtn.click();
		chooseSize.click();
	}

	public void productAddToBag() {
		element = new Elements(driver);
		element.visibilityOfWebelement(clickAddToBag, 5);
		clickAddToBag.click();
	}

	public String retrieveCheckoutButtonText() {
		return displayCheckoutbtn.getText();
	}

	public ShoppingBagPage clickOnViewBag() {
		element = new Elements(driver);
		element.visibilityOfWebelement(ViewBag, 10);
		ViewBag.click();
		return new ShoppingBagPage(driver);
	}

	public void roadToProductDetailsPage(String SearchCategory) {
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
		plp.clickOnProduct();
	}
}
