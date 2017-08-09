package org.fundacionjala.sfdc.pages.base;

import org.fundacionjala.sfdc.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by abelb on 8/9/2017.
 */
public abstract class DetailBase extends BasePage{
    protected WebElement createdItem;

    public void getCreatedItem(String name) {
        String cssSelector = String.format("h1[title='%s']", name);
        createdItem = driver.findElement(By.cssSelector(cssSelector));
    }

    public String getItemName(String name) {
        getCreatedItem(name);
        return CommonActions.getTextElement(createdItem);
    }
}
