@Regression
Feature: Driver Management
  As an admin
  I want to manage drivers
  So that I can add, edit, and delete driver records

  Background:
    Given Login is displayed
    When the user logs in with valid credentials
    And the user clicks on Settings and Driver management

  Scenario: Add a new driver
    When user enter name into the Name field
    And user enter surname into the Surname field
    And user enter ID into the ID field
    And user select male from the Gender dropdown
    And user click the Save button
    And success message is displayed

  #: Verify if the user can search the driver

    And  user search driver on the search field

  #: Verify if the user can Edit the drivers details

    And  user click edit icon to edit driver
    And   user enter driver details
    And   user saves edited driver details
    And  successfully updated message is displayed

  Scenario: Verify if user can delete driver
    And  user click driver delete icon
    And   delete pop up is displayed
    And   user clicks delete button to delete driver
    Then  delete message is displayed
