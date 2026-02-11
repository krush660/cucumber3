Feature: Successful Product Purchase Workflow

  Scenario: User completes end-to-end purchase
    Given the user navigates to the SauceDemo login page
    When the user logs in with valid credentials
    And the user adds "Sauce Labs Backpack" and "Sauce Labs Bolt T-Shirt" to the cart
    And the user verifies the items in the cart
    And the user proceeds to checkout
    And the user enters checkout details "Krushnal" "QA" "440001"
    And the user completes the purchase
    Then the user should see the order confirmation message
