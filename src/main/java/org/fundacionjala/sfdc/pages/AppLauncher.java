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
//    @FindBy(css = "one-app-launcher-header")
    private WebElement openAllItemsButton;

    /**
     * Clicks the Product Text Link.
     * @return ProductHome.
     */
    public ProductHome clickProductsTextLink() {
        waitModal();
        CommonActions.clickElement(openAllAppsButton);
        CommonActions.clickElement(productsTextLink);
        return new ProductHome();
    }

    /**
     * Waits for the modal is displayed.
     */
    private void waitModal() {
        CommonActions.isElementDisplayed(windowModal);
    }
}
