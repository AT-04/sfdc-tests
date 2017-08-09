package org.fundacionjala.sfdc;

import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.Home;
import org.fundacionjala.sfdc.pages.login.Login;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by abelb on 8/9/2017.
 */
public class ProductTest {
    /**
     *
     */
    @Test
    public void test01CreateProduct() {
        final String username = "demouser2710@gmail.com";
        final String password = "secret2710";
        Home homePage = Login.loginInitial(username, password);
        AppLauncher appLauncher = homePage.clickAppLauncher();
        ProductHome productHome = appLauncher.clickProductsTextLink();
        ProductForm productForm = (ProductForm) productHome.clickNewButton();
        productForm.setProductNameInputText("nuevo");
        productForm.clickSaveButton();
    }

    /**
     *
     */
    @Test
    public void test02EditProduct() {
        final String username = "demouser2710@gmail.com";
        final String password = "secret2710";
        Home homePage = Login.loginInitial(username, password);
        AppLauncher appLauncher = homePage.clickAppLauncher();
        ProductHome productHome = appLauncher.clickProductsTextLink();
        ProductForm productForm = (ProductForm) productHome.clickEditButton("nuevo");
        productForm.setProductNameInputText("nuevoEditado");
        productForm.clickSaveButton();
    }

    /**
     *
     */
    @Test
    public void test03DeleteProduct() {
        final String username = "demouser2710@gmail.com";
        final String password = "secret2710";
        Home homePage = Login.loginInitial(username, password);
        AppLauncher appLauncher = homePage.clickAppLauncher();
        ProductHome productHome = appLauncher.clickProductsTextLink();
        productHome.deleteElement("nuevo");
    }

    /**
     *
     */
    @Test
    public void test04GetDetailPage() {
        final String username = "demouser2710@gmail.com";
        final String password = "secret2710";
        Home homePage = Login.loginInitial(username, password);
        AppLauncher appLauncher = homePage.clickAppLauncher();
        ProductHome productHome = appLauncher.clickProductsTextLink();
//        productHome.getDisplayedItem("AutomatedDemoAT04");
        productHome.clickDisplayedItem("AutomatedDemoAT04");
//        ProductDetail productDetail = (ProductDetail) productHome.clickDisplayedItem("AutomatedDemoAT04");
//        productDetail.getItemName("AutomatedDemoAT04");
    }
}
