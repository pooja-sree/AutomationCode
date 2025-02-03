Feature: Supplement Recommendation 

Background: Login into the application
	Given Launch the URL
	When Enter credentials and sign in
	|gopinath+prabhu@livingmatrix.com|Password@20|

@test2	
Scenario Outline: Verify supplement recommendation sent by the practitioner
	Given Navigate to report
	When Validate the recommendation in Report
	And Navigate to Supplement recommendation
	Then Verify the supplement list "<Ecommerce>" 
	And Logout from application

Examples:
	 |Ecommerce|
	 |OFF			 |