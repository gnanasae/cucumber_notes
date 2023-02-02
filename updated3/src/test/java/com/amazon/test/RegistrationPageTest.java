package com.amazon.test;

import java.io.IOException;
import java.util.Map;
import org.testng.annotations.Test;

import com.amazon.pageobjects.RegistrationPage;

public final class RegistrationPageTest extends BaseTest {

	RegistrationPage registrationPage;
	
	private RegistrationPageTest() {

	}

	@Test(dataProvider = "getRegistrationData")
	public void registration(Map<String, String> map) throws IOException {
		homepage.launchTheApplication()
		.clickOnSignIn()
		.createNewAccount()
		.enterCustomerName(map.get("Customer_Name"))		
		.enterCustomerPhnNum(map.get("Customer_Phone_Number"))		
		.enterCustomerEmailId(map.get("Customber_EmailId"))
		.enterCustomerPassword(map.get("Customer_pswd"));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
