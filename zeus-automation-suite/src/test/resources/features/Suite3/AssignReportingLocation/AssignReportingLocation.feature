Feature: Assign Reporting Location
  This feature verifies all combinations of Assign Reporting Location feature

  @RegressionTest @Sanity @Smoke
  Scenario: 01 Create an Event in AutoTruck SPHQ and Validate the event in Parent SPHQ
    Given Create a Event-- SPHQ -- Feature - AssignReportingLocation
      | EquipmentType | EquipmentProvider | CustomerName |
      | Container     | AutoTruck         | AutoTruck TD |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repair | Front    |
    And Get Event information from -- SPHQ
    And Verify Event Status
      | StatusType | TenandType         | Status    | Page      |
      | Org        | SPHQ>AutoTruck SP2 | Submitted | Dashboard |
      | Org        | SPHQ>AutoTruck SP2 | Submitted | EventInfo |
    And Validate AssignReportingLocation
      | CreatedBy | ServiceCenter |
      | SPHQ      | AutoTruck SP2 |

  @RegressionTest
  Scenario: 02 Create an Event in AutoTruck CCHQ and Validate the event in Parent CCHQ
    Given Create a Event-- CCHQ -- Feature - AssignReportingLocation
      | EquipmentType | EquipmentProvider | CustomerName |
      | Chassis       | AutoTruck         | AutoTruck TD |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- CCHQ
    And Get Event information from -- SP3
    And Verify Event Status
      | StatusType | TenandType    | Status    | Page      |
      | Single     | SP3 | Submitted | EventInfo |
