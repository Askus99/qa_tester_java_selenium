Feature: Checkout functionality
  Scenario: Checkout success
    Given add chart
    Then click cart
    Then click checkout
    Then fill the input
    Then finish
    Then back home