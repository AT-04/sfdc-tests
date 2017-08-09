Feature: Delete a Product

  Background: Create Product
    Given I am on Products Home Page
    When I create a new Product "AutomatedDemoAT04"

  Scenario: Delete the Product
    When I Delete the Product
    Then On Products Home Page "AutomatedDemoAT04" should not be displayed