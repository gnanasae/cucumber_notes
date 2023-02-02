package com.amazon.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.amazon.pageobjects.SingleProductPage;

public final class RandomTest extends BaseTest {
	SingleProductPage sp;
	
	private RandomTest() {
		
	}

	@Test
	public void productSelection() throws InterruptedException {

		homepage.launchTheApplication();

		List<WebElement> products = driver
				.findElements(By.cssSelector("span[class='a-size-medium a-color-base a-text-normal']"));

		for (WebElement webElement : products) {

//			System.out.println(webElement.getText());

			String product = webElement.getText();

			if (product.startsWith("Nothing Phone")) {

				System.out.println(webElement.getText());
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", webElement);
				webElement.click();
				Thread.sleep(3000);
				break;
			}
		}
		homepage.switchTo("Nothing Phone");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement ac = driver.findElement(By.id("add-to-cart-button"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		js.executeScript("scroll(0,250)");
		
		wait.until(ExpectedConditions.visibilityOf(ac)).click();

		WebElement co = driver.findElement(By.id("attach-sidesheet-checkout-button"));

		

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(co)).click();

	}

}
