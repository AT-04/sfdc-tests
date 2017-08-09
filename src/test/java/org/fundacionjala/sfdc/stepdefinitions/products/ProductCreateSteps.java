package org.fundacionjala.sfdc.stepdefinitions.products;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.entities.ProductHelper;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

import static org.testng.Assert.assertEquals;

/**
 * Created by abelb on 8/9/2017.
 */
public class ProductCreateSteps {

    private ProductHelper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper ProductHelper.
     */
    public ProductCreateSteps(ProductHelper helper) {
        this.helper = helper;
    }

    /**
     * In this step the Product Home Page is loaded.
     */
    @When("^I am on Products Home Page$")
    public void iAmOnProductsHomePage() {
        helper.setAppLauncher(helper.getHomePage().clickAppLauncher());
        helper.setProductHome(helper.getAppLauncher().clickProductsTextLink());
        System.out.println(helper.getProductHome().getPageTitle());
        //assertTrue(helper.getProductHome().getPageTitle().contains("Products"));
    }

    /**
     * In this step a new Product is created.
     *
     * @param productName String.
     */
    @And("^I create a new Product \"([^\"]*)\"$")
    public void iCreateANewProduct(String productName) {
        helper.setProductForm((ProductForm) helper.getProductHome().clickNewButton());
        helper.setProductDetail((ProductDetail) helper.getProductForm().newItem(productName));
    }

    /**
     * In this Step asserts that the Product Home Page contains the Item.
     *
     * @param productName String.
     */
    @Then("^On Products Home Page \"([^\"]*)\" should be displayed$")
    public void onProductsHomePageShouldBeDisplayed(String productName) {
        assertEquals(productName, helper.getProductDetail().getItemName(productName));
        helper.setProductHome((ProductHome) helper.getProductDetail().deleteItem());
    }
}
