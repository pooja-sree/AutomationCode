Feature: Add patient

Background: Login into the application
	Given Launch the URL
	When Enter credentials and sign in
	|gopinath+automation@livingmatrix.com|Password@20|
	Then Verify logged user

@AddPatient
Scenario Outline: Add a patient with upload genetic file "<genetic>", Questionnaire "<ques>" and lab upload "<lab>"
	Given Navigate to Add patient page
	When Select patient type "<patient type>" 
	And Enter patient details
	And Select Genetic "<genetic>"  Questionnaire "<ques>" and Lab upload "<lab>"
	Then Create patient
	And Verify added patient in patient list "<patient type>"
	And Logout from application
	
Examples:
|patient type|genetic			|ques|lab|
|Real Patient|Practitioner|Yes |No |
|Real Patient|Practitioner|Yes |No |
|Real Patient|Practitioner|Yes |Yes|
|Real Patient|Practitioner|Yes |Yes|
|Real Patient|Patient			|Yes |No |
|Real Patient|Patient			|Yes |No |
|Real Patient|Patient			|Yes |Yes|
|Real Patient|Patient			|Yes |Yes|

Scenario Outline: Add myself & test patient
	Given Navigate to Add patient page
	When Select patient type "<patient type>"
	And Verify Genetic Questionnaire and Lab upload "<patient type>"
	Then Create patient
	And Verify added patient in patient list "<patient type>"
	And Logout from application
	
Examples:
|patient type	 |
|Myself Patient|
|Test Patient	 |
 