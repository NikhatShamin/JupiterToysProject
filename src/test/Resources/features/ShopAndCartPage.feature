Feature:Jupiter Toys-Shop Page and Cart Page

  Background:
  Test Case 3: Scenario--Shop Page and Cart Page
  1. Buy 2 Stuffed Frog,5 Fluffy Bunny, 3 Valentine Bear
  2. Go to the cart page
  3. Verify the subtotal for each product is correct
  4. Verify the price for each product
  5. Verify that total = sum(sub totals)

  Scenario Outline: Shop Page and Cart Page
    Given User is on home page
    When User clicks on Shop Page button
    Then Verify Shop Page is Open
    When User Buys "<StuffedFrog>","<FluffyBunny>","<ValentineBear>"
    And User goes to Cart page
    Then Verify Cart Page is open
    And Verify subtotal of each product "<StuffedFrogPrice>","<FluffyBunnyPrice>","<ValentineBearPrice>"
    And Verify the price of each product "<StuffedFrogPrice>","<FluffyBunnyPrice>","<ValentineBearPrice>"
    Then Verify the total sum of Shopping "<StuffedFrog>","<FluffyBunny>","<ValentineBear>" "<StuffedFrogPrice>","<FluffyBunnyPrice>","<ValentineBearPrice>"

    Examples:
      | StuffedFrog | FluffyBunny | ValentineBear | StuffedFrogPrice | FluffyBunnyPrice | ValentineBearPrice |
      | 2           | 5           | 3             | 10.99            | 9.99             | 14.99              |