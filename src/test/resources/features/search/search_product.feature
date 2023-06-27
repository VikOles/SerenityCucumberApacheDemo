Feature: Search Product

  Scenario: Search product by price and filter
    Given open page
    And search for "Portable Charger"
    And Set price from "20" to "50"
    And Select filter APPLE_IPHONE
    When Select 5 product
    Then Product page opened