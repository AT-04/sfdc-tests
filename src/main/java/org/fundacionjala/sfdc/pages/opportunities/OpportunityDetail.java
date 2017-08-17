package org.fundacionjala.sfdc.pages.opportunities;

import org.fundacionjala.sfdc.core.CommonActions;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 8/8/2017.
 */
public class OpportunityDetail extends DetailBase {


    @FindBy(xpath = "//p[contains(text(), 'Opportunity')]/following-sibling::h1")
    private WebElement opportunityNameText;

    @FindBy(xpath = "//p[contains(text(), 'Account Name')]/following-sibling::p/descendant::a")
    private WebElement accountNameText;

    @FindBy(xpath = "//p[contains(text(), 'Close Date')]/following-sibling::P")
    private WebElement closeDateText;

    @FindBy(xpath = " //p[contains(text(), 'Amount')]/following-sibling::P")
    private WebElement amountText;

    //span[contains(@class,'current')]/following-sibling::span
    @FindBy(xpath = "//span[contains(@class,'current')]/following-sibling::span")
    private WebElement stageText;

    /**
     * {@inheritDoc}
     */
    @Override
    public OpportunityForm clickEditButton() {
        CommonActions.clickElement(editButton);
        return new OpportunityForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OpportunityHome deleteItem() {
        clickDeleteButton();
        clickConfirmDeleteButton();
        return new OpportunityHome();
    }

    /**
     * Gets the Opportunity Name Text.
     *
     * @return String.
     */
    public String getOpportunityNameText() {
        return opportunityNameText.getText();
    }

    /**
     * Gets the Opportunity Account Text.
     *
     * @return String.
     */
    public String getOpportunityAccountText() {

        return accountNameText.getText();
    }

    /**
     * Gets the Opportunity Close date Text.
     *
     * @return String.
     */
    public String getOpportunityCloseDateText() {
        return closeDateText.getText();
    }

    /**
     * Gets the Opportunity Amount Text.
     *
     * @return String.
     */
    public String getOpportunityAmountText() {
        return amountText.getText();
    }

    /**
     * Gets the Opportunity Stage Text.
     *
     * @return String.
     */
    public String getOpportunityStageText() {
        return stageText.getText();
    }
}

