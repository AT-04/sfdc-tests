package org.fundacionjala.sfdc.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abelb on 8/8/2017.
 */
public final class DriverFactory {

    /**
     * Private Constructor.
     */
    private DriverFactory() {

    }

    /**
     * Return current Driver.
     * @param driverType Enum from DriverType.
     * @return Current WebDriver.
     */
    public static WebDriver getDriverManager(final DriverType driverType) {
        Map<DriverType, WebDriver> map = new HashMap<>();
        map.put(DriverType.CHROME, new ChromeDriver());
        map.put(DriverType.FIREFOX, new FirefoxDriver());
        return map.get(driverType);
    }
}
