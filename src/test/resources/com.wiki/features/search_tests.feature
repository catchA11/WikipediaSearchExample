Feature: Wikipedia Search

Scenario: English Search
  Given a search string is entered with English as selected language
  When the search button is clicked
  Then the results page title matches the search string