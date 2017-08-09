package org.fundacionjala.sfdc.entities;

import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.Home;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Created by abelb on 8/9/2017.
 */
public class Helper {

    private Home homePage;
    private AppLauncher appLauncher;
    private ProductHome productHome;
    private ProductForm productForm;
    private ProductDetail productDetail;

    public Home getHomePage() {
        return homePage;
    }

    public void setHomePage(Home homePage) {
        this.homePage = homePage;
    }

    public AppLauncher getAppLauncher() {
        return appLauncher;
    }

    public void setAppLauncher(AppLauncher appLauncher) {
        this.appLauncher = appLauncher;
    }

    public ProductHome getProductHome() {
        return productHome;
    }

    public void setProductHome(ProductHome productHome) {
        this.productHome = productHome;
    }

    public ProductForm getProductForm() {
        return productForm;
    }

    public void setProductForm(ProductForm productForm) {
        this.productForm = productForm;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }
}
