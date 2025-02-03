Feature: Parts and Labor
  This feature verifies all combinations of Parts and Labor functionality.

  @RegressionTest @Sanity @Smoke
  Scenario: 01 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And AssignPLT TD event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | SP         | Submitted   | EventInfo |
    And EventAction -- Accept -- by -- SP
    And PLT Event -- AutoTruck SP -- Add
      | GroupCode | GroupDescription |
      | Test      | Test Desc2       |
    And EventAction -- Repair -- by -- SP
    And EventAction -- Complete -- by -- SP
    And Get Event information from -- TD
    And EventAction -- Approve -- by -- TD

  @RegressionTest
  Scenario: 02 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And AssignPLT TD event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | SP         | Submitted   | EventInfo |
    And EventAction -- Accept -- by -- SP
    And PLT Event -- AutoTruck SP -- Add
      | GroupCode | GroupDescription |
      | Test      | Test Desc2       |
    And EventAction -- Repair -- by -- SP
    And EventAction -- Complete -- by -- SP
    And Get Event information from -- TD
    And EventAction -- Reprocess -- by -- TD
    And Get Event information from -- SP
    And PLT Event -- AutoTruck SP -- AddLabor
      | LaborCode | GroupDescription |
      | InShop    | Test Desc3      |
    And EventAction -- Repair -- by -- SP
    And EventAction -- Complete -- by -- SP
    And Get Event information from -- TD
    And EventAction -- Approve -- by -- TD