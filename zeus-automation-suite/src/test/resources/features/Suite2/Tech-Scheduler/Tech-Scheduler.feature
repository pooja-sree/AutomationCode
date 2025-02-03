Feature: Tech-Scheduler
  This feature verifies all combinations of Tech-Scheduler functionality

  @RegressionTest @Smoke
  Scenario: 01 Add Technician in TS page
    Given Open SP5 dashboard
    And Add Tech -- TestNEPSP1 Tech2 -- in TS -- TestNEPSP1
    And Add Shift -- TestNEPSP1 Tech2 -- in TS -- TestNEPSP1
    And Add Notes and Verify Notes
#    And Copy Shift in TS
    And Edit Tech -- TestNEPSP1 Tech2 -- in TS -- TestNEPSP1
    And Edit and Verify Shift -- TestNEPSP1 Tech2 -- in TS -- TestNEPSP1
    And Delete Shift -- TestNEPSP1 Tech2 -- in TS -- TestNEPSP1
#    And Upload Shift -- TestNEPSP1 Tech2 -- in TS -- TestNEPSP1
    And Validate Technician Log
    And Delete Tech -- TestNEPSP1 Tech2 -- in TS -- TestNEPSP1