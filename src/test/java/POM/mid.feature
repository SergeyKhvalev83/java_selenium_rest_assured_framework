

Scenario: Login scenario with 2 parameters
When user enter user name "username"
And user enter password "password"
And user click to login button
@table
Scenario: Login scenario with data table
When user enters below credentials
| username     | standard_user   |
| password     | secret_sauce |
Then user should see url contains inventory




Scenario Template: User should be able to place order and order seen in web table with using DDT
When user enter user name "<username>"
And user enter password "<password>"
And user click to login button
Then user should see url contains inventory

@femaleScientiests
Examples: famous female scientists
| username        | password     |
| standard_user   | secret_sauce |
| problem_user    | secret_sauce |
| visual_user     | secret_sauce |
| error_user       | secret_sauce |

