Feature: Launch application

  Scenario Outline:Launch Application
    Given I launch the app on the emulator
    Then The app should be open
    Then I Enter User "<User>" Credentials Email "<Email>" and Password "<Password>"
#    Then Close Application


    Examples:
   |User         | Email                                            | Password |
   |SC-Admin     |poojasree.kaliyaperumal+autoadmin@reach24.net     |welcome123|
#    |SC-Technician|poojasree.kaliyaperumal+autotechnician@reach24.net|welcome123|
