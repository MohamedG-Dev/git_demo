package pageObjectsRepository;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckOutPage checkoutPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}

	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CheckOutPage getCheckOutPage() {
		return checkoutPage = new CheckOutPage(driver);
	}
}
