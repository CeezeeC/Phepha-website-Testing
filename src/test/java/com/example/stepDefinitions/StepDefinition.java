package com.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import pageObjects.*;
import utils.ConfigReader;


public class StepDefinition {

    //================== OBJECTS ==================//
    LoginPage loginObj = new LoginPage(Hooks.driver);
    DashboardPage dashObj = new DashboardPage(Hooks.driver);
    WareHouseManagement wareHouseObj = new WareHouseManagement(Hooks.driver);
    SystemOperationManagement systemObj = new SystemOperationManagement(Hooks.driver);
    DriverManagement driverObj = new DriverManagement(Hooks.driver);
    NonCompliancePage nonObj = new NonCompliancePage(Hooks.driver);
    PPEPage pppObj = new PPEPage(Hooks.driver);
    CameraManagement cameraObj = new CameraManagement(Hooks.driver);
    VehicleAllocationPage vehiclePage = new VehicleAllocationPage(Hooks.driver);
    InvalidLoginPage loginPage  = new InvalidLoginPage(Hooks.driver);
    ForgotPasswordPage forgotPage = new ForgotPasswordPage(Hooks.driver);
    ResetPasswordPage resetPage = new ResetPasswordPage(Hooks.driver);
    RegisterPage  registerObj =  new RegisterPage(Hooks.driver);
    ReportsPage reportsObj = new ReportsPage(Hooks.driver);



    //================== LOGIN ==================//
    @Given("Login is displayed")
    public void loginIsDisplayed() {
        loginObj = new LoginPage(Hooks.driver);
        Hooks.driver.get(ConfigReader.getProperty("testURL"));

        String actualUrl = loginObj.getCurrentLoginUrl();
        String expectUrl = loginObj.getExpectedLoginUrl();
        Assert.assertEquals(expectUrl, actualUrl);
    }

    @When("The user enters a valid email address")
    public void theUserEntersAValidEmailAddress() {
        loginObj.enterLoginEmail("Mathabontuli2@gmail.com");
    }

    @And("The user enters a valid password")
    public void theUserEntersAValidPassword() {
        loginObj.enterLoginPassword(" Khanya.94@Tm");
    }

    @And("The user clicks on the Login button")
    public void theUserClicksOnTheLoginButton() {
        loginObj.clickLoginButton();
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        loginObj.loginDetails();
    }

    //================== DASHBOARD ==================//
    @And("The user should be redirected to the dashboard page")
    public void theUserShouldBeRedirectedToTheDashboardPage() {
        String actualUrl = dashObj.getCurrentDashboardUrl();
        String expectUrl = dashObj.getExpectedDashboardUrl();
        Assert.assertEquals(expectUrl, actualUrl);
    }

    @And("click the hamburger menu")
    public void clickHamburgerMenu() {
        dashObj.clickHamburgerMenu();
    }

    @And("click the View All button")
    public void clickViewAllButton() {
        dashObj.clickViewAllButton();
    }

    @And("click the Chevron down icon")
    public void clickChevronDown() {
        dashObj.clickChevronDown();
    }

    @And("click See More")
    public void clickSeeMore() {
        dashObj.clickSeeMore();
    }

    @And("verify Total PPE Non-Compliance card is visible")
    public void verifyTotalPPENonCompliance() {
        String totalPPE = dashObj.getTotalPPENonCompliance();
        Assert.assertFalse("Total PPE Non-Compliance card is empty!", totalPPE.isEmpty());
        System.out.println("Total PPE Non-Compliance: " + totalPPE);
    }

    @And("click PPE sidebar and view Non-Compliance")
    public void clickPPESidebarAndViewNonCompliance() {
        dashObj.clickPPESidebar();
        dashObj.clickViewNonCompliance();
    }

    @And("verify total entries on PPE report")
    public void verifyTotalEntriesPPEReport() {
        String totalEntries = dashObj.getTotalEntriesFromPPEReport();
        Assert.assertTrue("PPE report entries not found!", !totalEntries.isEmpty());
        System.out.println("Total PPE Report Entries: " + totalEntries);
        dashObj.navigateBackToDashboard();
    }

    @And("select year {string} from Monthly Non-Compliance Overview dropdown")
    public void selectMonthlyOverviewYear(String year) {
        dashObj.selectMonthlyOverviewYear(year);
    }

    @And("verify Monthly Non-Compliance Overview fullscreen works")
    public void verifyMonthlyOverviewFullscreen() {
        dashObj.openMonthlyOverviewFullscreen();
    }

    @And("select year {string} from Monthly Non-Compliance Trend dropdown")
    public void selectMonthlyTrendYear(String year) {
        dashObj.selectMonthlyTrendYear(year);
    }

    @And("verify Monthly Non-Compliance Trend fullscreen works")
    public void verifyMonthlyTrendFullscreen() {
        dashObj.openMonthlyTrendFullscreen();
    }

    @And("select year {string} from Top Non-Compliance Categories dropdown")
    public void selectTopCategoriesYear(String year) {
        dashObj.selectTopCategoriesYear(year);
    }

    @And("verify Top Non-Compliance Categories fullscreen works")
    public void verifyTopCategoriesFullscreen() {
        dashObj.openTopCategoriesFullscreen();
    }

    @And("select warehouse {string} and {string} form compare dropdown")
    public void selectWarehouseComparison(String warehouse1, String warehouse2) {
        dashObj.selectWarehouseCompareDropdown1(warehouse1);
        dashObj.selectWarehouseCompareDropdown2(warehouse2);
    }

    @And("verify Warehouse Comparison fullscreen works")
    public void verifyWarehouseComparisonFullscreen() {
        dashObj.openWarehouseFullscreen();
    }

    //================== PPE ==================//


    @And("the user clicks on PPE")
    public void theUserClicksOnPPE() {
        pppObj.clickPPE();

    }

    @Then("PPE Live Monitoring page is displayed")
    public void ppeLiveMonitoringPageIsDisplayed() {
        pppObj.liveMonitoringIsDisplayed();
    }


    @And("the user clicks on View-Non Compliance")
    public void theUserClicksOnViewNonCompliance() {
        nonObj.ViewNonCompliance();

    }
    @Then("Non-Compliance page is displayed")
    public void nonCompliancePageIsDisplayed() {
        nonObj.NonComplianceIsDisplayed();
    }

    @And("the user clicks on the search box and type {string}")
    public void theUserClicksOnTheSearchBoxAndType(String Searchbox) {
        nonObj.SearchExistingWarehouse();

    }


    @Then("the search results are displayed")
    public void theSearchResultsAreDisplayed() {

    }

    @And("I click the show entries dropdown")
    public void iClickTheShowEntriesDropdown() {
        nonObj.entriesDropdown();
    }

    @And("I click on the entries dropdown and select {int}")
    public void iClickOnTheEntriesDropdownAndSelect() {
        nonObj.entry25();
    }

    @And("clicks on the next button")
    public void clicksOnTheNextButton() {
        nonObj.NextPage();
    }


    @And("the user clicks on the search box")
    public void theUserClicksOnTheSearchBox() {
        nonObj.searchBox();
    }

    @And("the user searches Mpumalanga")
    public void theUserSearchesMpumalanga() {
        nonObj.ExistingProvince();
    }

    @And("the user searches Spain")
    public void theUserSearchesSpain() {
        nonObj.NonExistingProvince();
    }

    @And("the user searches {string}")
    public void theUserSearches(String Searchbox) {
        nonObj.NonExistingWarehouse();
    }
    //================== WAREHOUSE MANAGEMENT ==================//

    @And("the user clicks on Settings")
    public void theUserClicksOnSettings() {
        wareHouseObj.clickSettingDropDown();
    }
    @And("the user clicks on Settings and  the user clicks on WareHouse")
    public void theUserClicksOnSettingsAndTheUserClicksOnWareHouse() {


    }

    @And("the user clicks on WareHouse")
    public void theUserClicksOnWareHouse() {

        wareHouseObj.clickWareHouseManagement();

    }

    @And("user lands on the warehouse management")
    public void userLandsOnTheWarehouseManagement() {
        String actualTitle = wareHouseObj.getWareHouseTitle();
        String expectTitle = "Warehouse Management";
        Assert.assertEquals("The title does not match",expectTitle,actualTitle);
    }

    @And("user enters Warehouse into Warehouse field")
    public void userEntersWarehouseIntoWarehouseField() {
        wareHouseObj.enterWarehouse();
    }

    @And("user selects Province in drop down")
    public void userSelectsProvinceInDropDown() {
        wareHouseObj.selectProvince();
    }

    @And("user clicks Save")
    public void userClicksSave() {
        wareHouseObj.clickSave();
    }

    @And("the warehouse should be successfully added")
    public void theWarehouseShouldBeSuccessfullyAdded() {
        String message = "Data saved successfully";
        Assert.assertEquals(message, wareHouseObj.getSuccessMessage());
    }

    @And("user view added warehouse")
    public void userViewAddedWarehouse() {
        Assert.assertTrue(wareHouseObj.displayWareHouse());
    }

    @And("user clicks Cancel")
    public void userClicksCancel() {
        wareHouseObj.clickCancel();
    }

    @And("user enters WareHouse in the search field")
    public void userEntersWareHouseInTheSearchField() {
        wareHouseObj.searchFor("Midrand");
    }

    @And("the matching results should be displayed")
    public void theMatchingResultsShouldBeDisplayed()
    {

    }

    @And("user enters Province in the search field")
    public void userEntersProvinceInTheSearchField() {
        wareHouseObj.searchFor("Limpopo");
    }

    @And("user enters ID in the search field")
    public void userEntersIDInTheSearchField() {
        wareHouseObj.searchFor("2");
    }

    @And("user clicks edit icon")
    public void userClicksEditIcon() {
        wareHouseObj.clickEditIcon();
    }

    @And("user edit Warehouse")
    public void userEditWarehouse() {
        wareHouseObj.editWarehouse();
    }

    @And("user edit Province")
    public void userEditProvince() {
        wareHouseObj.editProvince();
    }

    @And("user clicks Save edited WareHouse")
    public void userClicksSaveEditedWareHouse() {
        wareHouseObj.clickSaveEdit();
    }

    @And("user click delete icon")
    public void userClickDeleteIcon() {
        wareHouseObj.clickDelete();
    }

    @And("user click delete button")
    public void userClickDeleteButton() {
        wareHouseObj.clickConfirmDelete();
    }

    @And("user click next")
    public void userClickNext() {
        wareHouseObj.clickNext();
    }

    @And("user click previous")
    public void userClickPrevious() {
        wareHouseObj.clickPrevious();
    }

    @And("user add ten entries")
    public void userAddTenEntries() {
        wareHouseObj.clickEntries10();
    }

    @And("user add twenty five entries")
    public void userAddTwentyFiveEntries() {
        wareHouseObj.clickEntries25();
    }

    @And("user click province ascending icon")
    public void userClickProvinceAscendingIcon() {
        wareHouseObj.sortByAscendingOrder();
    }

    @And("user view Warehouse add in ascending order")
    public void userViewWarehouseAddInAscendingOrder() {
        wareHouseObj.sortByAscendingOrder();
    }

    @And("user click warehouse descending icon")
    public void userClickWarehouseDescendingIcon() {
        wareHouseObj.sortByDescendingOrder();
    }

    @Then("user view Warehouse add in descending order")
    public void userViewWarehouseAddInDescendingOrder() {
        wareHouseObj.sortByDescendingOrder();
    }

    //================== SYSTEM OPERATION MANAGEMENT ==================//
    @And("the user clicks on Settings and click system operation")
    public void theUserClicksOnSettingsAndClickSystemOperation() {


        systemObj.clickSettingDropDown();
    }
    @And("user lands on System Operation")
    public void userLandsOnSystemOperation() {

        String actualTitle =  systemObj.getSystemTitle();
        String expectedTitle = "System Operators Management";

        Assert.assertEquals("The title does not match",expectedTitle,actualTitle);
    }


    @And("user enter name in the Name field")
    public void userEnterNameInTheNameField() {
        systemObj.enterName("Cecil");
    }

    @And("user enter surname in the Surname field")
    public void userEnterSurnameInTheSurnameField() {
        systemObj.enterSurname("Mkhari");
    }

    @And("user enter id in the Employee ID field")
    public void userEnterIdInTheEmployeeIDField() {
        systemObj.enterEmployeeId("4322");
    }

    @And("user enter email in the Email field")
    public void userEnterEmailInTheEmailField() {
        systemObj.enterEmail("cecilm@lubanzi.tech");
    }

    @And("user enter password in the Password field")
    public void userEnterPasswordInThePasswordField() {
        systemObj.enterPassword("c3c!l9595");
    }

    @And("user select role from the Role dropdown")
    public void userSelectRoleFromTheRoleDropdown() {
        systemObj.selectRole("Vehicle Operator");
    }

    @And("user clicks save button")
    public void userClicksSaveButton() {
        systemObj.saveButton();
    }

    @And("user added successfully")
    public void userAddedSuccessfully() {
        String message = "User added successfully";
        Assert.assertEquals(message, systemObj.getSuccessMessage());
    }

    @And("user enters added user on the search field")
    public void userEntersAddedUserOnTheSearchField() {
        systemObj.searchUser();
    }

    @And("user clicks edit user icon")
    public void userClicksEditUserIcon() {
        systemObj.clickEditIcon();
    }

    @And("user lands on the edit system operator")
    public void userLandsOnTheEditSystemOperator() {

        String actualTitle = systemObj.getEditSystemTitle();
        String expectedTitle = "Edit System Operators";

        Assert.assertEquals("The title does not match",expectedTitle,actualTitle);
    }

    @And("user edit id in the Employee ID field")
    public void userEditIdInTheEmployeeIDField() {
        systemObj.editEmployeeId("6564");
    }

    @And("user edit name in the Name field")
    public void userEditNameInTheNameField() {
        systemObj.editName("Daniel");
    }

    @And("user edit surname in the Surname field")
    public void userEditSurnameInTheSurnameField() {
        systemObj.editSurname("Kruger");
    }

    @And("user edit email in the Email field")
    public void userEditEmailInTheEmailField() {
        systemObj.editEmail("danielk@lubanzi.tech");
    }

    @And("user edit role from the Role dropdown")
    public void userEditRoleFromTheRoleDropdown() {
        systemObj.editSelectRole("Both");
    }

    @And("user saved edited user")
    public void userSavedEditedUser() {
        systemObj.clickSave();
    }

    @And("user edited successfully")
    public void userEditedSuccessfully() {
        String message = "undefined";
        Assert.assertTrue(message, systemObj.getEditSuccessMessage());
    }


    @And("user clicks ID to sort in ascending order")
    public void userClicksIDToSortInAscendingOrder() {
        systemObj.sortIDByAscendingOrder();
    }

    @And("user clicks ID to sort in descending order")
    public void userClicksIDToSortInDescendingOrder() {
        systemObj.sortIDByDescendingOrder();
    }

    @And("user clicks Name to sort by ascending order")
    public void userClicksNameToSortByAscendingOrder() {
        systemObj.sortNameByAscendingOrder();
    }

    @And("user clicks Name to sort by descending order")
    public void userClicksNameToSortByDescendingOrder() {
        systemObj.sortNameByDescendingOrder();
    }

    @And("user clicks Surname to sort by ascending order")
    public void userClicksSurnameToSortByAscendingOrder() {
        systemObj.sortSurnameByAscendingOrder();
    }

    @And("user clicks Surname to sort by descending order")
    public void userClicksSurnameToSortByDescendingOrder() {
        systemObj.sortSurnameByDescendingOrder();
    }

    @And("user clicks Email to sort by ascending order")
    public void userClicksEmailToSortByAscendingOrder() {
        systemObj.sortEmailByAscendingOrder();
    }

    @And("user clicks Email to sort by descending order")
    public void userClicksEmailToSortByDescendingOrder() {
        systemObj.sortEmailByDescendingOrder();
    }

    @And("user clicks Role to sort by ascending order")
    public void userClicksRoleToSortByAscendingOrder() {
        systemObj.sortRoleByAscendingOrder();
    }

    @And("user clicks Role to sort by descending order")
    public void userClicksRoleToSortByDescendingOrder() {
        systemObj.sortRoleByDescendingOrder();
    }


    @And("user search with invalid data")
    public void userSearchWithInvalidData() {
        systemObj.clickSearchUser();
    }

    @And("user saves without user credentials")
    public void userSavesWithoutUserCredentials() {
        systemObj.saveButton();
    }



    @And("user click cancel to cancel add user")
    public void userClickCancelToCancelAddUser() {
        systemObj.clickCancelButton();
    }

    @And("message is displayed")
    public void messageIsDisplayed() {
        Assert.assertTrue("there is no message displayed",systemObj.getFillBlackMessage());
    }

    @And("user click on cancel to cancel deleting user")
    public void userClickOnCancelToCancelDeletingUser() {
        systemObj.clickCancelDeleteButton();
    }

    @And("user click cancel to go back to user list")
    public void userClickCancelToGoBackToUserList() {
        systemObj.clickCancelEdit();
    }
    @And("user clicks delete icon")
    public void userClicksDeleteIcon() {
        systemObj.clickDeleteIcon();
    }

    @And("user clicks delete user")
    public void userClicksDeleteUser() {
        systemObj.clickConfirmDelete();
    }

    @Then("user deleted successfully is displayed")
    public void userDeletedSuccessfullyIsDisplayed() {
        String message = "User deleted successfully";
        Assert.assertEquals(message, systemObj.getDeletedMessage());
    }


    //------------------------Vehicle Allocation-------------------------------

    @And("the user clicks on Vehicle Allocation")
    public void clickVehicleAllocation() {
        vehiclePage.clickVehicleAllocation();
    }

    @When("User enters vehicle registration number {string}")
    public void user_enters_vehicle_registration_number(String registrationNumber) {
        vehiclePage.enterRegistrationNumber(registrationNumber);
    }

    @When("User enters driver ID number {string}")
    public void user_enters_driver_id_number(String idNumber) {
        vehiclePage.enterDriverID(idNumber);
    }

    @When("User clicks save")
    public void user_clicks_save() {
        vehiclePage.clickSave();
    }

    @Then("verify Vehicle Assignment table is displayed with Vehicle information")
    public void verifyVehicleAssignmentTableIsDisplayed() {
        Assert.assertTrue("Vehicle Assignment table is not visible!", vehiclePage.isVehicleTableVisible());
        System.out.println("Vehicle Assignment table is displayed.");
    }


    @And("search for vehicle with keyword {string}")
    public void searchForVehicle(String keyword) {
        vehiclePage.searchVehicle(keyword);
        System.out.println("Searched for vehicle with keyword: " + keyword);
    }

    @Then("verify vehicle is visible in the table")
    public void verifyVehicleIsVisibleInTable() {
        boolean result = vehiclePage.isVehicleTableVisible();
        Assert.assertTrue("Vehicle not visible in the table!", result);
        System.out.println("Verified that the vehicle is visible in the table.");
    }

    //================CAMERA MANAGEMENT ===========================//

    @And("user clicks Camera Management")
    public void userClicksCameraManagement() {

        cameraObj.clickCameraManagement();
    }

    @When("user lands on the Camera Management page")
    public void userLandsOnTheCameraManagementPage()
    {

        String actualTitle = cameraObj.getCameraManagementTitle();
        String expectedTitle = "Camera Management";

        Assert.assertEquals("The title does not match", expectedTitle,actualTitle);
    }

    @And("user clicks the Add Camera button")
    public void userClicksTheAddCameraButton() {
        cameraObj.clickAddCamera();
    }

    @And("verify user lands on the add camera pop up")
    public void verifyUserLandsOnTheAddCameraPopUp() {
        String actualTitle =  cameraObj.getAddCameraTitle();
        String expectedTitle = "Add The Camera";
        Assert.assertEquals("The title does not match",expectedTitle,actualTitle);
    }

    @And("user populate camera details text fields")
    public void userPopulateCameraDetailsTextFields()
    {
        cameraObj.enterCameraName("Innocam");
        cameraObj.enterCameraDescription("Innotech silver camera");
        cameraObj.enterSerialNumber("SN2354212043");
        cameraObj.enterCameraModel("2025.04");
        cameraObj.enterIP("192.168.1.10");
        cameraObj.enterPort("8083");
        cameraObj.enterChannel("101");
        cameraObj.selectWarehouse();
    }

    @And("user clicks save to save camera details")
    public void userClicksSaveToSaveCameraDetails() {

        cameraObj.clickSave();
    }


    @And("user add twenty five entries of camera")
    public void userAddTwentyFiveEntriesOfCamera() {

        cameraObj.clickEntries25();
    }
    @And("user add ten entries of camera")
    public void userAddTenEntriesOfCamera() {

        cameraObj.clickEntries10();
    }
    /*@And("verify successful message is displayed")
    public void verifySuccessfulMessageIsDisplayed() {

        String actualMessage =  cameraObj.getSuccessfulMessage();
        String expectedMessage = "Data saved successfully";

        Assert.assertEquals("Success message is not displayed",expectedMessage,actualMessage);
    }*/


    @And("user clicks icon to sort camera name by ascending order")
    public void userClicksIconToSortCameraNameByAscendingOrder() {

        cameraObj.sortByAscendingOrderName();
    }

    @And("user clicks icon to sort camera name by descending order")
    public void userClicksIconToSortCameraNameByDescendingOrder() {

        cameraObj.sortByDescendingOrderName();
    }

    @And("user clicks icon to sort camera description by ascending order")
    public void userClicksIconToSortCameraDescriptionByAscendingOrder() {
        cameraObj.sortByAscendingOrderDescription();
    }

    @And("user clicks icon to sort camera description by descending order")
    public void userClicksIconToSortCameraDescriptionByDescendingOrder() {
        cameraObj.sortByDescendingOrderDescription();
    }

    @And("user clicks icon to sort camera model by ascending order")
    public void userClicksIconToSortCameraModelByAscendingOrder() {

        cameraObj.sortByAscendingOrderModel();
    }

    @And("user clicks icon to sort camera model by descending order")
    public void userClicksIconToSortCameraModelByDescendingOrder() {
        cameraObj.sortByDescendingOrderModel();
    }

    @And("user clicks icon to sort Serial number by ascending order")
    public void userClicksIconToSortSerialNumberByAscendingOrder() {

        cameraObj.sortByAscendingOrderSerial();
    }

    @And("user clicks icon to sort Serial number by descending order")
    public void userClicksIconToSortSerialNumberByDescendingOrder() {
        cameraObj.sortByDescendingOrderSerial();
    }

    @And("user clicks icon to sort Allocation by ascending order")
    public void userClicksIconToSortAllocationByAscendingOrder() {
        cameraObj.sortByAscendingOrderAllocation();
    }

    @And("user clicks icon to sort Allocation by descending order")
    public void userClicksIconToSortAllocationByDescendingOrder() {

        cameraObj.sortByDescendingOrderAllocation();
    }

    @And("user clicks edit icon on camera management page to edit")
    public void userClicksEditIconOnCameraManagementPageToEdit() {


        cameraObj.clickEdit();
    }
    @And("user land on Edit Camera Settings")
    public void userLandOnEditCameraSettings()
    {
        String actualTitle = cameraObj.getEditSettingsTitle();
        String expectTitle = "Edit Camera Settings";

        Assert.assertEquals("The title does not match",expectTitle,actualTitle);
    }

    @And("user populate edited camera details text fields")
    public void userPopulateEditedCameraDetailsTextFields() {

        cameraObj. editCameraName("Camera1");
        cameraObj. editCameraDescription("front view camera");
        cameraObj.editSerialNumber("SN54765843");
        cameraObj.editCameraModel("AW122");
        cameraObj.editIP("192.10.1.24");
        cameraObj.editPort("104563");
        cameraObj.editChannel("301");
        cameraObj.selectWarehouses();

    }

    @And("user click to save edited camera details")
    public void userClickToSaveEditedCameraDetails() {
        cameraObj.saveEdited();
    }

    @And("verify successful updated is displayed")
    public void verifySuccessfulUpdatedIsDisplayed() {

        String actualMessage = cameraObj.displaySuccessfulEditedMessage();
        String expectedMessage = "Succsessfully Updated";
        Assert.assertEquals("Successful message does not match",expectedMessage,actualMessage);
    }
    @And("user click next to view camera records")
    public void userClickNextToViewCameraRecords() {

        cameraObj.clickNext();
    }

    @And("user click previous to view camera records")
    public void userClickPreviousToViewCameraRecords() {

        cameraObj.clickPrevious();
    }

    @Then("user clicks camera delete icon to delete camera details")
    public void userClicksCameraDeleteIconToDeleteCameraDetails() {
        cameraObj.clickDeleteCameraDetails();
    }

    //================== DRIVER MANAGEMENT ==================//
    @And("the user clicks on Settings and Driver management")
    public void theUserClicksOnSettingsAndDriverManagement() {
        driverObj.clickSettingDropDown();
    }

    @When("user enter name into the Name field")
    public void userEnterNameIntoTheNameField() {
        driverObj.enterName();
    }

    @And("user enter surname into the Surname field")
    public void userEnterSurnameIntoTheSurnameField() {
        driverObj.enterSurname();
    }

    @And("user enter ID into the ID field")
    public void userEnterIDIntoTheIDField() {
        driverObj.enterId();
    }

    @And("user select male from the Gender dropdown")
    public void userSelectMaleFromTheGenderDropdown() {
        driverObj.selectGender();
    }

    @And("user click the Save button")
    public void userClickTheSaveButton() {
        driverObj.clickSave();
    }
    @And("success message is displayed")
    public void successMessageIsDisplayed() {

        Assert.assertTrue("", driverObj.getSuccessfulMessage());
    }

    @And("user search driver on the search field")
    public void userSearchDriverOnTheSearchField() {
        driverObj.setSearchDriver();
    }

    @And("user click edit icon to edit driver")
    public void userClickEditIconToEditDriver() {

        driverObj.clickEditIcon();
    }

    @And("user enter driver details")
    public void userEnterDriverDetails() {

        driverObj.editDriver("John","Wick","33333","Female");
    }

    @And("user saves edited driver details")
    public void userSavesEditedDriverDetails() {
        driverObj.saveEditDriver();
    }
    @And("successfully updated message is displayed")
    public void successfullyUpdatedMessageIsDisplayed() {

        Assert.assertTrue("The message is not displayed",driverObj.updatedMessageIsDisplayed());
    }



    @And("user click driver delete icon")
    public void userClickDriverDeleteIcon() {

        driverObj.clickDeleteIcon();
    }

    @And("delete pop up is displayed")
    public void deletePopUpIsDisplayed() {

        Assert.assertTrue("Are you sure you want to delete this record? is not displayed", driverObj.deletePageIsDisplayed());
    }

    @And("user clicks delete button to delete driver")
    public void userClicksDeleteButtonToDeleteDriver() {

        driverObj.clickConfirmDeleteButton();
    }

    @Then("delete message is displayed")
    public void deleteMessageIsDisplayed() {

        Assert.assertTrue("Driver successfully removed message is not displayed",driverObj.deleteMessageIsDisplayed());
    }

    //================INVALID LOGIN ===========================//

    @When("user enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("user leaves email and password empty")
    public void user_leaves_email_and_password_empty() {
        loginPage.clearEmailAndPassword();
    }

    @When("user clicks login")
    public void user_clicks_login() {
        loginPage.clickLogin();
    }

    @Then("user sees error message for incorrect credentials")
    public void user_sees_error_message_for_incorrect_credentials() {
        String expectedMessage = "Incorrect username / password!";
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("user sees browser validation message for empty email")
    public void user_sees_browser_validation_message_for_empty_email() {
        String validationMessage = loginPage.getEmailValidationMessage();
        Assert.assertTrue(validationMessage.length() > 0); // browser shows some message
    }

    // Password visibility toggle steps
    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user toggles password visibility")
    public void user_toggles_password_visibility() {
        loginPage.togglePasswordVisibility();
    }

    @Then("password is visible")
    public void password_is_visible() {
        String type = loginPage.getPasswordFieldType();
        Assert.assertEquals("text", type); // password should now be visible
    }

    //---------------------Forgot Password--------------------------------------------//
    @When("user clicks forgot password link")
    public void user_clicks_forgot_password_link() {

    forgotPage.clickForgotPasswordLink();

    }

    @Then("forgot password page should be displayed")
    public void forgot_password_page_should_be_displayed() {

        Assert.assertTrue("Email input NOT displayed",forgotPage.verifyForgotPasswordPageDisplayed());

    }

    @When("user enters forgot password email {string}")
    public void user_enters_forgot_password_email(String email) {
        forgotPage.enterEmail(email);
    }

    @When("user submits forgot password request")
    public void user_submits_forgot_password_request() {
        forgotPage.clickSubmit();
    }

    @Then("email sent confirmation should display")
    public void email_sent_confirmation_should_display() {
        Assert.assertTrue("Email sent message NOT displayed",forgotPage.verifyEmailSentMessage());
    }

    @When("user opens the reset password link")
    public void user_opens_the_reset_password_link() {
        // You will replace this with real Gmail logic later
        resetPage.openResetLink("http://phephadev.lubanzi-ictc.co.za//reset/611087f1-fadf-4553-8dbe-ec6986174e7d");
    }

    @When("user enters new password {string} and confirms {string}")
    public void user_enters_new_password_and_confirms(String pass, String confirm) {
        resetPage.enterNewPasswords(pass, confirm);
    }

    @When("user submits new password")
    public void user_submits_new_password() {
        resetPage.submitNewPassword();
    }

    @Then("password reset success message must display")
    public void password_reset_success_message_must_display() {
        Assert.assertTrue("Reset success message NOT displayed",  resetPage.verifyResetSuccessMessage());

    }

    // ================== REGISTER ================== //

    String registeredEmail;
    String registeredPassword = "Enk@y2020";

    @When("the user clicks the create account link")
    public void the_user_clicks_the_create_account_link() {
        registerObj.clickCreateAccountLink();
    }

    @Then("the registration form should be displayed")
    public void the_registration_form_should_be_displayed() {
        Assert.assertTrue(registerObj.isRegistrationFormVisible());
    }

    @When("the user enters valid details")
    public void the_user_enters_valid_details() {
        registeredEmail = "khanylunga@gmail.com";

        registerObj.enterName("Lungani");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.enterRegNumber("K2025/802476/07");
        registerObj.enterEmail(registeredEmail);
        registerObj.enterPassword(registeredPassword);
        registerObj.enterConfirmPassword(registeredPassword);
        registerObj.selectBothSubscriptions();
    }

    @When("clicks the Sign-Up button")
    public void clicks_the_sign_up_button() {
        registerObj.clickSignUpButton();
    }

    // --------- OTP message ---------
    @Then("the user should see an OTP message after registration")
    public void the_user_should_see_an_otp_message_after_registration() {
        try {
            Alert alert = Hooks.driver.switchTo().alert();
            String alertText = alert.getText();

            Assert.assertTrue("OTP message not displayed",
                    alertText.contains("OTP has been sent to your Email! Please verify to complete registration."));

            alert.accept();
        } catch (NoAlertPresentException e) {
            Assert.fail("OTP popup did not appear after registration");
        }
    }

// --------- Browser validations ---------

    @When("the user fills all details except name")
    public void the_user_fills_all_details_except_name() {
        registerObj.enterName("");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.enterRegNumber("K2025/802476/07");
        registerObj.enterEmail("test" + System.currentTimeMillis() + "khanylunga@gmal.com");
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungai1@");
        registerObj.selectBothSubscriptions();
    }

    @Then("a browser validation message should be displayed for the name field")
    public void a_browser_validation_message_should_be_displayed_for_the_name_field() {
        String msg = registerObj.getFieldValidationMessage(By.name("username"));
        Assert.assertEquals("Please fill out this field.", msg);
    }

    @When("the user leaves the surname field empty")
    public void the_user_leaves_the_surname_field_empty() {
        registerObj.enterName("Lungani");
        registerObj.enterSurname("");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.enterRegNumber("K2025/802476/07");
        registerObj.enterEmail("khanylunga@gmail.com");
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungani1@");
        registerObj.selectBothSubscriptions();
    }

    @Then("a browser validation message should be displayed for the surname field")
    public void a_browser_validation_message_should_be_displayed_for_the_surname_field() {
        String msg = registerObj.getFieldValidationMessage(By.name("surname"));
        Assert.assertEquals("Please fill out this field.", msg);
    }

    @When("the user fills all details except email")
    public void fill_all_details_except_email() {
        registerObj.enterName("Lungani");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.enterRegNumber("K2025/802476/07");
        registerObj.enterEmail("");
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungani1@");
        registerObj.selectBothSubscriptions();
    }

    @Then("a browser validation message should be displayed for the email field")
    public void a_browser_validation_message_should_be_displayed_for_the_email_field() {
        String msg = registerObj.getFieldValidationMessage(By.name("email"));
        Assert.assertEquals("Please fill out this field.", msg);
    }

    @When("the user does not select any subscription")
    public void the_user_does_not_select_any_subscription() {
        registerObj.enterName("Lungani");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.enterRegNumber("K2025/802476/07");
        registerObj.enterEmail("khanylunga@gmail.com");
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungani1@");
        registerObj.selectSubscription();
    }

    @Then("a browser validation message should be displayed for the subscription field")
    public void a_browser_validation_message_should_be_displayed_for_the_subscription_field() {
        String msg = registerObj.getSubscriptionValidationMessage();
        Assert.assertEquals("Please select an item in the list.", msg);
    }

    @When("the user fills all details except company name")
    public void fill_all_details_except_company_name() {
        registerObj.enterName("Lungani");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("");
        registerObj.enterRegNumber("K2025/802476/07");
        registerObj.enterEmail("khanylunga@gmail.com");
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungani1@");
        registerObj.selectBothSubscriptions();
    }

    @When("the user fills all details except company registration number")
    public void fill_all_details_except_company_reg_number() {
        registerObj.enterName("Lungani");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.enterRegNumber("");
        registerObj.enterEmail("khanylunga@gmail.com");
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungani1@");
        registerObj.selectBothSubscriptions();
    }

// --------- OTP & Error messages ---------

    @Then("an OTP message should be displayed")
    public void an_otp_message_should_be_displayed() {
        Assert.assertTrue(registerObj.isOtpMessageVisible());
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        Assert.assertTrue(registerObj.isErrorMessageVisible());
    }

// --------- Other actions ---------

    @When("the user enters mismatching passwords")
    public void the_user_enters_mismatching_passwords() {
        registerObj.enterName("Lungani");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.enterRegNumber("K2025/802476/07");
        registerObj.enterEmail("khanylunga@gmail.com");
        registerObj.selectBothSubscriptions();
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungani2@");
    }

    @When("the user toggles the password visibility")
    public void the_user_toggles_the_password_visibility() {
        registerObj.togglePasswordVisibility();
        registerObj.enterName("Lungani");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.enterRegNumber("K2025/802476/07");
        registerObj.enterEmail("khanylunga@gmail.com");
        registerObj.selectBothSubscriptions();
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungani1@");
    }

    @Then("the password should be visible")
    public void the_password_should_be_visible() {
        Assert.assertTrue(registerObj.isPasswordVisible());
    }

    @When("the user enters an email that already exists")
    public void the_user_enters_an_email_that_already_exists() {
        registerObj.enterEmail("brianmabunda00@gmail.com");
        registerObj.togglePasswordVisibility();
        registerObj.enterName("Lungani");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.selectBothSubscriptions();
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungani1@");
    }

    @When("the user selects both subscriptions")
    public void the_user_selects_both_subscriptions() {
        registerObj.selectBothSubscriptions();
        registerObj.enterEmail("khanylunga@gmail.com");
        registerObj.togglePasswordVisibility();
        registerObj.enterName("Lungani");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.selectBothSubscriptions();
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungani1@");
    }

    @When("the user selects vehicle subscription only")
    public void the_user_selects_vehicle_subscription_only() {
        registerObj.selectVehicleSubscription();
        registerObj.enterEmail("khanylunga@gmail.com");
        registerObj.enterName("Lungani");
        registerObj.enterSurname("Khanyile");
        registerObj.enterCompanyName("Lubanzi ICT Consulting");
        registerObj.enterPassword("Lungani1@");
        registerObj.enterConfirmPassword("Lungani1@");
    }

//================== LOGIN AFTER REGISTRATION  ==================//

    @When("the user enters a valid email and password")
    public void the_user_enters_a_valid_email_and_password() {
        loginObj.enterLoginEmail("khanylunga@gmail.com");
        loginObj.enterLoginPassword("Lungani1@");
    }

    @And("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {
        loginObj.clickLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        boolean dashboardVisible = dashObj.isDashboardVisible();
        Assert.assertTrue("Dashboard is NOT visible — login failed!", dashboardVisible);
    }

    // ---------------- PPE Reports ----------------
    @When("the user clicks on the Reports menu")
    public void the_user_clicks_on_the_reports_menu() {
        reportsObj.clickReportsMenu();
    }

    @Then("the user should see PPE reports displayed")
    public void the_user_should_see_ppe_reports_displayed() {
        Assert.assertTrue("PPE Reports not visible", reportsObj.isPPEResultsVisible());
    }

    @And("the user clicks next page on PPE reports")
    public void the_user_clicks_next_page_on_ppe_reports() {
        reportsObj.clickNextPage();
    }

    @And("the user clicks previous page on PPE reports")
    public void the_user_clicks_previous_page_on_ppe_reports() {
        reportsObj.clickPreviousPage();
    }

    @And("the user sorts PPE reports by province and timestamp")
    public void the_user_sorts_ppe_reports_by_province_and_timestamp() {
        reportsObj.sortReportsByProvinceAndTimestamp();
    }

    @And("the user downloads the PPE report")
    public void the_user_downloads_the_ppe_report() {
        reportsObj.downloadPPEReport();
    }

    // ---------------- Vehicle Reports ----------------
    @When("the user navigates to Vehicle Reports")
    public void the_user_navigates_to_vehicle_reports() {
        reportsObj.clickVehicleReportsTab();
    }

    @Then("the user should see Vehicle reports displayed")
    public void the_user_should_see_vehicle_reports_displayed() {
        Assert.assertTrue("Vehicle Reports not visible", reportsObj.isVehicleResultsVisible());
    }

    @And("the user downloads the vehicle report")
    public void the_user_downloads_the_vehicle_report() {
        reportsObj.downloadVehicleReport();
    }




}







