package com.amazon.test;

import java.io.IOException;
import org.testng.annotations.Test;

import com.amazon.pageobjects.LoginPage;
import com.configproperties.Data;

public final class CartPageTest extends BaseTest {
	LoginPage loginPage;

	private CartPageTest() {

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

	@Test(dependsOnMethods = { "loginToApplication" })
	public void checkTheProductsOnCart() {
		String currentName = new Throwable().getStackTrace()[0].getMethodName();
		homepage.goToCart();
		captureScreenshot(currentName);

	}

}
