Feature: Login functionality

  In order to do internet banking
  As a valid Para Bank customer
  I want to login successfully

  Scenario Outline: Login successful
    Given I am in the Login page of the Para Bank Application
    When I enter valid <username> and <password>
    Then I should be taken to the Overview page
    Examples:
    |username|password|
    |"autotester"|"password"|
    |"tautester"|"password"|