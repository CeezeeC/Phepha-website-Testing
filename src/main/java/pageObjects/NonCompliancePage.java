package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NonCompliancePage {

        protected WebDriver driver;
        protected WebDriverWait wait;


        By Search_field = By.xpath("//*[@id=\"myTable_filter\"]/label/input");
        By Search_Results = By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[1]");
        By Non_Existing_Warehouse = By.xpath("//*[@id=\"myTable\"]/tbody/tr[1]/td[1]");
        By Entries_dropdown = By.name("myTable_length");
        By btn_Next = By.id("myTable_next");
        By pageButtonXpath=By.xpath("//*[@id=\\\"myTable_paginate\\\"]/span/a[2]");


        private final By dropdown_PPE = By.name("PPE");

        //Constructor
        public NonCompliancePage(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        }

        //Action Methods
        public void ViewNonCompliance() {
            WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown_PPE));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText("View Non-Compliance");
        }

        public void NonComplianceIsDisplayed() {
            driver.findElement(By.xpath("/html/body/div/div[3]/div/div[1]/h1")).isDisplayed();
        }

        public void SearchExistingWarehouse() {

            WebElement Searchbox = driver.findElement(Search_field);
            Searchbox.click();
            Searchbox.sendKeys("EngineRoom43");

        }

        public void entriesDropdown() {
            int entry = 10;
            driver.findElement(Entries_dropdown).click();
        }

        public void entry25() {
            WebElement entriesDropdown = driver.findElement(Entries_dropdown);

            Actions actions = new Actions(driver);

            actions.moveToElement(entriesDropdown)
                    .click()
                    .moveToElement(driver.findElement(By.xpath("//*[@id=\"myTable_length\"]/label/select/option[2]")))
                    .click()
                    .perform();
        }

        public void NextPage() {
            driver.findElement(btn_Next).click();
        }
        public void searchBox(){
            driver.findElement(Search_field).click();

        }
        public void ExistingProvince(){
            driver.findElement(Search_field).sendKeys("Mpumalanga");
        }
        public void NonExistingProvince(){
            driver.findElement(Search_field).sendKeys("Spain");

        }
        public void NonExistingWarehouse(){
            WebElement Searchbox = driver.findElement(Search_field);
            Searchbox.click();
            Searchbox.sendKeys("Zwavhudi99");
        }

    }


