package pageObjectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	WebDriver driver;

	private By cartIcon = By.cssSelector("img[alt='Cart']");
	private By proceedCheckoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	private By promoButton = By.cssSelector(".promoBtn");
	private By placeOrderButton = By.xpath("//button[text()='Place Order']");
	private By productName = By.cssSelector("p.product-name");

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void checkOutItems() {
		driver.findElement(cartIcon).click();
		driver.findElement(proceedCheckoutButton).click();
	}

	public boolean verifyPromoButton() {
		return driver.findElement(promoButton).isDisplayed();
	}

	public boolean verifyPlaceOrderButton() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}
}
