Feature: Genetic File Upload

Background: Login into the application
	Given Launch the URL
	When Enter credentials and sign in
	|gopinath+automation@livingmatrix.com|Password@20|
	Then Verify logged user


@Genetic
Scenario Outline: Patient will upload the genetic file and generate the report
	Given Navigate to Genetic screen in patient
	When Add genetic file and Upload "<upload>"
	Then Verify Report generated

Examples:
|upload|
|D:\\PG3\\TestData\\AncestryDNA.txt|

@migration
Scenario Outline: Add a patient with upload genetic file, Questionnaire and lab upload
	Given Navigate to Add patient page
	When Select patient type "<patient type>" 	
	And Enter patient details
	And Select Genetic "<genetic>"  Questionnaire "<ques>" and Lab upload "<lab>"
	And Create patient
	And Verify added patient in patient list "<patient type>"
	And Navigate to Genetic upload screen
	And Add genetic file and Upload "<upload>"
	Then Verify Report generated
	And Logout from application 
	
Examples:
|patient type|genetic			|ques|lab|upload|
|Real Patient|Practitioner|Yes |No|D:\\PureGenomics_WorkSpace\\PGAutomation\\src\\test\\resources\\genetic\\63f0d4e3-27c0-4005-b9ac-1ac2c167dc2f.txt|
