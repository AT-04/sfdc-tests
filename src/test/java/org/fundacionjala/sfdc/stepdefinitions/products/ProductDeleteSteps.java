package org.fundacionjala.sfdc.stepdefinitions.products;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.entities.ProductHelper;
import org.fundacionjala.sfdc.pages.products.ProductHome;

import static org.testng.Assert.assertFalse;

/**
 * Created by AbelBarrientos on 8/9/2017.
 */
public class ProductDeleteSteps {

    private ProductHelper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper ProductHelper.
     */
    public ProductDeleteSteps(ProductHelper helper) {
        this.helper = helper;
    }

    /**
     * In this Step a Product is deleted.
     */
    @When("^I Delete the Product$")
    public void iDeleteTheProduct() {
        helper.setProductHome((ProductHome) helper.getProductDetail().deleteItem());
    }

    /**
     * In this Step it assures that no Item is Displayed.
     *
     * @param productName String.
     */
    @Then("^On Products Home Page \"([^\"]*)\" should not be displayed$")
    public void onProductsHomePageShouldNotBeDisplayed(String productName) {
        assertFalse(helper.getProductHome().isDisplayedItem(productName));
    }
}
