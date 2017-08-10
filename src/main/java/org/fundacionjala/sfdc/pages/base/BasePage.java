package org.fundacionjala.sfdc.pages.base;

import org.fundacionjala.sfdc.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Simon on 07/08/2017.
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor.
     */
    public BasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    /**
     * Load page Url to web driver.
     *
     * @param url Url of web page.
     */
    public void loadUrlPage(String url) {
        driver.get(url);
    }

    /**
     * This method get page title.
     *
     * @return title for Page.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * This method get current url.
     *
     * @return url for Page.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
