Feature: ItemPurchase

  Scenario: User can log in
    Given user is on login page
    When user input “standard_user”  in username field
    And user input “secret_sauce” in password field
    And user click on Login button
    Then user is successfully logged in
    And redirected to Home page

  Scenario: User can add item to cart
    Given user is logged in
    When user adds any item to cart
    And user goes to cart
    Then item is in cart

  Scenario: User can go to Checkout page
    Given user is logged in
    And user adds any item to cart
    And user goes to cart
    When user clicks on checkout button
    Then user is on Checkout page

  Scenario: User can go to confirm purchase page
    Given user is on checkout page with added item
    When user inputs “John” in first name field
    And user inputs “Smith” in lastname field
    And user inputs “10001” in zipcode field
    And user clicks on continue button
    Then user is on Confirm purchase page

  Scenario: User can confirm purchase
    Given user is on Confirm purchase Page
    When user clicks on finish button
    Then purchase is confirmed

  Scenario: User can return to homepage after purchase
    Given user has purchased an item
    When user clicks on back home button
    Then user is redirected to Home page
