package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SystemOperationManagement {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // ================= LOCATORS =================
    private final By settingDropDown =By.cssSelector("select[name='settings']");
    private final By systemTitle = By.className("main-header");

    // Add User fields
    private final By nameField = By.id("input1");
    private final By surnameField = By.id("input2");
    private final By employeeIdField = By.id("input3");
    private final By emailField = By.id("input4");
    private final By passwordField = By.id("input5");
    private final By roleDropdown = By.id("Permission");

    private final By theSave = By.name("theSave");
    private final By flashMessage = By.className("flash-messages");

    private final By searchUser = By.xpath("//input[@aria-controls='myTable']");

    // Edit User fields
    private final By editUser = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div/table/tbody/tr[1]/td[6]/a[1]/i");
    private final By editNameField = By.id("editInput3");
    private final By editSurnameField = By.id("editInput1");
    private final By editEmployeeIdField = By.id("editInput2");
    private final By editEmailField = By.id("editInput4");
    private final By editRoleDropdown = By.id("editPermission");
    private final By saveEdited = By.id("modalSave");
    private final By editSuccessMessage = By.xpath("/html/body/div[1]/div[3]/div/div[1]");
    private final By systemEditTitle = By.xpath("//h2[text()='Edit System Operators']");

    // Delete User fields
    private final By deleteIcon = By.xpath("//*[@id='myTable']/tbody/tr[1]/td[6]/a[2]");
    private final By confirmDeleteBtn = By.id("confirmDeleteBtn");
    private final By deleteMessage = By.className("flash-messages");

    // Misc messages
    private final By fillBlank = By.xpath("//*[@id='flash-container']/div");

    // Sorting locators
    private final By ascendingOrderID = By.xpath("//*[@id='myTable']/thead/tr/th[1]");
    private final By descendingOrderID = By.xpath("//*[@id='myTable']/thead/tr/th[1]");
    private final By ascendingOrderName = By.xpath("//*[@id='myTable']/thead/tr/th[2]");
    private final By descendingOrderName = By.xpath("//*[@id='myTable']/thead/tr/th[2]");
    private final By ascendingOrderSurname = By.xpath("//*[@id='myTable']/thead/tr/th[3]");
    private final By descendingOrderSurname = By.xpath("//*[@id='myTable']/thead/tr/th[3]");
    private final By ascendingOrderEmail = By.xpath("//*[@id='myTable']/thead/tr/th[4]");
    private final By descendingOrderEmail = By.xpath("//*[@id='myTable']/thead/tr/th[4]");
    private final By ascendingOrderRole = By.xpath("//*[@id='myTable']/thead/tr/th[5]");
    private final By descendingOrderRole = By.xpath("//*[@id='myTable']/thead/tr/th[5]");

    private final By searchUser1 = By.xpath("//input[@type='search']");
    private final By cancelSaveButton = By.xpath("/html/body/div[1]/div[3]/div/div[2]/button[2]");
    private final By cancelDeleteBtn = By.id("cancelDeleteBtn");

    private final By cancelEdit = By.id("cancelEdit");

    // ================= CONSTRUCTOR =================
    public SystemOperationManagement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait up to 60 seconds
    }

    // ================= SYSTEM OPERATORS SETTINGS =================
    public void clickSettingDropDown() {
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(settingDropDown));

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("System Operators");
        // Select System Operators from settings
    }

    public  String getSystemTitle(){

      return   wait.until(ExpectedConditions.visibilityOfElementLocated(systemTitle)).getText();
    }

    // ================= ADD USER =================
    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
    }

    public void enterSurname(String surname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(surnameField)).sendKeys(surname);
    }

    public void enterEmployeeId(String empId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdField)).sendKeys(empId);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void selectRole(String role) {
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(roleDropdown));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(role);
    }

    public void saveButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(theSave)).click();
    }

    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage)).getText();
    }

    public void searchUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchUser)).sendKeys("Cecil");
    }

    // ================= EDIT USER =================
    public void clickEditIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editUser)).click();
    }

    public  String getEditSystemTitle(){

      return  wait.until(ExpectedConditions.visibilityOfElementLocated(systemEditTitle)).getText();
    }

    public void editName(String name) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(editNameField));
        element.clear();
        element.sendKeys(name);
    }

    public void editSurname(String surname) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(editSurnameField));
        element.clear();
        element.sendKeys(surname);
    }

    public void editEmployeeId(String empId) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(editEmployeeIdField));
        element.clear();
        element.sendKeys(empId);
    }

    public void editEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(editEmailField));
        element.clear();
        element.sendKeys(email);
    }

    public void editSelectRole(String role) {
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(editRoleDropdown));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(role);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveEdited)).click();
    }

    public Boolean getEditSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(editSuccessMessage)).isDisplayed();
    }

    // ================= DELETE USER =================
    public void clickDeleteIcon() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteIcon)).click();
    }

    public void clickConfirmDelete() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteBtn)).click();
    }

    public String getDeletedMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deleteMessage)).getText();
    }

    // ================= SORTING =================
    public void sortIDByAscendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrderID)).click();
    }

    public void sortIDByDescendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrderID)).click();
    }

    public void sortNameByAscendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrderName)).click();
    }

    public void sortNameByDescendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrderName)).click();
    }

    public void sortSurnameByAscendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrderSurname)).click();
    }

    public void sortSurnameByDescendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrderSurname)).click();
    }

    public void sortEmailByAscendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrderEmail)).click();
    }

    public void sortEmailByDescendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrderEmail)).click();
    }

    public void sortRoleByAscendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrderRole)).click();
    }

    public void sortRoleByDescendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrderRole)).click();
    }

    // ================= SEARCH & MISC =================
    public void clickSearchUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchUser1)).sendKeys("Ronaldo");
    }

    public Boolean getFillBlackMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(fillBlank)).isDisplayed();
    }

    public void clickCancelButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelSaveButton)).click();
    }

    public void clickCancelDeleteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelDeleteBtn)).click();
    }

    public void clickCancelEdit(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelEdit)).click();
    }

}
