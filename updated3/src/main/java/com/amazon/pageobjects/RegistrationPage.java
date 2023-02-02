package com.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class RegistrationPage extends BasePage {
	private WebDriver driver;

	// page objects
	@FindBy(id = "ap_customer_name")
	private WebElement customerNameEle;

	@FindBy(id = "ap_phone_number")
	private WebElement customerPhnEle;

	@FindBy(id = "ap_email")
	private WebElement emailIdEle;

	@FindBy(id = "ap_password")
	private WebElement customerPassword;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RegistrationPage enterCustomerName(String customerName) {
		sendKeys(customerNameEle, customerName);
		return this;
	}

	public RegistrationPage enterCustomerPhnNum(String phoneNum) {
		sendKeys(customerPhnEle, phoneNum);
		return this;
	}

	public RegistrationPage enterCustomerEmailId(String emailId) {
		sendKeys(emailIdEle, emailId);
		return this;
	}

	public RegistrationPage enterCustomerPassword(String password) {
		sendKeys(customerPassword, password);
		return this;
	}

}
