package org.example.sfdc.pages.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.example.sfdc.core.CommonActions;
import org.example.sfdc.core.Env;
import org.example.sfdc.core.ui.DriverManager;
import org.example.sfdc.pages.Home;
import org.example.sfdc.pages.Profile;
import org.example.sfdc.core.ui.BasePage;

/**
 * Class for the login page.
 */
public class Login extends BasePage {

    private static final String URL = Env.getInstance().getLoginUrl();

    private static final int TIME_WAIT_DURATION = 5;

    private static final Logger LOGGER = LogManager.getLogger();

    //All WebElements are identified by @FindBy annotation.
    @FindBy(id = "username")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "Login")
    private WebElement loginBtn;

    /**
     * Constructor for Default.
     */
    public Login() {
        loadUrlPage(URL);
    }

    /**
     * Set user name in input field.
     *
     * @param username User Name for Sales Force.
     * @return Login pageObject.
     */
    public Login setUserName(final String username) {
        CommonActions.setInputField(userNameInputField, username);
        return this;
    }

    /**
     * Set password in password input field.
     *
     * @param password Password for Sales Force.
     * @return Login pageObject.
     */
    public Login setPassword(final String password) {
        CommonActions.setInputField(passwordInputField, password);
        return this;
    }

    /**
     * This method make click on login button.
     *
     * @return Home pageObject.
     */
    public Home clickLogin() {
        CommonActions.clickElement(loginBtn);
        return new Home();
    }

    /**
     * This Method make a login to Salesforce application.
     *
     * @param username User Name for Sales Force.
     * @param password Password for Sales Force.
     * @return Home page after login to Salesforce application.
     */
    public Home loginAs(final String username, final String password) {
        return setUserName(username).setPassword(password).clickLogin();
    }

    /**
     * This Method make a login with other user to Salesforce application.
     *
     * @param userName User Name for Sales Force with other user.
     * @param password Password for Sales Force with other user.
     * @return Home page after login to Salesforce application.
     */
    public Home loginOtherUser(final String userName, final String password) {
        Home homePage;
        try {
            DriverManager.getInstance().setUpdateWait(TIME_WAIT_DURATION);
            homePage = verifyCorrectUser(userName, password);
            homePage.clickHomeLink();
        } catch (WebDriverException e) {
            LOGGER.error("WebDriverException");
            LOGGER.info(e);
            DriverManager.getInstance().getDriver().get(URL);
            homePage = loginAs(userName, password);
        } finally {
            DriverManager.getInstance().backPreviousWait();
        }
        return homePage;
    }

    /**
     * This method logs in if we are not in the correct session.
     *
     * @param userName User Name for Sales Force with other user.
     * @param password Password for Sales Force with other user.
     * @return Home page after login with correct session.
     */
    private Home verifyCorrectUser(final String userName, final String password) {
        final Home homePage = new Home();
        Profile profile = homePage.clickProfileLinkLabel();
        if (!profile.isCorrectUserLogged(userName)) {
            homePage.clickLogOutLink();
            loginAs(userName, password);
        }
        return homePage;
    }

    /**
     * This method verify is the user is logged.
     *
     * @return True if the user is logged.
     */
    public boolean isUserLogged() {
        return getCurrentUrl().contains(".lightning.force.com");

    }

    /**
     * This method make a login Initial.
     *
     * @param userName User Name for Sales Force with other user.
     * @param password Password for Sales Force with other user.
     * @return Home page after login to Salesforce application.
     */
    public static Home loginInitial(final String userName, final String password) {
        Login login = new Login();
        return login.isUserLogged() ? login.loginOtherUser(userName, password) : login.loginAs(userName, password);
    }
}