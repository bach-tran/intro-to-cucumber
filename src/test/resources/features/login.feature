Feature: Login

  Scenario: Valid login credentials
    Given User is at the login page
    When User types in a username of "username"
    And User types in a password of "password"
    And User clicks the login button
    Then User should be redirected to the homepage

  Scenario: Valid username, invalid password
    Given User is at the login page
    When User types in a username of "username"
    And User types in a password of "test123"
    And User clicks the login button
    Then User should receive a popup alert saying "invalid login"