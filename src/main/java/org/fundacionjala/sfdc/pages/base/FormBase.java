package org.fundacionjala.sfdc.pages.base;

import org.fundacionjala.sfdc.CommonActions;
import org.fundacionjala.sfdc.pages.products.ProductFormField;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

/**
 * Created by abelb on 8/8/2017.
 */
public abstract class FormBase extends BasePage {

    @FindBy(css = ".modal-footer button[title='Save']")
    protected WebElement saveButton;

    @FindBy(css = ".modal-footer button[title='Save & New']")
    protected WebElement saveAndNewButton;

    @FindBy(css = ".modal-footer button[title='Cancel']")
    protected WebElement cancelButton;

    /**
     * Clicks the Save Button of the Form.
     */
    public void clickSaveButton() {
        CommonActions.clickElement(saveButton);
    }

    /**
     * Clicks the Save and New Button of the Form.
     */
    public void clickSaveAndNewButton() {
        CommonActions.clickElement(saveAndNewButton);
    }

    /**
     * Clicks the Cancel Button of the Form.
     */
    public void clickCancelButton() {
        CommonActions.clickElement(cancelButton);
    }

    /**
     * Creates or Updates the Item with only Required values.
     *
     * @param name String.
     * @return DetailBase.
     */
    public abstract DetailBase newItem(String name);

    /**
     * Creates or Updates the Item with any values.
     *
     * @param formMapData Map.
     * @return DetailBase.
     */
    public abstract DetailBase newItemFromMap(Map<ProductFormField, String> formMapData);
}
