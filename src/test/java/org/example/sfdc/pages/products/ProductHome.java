package org.example.sfdc.pages.products;

import org.example.sfdc.pages.Experience;
import org.example.sfdc.pages.SFDCEnvironment;
import org.example.sfdc.pages.TopMenuClassic;
import org.example.sfdc.pages.TopMenuLightning;
import org.openqa.selenium.By;

import org.example.sfdc.pages.base.HomeBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Class containing Product Home Page.
 */
public class ProductHome extends HomeBase {

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductForm clickNewButton() {
        action.waitFixedTime();
        wait.until(ExpectedConditions.visibilityOf(newButton));
        newButton.click();
        return new ProductForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductForm clickEditButton(final String name) {
        clickDropDownListLink(name);
        action.clickElement(editButton);
        return new ProductForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductDetail clickDisplayedItem(final String name) {
        isDisplayedItem(name);
        displayedItem.click();
        return new ProductDetail();
    }

    /**
     * Determines if the Product Field Data is displayed on Home Page.
     *
     * @param productName  Product Name for row.
     * @param productField Product Field like Code, Family.
     * @return boolean.
     */
    public boolean isProductFieldDisplayed(final String productName, final String productField) {
        String xpathSelector;

        if (SFDCEnvironment.getExperience().toString().equals("CLASSIC")) {
            xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::td[text()='%s'] | //a[text()='%s']/ancestor::tr/descendant::td//a[text()='%s']"
                    ,productName, productField,productName, productField);
        } else {
            xpathSelector = String.format("//a[text()='%s']/ancestor::tr/descendant::td//*[text()='%s']"
                    ,productName, productField);
        }

        return driver.findElement(By.xpath(xpathSelector)).isDisplayed();
    }
}
