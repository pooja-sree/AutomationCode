Feature: Reject and Reassign SE feature
  This feature verifies all combinations of Reject SE and Reassign SE  functionality

  @RegressionTest @Sanity @Smoke
  Scenario: 01 Event from TD to SP --(TD to SP(rejects))--Single Service line--Assign event--Accept Event--Reject event
    Given Create a Event-- TD -- Feature - RejectReassign
      | EquipmentType | EquipmentProvider |
      | Power Unit    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventStatus | TD         | Open   | Dashboard |
      | eventLog    | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | TD         | Submitted | Dashboard |
      | eventLog    | TD         | Submitted | EventInfo |
      | eventStatus | SP         | Submitted | Dashboard |
      | eventLog    | SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventStatus | TD         | In Process | Dashboard |
      | eventLog    | TD         | In Process | EventInfo |
      | eventStatus | SP         | In Process | Dashboard |
      | eventLog    | SP         | In Process | EventInfo |
    And EventAction -- Reject2 -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventStatus | SP         | Rejected | Dashboard |
      | eventLog    | SP         | Rejected | EventInfo |
      | eventStatus | TD         | Rejected | Dashboard |
      | eventLog    | TD         | Rejected | EventInfo |

  @RegressionTest
  Scenario: 02 Event from TD to CC to SP(TD to CC(Reject) > TD to SP) --Single Service line--Assign--Reject--Assign--Accept--Complete--Approve
    Given Create a Event-- TD -- Feature - RejectReassign
      | EquipmentType | EquipmentProvider |
      | Chassis    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventStatus | TD         | Open   | Dashboard |
      | eventLog    | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck CC -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | TD         | Submitted | Dashboard |
      | eventLog    | TD         | Submitted | EventInfo |
      | eventStatus | CC         | Submitted | Dashboard |
      | eventLog    | CC         | Submitted | EventInfo |
    And EventAction -- Reject2 -- by -- CC
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventStatus | CC         | Rejected | Dashboard |
      #      | eventLog     | CC        | Rejected   | EventInfo |
      | eventStatus | TD         | Rejected | Dashboard |
      | eventLog    | TD         | Rejected | EventInfo |
    And Assigncc TD event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | TD         | Submitted | Dashboard |
      | eventLog    | TD         | Submitted | EventInfo |
      #      | RejectedValidation| CC        | Rejected | Dashboard |
      | eventStatus | SP         | Submitted | Dashboard |
      | eventLog    | SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventStatus | TD         | In Process | Dashboard |
      | eventLog    | TD         | In Process | EventInfo |
      | eventStatus | SP         | In Process | Dashboard |
      | eventLog    | SP         | In Process | EventInfo |
    And EventAction -- Complete -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | TD         | Completed | Dashboard |
      | eventStatus | SP         | Completed | Dashboard |
      | eventLog    | SP         | Completed | EventInfo |
      | eventLog    | TD         | Completed | EventInfo |
    And EventAction -- Approve -- by -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventStatus | TD         | Approved | Dashboard |
      | eventStatus | SP         | Approved | Dashboard |
      | eventLog    | TD         | Approved | EventInfo |
      | eventLog    | SP         | Approved | EventInfo |

  @Sanity @RegressionTest
  Scenario: 03 Event from TD to SP to SP2 --(TD to SP(no response) > TD to SP2(reasssign)) --Single Service line--Assign to SP1--Assign to SP2--Accept--Complete--Approve
    Given Create a Event-- TD -- Feature - RejectReassign
      | EquipmentType | EquipmentProvider |
      | Chassis    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | SP         | Submitted | Dashboard |
      | eventLog    | SP         | Submitted | EventInfo |
      | eventStatus | TD         | Submitted | Dashboard |
      | eventLog    | TD         | Submitted | EventInfo |
    And Reassign TD-2 event to -- AutoTruck SP1 -- Payment Method - Cash
    And Verify Event Status
      | StatusType           | TenandType | Status     | Page      |
      | eventStatus          | TD         | Submitted  | Dashboard |
      | eventLog             | TD         | Submitted  | EventInfo |
      | ReassignedValidation | SP         | Reassigned | Dashboard |
      | eventStatus          | SP1        | Submitted  | Dashboard |
      | eventLog             | SP1        | Submitted  | EventInfo |
    And EventAction -- Accept -- by -- SP1
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventStatus | TD         | In Process | Dashboard |
      | eventLog    | TD         | In Process | EventInfo |
      | eventStatus | SP1        | In Process | Dashboard |
      | eventLog    | SP1        | In Process | EventInfo |
    And EventAction -- Complete -- by -- SP1
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | TD         | Completed | Dashboard |
      | eventStatus | SP1        | Completed | Dashboard |
      | eventLog    | SP1        | Completed | EventInfo |
      | eventLog    | TD         | Completed | EventInfo |
    And EventAction -- Approve -- by -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventStatus | SP1        | Approved | Dashboard |
      | eventStatus | TD         | Approved | Dashboard |
      | eventLog    | TD         | Approved | EventInfo |
      | eventLog    | SP1        | Approved | EventInfo |

  @RegressionTest
  Scenario: 04 Event from Fleet to SP to SP2 --(Fleet to SP(In Process) > Fleet to SP2(reassign)) Single Service line--Assign to SP1--Accept--In Process--Assign to SP2--Accept--Complete--Approve
    Given Create a Event-- Fleet -- Feature - RejectReassign
      | EquipmentType | EquipmentProvider |
      | Chassis    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    Then Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | Fleet      | Open   | Dashboard |
      | Single     | Fleet      | Open   | EventInfo |
    And Assign Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | Fleet      | Submitted | Dashboard |
      | eventLog    | Fleet      | Submitted | EventInfo |
      | eventStatus | SP         | Submitted | Dashboard |
      | eventLog    | SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventStatus | SP         | In Process | Dashboard |
      | eventLog    | SP         | In Process | EventInfo |
      | eventStatus | Fleet      | In Process | Dashboard |
      | eventLog    | Fleet      | In Process | EventInfo |
    And Reassign TD-2 event to -- AutoTruck SP1 -- Payment Method - Cash
    And Verify Event Status
      | StatusType           | TenandType | Status     | Page      |
      | eventStatus          | Fleet      | Submitted  | Dashboard |
      | eventLog             | Fleet      | Submitted  | EventInfo |
      | ReassignedValidation | SP         | Reassigned | Dashboard |
      | eventStatus          | SP1        | Submitted  | Dashboard |
      | eventLog             | SP1        | Submitted  | EventInfo |
    And EventAction -- Accept -- by -- SP1
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventStatus | Fleet      | In Process | Dashboard |
      | eventLog    | Fleet      | In Process | EventInfo |
      | eventStatus | SP1        | In Process | Dashboard |
      | eventLog    | SP1        | In Process | EventInfo |
    And EventAction -- Complete2 -- by -- SP1
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | Fleet      | Completed | Dashboard |
      | eventStatus | SP1        | Completed | Dashboard |
      | eventLog    | SP1        | Completed | EventInfo |
      | eventLog    | Fleet      | Completed | EventInfo |
    And EventAction -- Approve -- by -- Fleet
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventStatus | Fleet      | Approved | Dashboard |
      | eventStatus | SP1        | Approved | Dashboard |
      | eventLog    | Fleet      | Approved | EventInfo |
      | eventLog    | SP1        | Approved | EventInfo |

  @RegressionTest
  Scenario: 05 Event from TD to CC to SP to SP1(TD to CC > SP(reject)> CC to SP1) --Single Service line--Assign--Reject--Assign--Accept--Complete--Approve
    Given Create a Event-- TD -- Feature - RejectReassign
      | EquipmentType | EquipmentProvider |
      | Chassis    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    Then Get Event information from -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventStatus | TD         | Open   | Dashboard |
      | eventLog    | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck CC -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | TD         | Submitted | Dashboard |
      | eventLog    | TD         | Submitted | EventInfo |
      | eventStatus | CC         | Submitted | Dashboard |
      | eventLog    | CC         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- CC
    And Assign CC event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventLog    | SP         | In Process| EventInfo |
    And EventAction -- Reject2 -- by -- SP
    And Verify Event Status
      | StatusType         | TenandType | Status     | Page      |
      | eventStatus        | TD         | In Process | Dashboard |
      | eventLog           | TD         | In Process | EventInfo |
      | RejectedValidation | SP         | Rejected   | Dashboard |
      | eventStatus        | CC         | Rejected   | Dashboard |
      | eventLog           | CC         | Rejected   | EventInfo |
    Then Get Event information from -- CC
    And Assign CC event to -- AutoTruck SP3 -- Payment Method - Cash
    Then Get Event information from -- CC
    Then Get Event information from -- SP3
    And EventAction -- Accept -- by -- SP3
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventStatus | TD         | In Process | Dashboard |
      | eventLog    | TD         | In Process | EventInfo |
      | eventStatus | SP3        | In Process | Dashboard |
      | eventLog    | SP3        | In Process | EventInfo |
    And EventAction -- Complete -- by -- SP3
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | TD         | Completed | Dashboard |
      | eventStatus | SP3        | Completed | Dashboard |
      | eventLog    | SP3        | Completed | EventInfo |
      | eventLog    | TD         | Completed | EventInfo |
    And EventAction -- Approve -- by -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventStatus | TD         | Approved | Dashboard |
      | eventStatus | SP3        | Approved | Dashboard |
      | eventLog    | TD         | Approved | EventInfo |
      | eventLog    | SP3        | Approved | EventInfo |

  @RegressionTest
  Scenario: 06 Event from Fleet to CC (Accepts)->Fleet -- Reassign to SP --Single Service line--Assign--Reject--Assign--Accept--Complete--Approve
    Given Create a Event-- Fleet -- Feature - RejectReassign
      | EquipmentType | EquipmentProvider |
      | Chassis    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    Then Get Event information from -- Fleet
    And Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventStatus | Fleet      | Open   | Dashboard |
      | eventLog    | Fleet      | Open   | EventInfo |
    And Assign Fleet event to -- AutoTruck CC -- Payment Method - Cash
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | Fleet      | Submitted | Dashboard |
      | eventLog    | Fleet      | Submitted | EventInfo |
      | eventStatus | CC         | Submitted | Dashboard |
      | eventLog    | CC         | Submitted | EventInfo |
    Then Get Event information from -- CC
    And EventAction -- Accept -- by -- CC
    Then Get Event information from -- Fleet
    And Reassign Fleet event to -- AutoTruck SP -- Payment Method - Cash
    Then Get Event information from -- Fleet
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | Fleet      | Submitted | Dashboard |
      | eventLog    | Fleet      | Submitted | EventInfo |
      | eventStatus | SP         | Submitted | Dashboard |
      | eventLog    | SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    Then Get Event information from -- SP
    And EventAction -- Complete2 -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | Fleet      | Completed | Dashboard |
      | eventStatus | SP         | Completed | Dashboard |
      | eventLog    | SP         | Completed | EventInfo |
      | eventLog    | Fleet         | Completed | EventInfo |
    And EventAction -- Approve -- by -- Fleet
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventStatus | Fleet      | Approved | Dashboard |
      | eventStatus | SP         | Approved | Dashboard |
      | eventLog    | Fleet      | Approved | EventInfo |
      | eventLog    | SP         | Approved | EventInfo |
