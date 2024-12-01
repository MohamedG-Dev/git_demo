package pageObjectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;

	private By searchBox = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDealsLink = By.linkText("Top Deals");
	private By incrementButton = By.cssSelector("a.increment");
	private By addToCartButton = By.xpath("//button[text()='ADD TO CART']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterSearchItem(String itemName) {
		driver.findElement(searchBox).sendKeys(itemName);
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void selectTopDealsLink() {
		driver.findElement(topDealsLink).click();
	}

	public String getTitleLandingPage() {
		return driver.getTitle();
	}

	public void incrementQuantity(int quantity) {
		int i = quantity - 1;
		while (i > 0) {
			driver.findElement(incrementButton).click();
			i--;
		}
	}

	public void addToCart() {
		driver.findElement(addToCartButton).click();
	}
}
