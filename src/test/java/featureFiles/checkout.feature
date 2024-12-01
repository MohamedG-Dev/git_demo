Feature: Place the order for products

  @PlaceOrder
  Scenario Outline: Search Experience for product search in both home and Offers page
    Given User should be on GreenKart Landing page
    When User searched with short name <productShortName> and extract actual name of the product
    And Added "3" quantities of the selected product to the cart
    Then User proceeds to Checkout and validate the <productShortName> items in the checkout page
    And User has the ability to enter promocode and place the order

    Examples: 
      | productShortName |
      | Bro              |
      | Car              |