Feature: Genetic Upload

Background: Login into the application
	Given Launch the URL
	When Enter credentials and sign in
	|gopinath+automation@livingmatrix.com|Password@20|
	
@genetic
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
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\11024c34-7c91-4612-9f84-27a3aba8bf57.txt|
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\499a83f9-8e4d-4f82-89d2-9c76fbe771c9.txt|
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\535e6dac-c4cb-4d78-946e-a3dc91fbf61e.txt|
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\66e3fb1d-74bc-40f9-923b-a24708b56322.txt|
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\7bd81a2f-836b-47d8-803a-c4458fa72acc.txt|
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\7e619691-7f54-4761-b6ae-0f70b00183c2.txt|
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\8218e268-cdab-4ad8-9923-cebced33bed0.txt|
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\8495fce0-53a8-4631-bcb4-f7830f9d7185.txt|
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\8e5efea3-07c2-4a48-9310-c1b6d8009df6.txt|
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\92597348-4dbe-403e-91e7-a3870305d4f3.txt|
|Real Patient|Practitioner|Yes |No|D:\\PG3_Workspace\\PG3_Automation\\src\\test\\resources\\genetic_file\\d1e38f20-be4e-4ac9-8b0c-c427370f21da.txt|