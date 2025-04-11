Feature: Launch application


  Scenario:01 Login into the application as admin
    Given I launch the app on the emulator
    When Login as "SC-Admin"
    |Email                                        |Password  |
    |poojasree.kaliyaperumal+autoadmin@reach24.net|Welcome123|
    Then Logout

  Scenario:02 Login into the application as Technician
    Given I launch the app on the emulator
    When Login as "SC-Technician"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autotechnician@reach24.net|welcome123|
    Then Logout



