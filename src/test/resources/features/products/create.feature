Feature: Create Product

#  @deleteProduct @login
#  Scenario: Create a new Product
#    Given I am on Products Home Page
#    When I create a new Product "AutomatedDemoAT04"
#    Then On Products Home Page "AutomatedDemoAT04" should be displayed

  @deleteProduct @login
  Scenario: Create a second Product
    Given I am on Products Home Page
    When I create a new Product with
      | PRODUCT_NAME        | AutomatedDemoAT04 |
      | PRODUCT_CODE        | 123               |
      | PRODUCT_DESCRIPTION | Just Something    |
      | PRODUCT_FAMILY      | None              |
      | ACTIVE              | true              |
    Then On Products Home Page "AutomatedDemoAT04" should be displayed