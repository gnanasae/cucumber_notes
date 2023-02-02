package com.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class LoginPage extends BasePage {

	private WebDriver driver;

	// constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page objects
	@FindBy(id = "createAccountSubmit")
	private WebElement createYourAcBtn;

	@FindBy(id = "ap_email")
	private WebElement userNameEle;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	@FindBy(id = "ap_password")
	private WebElement passwordEle;

	@FindBy(id = "signInSubmit")
	private WebElement signInSubmitBtn;

	// page actions
	public LoginPage enterUserName(String username) {
		sendKeys(userNameEle, username);
		return this;
	}

	public LoginPage enterUserPassword(String password) {
		sendKeys(passwordEle, password);
		return this;
	}

	public LoginPage clickOnContinue() {
		click(continueBtn);
		return this;
	}

	public void clickOnLogin() {
		click(signInSubmitBtn);
	}

	public RegistrationPage createNewAccount() {
		click(createYourAcBtn);
		return new RegistrationPage(driver);
	}
}
