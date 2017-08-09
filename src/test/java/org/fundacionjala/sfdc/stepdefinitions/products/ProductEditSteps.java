package org.fundacionjala.sfdc.stepdefinitions.products;

import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.entities.ProductHelper;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;

/**
 * Created by AbelBarrientos on 8/9/2017.
 */
public class ProductEditSteps {

    private ProductHelper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper ProductHelper.
     */
    public ProductEditSteps(ProductHelper helper) {
        this.helper = helper;
    }

    /**
     * In this Step the Current Product is Edited.
     *
     * @param oldName String.
     * @param newName String.
     */
    @When("^I Edit the Product \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iEditTheProductTo(String oldName, String newName) {
        helper.setProductForm((ProductForm) helper.getProductDetail().clickEditButton());
        helper.setProductDetail((ProductDetail) helper.getProductForm().newItem(newName));
    }
}
