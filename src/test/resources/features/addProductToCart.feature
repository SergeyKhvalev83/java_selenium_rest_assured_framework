# Add product to cart
#User Story:
#As a logged-in user, I want to add a product to my cart so that I can purchase it later.
#Acceptance Criteria:
#Log in successfully
#Click Add to cart for one product
#Verify cart badge shows 1
#Open cart
#Verify selected product is displayed in the cart

Feature: Add product to cart

  Background: Login with simple user parameter
    @Test
  Scenario: Add Sauce Labs Backpack to the cart
    Given the user is logged in and on Home page
    When the user clicks Add to cart for "Sauce Labs Backpack"
    Then the cart badge should display "1"
    When the user opens the shopping cart
    Then the product "Sauce Labs Backpack" should be displayed in the cart