package org.example.sfdc.pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.example.sfdc.pages.base.DetailBase;

/**
 * Class containing Product Detail Page.
 */
public class ProductDetail extends DetailBase {

    @FindAll({
            @FindBy(xpath = "//*[text()='Product Name']//following-sibling::td//div[@id='Name_ileinner']"),

            @FindBy(xpath = "//div[contains(@class,'windowViewMode-normal')]//*[text()='Product Name']/..//following-sibling::div//span[@class='uiOutputText']")
    })
    private WebElement productNameText;


    @FindAll({
            @FindBy(xpath = "//*[text()='Product Family']/following-sibling::td//div"),

            @FindBy(xpath = "//div[contains(@class,'windowViewMode-normal')]//div[@data-component-id='force_detailPanel']//*[text()='Product Family']/..//following-sibling::div//span/span")
    })
    private WebElement productFamilyText;


    @FindAll({
            @FindBy(xpath = "//*[text()='Product Code']/following-sibling::td//div"),

            @FindBy(xpath = "//div[contains(@class,'windowViewMode-normal')]//div[@data-component-id='force_detailPanel']//*[text()='Product Code']/..//following-sibling::div//span[@class='uiOutputText']")
    })
    private WebElement productCodeText;

    @FindAll({
            @FindBy(xpath = "//*[text()='Product Description']/following-sibling::td//div"),

            @FindBy(xpath = "//div[contains(@class,'windowViewMode-normal')]//div[@data-component-id='force_detailPanel']//*[text()='Product Description']/..//following-sibling::div//span/span")
    })
    private WebElement productDescriptionText;

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductForm clickEditButton() {
        action.clickElement(editButton);
        return new ProductForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductHome deleteItem() {
        clickDeleteButton();
        clickConfirmDeleteButton();
        return new ProductHome();
    }

    /**
     * Gets the Product Name Text.
     *
     * @return String.
     */
    public String getProductNameText() {
        return productNameText.getText();
    }

    /**
     * Gets the Product Family Text.
     *
     * @return String.
     */
    public String getProductFamilyText() {
        return productFamilyText.getText();
    }

    /**
     * Gets the Product Code Text.
     *
     * @return String.
     */
    public String getProductCodeText() {
        return productCodeText.getText();
    }

    /**
     * Gets the Product Description Text.
     *
     * @return String.
     */
    public String getProductDescriptionText() {
        return productDescriptionText.getText();
    }
}
