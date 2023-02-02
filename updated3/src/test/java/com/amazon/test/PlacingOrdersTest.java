package com.amazon.test;

import java.io.IOException;
import org.testng.annotations.Test;

import com.amazon.pageobjects.LoginPage;
import com.amazon.pageobjects.SingleProductPage;
import com.configproperties.Data;

public final class PlacingOrdersTest extends BaseTest {
	LoginPage loginPage;
	SingleProductPage singleProduct;

	private PlacingOrdersTest() {

	}

	@Test
	public void loginToApplication() throws IOException {

		homepage.launchTheApplication()
		.clickOnSignIn()
		.enterUserName(Data.property.getProperty("user"))
		.clickOnContinue()
		.enterUserPassword(Data.property.getProperty("password"))
		.clickOnLogin();
		
	}

	@Test(dataProvider = "getProductsData", dependsOnMethods = { "loginToApplication" })
	public void addTheProductsToCart(String p1, String p2, String p3, String p4) throws InterruptedException {

		String[] products = { p1, p2, p3, p4 };
		for (String product : products) {
			homepage.search(product)
			.clickOnProduct(product)
			.switchTo(product)
			.clickOnAddToCartBtn()
			.clickOnProceedToCheckOut()
			.closeCurrentTab();
			homepage.switchToHomePage().clearTheSearch();
		} homepage.goToCart();
	}

}
