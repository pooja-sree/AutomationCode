Feature: Find Servive Centre(FSC)
  This feature verifies all combinations of FSC  functionality

  @RegressionTest
  Scenario: 01 Assigning a TD Event--SP-- DefaultTab
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog     | TD         | Open   | EventInfo |
    And AssignDefault TD event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | TD         | Submitted | EventInfo |

  @RegressionTest
  Scenario: 02 Assigning a TD Event--SP-- ReportingSP
    Given Create a Event-- CCHQ -- Feature - CCEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And EventAction -- Accept -- by -- CCHQ
    And AssignRSP CC event to -- AutoTruck SP3 -- Payment Method - Cash
    And Get Event information from -- CCHQ
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | dispatchLog     | CCHQ      | Submitted | EventInfo |

  @RegressionTest
  Scenario: 03 Assigning a TD Event--SP-- FSCMap
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD        | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And AssignMap Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventStatus     | TD      | Submitted | Dashboard |

  @RegressionTest
  Scenario: 04 Assigning a TD Event--SP-- OEMAutorisedSP
    Given Create a Event-- Fleet -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck Fleet        | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And AssignOEM Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog     | Fleet      | Submitted | EventInfo |

  @RegressionTest @Smoke @Sanity
  Scenario: 05 Event from TD to SP --Assign event-- Using All tab of FSC and Override Search Results
    Given Create a Event-- TD -- Feature - FSC
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | TD         | Open   | EventInfo |
    And AssignAll TD event to -- AutoTruck SP -- Payment Method - Yes
    And Verify Event Status
      | StatusType   | TenandType | Status    | Page      |
      | eventLog     | TD         | Submitted | EventInfo |
    And Override TD event to -- AutoTruck SP1 -- Payment Method - Yes
    And Verify Event Status
      | StatusType   | TenandType | Status    | Page      |
      | eventStatus  | SP1         | Submitted | Dashboard |

  @RegressionTest
  Scenario: 06 Event from Fleet to SP --Assign event-- Using SP Authority tab of FSC.
    Given Create a Event-- Fleet -- Feature - FSCSPAuthority
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck Fleet  | Container   | AutoTruck      |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | OTR Service | OTR Labor   | Service Call - Mechanical | Per Contract | Complete    |
    Then Get Event information from -- Fleet
    Then Verify Event Status
      | StatusType | TenandType | Status| Page     |
      | eventLog   | Fleet      | Open  | EventInfo |
    And SPAuthority Fleet event to -- AutoTruck SP1 -- Payment Method - Cash
    And Verify Event Status
      | StatusType   | TenandType | Status    | Page      |
      | eventLog     | SP1         | Submitted | EventInfo |
      | eventStatus  | Fleet         | Submitted | Dashboard |

  @RegressionTest
  Scenario: 07 Event from TD to SP --Assign event-- Using EP Approved tab of FSC.
    Given Create a Event-- TD -- Feature - FSCEPApproved
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Container     | AutoTruck       |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repairs | Front    |
    Then Get Event information from -- TD
    Then Verify Event Status
      | StatusType | TenandType | Status| Page   |
      | eventStatus| TD      | Open  | Dashboard |
      | eventLog   | TD      | Open  | EventInfo |
    And FSCEPApproved TD event to -- AutoTruck SP3 -- Payment Method - Cash
    And Verify Event Status
      | StatusType   | TenandType     | Status    | Page      |
      | eventStatus  | TD             | Submitted | Dashboard |
      | eventLog     | SP3            | Submitted | EventInfo |

  @RegressionTest
  Scenario: 08 Event from Fleet to SP --Assign event-- Using Under Radius tab of FSC
    Given Create a Event-- Fleet -- Feature - FSCUnderRadius
      | CustomerName   | EquipmentType | EquipmentProvider |
      | AutoTruck Fleet | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    Then Get Event information from -- Fleet
    And Verify Event Status
      | StatusType   | TenandType    | Status | Page      |
      | eventStatus  | Fleet         | Open   | Dashboard |
      | eventLog     | Fleet         | Open   | EventInfo |
    And UnderRadius1  event to -- AutoTruck SP8 -- Payment Method - Cash
#    And UnderRadius2  event to -- AutoTruck SP2 -- Payment Method - Cash
    And Verify Event Status
      | StatusType   | TenandType    | Status    | Page      |
      | eventStatus  | Fleet         | Open | Dashboard |
      | eventLog     | Fleet         | Open | EventInfo |
#      | eventStatus  | AutoTruck SP2 | Submitted | Dashboard |
#      | eventLog     | AutoTruck SP2 | Submitted | EventInfo |

  @RegressionTest
  Scenario: 09 Event from CC to SP --Assign event-- Override Search Results for NPSP tenant
    Given Create a Event-- CC -- Feature - CCEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Trailer       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly              | Component              | Position     | WorkAccomplished | Reason      |
      | Trailer       | Brakes | Brake Master Cylinder | Boot - Master Cylinder | Front Center | Adjust           | Abandonment |
    Then Get Event information from -- CC
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | CC         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- CC
    And OverrideNPSP CC event to -- AutoTruckNPSP -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | eventLog   | CC         | In Process | EventInfo |