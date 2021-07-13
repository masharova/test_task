package com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup {
    private static WebDriver driverInstance;

    public static WebDriver setWebDriver() {
        if (driverInstance != null) {
            return driverInstance;
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driverInstance = new ChromeDriver(chromeOptions);

        return driverInstance;
    }

    public static WebDriver getWebDriver() {
        return driverInstance;
    }
}
