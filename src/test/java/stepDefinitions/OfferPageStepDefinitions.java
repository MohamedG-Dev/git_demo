package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjectsRepository.LandingPage;
import pageObjectsRepository.OffersPage;
import pageObjectsRepository.PageObjectManager;
import utilities.TestBase;

public class OfferPageStepDefinitions {
	public String offerPageProductName;
	public TestBase testBase;
	public PageObjectManager pageObjectManager;

	public OfferPageStepDefinitions(TestBase testBase) {
		this.testBase = testBase;
	}

	@Then("^User searched (.+) short name in offers page$")
	public void user_searched_same_short_name_in_offers_page(String shortName) throws InterruptedException {
		switchToOffersPage();
		OffersPage offersPage =testBase.pageObjectManager.getOffersPage();
		offersPage.enterSearchItem(shortName);
		Thread.sleep(3000);
		offerPageProductName=offersPage.getProductName();
		System.out.println("Searched product in the top deals page is: " + offerPageProductName);
	}

	public void switchToOffersPage() {
		LandingPage landingPage = testBase.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsLink();
		testBase.genericUtils.switchWindowToChild();
	}
	@Then("Validate product name in offers page matched with the landing page")
	public void validate_product_name_in_offers_page_matched_with_the_landing_page() {
		Assert.assertEquals(testBase.landingPageProductName, offerPageProductName);
	}

}
