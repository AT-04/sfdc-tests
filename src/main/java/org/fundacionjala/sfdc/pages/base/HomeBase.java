package org.fundacionjala.sfdc.pages.base;

import org.fundacionjala.sfdc.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by abelb on 8/8/2017.
 */
public abstract class HomeBase extends BasePage {

    @FindBy(css = "a[title='New']")
    protected WebElement newButton;

    protected WebElement displayedItem;

    //@FindBy(xpath = "//a[contains(text(),'demo')]/ancestor::tr/descendant::a[contains(@class,'slds-button slds-button--icon-x-small')]")
    protected WebElement dropDownListLink;

    @FindBy(css = "a[title='Edit']")
    protected WebElement editButton;

    @FindBy(css = "a[title='Delete']")
    protected WebElement deleteButton;

    @FindBy(css = "button[title='Delete']")
    protected WebElement confirmDeleteButton;

    public void getDropDownListLink(String name) {
        String xpathSelector = String.format("//a[contains(text(),'%s')]/ancestor::tr/descendant::a[contains(@class,'slds-button slds-button--icon-x-small')]", name);
        dropDownListLink = driver.findElement(By.xpath(xpathSelector));
    }

    public void getDisplayedItem(String name) {
        String xpathSelector = String.format("//a[contains(text(),'%s')]", name);
        displayedItem = driver.findElement(By.xpath(xpathSelector));
    }

    public abstract DetailBase clickDisplayedItem(String name);

    public abstract FormBase clickNewButton();

    public abstract FormBase clickEditButton(String name);

    public void clickDropDownListLink(String name) {
        getDropDownListLink(name);
        CommonActions.clickElement(dropDownListLink);
    }

    public void clickDeleteButton() {
        CommonActions.clickElement(deleteButton);
    }

    public void clickConfirmDeleteButton() {
        CommonActions.clickElement(confirmDeleteButton);
    }

    public void deleteElement(String name) {
        clickDropDownListLink(name);
        clickDeleteButton();
        clickConfirmDeleteButton();
    }
}
