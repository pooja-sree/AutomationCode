Feature: Service Event Creation

  Scenario Outline: Create Service Event
    Given I launch the app on the emulator
    Then I Enter User "<User>" Credentials Email "<Email>" and Password "<Password>" to create an event with this Equipment type "<EquipmentType>"
#    Then Close the Application

    Examples:
      |User         | Email                                            | Password |EquipmentType    |
     |SC-Admin      |poojasree.kaliyaperumal+autoadmin@reach24.net     |welcome123|PowerUnit|
     |SC-Technician |poojasree.kaliyaperumal+autotechnician@reach24.net     |welcome123|PowerUnit|

