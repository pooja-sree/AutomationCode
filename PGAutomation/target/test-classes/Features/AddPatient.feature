Feature: Add patient

Background: Login into the application
	Given Launch the URL
	When Enter credentials and sign in
	|gopinath+automation@livingmatrix.com|Password@20|
	Then Verify logged user

@AddPatient
Scenario Outline: Practitioner portal patient status will show as Pending until patient is setting password 
	Given Navigate to Add patient page
	When Select patient type "<patient type>" 
	And Enter patient details
	And Select Genetic "<genetic>"  Questionnaire "<ques>" and Lab upload "<lab>"
	Then Create patient
	And Verify added patient in patient list "<patient type>"
	And Validate the patient status
	And Logout from application
	
Examples:
|patient type|genetic			|ques|lab|
|Real Patient|Practitioner|Yes |No |

@AddPatient
Scenario Outline: Practitioner will able to send reminder to patient for setup password 
	Given Navigate to Add patient page
	When Select patient type "<patient type>" 
	And Enter patient details
	And Select Genetic "<genetic>"  Questionnaire "<ques>" and Lab upload "<lab>"
	And Create patient
	And Verify added patient in patient list "<patient type>"
	Then Send Reminder and validate mail sent
	And Logout from application
	
Examples:
|patient type|genetic			|ques|lab|
|Real Patient|Practitioner|Yes |No |

