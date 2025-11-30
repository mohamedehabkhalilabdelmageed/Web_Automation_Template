package io.paysky.qc.utilities.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = chromeDriverConfig();
        }
        return driver;
    }

    public static WebDriver getErrorDriver(boolean isError) {
        // Ensure the driver is initialized
        getDriver();
        //screenshotManager.takeScreenShot_Fail();
        return driver;
    }

    static WebDriver chromeDriverConfig(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        // Use WebDriverManager to set up the latest Chrome driver
        WebDriverManager.chromedriver();
    // options.addArguments("--headless");
        //System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        return new ChromeDriver(options);
    }
}