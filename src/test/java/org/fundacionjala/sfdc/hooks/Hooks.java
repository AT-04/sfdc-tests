package org.fundacionjala.sfdc.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.fundacionjala.sfdc.entities.ProductHelper;
import org.fundacionjala.sfdc.pages.login.Login;

/**
 * Created by abelb on 8/9/2017.
 */
public class Hooks {

    private ProductHelper helper;

    /**
     * Constructor with Dependency Injection.
     * @param helper ProductHelper.
     */
    public Hooks(ProductHelper helper) {
        this.helper = helper;
    }

    /**
     * Opens the browser and Logins to Sales Force.
     */
    @Before
    public void loginToSalesForce() {
        final String username = "demouser2710@gmail.com";
        final String password = "secret2710";
        helper.setHomePage(Login.loginInitial(username, password));
    }

    /**
     * Logout the current session.
     */
    @After
    public void logoutFromSalesForce() {
        helper.getHomePage().clickLinkLogOut();
    }
}
