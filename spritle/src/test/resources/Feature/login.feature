Feature: Login Functionality 
@Scenario1
Scenario: Successful Login
Given I navigate to login page
When I enter valid Credential
|username                 |password     |
|poojasree.k+o@spritle.com|1234@Password|
Then should be logged in

@Scenario2
Scenario: Unsuccessful Login
Given I navigate to login page
When I enter Invalid Credentials 
|poojasree |       oio|
Then login unsuccessful

@Scenario3
Scenario: Login without Credentials
Given I navigate to login page
When Login without Credentials with username "username" and password "password"
Then Validation message

@Scenario4
Scenario: Forgot Password
Given I navigate to login page
When Click on Forgot Password
Then set up new Password using link sent to given email

#Feature: Login as Practice
#Scenario: Successful Login
#Given I navigate to login page
#When I enter valid Credential with username "<username>" and password "<password>"
#Then should be logged in