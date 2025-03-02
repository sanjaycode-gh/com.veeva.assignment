@warriorsTest @warriorsJacketsTest @Tests
Feature: Finding all the jackets available in warriors shopping page and storing the price, title and top seller message to a text file

  Scenario: Adding mens jackets price, title and message into txt file
    Given user is on warriors Homepage "Data.WarriorsData.WarriorsUrl"
    When user navigates to shopping menu
    Then user verifies it should be on warriors shopping page
    When user searches for all the "Data.WarriorsData.SubMenu" "Data.WarriorsData.Product"
    And user saves products title and price details into a text file

