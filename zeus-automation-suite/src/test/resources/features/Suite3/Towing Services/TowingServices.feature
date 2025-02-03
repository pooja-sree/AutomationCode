Feature: Towing Services
This feature verifies Towing Services functionality.

  @RegressionTest
  Scenario: 01 Event From TD-- AncillaryLocation--Towing Services - VMRS  - with Service Line Attachment
  Given Create a Event-- TD -- Feature - AncillaryLocation
     | EquipmentType | EquipmentProvider |
     | Power Unit       | AutoTruck         |
  When Enter Service details -- with Attachments
     | EquipmentType | System            | Assembly          | Component         | Position| WorkAccomplished | Reason                 | TowingDestination| Mileage|
     | Power Unit    | Accessories group | Accessories group | Accessories group | Front   | Towing           | Abuse Caused by Driver | AC Hotel by Marriott Palo Alto    |30|
  Then Get Event information from -- TD
  And Verify Event Status
     | StatusType | TenandType | Status | Page      |
     | Single     | TD         | Open   | EventInfo |
  Then Validate Towing Services Details- VMRS - 744 San Antonio Rd, Palo Alto, CA 94303, USA - 35
  And Verify Event Status
     | StatusType | TenandType | Status | Page      |
     | Single     | TD         | Open   | EventInfo |
  Then Validate OtherAttachment Info -- TD

  @RegressionTest
  Scenario: 02 Event From TD -- Towing Services - AAR  - with Service Line Attachment
    Given Create a Event-- TD -- Feature - TowingServices
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details -- with Pre Attachments
      | EquipmentType | System | SubSystem | Service                  | Defect   | Location | TowingDestination | Mileage |
      | Chassis       | Service | Other    | Towing Service           | Associated With Repairs | C- Complete   | AC Hotel by Marriott Palo Alto | 30 |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    Then Validate Towing Services Details- AAR - 744 San Antonio Rd, Palo Alto, CA 94303, USA - 35
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    Then Validate Pre-repairAttachment Info -- TD

  @RegressionTest @Sanity @Smoke
  Scenario: 03 Event From SP -- Towing Services - VMRS - Double Service line
    Given Create a Event-- SP -- Feature - SPEventCreation
      | EquipmentType | EquipmentProvider | CustomerName |
      | Trailer       | AutoTruck         | AutoTruck TD  |
    When Enter Service details -- Create
      | EquipmentType | System            | Assembly          | Component         | Position| WorkAccomplished | Reason                 | TowingDestination| Mileage|
      | Trailer   | Accessories group | Accessories group | Accessories group | Front   | Towing           | Abuse Caused by Driver | AC Hotel by Marriott Palo Alto    |30|
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | SP         | Submitted   | EventInfo |
    Then Validate Towing Services Details- AAR - 744 San Antonio Rd, Palo Alto, CA 94303, USA - 35
    Then Re-Evaluate Towing Service - Airport Blvd, San Jose - 40
    When Enter Service details -- SecondServiceLine
      | EquipmentType | System            | Assembly          | Component         | Position| WorkAccomplished | Reason                 | ValidateSecondServiceLine |
      | Trailer   | Accessories group | Accessories group | Accessories group | Front   | Towing           | Abuse Caused by Driver |             Yes            |
