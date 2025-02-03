Feature: Crosswalk and Walk-In Scenarios
  This feature verifies all combinations of Crosswalk and Walk-In functionalities

#  @RegressionTest @Smoke @Sanity
#  Scenario: 01 Create a SP Event--CrossWalk-Active/Inactive Filter
#    Given Create a Event-- SP -- Feature - CrossWalk
#      | CustomerName | EquipmentType | EquipmentProvider| Crosswalk    |
#      | AutoTruck TD  | Container    | AutoTruck        | Reach and My fleet listing:TestCrossWalk?TestCrosswalk1(Inactive)>TestCrosswalk2(Inactive)>TestCrosswalk3>TestCrosswalk4=TestCrosswalk3|
#    When Enter Service details -- Crosswalk
#      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
#      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repair | Front    |
#    And Validate Crosswalk -- SP
#      | Crosswalk     |
#      | TestCrosswalk3 |
#
#  @RegressionTest
#  Scenario: 02 Create a SP Event--CrossWalk-Active/Inactive Filter
#    Given Create a Event-- SP -- Feature - CrossWalk
#      | CustomerName | EquipmentType | EquipmentProvider | Crosswalk    |
#      | AutoTruck TD  | Chassis       | AutoTruck        | My fleet listings:TestCrossWalk?TestCrosswalk3>TestCrosswalk4>TestCrosswalk1(Inactive)>TestCrosswalk2(Inactive)=TestCrosswalk4|
#    When Enter Service details -- Crosswalk
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Validate Crosswalk -- SP
#      | Crosswalk    |
#      | TestCrosswalk4 |

  @RegressionTest @Smoke @Sanity
  Scenario: 03 Create a SP Event--Walkin
    Given Create a Event-- SP -- Feature - Walkin
      | CustomerName | EquipmentType | EquipmentProvider | Crosswalk  |
      | AutoTruck TD | Chassis       | AutoTruck         | TestWalkIn |
    When Enter Service details -- Crosswalk
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType         | Status    | Page      |
      | Single     | SP | Submitted | Dashboard |
      | Single     | SP | Submitted | EventInfo |

#  @RegressionTest
#  Scenario: 04 Create a SP Event--Walkin
#    Given Create a Event-- SP -- Feature - Walkin
#      | CustomerName | EquipmentType | EquipmentProvider | Crosswalk   |
#      | AutoTruck TD  | Chassis       | AutoTruck         | TestWalkIn2 |
#    When Enter Service details -- Crosswalk
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- SP
#    And Verify Event Status
#      | StatusType | TenandType         | Status    | Page      |
#      | Single     | SP | Submitted | EventInfo |
#
#  @RegressionTest
#  Scenario: 05 Create a SP Event--NormalCrosswalk
#    Given Create a Event-- SP -- Feature - CrossWalk
#      | CustomerName | EquipmentType | EquipmentProvider | Crosswalk     |
#      | AutoTruck TD  | Chassis       | AutoTruck        | SPCrosswalk1 |
#    When Enter Service details -- Crosswalk
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Validate Crosswalk -- SP
#      | Crosswalk     |
#      | SPCrosswalk1 |

  @RegressionTest
  Scenario: 06 Create a SP Event--BridgeStoneBillToCrosswalk
    Given Create a Event-- Bridgestone -- Feature - BridgestoneShipToCrossWalk
      | CustomerName    | EquipmentType | EquipmentProvider           | Crosswalk     |
      | AutoTruck Fleet | Chassis       |  BridgeStoneBillToCrosswalk | AutoTruck Fleet |
    When Enter Service details -- Crosswalk
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Validate Crosswalk -- Bridgestone
      | Crosswalk     |
      | AutoTruck Fleet  |
