package pageObjectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	public WebDriver driver;
	
	private By searchBox = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tr td:nth-child(1)");

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterSearchItem(String itemName) {
		driver.findElement(searchBox).sendKeys(itemName);
	}
	
	public String getProductName() {
		 return driver.findElement(productName).getText();
	}
}
