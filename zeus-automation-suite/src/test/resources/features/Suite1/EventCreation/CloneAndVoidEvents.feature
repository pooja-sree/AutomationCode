Feature: Clone and Void Events
  This feature verifies all combinations of Cone and Void event functionality

  @RegressionTest @Smoke @Sanity
  Scenario: 01 Create a TD Event--Clone--Void
    Given Create a Event-- TD -- Feature - VoidEvent
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Clone Event -- TD -- Clone
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis       | AutoTruck         |
    When Enter Service details -- Clone
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Void Event -- TD -- Void
      | VoidReason          | VoidStatus |
      | Cannot Locate Asset | Voided     |

  @RegressionTest
  Scenario: 02 Create a TD Event--Clone--Void
    Given Create a Event-- TD -- Feature - VoidEvent
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Power Unit     | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason      |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abandonment |
    And Clone Event -- TD -- Clone
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Power Unit     | AutoTruck         |
    When Enter Service details -- Clone
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason      |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abandonment |
    And Void Event -- TD -- Void
      | VoidReason              | VoidStatus |
      | Duplicate Service Event | Voided     |

  @RegressionTest
  Scenario: 03 Create a TD Event--Clone--Void
    Given  Create a Event-- TD -- Feature - VoidEvent
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Power Unit    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason      |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abandonment |
    And Add Custom Fields -- TD -- Clone
    And Clone Event -- TD -- Clone
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Power Unit    | AutoTruck         |
    When Enter Service details -- Clone
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason      |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abandonment |
    And Void Event -- TD -- Void
      | VoidReason            | VoidStatus |
      | Vendor Not Authorized | Voided     |
