package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By createAccountLink = By.xpath("/html/body/div/div/form/p/a");
    private final  By nameField = By.name("username");
    private final By surnameField = By.name("surname");
    private final By companyNameField = By.name("company_name");
    private final By regNumberField = By.name("C_R_N");
    private final   By emailField = By.name("email");
    private final   By passwordField = By.id("password");
    private final   By confirmPasswordField = By.name("confirm_password");
    private final   By subscriptionDropdown = By.id("subscription");
    private final   By vehicleSubscriptionOption = By.xpath("//*[@id=\"subscription\"]/option[3]");
    private final  By bothSubscriptionOption = By.xpath("//*[@id=\"subscription\"]/option[4]");

    // UPDATED: registerButton → signUpButton
    private final  By signUpButton = By.xpath("//*[@id=\"signup\"]");

    private final   By otpMessage = By.xpath("/html/body/div/div/div[2]/div/div/div");
    private final  By successMessage = By.id("successMessage");
    private final  By errorMessage = By.xpath("/html/body/div/div/div[2]/div/div/div");
    private final  By togglePassword = By.xpath("/html/body/div/div/div[2]/div/div/form/div[7]/span/i");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickCreateAccountLink() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountLink)).click();
    }

    public boolean isRegistrationFormVisible() {
        return driver.findElement(nameField).isDisplayed();
    }

    // --- Enter details ---
    public void enterName(String name) {
        WebElement field = driver.findElement(nameField);
        field.clear();
        field.sendKeys(name);
    }

    public void enterSurname(String surname) {
        WebElement field = driver.findElement(surnameField);
        field.clear();
        field.sendKeys(surname);
    }

    public void enterCompanyName(String company) {
        WebElement field = driver.findElement(companyNameField);
        field.clear();
        field.sendKeys(company);
    }

    public void enterRegNumber(String reg) {
        WebElement field = driver.findElement(regNumberField);
        field.clear();
        field.sendKeys(reg);
    }

    public void enterEmail(String email) {
        WebElement field = driver.findElement(emailField);
        field.clear();
        field.sendKeys(email);
    }

    public void enterPassword(String pass) {
        WebElement field = driver.findElement(passwordField);
        field.clear();
        field.sendKeys(pass);
    }

    public void enterConfirmPassword(String pass) {
        WebElement field = driver.findElement(confirmPasswordField);
        field.clear();
        field.sendKeys(pass);
    }

    // --- Subscription ---
    public void selectSubscription() {
        WebElement dropdown = driver.findElement(subscriptionDropdown);
        dropdown.click();
        dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void selectVehicleSubscription() {
        driver.findElement(vehicleSubscriptionOption).click();
    }

    public void selectBothSubscriptions() {
        driver.findElement(bothSubscriptionOption).click();
    }


    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void togglePasswordVisibility() {
        driver.findElement(togglePassword).click();
    }

    // --- Visibility checks ---
    public boolean isSuccessMessageVisible() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean isErrorMessageVisible() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public boolean isOtpMessageVisible() {
        return driver.findElement(otpMessage).isDisplayed();
    }

    public boolean isPasswordVisible() {
        return driver.findElement(passwordField).getAttribute("type").equals("text");
    }

    // --- Browser validation messages ---
    public String getFieldValidationMessage(By fieldLocator) {
        WebElement field = driver.findElement(fieldLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", field);
    }

    public String getSubscriptionValidationMessage() {
        WebElement dropdown = driver.findElement(subscriptionDropdown);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(
                "if(arguments[0].selectedIndex == 0) { return 'Please select an item in the list.'; } else { return ''; }",
                dropdown);
    }
}
