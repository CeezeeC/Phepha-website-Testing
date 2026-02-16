package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CameraManagement {

    WebDriver driver;
    WebDriverWait wait;

    //Locators
    private final By settingDropDown =By.name("settings");
    private final By cameraManagement = By.xpath("//option[@value='/CameraManagement']");
    private final By addCameraButton =  By.id("addCameraButton");
    private final By cameraManagementTitle = By.xpath("//h1[text()='Camera Management']");
    private final By addCameraTitle = By.xpath("//h1[text()='Add The Camera']");

    private final By txt_CameraName = By.id("cameraName");
    private final By txt_CameraDescription = By.id("cameraDescription");
    private final By txt_SerialNumber = By.id("serialNumber");
    private final By txt_CameraModel = By.id("cameraModel");
    private final By txt_IP = By.id("ip");
    private final By txt_Port = By.id("port");
    private final By txt_Channel = By.id("channel");
    private final By ddl_Warehouse = By.id("warehouse");
    private final By btn_Save = By.xpath("//*[@id='cameraForm']/button[1]");
   private final By msg_Success = By.xpath("//div[contains(@class,'flash-success')]");

    private final By tenEntries10 = By.name("myTable_length");
    private final By tenEntries25 = By.name("myTable_length");

    private final By ascendingOrderName = By.xpath("//*[@id='myTable']/thead/tr/th[2]");
    private final By descendingOrderName = By.xpath("//*[@id='myTable']/thead/tr/th[2]");

    private final By ascendingOrderDescription = By.xpath("//*[@id='myTable']/thead/tr/th[3]");
    private final By descendingOrderDescription = By.xpath("//*[@id='myTable']/thead/tr/th[3]");

    private final By ascendingOrderModel = By.xpath("//*[@id='myTable']/thead/tr/th[4]");
    private final By descendingOrderModel = By.xpath("//*[@id='myTable']/thead/tr/th[4]");

    private final By ascendingOrderSerial = By.xpath("//*[@id='myTable']/thead/tr/th[5]");
    private final By descendingOrderSerial = By.xpath("//*[@id='myTable']/thead/tr/th[5]");

    private final By ascendingOrderAllocation = By.xpath("//*[@id='myTable']/thead/tr/th[6]");
    private final By descendingOrderAllocation = By.xpath("//*[@id='myTable']/thead/tr/th[6]");


    private final By editIcon = By.name("create");
    private final By cancelEdit  = By.id("cancelEdit");


    private final By EditCameraSettingsTitle = By.xpath("//h2[text()='Edit Camera Settings']");


    private final By editCameraName = By.id("editCameraName");
    private final By editCameraDescription = By.id("editCameraDescription");
    private final By editSerialNumber = By.id("editSerialNumber");
    private final By editCameraModel = By.id("editCameraModel");
    private final By editIP = By.id("editIP");
    private final By editPort = By.id("editPort");
    private final By editChannel = By.id("editChannel");
    private final By editWarehouse = By.id("editWarehouse");
    private final By editBtnSave = By.id("modalSave");
    private final By successfulEdited = By.xpath("//*[@id='flash-container']");
    private final By deleteCameraDetails  = By.name("trash");

    private final By myTable_next  = By.className("next");
    private final By myTable_previous = By.className("previous");



    public CameraManagement(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickSettingDropDown() {

        wait.until(ExpectedConditions.elementToBeClickable(settingDropDown)).click();

    }

    public  void clickCameraManagement(){

        wait.until(ExpectedConditions.elementToBeClickable(cameraManagement)).click();
    }

    public String getCameraManagementTitle(){

        return wait.until(ExpectedConditions.presenceOfElementLocated(cameraManagementTitle)).getText();
    }

    public void clickAddCamera(){
        wait.until(ExpectedConditions.presenceOfElementLocated(addCameraButton)).click();
    }

    public String getAddCameraTitle(){

       return wait.until(ExpectedConditions.presenceOfElementLocated(addCameraTitle)).getText();
    }
    public void enterCameraName(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(txt_CameraName)).sendKeys(name);
    }

    public void enterCameraDescription(String desc) {
        wait.until(ExpectedConditions.presenceOfElementLocated(txt_CameraDescription)).sendKeys(desc);
    }
    public void enterSerialNumber(String serial) {
        wait.until(ExpectedConditions.presenceOfElementLocated(txt_SerialNumber)).sendKeys(serial);
    }

    public void enterCameraModel(String model) {
        wait.until(ExpectedConditions.presenceOfElementLocated(txt_CameraModel)).sendKeys(model);
    }
    public void enterIP(String ip) {
        wait.until(ExpectedConditions.presenceOfElementLocated(txt_IP)).sendKeys(ip);
    }

    public void enterPort(String port) {
        wait.until(ExpectedConditions.presenceOfElementLocated(txt_Port)).sendKeys(port);
    }
    public void enterChannel(String channel) {
        wait.until(ExpectedConditions.presenceOfElementLocated(txt_Channel)).sendKeys(channel);
    }

    public void selectWarehouse() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ddl_Warehouse)).click();
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ddl_Warehouse));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Johannesburg");
    }

    // Save button
    public void clickSave() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Save)).click();
    }

    public  String getSuccessfulMessage(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(msg_Success)).getText();
    }

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
    public void sortByAscendingOrderName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrderName)).click();
    }

    public void sortByDescendingOrderName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrderName)).click();
    }
    public void sortByAscendingOrderDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrderDescription)).click();
    }

    public void sortByDescendingOrderDescription() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrderDescription)).click();
    }
    public void sortByAscendingOrderModel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrderModel)).click();
    }

    public void sortByDescendingOrderModel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrderModel)).click();
    }

    public void sortByAscendingOrderSerial() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrderSerial)).click();
    }

    public void sortByDescendingOrderSerial() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrderSerial)).click();
    }
    public void sortByAscendingOrderAllocation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ascendingOrderAllocation)).click();
    }

    public void sortByDescendingOrderAllocation() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(descendingOrderAllocation)).click();
    }


    public void clickEdit() {
        wait.until(ExpectedConditions.elementToBeClickable(editIcon)).click();
    }

    public  String getEditSettingsTitle(){

      return   wait.until(ExpectedConditions.presenceOfElementLocated(EditCameraSettingsTitle)).getText();
    }
    public void editCameraName(String name) {
        driver.findElement(editCameraName).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(editCameraName)).sendKeys(name);
    }

    public void editCameraDescription(String description) {
        driver.findElement(editCameraDescription).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(editCameraDescription)).sendKeys(description);
    }

    public void editSerialNumber(String number) {
        driver.findElement(editSerialNumber).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(editSerialNumber)).sendKeys(number);
    }

    public void editCameraModel(String model) {
        driver.findElement(editCameraModel).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(editCameraModel)).sendKeys(model);
    }

    public void editIP(String ip) {
        driver.findElement(editIP).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(editIP)).sendKeys(ip);
    }

    public void editPort(String port) {
        driver.findElement(editPort).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(editPort)).sendKeys(port);
    }

    public void editChannel(String channel) {
        driver.findElement(editChannel).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(editChannel)).sendKeys(channel);
    }

    public void selectWarehouses() {
        WebElement dropdown = driver.findElement(editWarehouse);
        Select select = new Select(dropdown);
        select.selectByVisibleText("Johannesburg");
    }


    public  void  saveEdited(){

        wait.until(ExpectedConditions.presenceOfElementLocated(editBtnSave)).click();
    }

    public  String  displaySuccessfulEditedMessage(){

       return wait.until(ExpectedConditions.presenceOfElementLocated(successfulEdited)).getText();
    }

    public void clickNext() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myTable_next)).click();
    }

    public void clickPrevious() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myTable_previous)).click();
    }

    public  void clickDeleteCameraDetails(){

        wait.until(ExpectedConditions.presenceOfElementLocated(deleteCameraDetails)).click();
    }
}
