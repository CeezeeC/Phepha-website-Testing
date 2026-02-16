package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PPEPage {



        protected WebDriver driver;
        protected WebDriverWait wait;

        //Locators
        //By dropdown_PPE = By.name("PPE");
       private final By live_monitoring = By.xpath("/html/body/div[1]/div[2]/ul/li[4]/a/div/select/option[2]");
        private final By dropdown_PPE = By.name("PPE");

        //Constructor
        public PPEPage(WebDriver driver){
            this.driver=driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        }

        //Action methods
        public void clickPPE(){
            WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown_PPE));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText("Live PPE-Monitoring");
        }

        public void liveMonitoringIsDisplayed(){
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]")).isDisplayed();
        }
    }


