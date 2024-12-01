package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjectsRepository.CheckOutPage;
import utilities.TestBase;

public class CheckoutStepDefinitions {
	TestBase testBase;
	CheckOutPage checkOutPage;

	public CheckoutStepDefinitions(TestBase testBase) {
		this.testBase = testBase;
		this.checkOutPage = testBase.pageObjectManager.getCheckOutPage();
	}

	@Then("^User proceeds to Checkout and validate the (.+) items in the checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_car_items_in_the_checkout_page(String vegetableName) {
		checkOutPage.checkOutItems();
		// Assertion to extract name fromm the screen and compare with the vegetableName
		// variable
		String itemName = checkOutPage.getProductName().split("-")[0].trim();
		System.out.println("itemName");
		Assert.assertTrue(itemName.startsWith(vegetableName));
	}

	@Then("User has the ability to enter promocode and place the order")
	public void user_has_the_ability_to_enter_promocode_and_place_the_order() {
		Assert.assertTrue(checkOutPage.verifyPromoButton());
		Assert.assertTrue(checkOutPage.verifyPlaceOrderButton());
	}

}
