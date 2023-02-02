package com.amazon.pageobjects;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.configproperties.Data;

public final class HomePage extends BasePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// page objects
	@FindBy(id = "nav-link-accountList")
	private WebElement homePageSignInButton;

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@FindBy(css = "span[class='a-size-medium a-color-base a-text-normal']")
	private List<WebElement> listOfProducts;

	// page actions
	public LoginPage clickOnSignIn() {
		click(homePageSignInButton);
		return new LoginPage(driver);
	}

	public HomePage search(String productName) {
		searchBox.sendKeys(productName, Keys.ENTER);
		return this;

	}

	public HomePage launchTheApplication() {
		driver.get(Data.property.getProperty("url"));
		return this;
	}

	public HomePage clickOnProduct(String title) throws InterruptedException {

		for (WebElement webElement : listOfProducts) {
			String product = getTheText(webElement);
			if (product.startsWith(title)) {
				System.out.println(product);
				scrollInToTheView(webElement);
				click(webElement);
				Thread.sleep(3000);
				break;
			}
		}
		return this;

	}

	public void clearTheSearch() {
		clear(searchBox);
	}
}
