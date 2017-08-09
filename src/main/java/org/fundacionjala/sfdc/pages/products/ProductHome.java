package org.fundacionjala.sfdc.pages.products;

import org.fundacionjala.sfdc.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * Created by abelb on 8/8/2017.
 */
public class ProductHome extends HomeBase {

    @Override
    public FormBase clickNewButton() {
        CommonActions.clickElement(newButton);
        return new ProductForm();
    }

    @Override
    public FormBase clickEditButton(String name) {
        clickDropDownListLink(name);
        CommonActions.clickElement(editButton);
        return new ProductForm();
    }

    //Need review
    @Override
    public DetailBase clickDisplayedItem(String name) {
        getDisplayedItem(name);
        CommonActions.clickElement(displayedItem);
        return new ProductDetail();
    }
}
