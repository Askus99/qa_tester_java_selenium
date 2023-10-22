Feature: Cart functionality

  Scenario: add and remove cart
    Given user login
    Then input username
    And input password
    And login
    Then add cart a T-shirt
    Then remove a T-shirt
