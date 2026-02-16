@Regression
Feature: System Operation Management

  Background:
    Given Login is displayed
    When the user logs in with valid credentials
    And the user clicks on Settings and click system operation


  Scenario: Verify the functionality of adding a user

    And user lands on System Operation
    And user enter name in the Name field
    And user enter surname in the Surname field
    And user enter id in the Employee ID field
    And user enter email in the Email field
    And user enter password in the Password field
    And user select role from the Role dropdown
    And user clicks save button
    And user added successfully

  #Verify the functionality of searching for added user
    And user enters added user on the search field
    And user clicks edit user icon
    And user lands on the edit system operator
    And user edit id in the Employee ID field
    And user edit name in the Name field
    And user edit surname in the Surname field
    And user edit email in the Email field
    And user edit role from the Role dropdown
    And user saved edited user
    And user edited successfully



  #Verify the functionality of sorting the list of users by ID in ascending and descending order

    And user clicks ID to sort in ascending order
    And user clicks ID to sort in descending order

    And user clicks Name to sort by ascending order
    And user clicks Name to sort by descending order

    And user clicks Surname to sort by ascending order
    And user clicks Surname to sort by descending order

    And user clicks Email to sort by ascending order
    And user clicks Email to sort by descending order

    And user clicks Role to sort by ascending order
    And user clicks Role to sort by descending order

    And  user search with invalid data

    And user saves without user credentials
    And message is displayed

  #Verify if admin can click on cancel to cancel adding user

    And user enter name in the Name field
    And user enter surname in the Surname field
    And user enter id in the Employee ID field
    And user enter email in the Email field
    And user enter password in the Password field
    And user select role from the Role dropdown
    And user click cancel to cancel add user
    And user clicks edit user icon
    And  user click cancel to go back to user list

 #Verify if admin can click on cancel to cancel deleting user
    And user clicks delete icon
    And user click on cancel to cancel deleting user

  #Verify the functionality of deleting a user

    And user clicks delete icon
    And user clicks delete user
    Then user deleted successfully is displayed