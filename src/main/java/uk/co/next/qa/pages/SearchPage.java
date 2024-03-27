package uk.co.next.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	private WebDriver driver;

	@FindBy(id = "header-big-screen-search-box")
	private WebElement searchTextField;

	@FindBy(xpath = "//button[@type = 'submit']//img")
	private WebElement searchbtn;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnSearchTextField() {
		searchTextField.click();
	}

	public void searchProduct(String productName) {
		searchTextField.sendKeys(productName);
	}

	public ProductListingPage clickOnSearchbtn() {
		searchbtn.click();
		return new ProductListingPage(driver);
	}
}
