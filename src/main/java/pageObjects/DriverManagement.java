package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DriverManagement {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public DriverManagement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait up to 20 seconds
    }

    // ================= Locators =================
    private final By settingDropDown =By.cssSelector("select[name='settings']");// Settings dropdown

    private final By nameField = By.id("inputName");          // Name input field
    private final By surnameField = By.id("inputSurname");       // Surname input field
    private final By idField = By.id("inputEmpId");           // Employee ID field
    private final By genderDropdown = By.id("Gender");     // Gender dropdown
    private final By saveButton = By.className("btn-save"); // Save button

    private final By searchField = By.xpath("//*[@id='myTable_filter']/label/input"); // Search input
    private final By successfulMessage = By.xpath("/html/body/div[1]/div[3]/div/div[1]/div/p"); // Success message

    private final By editDriverIcon  = By.className("edit-link");

    private final By editName  = By.id("editName");
    private final By editSurname   = By.id("editSurname");
    private final By editEmpId  = By.id("editEmpId");
    private final By editGender  = By.xpath("//*[@id='editGender']");
    private final By saveEdit =By.id("modal-save");
    private final By successfulEditedMsg = By.xpath("/html/body/div[1]/div[3]/div/div[1]");

    private final By deleteDriver  =  By.cssSelector("i.fas.fa-trash-alt");
    private final By deletePopUp   = By.xpath("//p[text()='Are you sure you want to delete this record?']");

    private final  By confirmDeleteBtn = By.xpath("/html/body/div[1]/div[4]/div/div/button[1]");
    private final  By deleteMessage = By.xpath("/html/body/div[1]/div[3]/div/div[1]");

    public  Boolean deleteMessageIsDisplayed(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(deleteMessage)).isDisplayed();
    }



    private final By cancel = By.className("btn"); // Cancel button

    // ================= Methods =================

    // Click Settings dropdown and select Driver Management
    public void clickSettingDropDown() {

       /* WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(settingDropDown));

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Driver Management");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        By settingsDropDown = By.xpath("//label[contains(text(),'Settings')]/following::select[1]");
        By driverOption = By.xpath("//option[contains(.,'Driver')]"); */

// Wait for settings dropdown
        WebElement settings = wait.until(ExpectedConditions.visibilityOfElementLocated(settingDropDown));

// Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", settings);

// Click dropdown
        wait.until(ExpectedConditions.elementToBeClickable(settings)).click();

// Select the option
        Select select = new Select(settings);
        select.selectByVisibleText("Driver Management");
    }

    // Enter driver name
    public void enterName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys("Cecil");
    }

    // Enter driver surname
    public void enterSurname() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(surnameField)).sendKeys("Mkhari");
    }

    // Enter driver ID
    public void enterId() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(idField)).sendKeys("2341");
    }

    // Select gender from dropdown
    public void selectGender() {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(genderDropdown)));
        select.selectByVisibleText("Male");
    }

    // Click Save button
    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    // Search for driver
    public void setSearchDriver() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys("Cecil");
    }

    public void clickEditIcon() {

        wait.until(ExpectedConditions.presenceOfElementLocated(editDriverIcon)).click();
    }

   public void enterEditName(String enterName){


        WebElement webName  = wait.until(ExpectedConditions.visibilityOfElementLocated(editName));
        webName.clear();
        webName.sendKeys(enterName);
    }
    public void enterEditSurname(String enterSurname){


        WebElement webSurname  = wait.until(ExpectedConditions.visibilityOfElementLocated(editSurname));
        webSurname.clear();
        webSurname.sendKeys(enterSurname);
    }
    public void enterEditEmpId(String enterEditEmpId){


        WebElement webEmoId  = wait.until(ExpectedConditions.visibilityOfElementLocated(editEmpId));
        webEmoId.clear();
        webEmoId.sendKeys(enterEditEmpId);
    }

    public void enterEditGender(String enterGender){


        WebElement webGender  = wait.until(ExpectedConditions.visibilityOfElementLocated(editGender));
        Select genderSelect = new Select(webGender);
        genderSelect.selectByVisibleText(enterGender);
    }



    public void editDriver(String name, String surname, String empId, String gender) {
        enterEditName(name);
        enterEditSurname(surname);
        enterEditEmpId(empId);
        enterEditGender(gender);

    }

    public void saveEditDriver(){

        wait.until(ExpectedConditions.elementToBeClickable(saveEdit)).click();
    }
    // Get success message text
    public Boolean getSuccessfulMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successfulMessage)).isDisplayed();
    }

    public  boolean updatedMessageIsDisplayed(){


        return  wait.until(ExpectedConditions.visibilityOfElementLocated(successfulEditedMsg)).isDisplayed();
    }

    // Click Cancel button
    public void cancelDriver() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveEdit)).click();
    }

    public void  clickDeleteIcon(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteDriver)).click();
    }

    public  void clickConfirmDeleteButton(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteBtn)).click();
    }

    public  boolean deletePageIsDisplayed(){

        return  wait.until(ExpectedConditions.visibilityOfElementLocated(deletePopUp)).isDisplayed();
    }
}
