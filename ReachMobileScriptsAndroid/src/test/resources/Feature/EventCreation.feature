Feature: EventCreation

  Background:
    Given I launch the "Android" app on the emulator
    Then The app should be open
    Then I Enter User "SC-Admin" Credentials Email "poojasree.kaliyaperumal+autoadmin@reach24.net" and Password "welcome123"

  Scenario: Create a event -- Chassis
    Given Create an event from TD
    When Enter Service Details
    And Verify event status
