Feature: Patient Forms

  Background:

      When User login "patient" and "poojasree.k+autotwo@spritle.com" and "Password@123"

    Scenario: Login as a patient to answer the forms.
      Given Answer the Forms
      Then Save Answers
      And Submit the forms
