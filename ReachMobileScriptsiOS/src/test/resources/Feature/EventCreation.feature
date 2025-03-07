Feature: Service Event Creation

Scenario Outline: Create Service Event
 Given I launch the app on the emulator
 Then I Enter User "<User>" Credentials Email "<Email>" and Password "<Password>"
 Then the user selects Equipment Type "<EquipmentType>"

 Examples:
      |User         | Email                                            | Password |EquipmentType    |
      |SC-Admin     |poojasree.kaliyaperumal+autoadmin@reach24.net     |welcome123|Chassis,Container|
      |SC-Admin     |poojasree.kaliyaperumal+autoadmin@reach24.net     |welcome123|PowerUnit,Trailer|

      