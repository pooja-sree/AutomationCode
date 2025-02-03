Feature: Org Structure
  This feature verifies all combinations of org structure functionality

  @RegressionTest @Sanity @Smoke
  Scenario: 01 Create an Event in AutoTruck SP2 and Validate the event in Parent SPHQ
    Given Create a Event-- SP2 -- Feature - SPEventCreation
      | EquipmentType | EquipmentProvider | CustomerName |
      | Chassis       | AutoTruck         | AutoTruck TD |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem  | Service                   | Defect                  | Location  |
      | Chassis       | Tire   | Rim Spacer | Spacer,Rim - ReplaceW/New | Associated With Repairs | Left Rear |
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Submitted | Dashboard |
    And Get Event information from -- SPHQ
    And Verify Event Status
      | StatusType | TenandType         | Status    | Page      |
      | Org        | SPHQ>AutoTruck SP2 | Submitted | Dashboard |
      | Org        | SPHQ>AutoTruck SP2 | Submitted | EventInfo |

  @RegressionTest
  Scenario: 02 Create an Event in SP3 and Validate the event in Parent CCHQ
    Given Create a Event-- SP3 -- Feature - CCEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem      | Service                                         | Defect | Location |
      | Chassis       | Tire   | Tire Inflation | TireInflationsystemControlBoxLid - ReplaceW/New | Broken | Under    |
    And Get Event information from -- SP3
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP3        | Submitted | Dashboard |
    And Get Event information from -- CCHQ
    And Verify Event Status
      | StatusType | TenandType         | Status    | Page      |
      | Org        | CCHQ>AutoTruck SP3 | Submitted | Dashboard |
      | Org        | CCHQ>AutoTruck SP3 | Submitted | EventInfo |

  @RegressionTest
  Scenario: 03 Create an Event in SP3 and Assign to a SP2
    Given Create a Event-- SP3 -- Feature - SPEventCreation
      | EquipmentType | EquipmentProvider | CustomerName |
      | Chassis       | AutoTruck         | AutoTruck TD |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- SP3
    And Verify Event Status
      | StatusType | TenandType         | Status    | Page      |
      | Org        | CCHQ>AutoTruck SP3 | Submitted | Dashboard |
      | Org        | CCHQ>AutoTruck SP3 | Submitted | EventInfo |
    And Get Event information from -- SP3
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | CCHQ       | Submitted | EventInfo |
    And EventAction -- TechAccept2 -- by -- CCHQ
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | CCHQ       | In Process | EventInfo |
    And AssignRPSP CC event to -- AutoTruck SP4 -- Payment Method - Cash
    And Get Event information from -- SP4
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP4        | Submitted | EventInfo |
    And Get Event information from -- SP4
    And Verify Event Status
      | StatusType | TenandType         | Status     | Page      |
      | Org        | CCHQ>Autotruck SP4 | Submitted  | Dashboard |
      | Org        | CCHQ>Autotruck SP4 | In Process | EventInfo |

  @RegressionTest
  Scenario: 04 Create a SP1 Event--Assign it to reporting SP2 from SPHQ
    Given Create a Event-- SP1 -- Feature - SPEventCreation
      | EquipmentType | EquipmentProvider | CustomerName |
      | Chassis       | AutoTruck         | AutoTruck TD |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- SP1
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP1        | Submitted | EventInfo |
    And Get Event information from -- SPHQ
    And Verify Event Status
      | StatusType | TenandType         | Status    | Page      |
      | Org        | SPHQ>AutoTruck SP1 | Submitted | Dashboard |
      | Org        | SPHQ>AutoTruck SP1 | Submitted | EventInfo |
    And AssignRPSP SPHQ-Org event to -- AutoTruck SP2 -- Payment Method - Cash
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP2        | Submitted | EventInfo |

  @RegressionTest
  Scenario: 05 Create an Event in TD and Assign to a SP
    Given Create a Event-- TD -- Feature - OrgStructure
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Org        | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP1 -- Payment Method - Cash
    And Get Event information from -- SP1
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP1        | Submitted | EventInfo |
    And Get Event information from -- SPHQ
    And Verify Event Status
      | StatusType | TenandType         | Status    | Page      |
      | Org        | SPHQ>AutoTruck SP1 | Submitted | Dashboard |
      | Org        | SPHQ>AutoTruck SP1 | Submitted | EventInfo |
      
      @RegressionTest
      Scenario: 06 Create an Event in TD Assign to SP -- SP Rejects the Event -- Check Event in Parent Tenant
       Given Create a Event-- TD -- Feature - OrgStructure
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Org        | TD         | Open   | Dashboard |
      | Org        | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP1 -- Payment Method - Cash
    And Verify Event Status
      | StatusType   | TenandType | Status    | Page      |
      | eventLog     | SP1        | Submitted | EventInfo |
    And Get Event information from -- SPHQ
    And Verify Event Status
      | StatusType | TenandType         | Status    | Page      |
      | Org        | SPHQ>AutoTruck SP1 | Submitted | Dashboard |
      | Org        | SPHQ>AutoTruck SP1 | Submitted | EventInfo |
    And Get Event information from -- SP1
    And EventAction -- Reject -- by -- SP1
    And Get Event information from -- TD
    And Assign TD event to -- AutoTruck SP2 -- Payment Method - Cash
