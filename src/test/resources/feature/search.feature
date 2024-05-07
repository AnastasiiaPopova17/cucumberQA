Feature: Search for a car by dates

@search
  Scenario: Search for a car in a city on specific dates
    Given User launches Chrome browser
    When User opens ilCarro HomePage
    And User enters city in the field
    And User selects the dates
    And User clicks on Yalla button
    Then User sees available cars in entered city for the entered dates