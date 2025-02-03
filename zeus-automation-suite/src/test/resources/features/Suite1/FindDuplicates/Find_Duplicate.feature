Feature: Find Duplicate Events
  This feature verifies all combinations of duplicate event functionality

	  @RegressionTest @Smoke @Sanity
  Scenario: 01 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - Duplicate
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Container    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repairs | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    And AssignDuplicate TD event to -- AutoTruck SP -- Payment Method - Cash
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | EventInfo |
#    And Validate WatchList

  @RegressionTest
  Scenario: 02 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - Duplicate
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Container       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repairs | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    And Edit Event -- TD -- Clone
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Container       | AutoTruck         |
