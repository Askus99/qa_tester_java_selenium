Feature: Login functionality

  Scenario Outline: Ensure login functionality
    Given user the login page
    Then user write <username> as username
    And user write <password> as password
    And click login button
    Then user verify <status> login result

    Examples:
    |username       |password     |status   |
    |standard_user  |secret_sauce |success  |
    |unknown        |unknown      |failed   |