package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public class LoginPage
{

    WebDriverWait wait ;
    protected WebDriver driver;
    private final By loginEmail = By.name("email");
    private final By loginPassword = By.id("password");
    private final By loginButton = By.className("submit");
    private final By dashBoard = By.xpath("//header[text()='Welcome to Phepha']");


    public LoginPage(WebDriver driver){

        this.driver = driver;
        this.wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void enterLoginEmail(String stringEmail) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail)).sendKeys(stringEmail);
    }

    public void enterLoginPassword(String stringPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPassword)).sendKeys(stringPassword);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public String getCurrentLoginUrl(){


        return driver.getCurrentUrl();

    }
    public  String getExpectedLoginUrl(){

        return  "http://phephaqa.lubanzi-ictc.co.za/";
    }

    public void loginDetails()
    {
        enterLoginEmail("Mathabontuli2@gmail.com");
        enterLoginPassword("Khanya.94@Tm");
        clickLoginButton();

    }
}
