Feature: EP Selection from Fleet
  This feature validates the selection of Equipment Provider from Fleet

  @RegressionTest @Smoke @Sanity
  Scenario: 01 Create a TD Event--Chassis-- EP Selection from Fleet
    Given Create a Event-- Fleet -- Feature - EPselectionfromFleet
      | CustomerName | EquipmentType | EquipmentProvider |
      | Fleet        | Trailer       | AutoTruck Fleet   |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly              | Component              | Position     | WorkAccomplished | Reason      |
      | Trailer       | Brakes | Brake Master Cylinder | Boot - Master Cylinder | Front Center | Adjust           | Abandonment |
    And Validate EquipmentProvider -- AutoTruck Fleet

  @RegressionTest
  Scenario: 02 Create a TD Event--Chassis-- EP Selection from TD
    Given Create a Event-- TD -- Feature - EPselectionfromFleet
      | CustomerName | EquipmentType | EquipmentProvider |
      | Fleet        | Container       | AutoTruck TD      |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repairs | Front    |
    And Validate EquipmentProvider -- AutoTruck TD

  @RegressionTest
  Scenario: 03 Create a TD Event--Chassis-- EP Selection from TD
    Given Create a Event-- TD -- Feature - EPselectionfromFleet
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Power Unit    | AutoTruck   |
    When Enter Service details -- Create
      | EquipmentType | System  | Assembly        | Component             | Position     | WorkAccomplished  | Reason      |
      | Power Unit    | Brakes  | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust            | Abandonment |
    And Validate EquipmentProvider -- AutoTruck TD

    @RegressionTest
  Scenario: 04 Create a TD Event--Chassis-- EP Selection from TD
    Given Create a Event-- TD -- Feature - EPselectionfromFleet
      | CustomerName    | EquipmentType | EquipmentProvider |
      | AutoTruck Fleet | Power Unit    | AutoTruck TD   |
    When Enter Service details -- Create
      | EquipmentType | System  | Assembly        | Component             | Position     | WorkAccomplished  | Reason      |
      | Power Unit    | Brakes  | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust            | Abandonment |
    And Validate EquipmentProvider -- AutoTruck TD
