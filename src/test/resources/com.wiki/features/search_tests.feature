Feature: Wikipedia Search

Scenario: English Search
  Given a search string is entered with English as selected language
  When the search button is clicked
  Then the results page title matches the search string

  Scenario: Search with different language selected
    Given a search string is entered with French as selected language
    When the search button is clicked
    Then the results page title matches the search string
    And a link is provided to results in English