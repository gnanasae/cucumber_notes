package com.amazon.pageobjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected String homePage;

	// page objects
	@FindBy(id = "nav-cart")
	WebElement cartBtn;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	// page actions
	protected void click(WebElement ele) {
		ele.click();
	}

	protected void sendKeys(WebElement ele, String input) {
		ele.sendKeys(input);
	}

	protected void clear(WebElement ele) {
		ele.clear();

	}

	public CartPage goToCart() {
		cartBtn.click();
		return new CartPage(driver);
	}

	public void closeCurrentTab() {
		driver.close();
	}

	protected String getTheText(WebElement ele) {
		return ele.getText();

	}

	protected void moveToTheElement(WebElement ele) {
		new Actions(driver).moveToElement(ele).build().perform();
	}

	// based on title switch to window
	public SingleProductPage switchTo(String productName) {
		homePage = driver.getWindowHandle();
		Set<String> pages = driver.getWindowHandles();
		Iterator<String> itr = pages.iterator();
		while (itr.hasNext()) {
			String title = driver.switchTo().window(itr.next()).getTitle();
			if (title.contains(productName)) {
				driver.switchTo().window(itr.next());
			}
		}
		return new SingleProductPage(driver);

	}

	public HomePage switchToHomePage() {
		driver.switchTo().window(homePage);
		return new HomePage(driver);
	}

	protected void waitForElement(WebElement ele) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ele));

	}

	protected void waitForElementToBeClickable(WebElement ele) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(ele));
	}

	protected void scrollDown() {
		((JavascriptExecutor) driver).executeScript("scroll(0,250);");
	}

	protected void scrollInToTheView(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
}