package org.fundacionjala.sfdc.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.login.Login;

/**
 * Created by abelb on 8/9/2017.
 */
public class Hooks {

    private Helper helper;

    public Hooks(Helper helper) {
        this.helper = helper;
    }

    @Before
    public void loginToSalesForce() {
        final String username = "demouser2710@gmail.com";
        final String password = "secret2710";
        helper.setHomePage(Login.loginInitial(username, password));
    }

    @After
    public void logoutFromSalesForce() {
        helper.getHomePage().clickLinkLogOut();
    }
}
