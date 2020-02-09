Feature: Wikipedia Search

  Scenario: English Search
    When a search is entered with English as selected language
    Then the results page title matches the search string
    And search results page is available in other languages

  Scenario Outline: Change results from English to another language
    Given a search is entered with English as selected language
    When the option is chosen to display the results in <language>
    Then the results are displayed in <language>
    And a link is provided to display the results in English
    Examples:
      | language |
      | French   |
      | German   |
