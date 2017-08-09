package org.fundacionjala.sfdc.stepdefinitions.products;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Created by abelb on 8/9/2017.
 */
public class ProductSteps {

    private Helper helper;

    public ProductSteps(Helper helper){
        this.helper = helper;
    }
    @When("^I am on Products Home Page$")
    public void iAmOnProductsHomePage() {
        helper.setAppLauncher(helper.getHomePage().clickAppLauncher());
        helper.setProductHome(helper.getAppLauncher().clickProductsTextLink());
    }

    @And("^I create a new Product \"([^\"]*)\"$")
    public void iCreateANewProduct(String productName) {
        helper.setProductForm((ProductForm) helper.getProductHome().clickNewButton());
        helper.setProductDetail((ProductDetail) helper.getProductForm().createNewItem(productName));
    }

    @Then("^On Products Home Page\"([^\"]*)\" should be displayed$")
    public void onProductsHomePageShouldBeDisplayed(String productName) {
//        helper.setProductHome(helper.getAppLauncher().clickProductsTextLink());
//        helper.getProductHome().getDisplayedItem(productName);
        helper.getProductDetail().getItemName(productName);
    }
}
