Feature: TestSuite2
  Scenario: TestWebSite
    Given I open website
    And I accept cookies
    When I add first name
    And I add last name
    And I check my gender
    Then I close my webdriver

  Scenario Outline: TestWebSiteMultipleScenario
    Given I open website
    And I accept cookies
    When I add first "firstname" name
    And I add last "lastname" name
    And I check my gender
    Then I close my webdriver

    Examples:
      | firstname  | lastname  |
      | Jan        | Sima      |
      | Petr       | Novak     |
      | Karel      | Novotny   |

