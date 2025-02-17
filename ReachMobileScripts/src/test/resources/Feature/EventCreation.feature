Feature: EventCreation

  Background:
  Scenario: Create a event -- Chassis
    Given Create an event from TD
    When Enter Service Details
    And Verify event status
