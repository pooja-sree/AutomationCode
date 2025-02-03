Feature: Questionnaire Functionality

Background: Login into the application
	Given Launch the URL
	When Enter credentials and sign in
	|gopinath+crist5432@livingmatrix.com|Password@20|
	
@Question
Scenario: Complete the Questionnaire
	Given Navigate to Questionnaire 
	When Compete the Questionnaire
  And Review the Questionnaire
	Then Verify data in Report

