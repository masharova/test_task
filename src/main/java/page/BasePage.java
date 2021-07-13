package page;

import com.Setup;
import com.WaitConfiguration;
import com.WaitUtils;
import org.junit.After;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = Setup.setWebDriver();
        WaitConfiguration waitConfiguration = new WaitConfiguration.Builder()
                .setDefaultImplicitTimeUnit(TimeUnit.SECONDS)
                .setDefaultImplicitTimeout(3)
                .setDefaultExplicitTimeout(3)
                .build();
        WaitUtils.setWaitConfiguration(waitConfiguration);
    }

    public WebDriver getWebDriver() {
        return Setup.getWebDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }

        driver.quit();
        driver = null;
    }
}
