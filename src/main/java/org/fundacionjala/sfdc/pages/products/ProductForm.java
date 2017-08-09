package org.fundacionjala.sfdc.pages.products;

import org.fundacionjala.sfdc.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.base.HomeBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abelb on 8/8/2017.
 */
public class ProductForm extends FormBase {

    @FindBy(xpath = "//span[contains(text(), 'Product Name')]/parent::label/following-sibling::input")
    private WebElement productNameInputText;

    @FindBy(xpath = "//span[contains(text(), 'Product Code')]/parent::label/following-sibling::input")
    private WebElement productCodeInputText;

    @FindBy(xpath = "//span[contains(text(), 'Active')]/parent::label/following-sibling::input")
    private WebElement activeCheckBox;

    @FindBy(xpath = "//span[contains(text(), 'Product Description')]/parent::label/following-sibling::textarea")
    private WebElement productDescriptionTextArea;


    @Override
    public DetailBase createNewItem(String name) {
        setProductNameInputText(name);
        clickSaveButton();
        return new ProductDetail();
    }

    public void setProductNameInputText(String productName){
        CommonActions.setInputField(productNameInputText, productName);
    }
}
