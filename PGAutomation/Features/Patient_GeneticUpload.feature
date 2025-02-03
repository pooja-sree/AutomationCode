Feature: Genetic Upload by Patient

Background: Login into the application
	Given Launch the URL
	When Enter credentials and sign in
	|gopinath+bertogli@livingmatrix.com|Password@20|

Scenario: Add a patient with upload genetic file, Questionnaire and lab upload
	Given Navigate to Genetic screen in patient
	And Add genetic file and Upload
	Then Verify Report generated