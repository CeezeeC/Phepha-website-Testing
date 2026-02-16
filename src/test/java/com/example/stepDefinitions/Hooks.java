package com.example.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;
import utils.ScreenshotTaker;

public class Hooks {

        public static WebDriver driver;
        public static String TEST_URL = ConfigReader.getProperty("testURL");
        private final String srcPath = ConfigReader.getProperty("Screenshot_Path");

        /**
         * Setup hook that runs before each scenario.
         * Initializes and configures the Firefox WebDriver.
         */
        @Before
        public void webdriverSetup() {
            String browser = ConfigReader.getProperty("Browser").toLowerCase();
            driver = BrowserConfig(browser);
            driver.manage().window().maximize();
        }

    private WebDriver BrowserConfig(String browser) {
        return switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

               //Run headless only in pipeline
                if (System.getProperty("env", "local").equals("pipeline")) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                }

                yield new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                yield new EdgeDriver();
            }
            default -> throw new IllegalStateException("Unexpected value: " + browser);
        };
    }

    /**
     * Teardown hook that runs after each scenario.
     * Ensures proper cleanup of WebDriver resources.
     */
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * AfterStep hook that captures screenshots when steps fail.
     * Takes a screenshot and logs the failure when a step fails during execution.
     *
     * @param StepInfo Current scenario information
     */
    @AfterStep
    public void ScreenShotUtil(Scenario StepInfo) {
        ScreenshotTaker SrcShotTaker = new ScreenshotTaker(
                srcPath,
                StepInfo.getName() + " " + StepInfo.getId(),
                driver
        );

        if (StepInfo.isFailed()) {
            System.out.printf("Step Failed: %s", StepInfo);
            SrcShotTaker.takeFullPageScreenShot();
        }

        SrcShotTaker.takeScreenShot();
    }
}
