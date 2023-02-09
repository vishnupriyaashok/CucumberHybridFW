
Feature: Accounts Page feature
 
 Background:
 Given User has already logged in ti the application
|username|password|
|testngselenium01@gmail.com|Test@123|
 
  Scenario: Accounts Page title
    Given user is on accounts page
    When user gets the title of the page
    Then page title should be "My Account"
  

  Scenario: Accounts side section count
    Given user is on accounts page
    Then user gets accoubts section
|My Account|
|Edit Account|
|Password|
|Address Book|
|Wish List|
|Order History|
|Downloads|
|Recurring payments|
|Reward Points|
|Returns|
|Transactions|
|Newsletter|
|Logout|
 
 And account section should be 13