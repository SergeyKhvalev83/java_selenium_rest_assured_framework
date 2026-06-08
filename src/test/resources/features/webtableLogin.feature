#TC #: Login scenario
#1- Open a chrome browser 2- Go to:
#https://web-table-2.cydeo.com/login
#3- Enter  username:  Test
#4- Enter password: Tester
#5- Verify URL:
#Expected: URL should end with “inventory”


Feature: User should be able to Login with valid credentials

  Background:
    Given user is on the login Page

  Scenario: Login with simple user parameter
    When user enter user name "standard_user"
    And user enter password "secret_sauce"
    And user click to login button
    Then user should see url contains "inventory"


  Scenario: Login scenario with data table
    When user enters below credentials
      | username     | standard_user   |
      | password     | secret_sauce |
    And user click to login button
    Then user should see url contains inventory




  Scenario Template: User should be able to place order and order seen in web table with using DDT
    When user enter user name "<username>"
    And user enter password "<password>"
    And user click to login button
    Then user should see url contains inventory
    Examples: famous female scientists
      | username        | password     |
      | standard_user   | secret_sauce |
      | problem_user    | secret_sauce |
      | visual_user     | secret_sauce |
      | error_user       | secret_sauce |





