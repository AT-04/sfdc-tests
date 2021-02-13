package org.example.sfdc.pages;

import org.example.sfdc.core.ui.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class for the Profile page.
 */
public class Profile extends BasePage {

    @FindBy(css = ".uiOutputEmail")
    private WebElement currentUserEmail;

    /**
     * This method checks if the user is correct logged.
     * @param userName userName of Sales Force.
     * @return True if the user is correct logged.
     */
    public boolean isCorrectUserLogged(final String userName) {
        return userName.equals(currentUserEmail.getText());
    }
}