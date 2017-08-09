Feature: Edit Product

  Background: Create Product
    Given I am on Products Home Page
    When I create a new Product "AutomatedDemoAT04"

  Scenario: Edit an existing Product
    When I Edit the Product "AutomatedDemoAT04" to "AutomatedDemoAT04Edited"
    Then On Products Home Page "AutomatedDemoAT04Edited" should be displayed