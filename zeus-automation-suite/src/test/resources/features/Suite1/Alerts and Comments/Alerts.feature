Feature: Alerts and Comments
  This feature verifies all combinations of Alerts and Comments functionality

  @RegressionTest
  Scenario: 01 Create a Fleet Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - FleetEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD  | Chassis       | AutoTruck         |
    When Enter Service details -- Alerts
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Assign TD event to -- AutoTruck SP -- Payment Method - Cash
    And Raise RFA from conversation Tab -- Fleet -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog    | SP    | Submitted | EventInfo |
    And Resolve RFA from conversation Tab -- SP -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog    | SP    | Submitted | EventInfo |
    And Raise RFA from conversation Tab -- SP -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventStatus    | TD    | Submitted | Dashboard |
    And Resolve RFA in Dashboard -- TD


  @RegressionTest @Smoke @Sanity
  Scenario: 02 Create a SP Event--Validate Confidential Comments tab
    Given Create a Event-- SP -- Feature - SPEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Container     | AutoTruck         |
    When Enter Service details -- Alerts
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repair | Front    |
    And Get Event information from -- SP
    And Assign Tech -- SP -- TECHSP
    And Raise -- RFA -- ConfidentialTab
      | EquipmentType | TenantName   | Message                | UserName |
      | SC            | AutoTruck SP | Test For Private Tab   | SP Admin |
    And Logout as -- SP
    And Login as -- TECHSP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog    | TECHSP    | Submitted | EventInfo |
    And View -- RFA -- ConfidentialTab
      | EquipmentType | TenantName   | Message                    | UserName  |PreviousMessage    |
      | SC            | AutoTruck SP | Test Success in Private Tab| Test tech |Test For Private Tab|
    And Logout as -- TECHSP
    And Login as -- SP

  @RegressionTest @Smoke @Sanity
  Scenario: 03 Create a SP Event--Validate Comments tab
    Given Create a Event-- SP -- Feature - SPEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Container     | AutoTruck         |
    When Enter Service details -- Alerts
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repair | Front    |
    And Get Event information from -- SP
    And Assign Tech -- SP -- TECHSP
    And Raise -- RFA -- CommentTab
      | EquipmentType | TenantName   | Message                | UserName |
      | SC            | AutoTruck SP | Test For Comment Tab   | SP Admin |
    And Logout as -- SP
    And Login as -- TECHSP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog    | TECHSP    | Submitted | EventInfo |
    And View -- RFA -- CommentTab
      | EquipmentType | TenantName   | Message                    | UserName  |PreviousMessage    |
      | SC            | AutoTruck SP | Test Success in Comment Tab| Test tech |Test For Comment Tab|
    And Logout as -- TECHSP
    And Login as -- SP