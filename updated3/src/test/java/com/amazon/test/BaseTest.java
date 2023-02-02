package com.amazon.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.amazon.pageobjects.HomePage;
import com.configproperties.Data;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends Data {

	protected WebDriver driver;
	protected HomePage homepage;

	protected WebDriver driverSetup() throws IOException {

		String browserName = property.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {

			// chrome
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			// firefox
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge") || browserName.equalsIgnoreCase("ie")
				|| browserName.equalsIgnoreCase("Internet Explorer")) {

			// edge browser
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		// page load timeout
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// delete cookies
		driver.manage().deleteAllCookies();

		return driver;

	}

	protected void captureScreenshot(String fileName) {

		// Convert web driver object to TakeScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;

		// Call getScreenshotAs method to create image file
		File srcFile = ts.getScreenshotAs(OutputType.FILE);

		// move image file to new destination
		File destFile = new File(System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".jpg");

		// Copy file at destination
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass(alwaysRun = true)
	protected HomePage launchApplication() throws IOException {
		Data.readThePropertyFile();
		driver = driverSetup();
		homepage = new HomePage(driver);
		return homepage;

	}

	@AfterClass(alwaysRun = true)
	protected void closeAllOpenedTabs() {
		driver.quit();
	}

}
