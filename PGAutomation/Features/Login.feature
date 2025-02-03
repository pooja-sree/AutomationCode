Feature: Application login

@login
Scenario Outline: Login into application for single domain
	Given Launch the URL
	When Enter email  "<Email>" password "<Password>" and sign in
	Then Verify logged user
	And Logout from application
	
Examples:
	|Email							 |Password	 |
	|gopinath+karnan@livingmatrix.com|Password@20|
	|gopinath+automation@livingmatrix.com|Password@20|
	
	
Scenario: Login into application for multiple domain
	Given Launch the URL
	When Enter credentials and sign in
	|siva.g+prac2@spritle.com|Password34|
	And Select domain
	|kb|
	Then Verify logged user
	And Logout from application
	