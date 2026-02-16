package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 40 seconds
    }

    // ================= URL CHECK =================
    public String getCurrentDashboardUrl() {
        return driver.getCurrentUrl(); // Get current URL
    }

    public String getExpectedDashboardUrl() {
        return "http://phephaqa.lubanzi-ictc.co.za/index"; // Expected dashboard URL
    }

    // ================= LOCATORS =================
    private final By dashboardContainer = By.xpath("/html/body/div[1]/div[3]"); // Dashboard main container
    private final By hamburgerMenu = By.xpath("//*[local-name()='ion-icon' and @name='menu-outline']"); // Hamburger menu
    private final By viewAllButton = By.xpath("/html/body/div[1]/div[3]/div[3]/div[1]/div[1]/a"); // View All button
    private final By chevronDown = By.xpath("//*[@id='profileTrigger']/i"); // Profile chevron
    private final By seeMoreButton = By.xpath("//div[@class='see_more']//button[normalize-space(text())='See More']"); // See More button
    private final By totalPPENonComplianceCard = By.xpath("/html/body/div[1]/div[3]/div[2]/div[1]"); // PPE non-compliance card
    private final By ppeSidebarButton = By.xpath("/html/body/div[1]/div[2]/ul/li[4]/a/div/select"); // PPE sidebar dropdown
    private final By ppeViewNonCompliance = By.xpath("/html/body/div[1]/div[2]/ul/li[4]/a/div/select/option[3]"); // PPE view non-compliance option
    private final By totalEntriesOnPPEReport = By.xpath("//*[@id='myTable_info']"); // Total entries info

    // Monthly Non-Compliance Overview
    private final By monthlyNonComplianceOverviewYearDropdown = By.xpath("//*[@id='year-select-bar']"); // Year dropdown
    private final By monthlyNonComplianceOverviewFullscreen = By.xpath("//*[@id='expand-bar']"); // Fullscreen button

    // Monthly Non-Compliance Trend
    private final By monthlyNonComplianceTrendYearDropdown = By.xpath("//*[@id='year-select-line']"); // Trend year dropdown
    private final By monthlyNonComplianceTrendFullscreen = By.xpath("//*[@id='expand-line']"); // Trend fullscreen

    // Top Non-Compliance Categories
    private final By topNonComplianceCategoriesYearDropdown = By.xpath("//*[@id='year-select-donut']"); // Categories year dropdown
    private final By topNonComplianceCategoriesFullscreen = By.xpath("//*[@id='expand-donut']"); // Categories fullscreen

    // Warehouse Non-Compliance Comparison
    private final By warehouseCompareDropdown1 = By.xpath("//*[@id='pie-warehouse-1']"); // Warehouse dropdown 1
    private final By warehouseCompareDropdown2 = By.xpath("//*[@id='pie-warehouse-2']"); // Warehouse dropdown 2
    private final By warehouseFullscreen = By.xpath("//*[@id='expand-pie']"); // Warehouse fullscreen

    // Common fullscreen close button
    private final By closeFullscreen = By.xpath("//*[@id='close-modal']"); // Close fullscreen

    // ================= PAGE ACTIONS =================

    // Check if dashboard is visible
    public boolean isDashboardVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardContainer));
        System.out.println("Dashboard is visible.");
        return driver.findElement(dashboardContainer).isDisplayed();
    }

    // Click hamburger menu
    public void clickHamburgerMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenu)).click();
        System.out.println("Hamburger menu clicked.");
    }

    // Click View All button
    public void clickViewAllButton() {
        wait.until(ExpectedConditions.elementToBeClickable(viewAllButton)).click();
        System.out.println("View All button clicked.");
    }

    // Click chevron dropdown
    public void clickChevronDown() {
        wait.until(ExpectedConditions.elementToBeClickable(chevronDown)).click();
        System.out.println("Chevron dropdown clicked.");
    }

    // Click See More button with fallback
    public void clickSeeMore() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(seeMoreButton)).click();
            System.out.println("'See More' clicked successfully.");
        } catch (TimeoutException e) {
            System.out.println("'See More' not found, returning to dashboard...");
            navigateBackToDashboard();
            wait.until(ExpectedConditions.elementToBeClickable(seeMoreButton)).click();
            System.out.println("'See More' clicked after navigating back.");
        }
    }

    // Get total PPE non-compliance from dashboard
    public String getTotalPPENonCompliance() {
        String total = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPPENonComplianceCard)).getText();
        System.out.println("Total PPE Non-Compliance from dashboard: " + total);
        return total;
    }

    // Click PPE sidebar
    public void clickPPESidebar() {
        wait.until(ExpectedConditions.elementToBeClickable(ppeSidebarButton)).click();
        System.out.println("PPE sidebar button clicked.");
    }

    // Open PPE Non-Compliance report
    public void clickViewNonCompliance() {
        wait.until(ExpectedConditions.elementToBeClickable(ppeViewNonCompliance)).click();
        System.out.println("PPE Non-Compliance report opened.");
    }

    // Get total entries from PPE report
    public String getTotalEntriesFromPPEReport() {
        String entries = wait.until(ExpectedConditions.visibilityOfElementLocated(totalEntriesOnPPEReport)).getText();
        System.out.println("Total entries from PPE report: " + entries);

        // Go back to dashboard automatically
        navigateBackToDashboard();
        return entries;
    }

    // ================= NAVIGATION =================

    // Navigate back to dashboard
    public void navigateBackToDashboard() {
        try {
            System.out.println("Navigating back to dashboard...");
            driver.navigate().back();
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardContainer));
            System.out.println("Returned to dashboard successfully.");
        } catch (TimeoutException e) {
            System.err.println("Dashboard not visible after back navigation. Reloading base URL...");
            String dashboardUrl = ConfigReader.properties.getProperty("dashboard_url",
                    ConfigReader.properties.getProperty("url"));
            driver.get(dashboardUrl);
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardContainer));
            System.out.println("Reloaded dashboard successfully.");
        } catch (Exception ex) {
            System.err.println("Unexpected error returning to dashboard: " + ex.getMessage());
        }
    }

    // ================= DROPDOWN & FULLSCREEN UTILITIES =================

    // Select dropdown by visible text
    private void selectDropdownByVisibleText(By dropdown, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
        Select select = new Select(element);
        select.selectByVisibleText(value);
        System.out.println("Selected '" + value + "' from dropdown: " + dropdown);
    }

    // Select dropdown by value with fallback
    private void selectDropdownByValue(By dropdown, String value) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
        Select select = new Select(element);

        try {
            select.selectByVisibleText(value);
            System.out.println("Selected visible text '" + value + "' from dropdown.");
        } catch (NoSuchElementException e) {
            System.out.println("Option '" + value + "' not found. Selecting first available option instead.");
            select.selectByIndex(0);
        }
    }

    // Click fullscreen and close
    private void clickFullscreen(By fullscreenButton) {
        wait.until(ExpectedConditions.elementToBeClickable(fullscreenButton)).click();
        System.out.println("Fullscreen opened.");

        // Wait for close button and close it
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeFullscreen));
        driver.findElement(closeFullscreen).click();
        System.out.println("Fullscreen closed.");
    }

    // ================= INDIVIDUAL CARD ACTIONS =================

    public void selectMonthlyOverviewYear(String year) {
        selectDropdownByVisibleText(monthlyNonComplianceOverviewYearDropdown, year);
    }

    public void openMonthlyOverviewFullscreen() {
        clickFullscreen(monthlyNonComplianceOverviewFullscreen);
    }

    public void selectMonthlyTrendYear(String year) {
        selectDropdownByVisibleText(monthlyNonComplianceTrendYearDropdown, year);
    }

    public void openMonthlyTrendFullscreen() {
        clickFullscreen(monthlyNonComplianceTrendFullscreen);
    }

    public void selectTopCategoriesYear(String year) {
        selectDropdownByVisibleText(topNonComplianceCategoriesYearDropdown, year);
    }

    public void openTopCategoriesFullscreen() {
        clickFullscreen(topNonComplianceCategoriesFullscreen);
    }

    // ================= SMART WAREHOUSE DROPDOWN =================

    public void selectWarehouseCompareDropdown1(String value) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(warehouseCompareDropdown1));
        Select select = new Select(dropdown);

        if (value.startsWith("pie-")) {
            String firstOption = select.getOptions().get(0).getText();
            select.selectByVisibleText(firstOption);
            System.out.println("Defaulted dropdown 1 to first option: " + firstOption);
        } else {
            select.selectByVisibleText(value);
            System.out.println("Selected dropdown 1 option: " + value);
        }
    }

    public void selectWarehouseCompareDropdown2(String value) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(warehouseCompareDropdown2));
        Select select = new Select(dropdown);

        if (value.startsWith("pie-")) {
            String secondOption = select.getOptions().get(0).getText();
            select.selectByVisibleText(secondOption);
            System.out.println("Defaulted dropdown 2 to second option: " + secondOption);
        } else {
            select.selectByVisibleText(value);
            System.out.println("Selected dropdown 2 option: " + value);
        }
    }

    public void openWarehouseFullscreen() {
        clickFullscreen(warehouseFullscreen);
    }
}
