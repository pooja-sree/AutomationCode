@ScheduleEvent
Feature: Schedule Event
  This feature file validates the Schedule Event

  Background: Enable Event Schedule feature for Autotruck
    Given AutoTruck SP5 -- Enable/Disable feature -- Enable Event Schedule--Enable

  @RegressionTest @Sanity @Smoke
  Scenario: 01 Create a TD Event--Validate slot limit configured in SP
    Given Create a Event-- TD -- Feature - Schedule Event
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType| Status | Page     |
      | Single     | TD        | Open   | EventInfo |
    And AssignSchedule TD-Schedule event to -- AutoTruck SP5 -- Payment Method - Cash
    And Dashboard actions for scheduled events -- SP5
      |Dropdown             |Validate       |
      |Pending Confirmation |   EventID     |
      |Pending Confirmation |  Schedule Time|
    And ScheduleEventAction -- SP5 -- Confirm
    And Dashboard actions for scheduled events -- SP5
      |Dropdown               |Validate       |
      |Scheduled Confirmation |   EventID     |
      |Scheduled Confirmation |  Schedule Time|
    Given Create a Event-- TD -- Feature - Schedule Event
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis  | AutoTruck      |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                   | Defect  | Location |
      | Chassis       | Brakes | ABS       | ABSECUCable - ReplaceW/New| Broken  | Under    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType| Status | Page     |
      | Single     | TD        | Open   | EventInfo |
    And Assign TD-Schedule(2) event to -- AutoTruck SP5 -- Payment Method - Cash

  @RegressionTest
  Scenario: 02 Create a TD Event--Schedule-Confirm-Reschedule
    Given Create a Event-- TD -- Feature - Reschedule Event
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType| Status | Page     |
      | Single     | TD        | Open   | EventInfo |
    And AssignSchedule TD-Schedule-Wo-TimeSlot event to -- AutoTruck SP5 -- Payment Method - Cash
    And Dashboard actions for scheduled events -- SP5
      |Dropdown             |Validate       |
      |Unscheduled          |   EventID     |
    And ScheduleEventAction -- SP5 -- Schedule
    And Dashboard actions for scheduled events -- SP5
      |Dropdown               |Validate       |
      |Scheduled Confirmation |   EventID     |
      |Scheduled Confirmation |  Schedule Time|
    And ScheduleEventAction -- SP5 -- Reschedule
    And Dashboard actions for scheduled events -- SP5
      |Dropdown               |Validate       |
      |Scheduled Confirmation |   EventID     |
      |Scheduled Confirmation |  Schedule Time|