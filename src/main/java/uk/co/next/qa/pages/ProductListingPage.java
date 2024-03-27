package uk.co.next.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uk.co.next.qa.utilities.Elements;

public class ProductListingPage {

	private WebDriver driver;
	private Elements element;

	@FindBy(id = "desktop-sort-select-label")
	private WebElement sortText;

	@FindBy(xpath = "//*[text() = 'Myleene Klass Green Co-Ord Shirt']")
	private WebElement productName;

	@FindBy(xpath = "//div[contains(@aria-label,'adidas Red Blank Arsenal FC Stadium 23/24 Home Football Shirt £80')]//div[contains(@class,'produc-1kp3g5s')]//span[contains(text(),'£80')]")
	private WebElement productPrice;

	@FindBy(xpath = "//*[text() = 'Category']//parent::button")
	private WebElement clickOnCategoryIcon;

	@FindBy(xpath = "(//span[text() = 'Football Shirts']//parent::span//preceding-sibling::span)[1]")
	private WebElement selectCategory;

	@FindBy(xpath = "//*[text() = 'Gender']//parent::button")
	private WebElement clickonGenderIcon;

	@FindBy(xpath = "(//*[text() = 'Men']//parent::span//parent::span//preceding-sibling::span)[1]")
	private WebElement selectGender;

	@FindBy(xpath = "//img[@alt='adidas Red Blank Arsenal FC Stadium 23/24 Home Football Shirt (D28839) | £80']")
	private WebElement clickOnProduct;

	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean displaySort() {
		boolean st = sortText.isDisplayed();
		return st;
	}

	public String retriveProductName() {
		return productName.getText();
	}

	public String retriveProductPrice() {
		return productPrice.getText();
	}

	public void clickAndSelectCategory() {
		clickOnCategoryIcon.click();
		selectCategory.click();
		element = new Elements(driver);
		element.staticWait(3000);

	}

	public void clickAndSelectGender() {
		clickonGenderIcon.click();
		selectGender.click();
		element = new Elements(driver);
		element.staticWait(2000);

	}

	public ProducDetailsPage clickOnProduct() {
		element = new Elements(driver);
		element.visibilityOfWebelement(clickOnProduct, 10);
		clickOnProduct.click();
		return new ProducDetailsPage(driver);
	}

	public void scrollUptoProduct() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		element = new Elements(driver);
		element.staticWait(2000);
	}

	public void roadToProductListingPage(String SearchCategory) {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnCookiesAndStayOnWebSite();
		SearchPage searchpage = new SearchPage(driver);
		searchpage.clickOnSearchTextField();
		searchpage.searchProduct(SearchCategory);
		searchpage.clickOnSearchbtn();
	}

}
