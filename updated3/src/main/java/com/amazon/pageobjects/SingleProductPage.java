package com.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class SingleProductPage extends BasePage {
	private WebDriver driver;

	public SingleProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page objects
	@FindBy(id = "add-to-cart-button")
	private WebElement addToCartBtn;

	@FindBy(id = "attach-sidesheet-checkout-button")
	private WebElement proceedToCheckOutBtn;

	// page actions
	public SingleProductPage clickOnAddToCartBtn() {
		waitForElement(addToCartBtn);
		moveToTheElement(addToCartBtn);
		click(addToCartBtn);
		return this;
	}

	public CartPage clickOnProceedToCheckOut() {
		waitForElementToBeClickable(proceedToCheckOutBtn);
		click(proceedToCheckOutBtn);
		return new CartPage(driver);
	}

}
