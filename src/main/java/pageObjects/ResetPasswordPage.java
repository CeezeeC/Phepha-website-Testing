package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetPasswordPage {

    WebDriver driver;
    WebDriverWait wait;

        // Locators
        private final By passwordField = By.id("password");
        private final By confirmPasswordField = By.id("confirm_password");
        private final By submitButton = By.cssSelector("input.submit");
        private final By resetSuccessMessage = By.xpath("//p[text()='Your password has been reset']");

        public ResetPasswordPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

        /**
         * Navigates the browser directly to the extracted URL.
         * @param url The dynamic reset link extracted from the email.
         */
        public void openResetLink(String url) {
            driver.get(url);
        }

        /**
         * Asserts if the key element of the reset form is visible.
         */
        public boolean isResetPageDisplayed() {
            // Use a try-catch or explicit wait in production code for robustness
            return driver.findElement(passwordField).isDisplayed();
        }

        public void enterNewPasswords(String password, String confirmPassword) {
            driver.findElement(passwordField).clear();
            driver.findElement(passwordField).sendKeys(password);

            driver.findElement(confirmPasswordField).clear();
            driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        }

        public void submitNewPassword() {
            driver.findElement(submitButton).click();
        }

        public Boolean verifyResetSuccessMessage() {

            return   wait.until(ExpectedConditions.visibilityOfElementLocated(resetSuccessMessage)).isDisplayed();
        }

}
