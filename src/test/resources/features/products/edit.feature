Feature: Edit Product

  Background: Create Product
    Given I am on Products Home Page
    When I create a new Product "AutomatedDemoAT04"

  @deleteProduct @login
  Scenario: Edit an existing Product
    When I Edit the Product
      | PRODUCT_NAME        | AutomatedDemoAT04Edited |
      | PRODUCT_CODE        | 123               |
      | PRODUCT_DESCRIPTION | Just Something    |
      | PRODUCT_FAMILY      | None              |
      | ACTIVE              | true              |
    Then On Products Home Page "AutomatedDemoAT04Edited" should be displayed