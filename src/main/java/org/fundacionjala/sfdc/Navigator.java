package org.fundacionjala.sfdc;

import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.Home;
import org.fundacionjala.sfdc.pages.products.ProductHome;

/**
 * Created by AbelBarrientos on 8/10/2017.
 */
public final class Navigator {

    /**
     * Private Constructor.
     */
    private Navigator() {

    }

    /**
     * Click and returns an AppLauncher Instance.
     * @return AppLauncher.
     */
    public static AppLauncher clickAppLauncher() {
        return new Home().clickAppLauncher();
    }

    /**
     * Go to Products Home Page.
     * @return ProductHome.
     */
    public static ProductHome goToProductsHome() {
        clickAppLauncher().clickProductsTextLink();
        return new ProductHome();
    }
}
