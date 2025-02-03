Feature: Departed Terminal
  This feature is about The Departed Terminal

  @RegressionTest @Smoke @Sanity
  Scenario: 01 Create a TD Event--Chassis-- DepartedTerminal
    Given Create a Event-- TD -- Feature - DepartedTerminal
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Container    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repairs | Front    |
    Then Get Event information from -- TD
    Then Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventLog    | TD         | Open   | EventInfo |
    And Validate Demo Terminal on Event Show Page -- TD

  @RegressionTest
  Scenario: 02 Create a Event from Fleet --Assign event
    Given Create a Event-- Fleet -- Feature - DepartedTerminal
      | CustomerName   | EquipmentType | EquipmentProvider |
      | AutoTruck Fleet | Container       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | OTR Service | OTR Labor   | Service Call - Mechanical | Per Contract | Complete    |
    Then Get Event information from -- Fleet
    Then Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventLog    | Fleet      | Open   | EventInfo |
    And Validate Demo Terminal on Event Show Page -- Fleet
    And AssignDuplicate Fleet event to -- AutoTruck SP -- Payment Method - cash
    And Verify Event Status
      | StatusType  | TenandType   | Status    | Page      |
      | eventLog    | Fleet        | Submitted | EventInfo |
      | eventStatus | SP | Submitted | Dashboard |

  @RegressionTest
  Scenario: 03 Create a Fleet Event--Chassis-- DepartedTerminal
    Given Create a Event-- Fleet -- Feature - DepartedTerminal
      | CustomerName   | EquipmentType | EquipmentProvider |
      | AutoTruck Fleet | Container    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | OTR Service | OTR Labor   | Service Call - Mechanical | Per Contract | Complete    |
    Then Get Event information from -- Fleet
    Then Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventLog    | Fleet      | Open   | EventInfo |
