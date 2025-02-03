Feature: Log Tech Arrival
  This feature verifies all combinations of Log Tech Arrival flow functionality

  @RegressionTest @Sanity @Smoke
  Scenario: 01 Verify Log Tech Arrival from SP
    Given Create a Event-- TD -- Feature - LogTechArrival
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog     | SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And LogTechArrival -- In SP


  @RegressionTest @Sanity
  Scenario: 02 Verify Log Tech Arrival from TD
    Given Create a Event-- TD -- Feature - LogTechArrival
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType   | TenandType | Status    | Page      |
      | eventLog     | SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog     | TD         | In Process | EventInfo |
    And LogTechArrival -- In TD
