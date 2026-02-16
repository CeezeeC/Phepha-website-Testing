package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InvalidLoginPage
{

        protected WebDriver driver;
        WebDriverWait wait ;
        // Locators
        private final By emailField = By.name("email");
        private final By passwordField = By.id("password");
        private final By loginButton = By.className("submit");
        private final By passwordToggle = By.id("togglePassword");
        private final By errorMessage = By.cssSelector(".flash-message.flash-n p");

        // Constructor
        public InvalidLoginPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        // Open login page
        public void open(String url) {
            driver.get(url);
        }

        // Enter email
        public void enterEmail(String email) {
            WebElement emailInput = driver.findElement(emailField);
            emailInput.clear();
            emailInput.sendKeys(email);
        }

        // Enter password
        public void enterPassword(String password) {
            WebElement passwordInput = driver.findElement(passwordField);
            passwordInput.clear();
            passwordInput.sendKeys(password);
        }

        // Leave email and password empty
        public void clearEmailAndPassword() {
            driver.findElement(emailField).clear();
            driver.findElement(passwordField).clear();
        }

        // Click login
        public void clickLogin() {
            driver.findElement(loginButton).click();
        }

        // Get flash error message
        public String getErrorMessage() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return error.getText();
        }

        // Get browser validation message for required field
        public String getEmailValidationMessage() {
            WebElement emailInput = driver.findElement(emailField);
            return emailInput.getAttribute("validationMessage");
        }

        // Toggle password visibility
        public void togglePasswordVisibility() {
            driver.findElement(passwordToggle).click();
        }

        // Get password field type ("password" or "text")
        public String getPasswordFieldType() {
            return driver.findElement(passwordField).getAttribute("type");
        }
    }

