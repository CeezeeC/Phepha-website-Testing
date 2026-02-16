@Regression
Feature: Warehouse Management

  As an user
  I want to manage warehouse
  So that it can be used for operations

  Background:
    Given Login is displayed
    When the user logs in with valid credentials
    And the user clicks on Settings
    And  the user clicks on WareHouse
    And user lands on the warehouse management

  Scenario: Verify if the user can add a warehouse
    When user enters Warehouse into Warehouse field
    And user selects Province in drop down
    And user clicks Save
    And the warehouse should be successfully added

  #Verify if the user/admin is able to view the Warehouse after it has been added
    And user view added warehouse

  #Verify if the user can cancel warehouse input fields
    And user enters Warehouse into Warehouse field
    And user selects Province in drop down
    And user clicks Cancel

  #Verify if the user can search for a warehouse by warehouse name
    And user enters WareHouse in the search field
    And the matching results should be displayed

  #Verify if the user can search for a warehouse by province name
    And user enters Province in the search field
    And the matching results should be displayed

  #Verify if the user can search for a warehouse by warehouse ID
    And user enters ID in the search field
    And the matching results should be displayed

  Scenario: Verify if the user can edit a warehouse
    And user clicks edit icon
    And user edit Warehouse
    And user edit Province
    And user clicks Save edited WareHouse

  #Verify if user can click Next and Previous
    And user click next
    And user click previous

  #Verify if the user/admin can add 10 entries and 25 entries
    And user add ten entries
    And user add twenty five entries

  #Verify if the user/admin can view the Warehouses added in ascending order
    And user click province ascending icon
    And user view Warehouse add in ascending order

  #Verify if the user/admin can view the Warehouses added in descending order
    And user click warehouse descending icon
    Then user view Warehouse add in descending order

  Scenario: if the user can delete a warehouse
    And user click delete icon
    And user click delete button
