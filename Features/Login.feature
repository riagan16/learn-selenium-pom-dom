Feature: Login
  Scenario: Successful login with valid credentials
    Given User launch browser
    When User opens URL "https://admin-demo.nopcommerce.com/login/"
    And User enters email "admin@yourstore.com" and password "admin"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on logout
    Then Page title should be "Your store. Login"
    And Close browser

    Scenario Outline: Login Data Driven
      Given User launch browser
      When User opens URL "https://admin-demo.nopcommerce.com/login/"
      And User enters email "<email>" and password "<password>"
      And Click on login
      Then Page title should be "Dashboard / nopCommerce administration"
      When User click on logout
      Then Page title should be "Your store. Login"
      And Close browser
      Examples:
      |email|password|
      |admin@yourstore.com|admin|
      |admin1@yourstore.com|admin123|

