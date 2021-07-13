package com;

import org.openqa.selenium.WebDriver;

public class WaitUtils {
    private static WaitConfiguration waitConfig;

    public WaitUtils(WaitConfiguration waitConfiguration) {
        waitConfig = waitConfiguration;
    }

    public static void setWaitConfiguration(WaitConfiguration waitConfiguration) {
        waitConfig = waitConfiguration;
    }

    public static void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(
                waitConfig.getDefaultImplicitTimeout(),
                waitConfig.getDefaultImplicitTimeUnit());
    }
}
