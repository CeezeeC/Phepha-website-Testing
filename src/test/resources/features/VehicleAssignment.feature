@Regression
Feature: Vehicle Assignment

  Background:
    Given Login is displayed
    When the user logs in with valid credentials
    And the user clicks on Settings

  Scenario: Verify vehicle assignment, search and details
    And the user clicks on Vehicle Allocation
    When User enters vehicle registration number "lf"
    And User enters driver ID number "123"
    And User clicks save
    Then verify Vehicle Assignment table is displayed with Vehicle information
    And search for vehicle with keyword "Ford"
    Then verify vehicle is visible in the table
