Feature: Supplement Suggestion

Background: Login into the application
	Given Launch the URL
	When Enter credentials and sign in
	|gopinath+automation@livingmatrix.com|Password@20| 
	
Scenario Outline: Send Supplement recommendation to newly added patient
	Given Navigate to Add patient page
	When Select patient type "<patient type>" 
	And Enter patient details
	And Select Genetic "<genetic>"  Questionnaire "<ques>" and Lab upload "<lab>"
	And Create patient
	And Verify added patient in patient list "<patient type>"
	And Navigate to Genetic upload screen
	And Add genetic file and Upload
	And Navigate to Supplement Suggestion
	And Add Supplement and navigate to catalog
	And Add Supplement and navigate to Customize
	And Customize the supplements and navigate to review
	And Send recommendation to the patient
	Then verify recommendation sent to the patient
	
	Examples:
|patient type|genetic			|ques|lab|
|Real Patient|Practitioner|Yes |Yes|

@test1
Scenario Outline: Send Supplement recommendation to existing patient
	Given Navigat to patientlist "<patient>"
	When Navigate to Genetic upload screen
	And Add genetic file and Upload
	And Verify Report generated
	And Navigate to Supplement Suggestion
	And Add Supplement and navigate to catalog
	And Add Supplement and navigate to Customize
	And Customize the supplements and navigate to review
	And Send recommendation to the patient
	Then verify recommendation sent to the patient
	
	Examples:
	|patient|
	|Prabhu M|