Feature: Create Product

  Scenario: Create a new Product
    When I am on Products Home Page
    And I create a new Product "AutomatedDemoAT04"
    Then On Products Home Page"AutomatedDemoAT04" should be displayed