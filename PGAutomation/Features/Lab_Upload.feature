Feature: Upload lab file 

Background: Login into the application
	Given Launch the URL
	When Enter credentials and sign in
	|gopinath+automation@livingmatrix.com|@Gopi12!|

Scenario: Upload lab file 
	Given Navigate to Lab file
	|Lab Upload|
	When Upload lab file
	Then Verify Report
	|Lab Upload|
	