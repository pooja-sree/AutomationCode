Feature: RPO Flows
   
  @RegressionTest
  Scenario: 01 Verify Fleet to NPSP flow for RPO -- Accept -- Submitted
    Given Create a Event-- TD -- Feature - RPO
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- Auto RPO NPSP -- Payment Method - Cash
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType   | TenandType        | Status    | Page      |
      | eventLog     | SP                | Submitted | EventInfo |

   
    @RegressionTest
  Scenario: 02 Verify CC to NPSP Event flow for RPO -- Accept -- Submitted
    Given Create a Event-- CC -- Feature - CCEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- CC
    Then Verify Event Status
     | StatusType | TenandType | Status    | Page      |
     | eventLog   | CC         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- CC  
    And Assign CC event to -- Auto RPO NPSP -- Payment Method - Cash
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType   | TenandType        | Status     | Page      |
      | eventLog     | SP                | In Process | EventInfo |

  @RegressionTest
   Scenario: 03 Verify Fleet to NPSP flow (via override search results) for RPO -- Accept -- Submitted
    Given Create a Event-- TD -- Feature - RPO
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    And OverrideNPSP TD event to -- Auto RPO NPSP -- Payment Method - Cash
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType   | TenandType        | Status    | Page      |
      | eventStatus  | SP                | Submitted | Dashboard |

  @RegressionTest
  Scenario: 04 Verify CC to NPSP Event flow(via override search results) for RPO -- Accept -- Submitted
    Given Create a Event-- CC -- Feature - CCEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- CC
    Then Verify Event Status
     | StatusType | TenandType | Status    | Page      |
     | eventLog   | CC         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- CC
    And OverrideNPSP CC event to -- Auto RPO NPSP -- Payment Method - Cash
    And Get Event information from -- SP
    And Verify Event Status
      | StatusType   | TenandType        | Status     | Page      |
      | eventLog     | SP                | In Process | EventInfo |
