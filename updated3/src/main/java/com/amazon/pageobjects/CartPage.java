package com.amazon.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class CartPage extends BasePage {

	private WebDriver driver;

	// page objects
	@FindBy(xpath = "//*[@id='activeCartViewForm']/div[@data-name='Active Items']/div[@data-asin]//span[@class='a-truncate-cut']")
	private List<WebElement> itemsOnCartEle;

	// constructor
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page actions
	public void itemsOnCartPage() {
		for (WebElement ele : itemsOnCartEle) {
			String cartItem = ele.getText();
			if (cartItem.contains("Apple iPhone 12")) {
				System.out.println("item added succesfully");
			}
		}
	}

}
