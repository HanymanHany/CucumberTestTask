Feature: web

  Scenario: Check auth
    Given opening the login page
    When enter the correct authorization data
    Then admin panel is displayed

  Scenario: Check players table
    Given opening the login page and enter the correct authorization data
    When opening the players page
    Then checking the display of a table with data

  Scenario: testCheckSortingPlayers
    Given opening the login page and enter the authorization data
    When opening the players tables
    And sorting name column
    Then checking correct sorting


