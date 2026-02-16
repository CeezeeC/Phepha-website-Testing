package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WareHouseManagement {

    protected WebDriver driver;
    protected WebDriverWait wait;

    // ================= LOCATORS =================
    private final By settingDropDown =By.name("settings");
    private  final By warehouseManagement = By.xpath("//option[@value='/PPEB']");

    private  final  By warehouseTitle = By.className("main-header");

    private final By warehouseInput = By.id("input1");
    private final By provinceDropdown = By.name("Province");
    private final By saveButton = By.cssSelector("button.btn-save");

    private final By viewWarehouse = By.id("myTable_wrapper");
    private final By flashMessage = By.id("flash-container");
    private final By cancelButton = By.id("theCancel");

    private final By searchField = By.cssSelector("input[type='search']");

    private final By editIcon = By.id("edit");
    private final By editWarehouseInput = By.id("editWarehouse");
    private final By editProvinceDropdown = By.id("editProvince");
    private final By editedSave = By.id("modalSave");

    private final By deleteBtn = By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[5]/a");
    private final By confirmDeleteBtn = By.id("confirmDeleteBtn");

    private final By next = By.id("myTable_next");
    private final By previous = By.id("myTable_previous");

    private final By tenEntries10 = By.name("myTable_length");
    private final By tenEntries25 = By.name("myTable_length");

    private final By ascendingOrder = By.xpath("//*[@id='myTable']/thead/tr/th[3]");
    private final By descendingOrder = By.xpath("//*[@id='myTable']/thead/tr/th[3]");

    // ================= CONSTRUCTOR =================
    public WareHouseManagement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 60 seconds
    }

    // ================= WAREHOUSE MANAGEMENT =================

    // Open warehouse management from settings dropdown
    public void clickSettingDropDown() {


       wait.until(ExpectedConditions.presenceOfElementLocated(settingDropDown)).click();

    }
    public  void clickWareHouseManagement(){

        wait.until(ExpectedConditions.presenceOfElementLocated(warehouseManagement)).click();
    }

    // Get current URL
    public String getWareHouseTitle() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(warehouseTitle)).getText();
    }

    // Enter warehouse name
    public void enterWarehouse() {
        WebElement warehouseField = wait.until(ExpectedConditions.visibilityOfElementLocated(warehouseInput));
        warehouseField.clear();
        warehouseField.sendKeys("Johannesburg");
    }

    // Select province from dropdown
    public void selectProvince() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(provinceDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Gauteng");
    }

    // Click save button
    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    // Get success message after save
    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage)).getText();
    }

    // Check if warehouse table is displayed
    public Boolean displayWareHouse() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(viewWarehouse)).isDisplayed();
    }

    // Click cancel button
    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
    }

    // ================= SEARCH WAREHOUSE =================
    public void searchFor(String result) {

        WebElement webSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        webSearch.sendKeys(result);
        webSearch.clear();



    }

    // ================= EDIT WAREHOUSE =================
    public void clickEditIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(editIcon)).click();
    }

    public void editWarehouse() {
        WebElement warehouseField = wait.until(ExpectedConditions.visibilityOfElementLocated(editWarehouseInput));
        warehouseField.clear();
        warehouseField.sendKeys("Giyani");
    }

    public void editProvince() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(editProvinceDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Limpopo");
    }

    public void clickSaveEdit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(editedSave)).click();
    }

    // ================= DELETE WAREHOUSE =================
    public void clickDelete() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteBtn)).click();
    }

    public void clickConfirmDelete() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteBtn)).click();
    }

    // ================= PAGINATION =================
    public void clickNext() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(next)).click();
    }

    public void clickPrevious() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(previous)).click();
    }

    // ================= ENTRIES PER PAGE =================
    public void clickEntries10() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenEntries10)).click();
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tenEntries10));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("10");
    }

    public void clickEntries25() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tenEntries25)).click();
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tenEntries25));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("25");
    }

    // ================= SORTING =================
    public void sortByAscendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrder)).click();
    }

    public void sortByDescendingOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrder)).click();
    }
}
