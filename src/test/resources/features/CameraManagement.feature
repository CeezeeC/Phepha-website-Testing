@Regression
Feature: Camera Management functionality

Background:
  Given Login is displayed
  When the user logs in with valid credentials
  And the user clicks on Settings
  And  user clicks Camera Management


  Scenario: As a user i want to click on camera management

    When  user lands on the Camera Management page
    And  user clicks the Add Camera button
    And  verify user lands on the add camera pop up
    And  user populate camera details text fields
    And  user clicks save to save camera details
    #And  verify successful message is displayed


  #Verify if the user/admin can add 10 entries and 25 entries

    And user add twenty five entries of camera
    And user add ten entries of camera



  #Verify the functionality of editing camera details
    And user clicks edit icon on camera management page to edit
    And user land on Edit Camera Settings
    And user populate edited camera details text fields
    And user click to save edited camera details
    And verify successful updated is displayed

  Scenario: :Verify if user can click Next and Previous
    And user click next to view camera records
    And user click previous to view camera records

     #Verify the functionality of sorting the list of camera by  ascending and descending order


    And user clicks icon to sort camera name by ascending order
    And user clicks icon to sort camera name by descending order


    And user clicks icon to sort camera description by ascending order
    And user clicks icon to sort camera description by descending order

    And user clicks icon to sort camera model by ascending order
    And user clicks icon to sort camera model by descending order

    And user clicks icon to sort Serial number by ascending order
    And user clicks icon to sort Serial number by descending order

    And user clicks icon to sort Allocation by ascending order
    And user clicks icon to sort Allocation by descending order

 #Verify the functionality of delete camera details

    Then user clicks camera delete icon to delete camera details