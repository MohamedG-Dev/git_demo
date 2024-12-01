package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjectsRepository.LandingPage;
import utilities.TestBase;

public class LandingPageStepDefinitions {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestBase testBase;
	LandingPage landingPage;

	public LandingPageStepDefinitions(TestBase testBase) {
		this.testBase = testBase;
		this.landingPage = testBase.pageObjectManager.getLandingPage();
	}

	@Given("User should be on GreenKart Landing page")
	public void user_should_be_on_green_cart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^User searched with short name (.+) and extract actual name of the product$")
	public void user_searched_with_short_name_and_extract_actual_name_of_the_product(String shortname)
			throws InterruptedException {

		landingPage.enterSearchItem(shortname);
		Thread.sleep(3000);
		testBase.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println("Searched product is: " + testBase.landingPageProductName);
	}

	@When("Added {string} quantities of the selected product to the cart")
	public void added_quantities_of_the_selected_product_to_the_cart(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}

}
