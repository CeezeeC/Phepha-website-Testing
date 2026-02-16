package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportsPage {



        WebDriver driver;
        WebDriverWait wait;

        private final By dashboardHeader = By.xpath("/html/body/div[1]/div[2]/ul/li[2]/a"); // Dashboard heading
    private final   By reportsMenu = By.xpath("/html/body/div[1]/div[2]/ul/li[5]/a/span[2]"); // Reports menu
    private final    By ppeReportSection = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]"); // PPE Reports section title
    private final     By vehicleReportSection = By.xpath("//*[@id=\"ppeTable\"]"); // Vehicle Reports section
    private final     By nextButton = By.xpath("//*[@id=\"myTable_next\"]"); // Pagination next
    private final    By prevButton = By.xpath("//*[@id=\"myTable_previous\"]"); // Pagination previous
    private final    By downloadPPE = By.xpath("//*[@id=\"pdfmake\"]"); // Download PPE PDF
    private final     By vehicleReportsTab = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]/button/ion-icon"); // Vehicle reports tab
    private final    By downloadVehicle = By.id("pdfmake"); // Download Vehicle PDF

        // Sorting headers
        By provinceHeader = By.xpath("//*[@id=\"myTable\"]/thead/tr/th[1]");
        By timestampHeader = By.xpath("//*[@id=\"myTable\"]/thead/tr/th[4]");

        public ReportsPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        }

        public boolean isDashboardVisible() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
        }

        public void clickReportsMenu() {
            WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(reportsMenu));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menu);
            menu.click();
        }

        public boolean isPPEResultsVisible() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ppeReportSection)).isDisplayed();
        }

        public void clickNextPage() {
            WebElement next = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
            if(next.isEnabled()) next.click();
        }

        public void clickPreviousPage() {
            WebElement prev = wait.until(ExpectedConditions.elementToBeClickable(prevButton));
            if(prev.isEnabled()) prev.click();
        }

        public void sortReportsByProvinceAndTimestamp() {
            wait.until(ExpectedConditions.elementToBeClickable(provinceHeader)).click();
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            wait.until(ExpectedConditions.elementToBeClickable(timestampHeader)).click();
        }

        public void downloadPPEReport() {
            WebElement download = wait.until(ExpectedConditions.elementToBeClickable(downloadPPE));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", download);
            download.click();
        }

        public void clickVehicleReportsTab() {
            WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(vehicleReportsTab));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tab);
            tab.click();
        }

        public boolean isVehicleResultsVisible() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(vehicleReportSection)).isDisplayed();
        }

        public void downloadVehicleReport() {
            WebElement download = wait.until(ExpectedConditions.elementToBeClickable(downloadVehicle));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", download);
            download.click();
        }
    }


