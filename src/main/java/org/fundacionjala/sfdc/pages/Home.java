package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.CommonActions;
import org.fundacionjala.sfdc.driver.DriverManager;
import org.fundacionjala.sfdc.pages.base.BasePage;
import org.fundacionjala.sfdc.pages.login.Login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Simon on 07/08/2017.
 */
public class Home extends BasePage {

    private static final String URL = "na59.salesforce.com";

    //All WebElements are identified by @FindBy annotation.
    @FindBy(css = ".oneUserProfileCardTrigger")
    private WebElement viewProfileIcon;

    @FindBy(css = ".oneUserProfileCard .logout")
//    @FindBy(css = ".profile-link-label.logout.uiOutputURL")
//    @FindBy
    private WebElement logOutButton;

    @FindBy(css = "h1.profile-card-name > a.profile-link-label")
    private WebElement nameProfileLabel;

    @FindBy(css = "div.profile-card-toplinks > a.profile-link-label")
    private WebElement settingButton;

    @FindBy(id = "error")
    private WebElement errorMessageId;

    @FindBy(css = ".profile-link-label.profile-photo")
    private WebElement profileLinkLabel;

    @FindBy(css = "a[href='#/home']")
    private WebElement homeLink;

    @FindBy(className = "slds-icon-waffle")
    private WebElement appLauncherButton;


    /**
     * Wait for page load and get the title from Home Page.
     *
     * @return Url current.
     */
    public String getTitleHomePage() {
        wait.until(ExpectedConditions.titleContains("| Salesforce"));
        return driver.getCurrentUrl();
    }

    /**
     * Method that make a click on the profile icon.
     */
    public void clickProfileIcon() {
        CommonActions.clickElement(viewProfileIcon);
    }

    /**
     * Method that get the username of the main page.
     *
     * @return name profile label of the user.
     */
    public String getUserNameOfHomePage() {
        clickProfileIcon();
        return CommonActions.getTextElement(nameProfileLabel);
    }

    /**
     * This method verify that error message is Displayed.
     * @return True if the element is Displayed.
     */
    public boolean isErrorMessageDisplayed() {
        return CommonActions.isElementDisplayed(errorMessageId);
    }

    /**
     * Method that makes click on logout link.
     * @return Login pageObject.
     */
    public Login clickLinkLogOut() {
//        clickProfileIcon();
//        CommonActions.clickElement(logOutButton);
        DriverManager.getInstance().getWait().until(ExpectedConditions.urlContains("Product2"));
        DriverManager.getInstance().getDriver().get("https://na59.salesforce.com/secur/logout.jsp");
        return new Login();
    }

    /**
     * This method make  click on Profile link label.
     * @return Profile pageObject.
     */
    public Profile clickProfileLinkLabel() {
        clickProfileIcon();
        CommonActions.clickElement(profileLinkLabel);
        return new Profile();
    }

    /**
     * This method make click on Home link label.
     * @return Home pageObject.
     */
    public Home clickHomeLink() {
        CommonActions.clickElement(homeLink);
        return new Home();
    }

    /**
     * Clicks the App Launcher Button.
     */
    public void clickAppLauncherButton() {
        CommonActions.clickElement(appLauncherButton);
    }

    /**
     * Loads the App Launcher by clicking on its button.
     * @return AppLauncher.
     */
    public AppLauncher clickAppLauncher() {
        clickAppLauncherButton();
        return new AppLauncher();
    }
}
