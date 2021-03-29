package org.example.core.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract Class BasePage implementing Page Object pattern.
 */
public abstract class BasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected WebdriverAction action;

    /**
     * Constructor.
     */
    protected BasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        this.action = new WebdriverAction(driver, wait);
        PageFactory.initElements(driver, this);
    }

    /**
     * Load page Url to web driver.
     *
     * @param url Url of web page.
     */
    public void loadUrlPage(final String url) {
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
