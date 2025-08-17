Feature: Login
  @positive
  Scenario:Login with proposed data
    Given User is on the Home Page
    When User clicks on Form Authentication link
    And User enters proposed data
    And User clicks on Login button
    Then User verifies Success message is displayed