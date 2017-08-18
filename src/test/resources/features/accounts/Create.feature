Feature: Create Account

  @deleteAccount
  Scenario: Create a new Account
    Given I go to "Account" Home Page
    And I click on New "Account"
    When I fill the Account form with:
      | ACCOUNT_NAME             | AutomatedDemoAT04          |
      | ACCOUNT_TYPE             | Analyst                    |
      | ACCOUNT_WEBSITE          | www.somepage.com           |
      | ACCOUNT_DESCRIPTION      | This is a Description test |
      | ACCOUNT_PHONE            | 59179732801                |
      | ACCOUNT_INDUSTRY         | Banking                    |
      | ACCOUNT_EMPLOYEES        | 25                         |
      | ACCOUNT_BILLING_STREET   | Some Street                |
      | ACCOUNT_BILLING_CITY     | Cochabamba                 |
      | ACCOUNT_BILLING_ZIP      | 3001                       |
      | ACCOUNT_BILLING_STATE    | Cercado                    |
      | ACCOUNT_BILLING_COUNTRY  | Bolivia                    |
      | ACCOUNT_SHIPPING_STREET  | This is a Shipping Street  |
      | ACCOUNT_SHIPPING_CITY    | Cochabamba                 |
      | ACCOUNT_SHIPPING_ZIP     | 3001                       |
      | ACCOUNT_SHIPPING_STATE   | Cercado                    |
      | ACCOUNT_SHIPPING_COUNTRY | Bolivia                    |
    Then the Account should be displayed
    And I go to "Account" Home Page
    And the Account should be displayed on Home Page