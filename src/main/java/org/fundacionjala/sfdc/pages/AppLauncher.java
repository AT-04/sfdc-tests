package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.CommonActions;
import org.fundacionjala.sfdc.pages.base.BasePage;
import org.fundacionjala.sfdc.pages.products.ProductHome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abelb on 8/9/2017.
 */
public class AppLauncher extends BasePage {

    @FindBy(css = ".modal-header")
    private WebElement windowModal;

    @FindBy(xpath = "//span[contains(@class, 'label-ctr')]/child::span[text()='Products']")
    private WebElement productsTextLink;

    @FindBy(css = ".salesforceIdentityAppLauncherDesktopInternal .uiButton")
    private WebElement openAllAppsButton;

    @FindBy(css = ".oneAppLauncherItemList .uiButton")
    private WebElement openAllItemsButton;

    /*
     * For future implementation maybe by internationalization.
    private void getProductsTextLink() {
        String xpathSelector = String.format("//span[contains(@class, 'label-ctr')]/child::span[text()='%s']", "Products");
        productsTextLink = driver.findElement(By.xpath(xpathSelector));
    }*/

    public ProductHome clickProductsTextLink() {
        waitModal();
        CommonActions.clickElement(openAllAppsButton);
        //getProductsTextLink();
        CommonActions.clickElement(productsTextLink);
        return new ProductHome();
    }
    private void waitModal() {
        CommonActions.isElementDisplayed(windowModal);
    }
}
