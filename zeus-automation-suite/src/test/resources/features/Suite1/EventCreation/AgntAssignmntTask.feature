Feature: Agent Assignment Task
  This feature verifies agent assignment task

  @RegressionTest
  Scenario: 01 Create a TD Event -- Agent Assignment -- Assign Agent -- Delete/Restore User
    Given Create a Event-- TD1 -- Feature - AgentAssignmntTask
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details -- AgentAssignmntTask
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD1
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD1         | Open   | Dashboard |
      | Single     | TD1         | Open   | EventInfo |
    Then Create Agent Assignmnt Task Info Login As -- AutoTruck TD1 Admin1 -- TD1
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD1         | Open   | Dashboard |
    And View The Agent Assignment On Dashboard Page -- AutoTruck TD1 Admin1 -- TD1
    Then Delete The Assigned User -- AutoTruck TD1 Admin1
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD1         | Open   | Dashboard |
    Then Verify Active or Inactive status of Deleted User -- AutoTruck TD1 Admin1
    And View The Agent Assignment On Dashboard Page -- AutoTruck TD1 Admin1 -- TD1

  @RegressionTest
  Scenario: 02 Create a TD Event -- Assign Agent -- Admin > Accountant
    Given Create a Event-- TD1 -- Feature - AgentAssignmntTask
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details -- AgentAssignmntTask
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD1
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD1         | Open   | Dashboard |
    And Create The Agent Assignment On Dashboard Page -- AutoTruck TD1 Admin1 -- TD1
    And View The Agent Assignment On Dashboard Page -- AutoTruck TD1 Admin1 -- TD1
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD1         | Open   | EventInfo |
    Then Validate Agent Assignmnt Task Info Login As -- AutoTruck TD1 Accountant -- TD1
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD1         | Open   | Dashboard |

  @RegressionTest
  Scenario: 03 Create a SC Event -- Agent Assignment -- Supervisor using DashBoard
    Given Create a Event-- SP3 -- Feature - SPEventCreation
      | EquipmentType | EquipmentProvider | CustomerName |
      | Chassis       | AutoTruck         | AutoTruck TD |
    When Enter Service details -- AgentAssignmntTask
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- SP3
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | SP3         | Submitted   | EventInfo |
    Then Create The Agent Assignment On Dashboard Page -- AutoTruck SP3 Supervisor -- SP3
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | SP3         | Submitted   | Dashboard |
    And View The Agent Assignment On Dashboard Page -- AutoTruck SP3 Supervisor -- SP3

  @RegressionTest
  Scenario: 04 Create a TD Event -- Agent Assignment -- User Claim
    Given Create a Event-- TD1 -- Feature - AgentAssignmntTask
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details -- AgentAssignmntTask
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD1
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD1         | Open   | EventInfo |
    Then Claim Agent Assignmnt Task Info Login As -- AutoTruck TD1 User -- TD1
    And Verify Event Status
      | StatusType | TenandType  | Status  | Page      |
      | Single     | TD1         | Open   | Dashboard |
    And View The Agent Assignment On Dashboard Page -- AutoTruck TD1 User -- TD1


  @RegressionTest
  Scenario: 05 Create a CC Event -- Agent Assignment -- Observer using DashBoard
    Given Create a Event-- CC1 -- Feature - CCEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Power Unit    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason      |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abandonment |
    And Get Event information from -- CC1
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | CC1         | Submitted   | EventInfo |
    Then Create The Agent Assignment On Dashboard Page -- AutoTruck CC1 Observer -- CC1
    And Verify Event Status
      | StatusType | TenandType | Status | Page       |
      | Single     | CC1         | Submitted   | Dashboard |