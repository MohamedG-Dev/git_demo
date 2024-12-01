Feature: Search and Place the order for products

  @OffersPage
  Scenario Outline: Search Experience for product search in both home and Offers page
    Given User should be on GreenKart Landing page
    When User searched with short name <productShortName> and extract actual name of the product
    Then User searched <productShortName> short name in offers page
    And Validate product name in offers page matched with the landing page

    Examples: 
      | productShortName |
      | Tom              |
      | Beet             |
