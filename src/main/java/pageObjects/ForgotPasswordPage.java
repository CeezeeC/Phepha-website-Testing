package pageObjects;

import org.assertj.core.api.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {


        private WebDriver driver;
         WebDriverWait wait;
        // Locators
        private final By forgotPasswordLink = By.xpath("//a[@href='/forgot']");
        private final By emailInput = By.name("email");
        private final By submitButton = By.cssSelector("input.submit");
        private final By emailSentMessage = By.xpath("//p[text()='Email has been sent']");

        public ForgotPasswordPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

        // ACTION: Click forgot password link
        public void clickForgotPasswordLink() {


            driver.findElement(forgotPasswordLink).click();

        }

        // VERIFY forgot password page loaded
        public Boolean verifyForgotPasswordPageDisplayed() {

               return driver.findElement(emailInput).isDisplayed();
        }

        // ACTION: Enter email
        public void enterEmail(String email) {
            driver.findElement(emailInput).clear();
            driver.findElement(emailInput).sendKeys(email);
        }

        // ACTION: Click submit
        public void clickSubmit() {
            driver.findElement(submitButton).click();
        }

        // VERIFY confirmation message
        public Boolean verifyEmailSentMessage() {


          return   wait.until(ExpectedConditions.visibilityOfElementLocated(emailSentMessage)).isDisplayed();
        }
    }

