package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class VehicleAllocationPage {



        WebDriver driver;
        WebDriverWait wait;

        public VehicleAllocationPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        // LOCATORS
        private final By vehicleAllocationButton = By.xpath("/html/body/div[1]/div[2]/ul/li[6]/a/div/select/option[7]");
        private final By registrationNumberField = By.id("registration");
        private final By idNumberField = By.id("idNum");
        private final By saveButton = By.className("btn-save");
        private final By vehicleTable = By.xpath("//*[@id='myTable']");
        private final By searchInput = By.xpath("//*[@id='myTable_filter']/label/input");
        private final By tableRows = By.xpath("//*[@id='myTable']/tbody/tr");
        private final By successMessage = By.id("successMessage");

        // PAGE ACTIONS

        public void clickVehicleAllocation() {
            WebElement allocationBtn = wait.until(ExpectedConditions.elementToBeClickable(vehicleAllocationButton));
            allocationBtn.click();
            System.out.println("Clicked on Vehicle Allocation.");
        }
        public void enterRegistrationNumber(String registrationNumber) {
            driver.findElement(registrationNumberField).sendKeys(registrationNumber);
        }
        public void enterDriverID(String idNumber) {
            driver.findElement(idNumberField).sendKeys(idNumber);
        }
        public void clickSave() {
            driver.findElement(saveButton).click();
        }
        // Wait for success message to appear, and then wait for it to disappear
        public void waitForSuccessMessage() {
            // Wait for the success message to be visible
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            System.out.println("Success message displayed: " + message.getText());

            // Optional: Wait for a specific amount of time (e.g., 5 seconds) for the message to disappear
            try {
                Thread.sleep(5000); // Wait for 5 seconds to allow the message to disappear (adjust as necessary)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Optionally, you can verify the message disappears (wait until it's no longer visible)
            wait.until(ExpectedConditions.invisibilityOf(message));
            System.out.println("Success message has disappeared.");
        }

        // Get the success message text (optional for verification)
        public String getSuccessMessageText() {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return message.getText();
        }

        public boolean isVehicleTableVisible() {
            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(vehicleTable));
            return table.isDisplayed();
        }

        public void searchVehicle(String keyword) {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
            input.clear();
            input.sendKeys(keyword);
            System.out.println("Entered keyword in vehicle search: " + keyword);
        }
        // Additional methods to verify the populated fields after clicking save (e.g., car model, type, and brand).
        public String getCarModel() {
            // Assuming the car model field can be identified by its locator
            return driver.findElement(By.id("carModel")).getText();
        }

        public String getVehicleType() {
            // Assuming vehicle type field
            return driver.findElement(By.id("vehicleType")).getText();
        }

        public String getBrand() {
            // Assuming brand field
            return driver.findElement(By.id("brand")).getText();
        }

        public boolean verifyVehicleSpecs(String model, String type, String brand) {
            List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tableRows));

            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                if (cells.size() >= 3) {
                    String rowModel = cells.get(0).getText().trim();
                    String rowType = cells.get(1).getText().trim();
                    String rowBrand = cells.get(2).getText().trim();

                    if (rowModel.equals(model) && rowType.equals(type) && rowBrand.equals(brand)) {
                        System.out.println("Found matching vehicle: " + rowModel + " | " + rowType + " | " + rowBrand);
                        return true;
                    }
                }
            }
            System.out.println("Vehicle with specified specs not found.");
            return false;
        }
}
