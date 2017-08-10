package org.fundacionjala.sfdc.entities;

import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.Home;
import org.fundacionjala.sfdc.pages.products.ProductDetail;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Created by abelb on 8/9/2017.
 */
public class ProductHelper {

    private Home homePage;
    private AppLauncher appLauncher;
    private ProductHome productHome;
    private ProductForm productForm;
    private ProductDetail productDetail;

    /**
     * Get the Current instance of Home Page.
     * @return Home.
     */
    public Home getHomePage() {
        return homePage;
    }

    /**
     * Set the Home Page instance.
     * @param homePage Home Page.
     */
    public void setHomePage(Home homePage) {
        this.homePage = homePage;
    }

    /**
     * Get the Current instance of App Launcher.
     * @return AppLauncher.
     */
    public AppLauncher getAppLauncher() {
        return appLauncher;
    }

    /**
     * Set the App Launcher instance.
     * @param appLauncher App Launcher.
     */
    public void setAppLauncher(AppLauncher appLauncher) {
        this.appLauncher = appLauncher;
    }

    /**
     * Get the Current instance of Product Home Page.
     * @return ProductHome.
     */
    public ProductHome getProductHome() {
        return productHome;
    }

    /**
     * Set the Product Home instance.
     * @param productHome Product Home.
     */
    public void setProductHome(ProductHome productHome) {
        this.productHome = productHome;
    }

    /**
     * Get the Current instance of Product Form Page.
     * @return ProductForm.
     */
    public ProductForm getProductForm() {
        return productForm;
    }

    /**
     * Set the Product Form instance.
     * @param productForm Product Form.
     */
    public void setProductForm(ProductForm productForm) {
        this.productForm = productForm;
    }

    /**
     * Get the Current instance of ProductDetail Page.
     * @return ProductDetail.
     */
    public ProductDetail getProductDetail() {
        return productDetail;
    }

    /**
     * Set the Product Detail instance.
     * @param productDetail Product Detail.
     */
    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }
}
