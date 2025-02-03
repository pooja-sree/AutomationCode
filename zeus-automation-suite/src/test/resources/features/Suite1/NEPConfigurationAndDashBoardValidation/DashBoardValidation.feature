Feature: DashBoard Validation
  This feature verifies all the elements on dashboard and event sorting on different tabs.

  Scenario: 01 Verify dashboard elements and validate sorting events
    Given Open SP dashboard
    Then Validate dashboard
    Then Validate Event Sorting -- submitted
    Then Validate Event Sorting -- in_process