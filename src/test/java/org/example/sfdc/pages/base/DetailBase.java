package org.example.sfdc.pages.base;

import org.example.sfdc.pages.SFDCEnvironment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.example.core.ui.BasePage;

/**
 * Abstract class that gets common info in Details Page.
 */
public abstract class DetailBase extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'oneContent active')]//a[@id='detailTab__item']")
    private WebElement detailsTab;

    @FindBy(xpath = "//div[contains(@class, 'oneContent active')]//button[@name='Edit']")
    protected WebElement editButton;

    @FindAll({
            @FindBy(css = "input[name='delete']"),

            @FindBy(xpath = "//div[contains(@class, 'oneContent active')]//a[@title='Delete']"
                    + "|//div[contains(@class, 'oneContent active')]//button[@name='Delete']")
    })
    protected WebElement deleteButton;

    @FindBy(css = "button[title='Delete']")
    protected WebElement confirmDeleteButton;

    @FindBy(xpath = "//span[contains(@class, 'toastMessage')]")
    protected WebElement successMessage;

    /**
     * Click Detail Button.
     */
    public void clickDetailButton() {
        if (SFDCEnvironment.isLightningExperience()) {
            action.waitFixedTime();
            action.clickElement(detailsTab);
        }
    }

    /**
     * Wait the Product Name is Displayed.
     *
     * @param name String.
     */
    public void waitObjectNameIs(final String name) {
        String cssSelector = String.format("//h2[contains(text(),'%s')] | //h1//span[contains(text(),'%s')]", name, name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cssSelector)));
    }

    /**
     * Opens the Form page for editing.
     *
     * @return FormBase.
     */
    public abstract FormBase clickEditButton();

    /**
     * Click the delete button of the current Item.
     */
    public void clickDeleteButton() {
        action.jsClick(deleteButton);
    }

    /**
     * Click the Confirm Delete Button from the current Item.
     */
    public void clickConfirmDeleteButton() {
        if (SFDCEnvironment.isLightningExperience()) {
            action.clickElement(confirmDeleteButton);
        } else {
            driver.switchTo().alert().accept();
        }
    }

    /**
     * Deletes the current Item.
     *
     * @return HomeBase.
     */
    public abstract HomeBase deleteItem();

    /**
     * Wait for the success message to be visible.
     */
    public void waitUntilSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
    }

    /**
     * Return the success text message.
     *
     * @return the success message content.
     */
    public String successMessageText() {
        return action.getTextElement(successMessage);
    }
}
