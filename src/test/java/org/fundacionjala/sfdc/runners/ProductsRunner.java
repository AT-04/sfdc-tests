package org.fundacionjala.sfdc.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeTest;

/**
 * Created by abelb on 8/9/2017.
 */
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/products"},
        glue = {"org.fundacionjala.sfdc"})
public class ProductsRunner extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void startBrowser() {

    }
}
