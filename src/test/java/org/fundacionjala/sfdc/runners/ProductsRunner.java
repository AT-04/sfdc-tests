package org.fundacionjala.sfdc.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.fundacionjala.sfdc.driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by abelb on 8/9/2017.
 */
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/products"},
        glue = {"org.fundacionjala.sfdc"})
public class ProductsRunner extends AbstractTestNGCucumberTests {

    /**
     * Should Initiate the browser here.
     */
    @BeforeTest
    public void startBrowser() {

    }

    /**
     * Close the browser.
     */
    @AfterTest
    public void closeBrowser() {
        DriverManager.getInstance().quitDriver();
    }
}
