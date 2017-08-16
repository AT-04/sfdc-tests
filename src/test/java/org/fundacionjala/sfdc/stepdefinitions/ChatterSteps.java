package org.fundacionjala.sfdc.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pages.chatter.PostForm;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Create Steps for Chatter.
 */
public class ChatterSteps {
    private Helper helper;

    /**
     * Constructor with Dependency Injection.
     *
     * @param helper Helper.
     */
    public ChatterSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Create a new Post.
     *
     * @param message String.
     */
    @When("^I create a new Post with \"([^\"]*)\"$")
    public void iCreateANewPostWith(String message) {
        helper.setPostMessage(message);
        PostForm postForm = new PostForm();
        postForm.savePost(message);

    }

    /**
     * The post should be displayed.
     *
     * @param message String.
     */
    @Then("^On Chatter Home Page \"([^\"]*)\" should be displayed$")
    public void onChatterHomePageShouldBeDisplayed(String message) {
        PostForm postForm = new PostForm();
        assertTrue(postForm.isPostDisplayed(message));
    }

    //Edit

    /**
     * The post edited should be displayed.
     *
     * @param message String.
     */
    @Then("^On the Chatter page should be display the \"([^\"]*)\"$")
    public void onTheChatterPageShouldBeDisplayThe(String message) {
        PostForm postForm = new PostForm();
        assertTrue(postForm.isPostDisplayed(message));
    }

    /**
     * Edit a the post.
     * @param newMessage String.
     */
    @When("^I Edit the Post with \"([^\"]*)\"$")
    public void iEditThePostWith(String newMessage) {
        new PostForm().editPost(helper.getPostMessage(), newMessage);
        helper.setPostMessage(newMessage);
    }

    //Delete

    /**
     * Delete a the post.
     */
    @When("^I Delete the Post$")
    public void iDeleteThePost() {
        new PostForm().deletePost(helper.getPostMessage());
        DriverManager.getInstance().getDriver().navigate().refresh();
    }

    /**
     * The post edited should be displayed.
     * @param message String.
     */
    @Then("^On the Chatter page should not display the \"([^\"]*)\"$")
    public void onTheChatterPageShouldNotDisplayThe(String message) {
        PostForm postForm = new PostForm();
        assertFalse(postForm.isPostDisplayed(message));
    }

    //Comment

    /**
     * Comment in Post.
     * @param comment
     */
    @When("^I comment in Post \"([^\"]*)\"$")
    public void iCommentInPost(String comment) {
        helper.setCommentPostMessage(comment);
        PostForm postForm = new PostForm();
        postForm.commentPost(helper.getPostMessage(), helper.getCommentPostMessage());
    }

    /**
     * The comment for the Post should be displayed.
     */
    @Then("^On the Chatter page the comment should be displayed$")
    public void onTheChatterPageTheCommentShouldBeDisplayed() {
        PostForm postForm = new PostForm();
        assertTrue(postForm.isPostDisplayed(helper.getCommentPostMessage()));
    }
}

