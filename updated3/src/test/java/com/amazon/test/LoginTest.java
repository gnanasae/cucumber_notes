package com.amazon.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.configproperties.Data;

//@Listeners({ MyListeners.class })
public final class LoginTest extends BaseTest {

	private LoginTest() {

	}

	@Test
	public void loginToApplication() {
		homepage.launchTheApplication()
		.clickOnSignIn()
		.enterUserName(Data.property.getProperty("user"))
		.clickOnContinue()
		.enterUserPassword(Data.property.getProperty("password"))
		.clickOnLogin();
		
		captureScreenshot("login");

	}
}
