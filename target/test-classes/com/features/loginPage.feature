Feature: Login page feature

 Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Account Login"

Scenario: Forgot Password Link
Given user is on the login page
Then forgot password link should be displayed

Scenario: Login with correct credentials
Given user is on the login page
When user enters username "testngselenium01@gmail.com"
And user enters password "Test@123"
And user clicks on login button
Then used gets the title of the page
And the page title should be "My Account"
