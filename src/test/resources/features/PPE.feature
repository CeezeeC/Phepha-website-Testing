@Regression
Feature: PPE Feature

  Background:
    Given Login is displayed
    When the user logs in with valid credentials


  Scenario: As a user I want to login to Phepha to view the PPE Live Monitoring feed
    And  the user clicks on PPE
    Then PPE Live Monitoring page is displayed

  Scenario: As a user i want to login to phepha to view the Non-compliance page
    And the user clicks on View-Non Compliance
    Then Non-Compliance page is displayed

  Scenario: As a User i want to search non compliance using an existing warehouse
    And the user clicks on View-Non Compliance
    And the user clicks on the search box and type "EngineRoom43"
    Then the search results are displayed

  Scenario: As a user I want to login to Phepha to test show entries functionality
    And the user clicks on View-Non Compliance
    And I click the show entries dropdown
    And the user clicks on View-Non Compliance
    And I click on the entries dropdown and select 25

  Scenario: As a user i want to view more entries using the Next Button
    And the user clicks on View-Non Compliance
    And clicks on the next button

  Scenario: As a user i want to search for non compliance using an existing province
    And the user clicks on View-Non Compliance
    And the user clicks on the search box
    And the user searches Mpumalanga
    Then the search results are displayed

  Scenario: As a user i want to search for non compliance using non existing province
    And the user clicks on View-Non Compliance
    And the user clicks on the search box
    And the user searches Spain
    Then the search results are displayed

  Scenario: As a user i want to search for non compliance using non existing warehouse
    And the user clicks on View-Non Compliance
    And the user clicks on the search box
    And the user searches "Zwavhudi99"
    Then the search results are displayed