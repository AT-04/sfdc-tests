package org.fundacionjala.sfdc.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.fundacionjala.sfdc.Env;
import org.fundacionjala.sfdc.entities.ProductHelper;
import org.fundacionjala.sfdc.pages.login.Login;

/**
 * Created by abelb on 8/9/2017.
 */
public class Hooks {

    private ProductHelper helper;
    private static final Env ENV = Env.getInstance();

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
    @Before("@login")
    public void loginToSalesForce() {
        helper.setHomePage(Login.loginInitial(ENV.getUsername(), ENV.getPassword()));
    }

    /**
     * Delete Item.
     */
    @After(value = "@deleteProduct", order = 20)
    public void deleteCreatedItem() {
        //For delete inside Details
//        helper.setProductHome((ProductHome) helper.getProductDetail().deleteItem());
        helper.getProductHome().deleteElement("Automated");
    }

    /**
     * Logout the current session.
     */
    @After(order = 10)
    public void logoutFromSalesForce() {
        helper.getHomePage().clickLinkLogOut();
    }
}
