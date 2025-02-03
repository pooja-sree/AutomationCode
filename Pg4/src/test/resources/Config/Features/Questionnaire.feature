Feature: Questionnaire for Patient

Background:
   Given I Navigate to Login Page


Scenario: Login as a Patient and complete the Questionnaire
  When User Login as Patient
  Then Patient should answer the Questionnaire
  Then I should be logged in