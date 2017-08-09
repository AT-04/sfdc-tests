package org.fundacionjala.sfdc.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Simon on 07/08/2017.
 */
public final class DriverManager {
    private static final String BASE_URL = "https://salesforce.com";
    //private static final String KEY = "webdriver.chrome.driver";
    //private static final String PATH = "drivers/chromedriver.exe";
    private static DriverManager instance;
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor.
     */
    private DriverManager() {
        //System.setProperty(KEY, PATH);
        //driver = new ChromeDriver();
        driver = DriverFactory.getDriverManager(DriverType.CHROME);
        backPreviousWait();
    }

    /**
     * Get Instance of the Driver manager.
     *
     * @return the instance.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Set time implicit wait.
     * @param implicitTimeWait time for wait.
     */
    public void setImplicitTimeWait(int implicitTimeWait) {
        driver.manage().timeouts().implicitlyWait(implicitTimeWait, TimeUnit.SECONDS);
    }

    /**
     * Set time explicit wait.
     * @param explicitTimeWait time for wait.
     */
    public void setExplicitTimeWait(int explicitTimeWait) {
        wait = new WebDriverWait(driver, explicitTimeWait);
    }

    /**
     * Set update waits.
     * @param time time for implicit and explicit.
     */
    public void setUpdateWait(int time) {
        setImplicitTimeWait(time);
        setExplicitTimeWait(time);
    }

    /**
     * Back previous set default times.
     */
    public void backPreviousWait() {
        final int implicitTimeWait = 15;
        final int explicitTimeWait = 30;
        setImplicitTimeWait(implicitTimeWait);
        setExplicitTimeWait(explicitTimeWait);
    }

    /**
     * Get Driver instance.
     *
     * @return driver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Quit the Driver instance.
     */
    public void quitDriver() {
        driver.quit();
    }

    /**
     * Get Base Url the driver.
     *
     * @return String url.
     */
    public String getBaseUrl() {
        return BASE_URL;
    }

    /**
     * Gets wait instance.
     *
     * @return the wait.
     */
    public WebDriverWait getWait() {
        return wait;
    }
}

