Feature: Edit and Delete Product

  Background:
    Given I go to "Product" Home Page
    And I click on New "Product"
    And I fill the Product form with:
      | PRODUCT_NAME | AutomatedDemoAT04 |
    And I go to "Product" Home Page

  @deleteProduct @SoftAssert
  Scenario: Edit the Product on Detail Page
    When I click on the "Product" item
    And I click on Edit from Product
    And I fill the Product form with:
      | PRODUCT_NAME        | AutomatedDemoAT04Edited |
      | PRODUCT_CODE        | 123Edited               |
      | PRODUCT_DESCRIPTION | Just Something Edited   |
      | PRODUCT_FAMILY      | None                    |
    Then "Product "AutomatedDemoAT04Edited" was saved." message should be displayed in "Product" Detail Page
    And the Product should be displayed
    And I go to "Product" Home Page
    And the Product should be displayed on Home Page
    And Assert all

  @deleteProduct @SoftAssert
  Scenario: Edit the Product Home Page
    When I go to "Product" Home Page
    And I click on Edit "Product"
    And I fill the Product form with:
      | PRODUCT_NAME        | AutomatedDemoAT04Edited |
      | PRODUCT_CODE        | 123Edited               |
      | PRODUCT_DESCRIPTION | Just Something Edited   |
      | PRODUCT_FAMILY      | None                    |
    Then "Product "AutomatedDemoAT04Edited" was saved." message should be displayed in "Product" Home Page
    And I go to "Product" Home Page
    And the Product should be displayed on Home Page
    And Assert all

  Scenario: Delete the Product on Home Page
    And I delete the "Product"
    Then "Product "AutomatedDemoAT04" was deleted." message should be displayed in "Product" Home Page
    And the Product should not be displayed on Home Page

  Scenario: Delete the Product on Detail Page
    And I click on the "Product" item
    And I click on Delete from Product
    Then "Product "AutomatedDemoAT04" was deleted." message should be displayed in "Product" Home Page
    And the Product should not be displayed on Home Page
