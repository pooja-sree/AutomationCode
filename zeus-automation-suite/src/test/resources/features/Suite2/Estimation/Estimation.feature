
Feature: Estimation
  This feature verifies all combinations of estimation functionality

  @RegressionTest @Smoke
  Scenario: 01 Estimation when Amount is less than Limit and Estimation is Auto-Approved
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Power Unit   | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
    And Get Event information from -- TD
    And Verify Event Status
    | StatusType | TenandType | Status | Page      |
    | eventLog   | TD         | Open   | EventInfo |
    And AssignEstimate TD event to -- AutoTruck SP2 -- Payment Method - Cash
    And Verify Event Status
    | StatusType | TenandType | Status    | Page      |
    | eventLog   | SP2         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP2
    And Verify Event Status
    | StatusType | TenandType         | Status     | Page      |
    | eventLog   | SP2 | In Process | EventInfo |
    And EventAction -- Estimate -- by -- SP2
    And Prepare estimate
      | Estimate    | Amount |
      | Discount    |      0 |
      | Taxable     |     10 |
      | NonTaxable  |     10 |
      | Tax         |     10 |
      | Parts       |     10 |
      | Labor       |     10 |
      | Oil         |     10 |
      | NewTires    |     10 |
      | UsedTires   |     10 |
      | TradeIn     |     10 |
      | Sublet      |     10 |
      | RoadCall    |     10 |
      | EnvWasteTax |     10 |
    And Verify Event Status
      | StatusType   | TenandType  | Status     | Page      |
      | eventLog     | SP2          | In Process | EventInfo |
    And Validate Estimate PreApproval -- TD

  @RegressionTest @Sanity
  Scenario: 02 Estimation when Amount is more than Limit (Estimation - Approved)
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Trailer       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly              | Component              | Position     | WorkAccomplished | Reason      |
      | Trailer       | Brakes | Brake Master Cylinder | Boot - Master Cylinder | Front Center | Adjust           | Abandonment |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | TD         | Open   | EventInfo |
    And AssignEstimate TD event to -- AutoTruck SP2 -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | SP2| Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP2
    And Verify Event Status
      | StatusType   | TenandType         | Status     | Page      |
      | eventLog     | SP2 | In Process | EventInfo |
    And EventAction -- Estimate -- by -- SP2
    And Prepare estimate
      | Estimate    | Amount |
      | Discount    |      0 |
      | Taxable     |    100 |
      | NonTaxable  |     10 |
      | Tax         |     10 |
      | Parts       |    110 |
      | Labor       |    100 |
      | Oil         |     10 |
      | NewTires    |     10 |
      | UsedTires   |     10 |
      | TradeIn     |     10 |
      | Sublet      |     10 |
      | RoadCall    |    100 |
      | EnvWasteTax |    100 |
    And Verify Event Status
      | StatusType   | TenandType         | Status     | Page      |
      | eventLog     | TD                 | Estimated | EventInfo |
    And Approve Estimation -- TD
    And Validate Estimate PreApproval -- TD

  @RegressionTest
  Scenario: 03 Estimation when Amount is more than Limit (Estimation - Reject)
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Power Unit   | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | TD         | Open   | EventInfo |
    And AssignEstimate TD event to -- AutoTruck SP2 -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | SP2         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Verify Event Status
      | StatusType   | TenandType  | Status     | Page      |
      | eventLog     | SP2          | In Process | EventInfo |
    And EventAction -- Estimate -- by -- SP2
    And Prepare estimate
      | Estimate    | Amount |
      | Discount    |      0 |
      | Taxable     |    100 |
      | NonTaxable  |     10 |
      | Tax         |     10 |
      | Parts       |    110 |
      | Labor       |    100 |
      | Oil         |     10 |
      | NewTires    |     10 |
      | UsedTires   |     10 |
      | TradeIn     |     10 |
      | Sublet      |     10 |
      | RoadCall    |    100 |
      | EnvWasteTax |    100 |
    And Verify Event Status
      | StatusType   | TenandType         | Status     | Page      |
      | eventLog     | TD                 | Estimated | EventInfo |
    And Reject Estimation -- TD
    And Validate Estimate PreApproval -- TDEstimate Rejected

  @RegressionTest @Smoke
  Scenario: 04 Estimation when Amount is more than Limit -- TD-CC-SP -- Estimation not allowed for SP
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Trailer       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly              | Component              | Position     | WorkAccomplished | Reason      |
      | Trailer       | Brakes | Brake Master Cylinder | Boot - Master Cylinder | Front Center | Adjust           | Abandonment |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck CC -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventLog    | TD         | Submitted | EventInfo |
    And Reassign TD-2 event to -- AutoTruck SP2 -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventLog    | SP2         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP2
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | SP2         | In Process | EventInfo |

  @RegressionTest @Smoke
  Scenario: 05 Estimation when Amount is more than Limit -- TD-AutoForward-SP3 -- Estimation not allowed for SP3
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Trailer       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly              | Component              | Position     | WorkAccomplished | Reason      |
      | Trailer       | Brakes | Brake Master Cylinder | Boot - Master Cylinder | Front Center | Adjust           | Abandonment |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoForward -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | dispatchLog | SP3        | Event Forwarded	 | EventInfo |
    And EventAction -- Accept -- by -- SP3
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | dispatchLog | SP3        | In Process	 | EventInfo |
