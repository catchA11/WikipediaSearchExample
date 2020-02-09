Feature: Wikipedia Search

  Scenario: English Search
    When a search is entered with English as selected language
    Then the results page title matches the search string
    And search results page is available in other languages

  Scenario Outline: Search with different language selected
    When a search is entered with <language> as selected language
    Then the results page title matches the search string
    And a link is provided to results in English
    Examples:
      | language |
      | French   |
      | German   |