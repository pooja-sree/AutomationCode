@FleetTechChecklist
Feature: Fleet and Technician Checklist
  
  This Scenario is to validate the Fleet and Technician Checklist

  Background: Enable Checklist feature for Autotruck SP and Autotruck Fleet
    Given AutoTruck SP -- Enable/Disable feature -- Enable Workflow Checklist--Enable
    Given AutoTruck Fleet -- Enable/Disable feature -- Enable Workflow Checklist--Enable

  @RegressionTest @Sanity
  Scenario: 01 Create a Fleet Event--ValidateChecklist--AssignTech-TechAccept-Enroute-TechArrive-TechRepair-Complete
    Given Create a Event-- Fleet -- Feature - FleetTechChecklist
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck Fleet  | Power Unit  | AutoTruck      |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason      |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abandonment |
    Then Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType     | Status | Page |
      | Single     | Fleet | Open   | EventInfo |
    And Assign Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType     | Status | Page |
      | Single     | SP | Submitted   | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Assign Tech -- SP -- TECHSP
    Given Logout as -- SP
    Given Login as -- TECHSP
    And Verify Event Status
      | StatusType | TenandType     | Status | Page |
      | Single     | TECHSP | In Process   | EventInfo |
#    And EventAction -- TechAccept -- by -- TECHSP
    And TechAccept Event with Checklist -- In TECHSP
      | Question   | Answer            |
      | Comments-F | Coming in 10 mins |
      | Comments-S | Need one rench    |
    And Verify Event Status
      | StatusType | TenandType     | Status | Page |
      | Single     | TECHSP | In Process   | EventInfo |
    And Enroute Event with Checklist -- In TECHSP
      | Question | Answer  |
      | ETA-F    | 10 mins |
      | ETA-S    | 10 mins |
    And Verify Event Status
      | StatusType | TenandType     | Status | Page |
      | Single     | TECHSP | In Process   | EventInfo |
    And TechArrive Event with Checklist -- In TECHSP
      | Question       | Answer             |
      | Arrival Time-F | Now                |
      | License Plate/Slate | Yes                |
      | Feedback-S     | Brakes replacement |
      | Car model      |               2015 |
    And Verify Event Status
      | StatusType | TenandType     | Status | Page |
      | Single     | TECHSP | In Process   | EventInfo |
    And TechRepair Event with Checklist -- In TECHSP
      | Question          | Answer            |
      | Completion Time-F | Now               |
      | Feedback-F        | Repair Done       |
      #| After Picture     | Yes               |
      | Completion Time-S | Now               |
      | Feedback-S        | Customer has paid |
    Given Logout as -- TECHSP
    Given Login as -- SP
    And Verify Event Status
      | StatusType | TenandType     | Status | Page |
      | Single     | SP | Repaired   | EventInfo |
    And Complete Event with Checklist -- In SP
      | Question          | Answer                 |
      | Completion Time-F | Now                    |
      | Feedback-F        | Approved and Completed |
      | Completion Time-S | Now                    |
      #| License Plate/Slate | Yes                    |
      | Feedback-S        | SP Completed and Done  |
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Completed | EventInfo |
    Then Validate Checklist Fields
      | Question   | Answer            |
      | ETA-F      | 10 mins           |
#      | Comments-F | Coming in 10 mins |
      | ETA-S      | 10 mins           |
#      | Comments-S | Need one rench    |
      | Car model  |              2015 |
    And Logout as -- SP
    And Verify Event Status
      | StatusType | TenandType     | Status    | Page      |
      | Single     | Fleet | Completed | EventInfo |
    Then Validate Checklist Fields
      | Question   | Answer            |
      | ETA-F      | 10 mins           |
#      | Comments-F | Coming in 10 mins |
    And Login as -- SP

  @RegressionTest
  Scenario: 02 Create a Fleet Event--ValidateChecklist--AssignTech-Reject
    Given Create a Event-- Fleet -- Feature - FleetTechChecklist
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck Fleet  | Power Unit  | AutoTruck      |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
    Then Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType     | Status | Page      |
      | Single     | Fleet | Open   | EventInfo |
    And Assign Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Assign Tech -- SP -- TECH2SP
    And Get Event information from -- SP
    And EventAction -- Accept -- by -- SP
    And Verify Event Status
      | StatusType | TenandType     | Status | Page      |
      | Single     | SP             | In Process   | EventInfo |
    And Reject Event with Checklist -- In SP
      | Question        | Answer                      |
      | Reject Reason-F | Unable to serve the Request |
      | Reject Reason-S | Unable to serve the Request |
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | Single     | SP         | Rejected | EventInfo |
    Then Validate Checklist Fields
      | Question        | Answer                      |
      | Reject Reason-F | Unable to serve the Request |
      | Reject Reason-S | Unable to serve the Request |
    And Logout as -- SP
    And Verify Event Status
      | StatusType | TenandType     | Status   | Page      |
      | Single     | Fleet | Rejected | EventInfo |
    Then Validate Checklist Fields
      | Question        | Answer                      |
      | Reject Reason-F | Unable to serve the Request |
    And Login as -- SP
