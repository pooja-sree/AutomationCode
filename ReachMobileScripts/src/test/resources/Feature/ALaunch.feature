Feature: Launch application

  Scenario Outline:Launch Application on android
    Given I launch the "<Platform>" app on the emulator
    Then The app should be open
    Then I Enter User "<User>" Credentials Email "<Email>" and Password "<Password>"
#    Then Close Application

    Examples:
   |Platform  |User         | Email                                            | Password |
   | Android |SC-Admin     |poojasree.kaliyaperumal+autoadmin@reach24.net     |welcome123|
#   | Ios |SC-Admin     |poojasree.kaliyaperumal+autoadmin@reach24.net     |welcome123|
#    |SC-Technician|poojasree.kaliyaperumal+autotechnician@reach24.net|welcome123|
#    |SC-Accountant|poojasree.kaliyaperumal+autoaccountant@reach24.net|welcome123|
#    |SC-Observer  |poojasree.kaliyaperumal+autoobserver@reach24.net  |welcome123|
#    |SC-Supervisor|poojasree.kaliyaperumal+autosupervisor@reach24.net|welcome123|
#    |SC-User      |poojasree.kaliyaperumal+autouser@reach24.net      |welcome123|
#    |SC-Guest     |poojasree.kaliyaperumal+autoguest@reach24.net     |welcome123|