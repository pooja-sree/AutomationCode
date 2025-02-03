Feature: Validation of Event Statuses and Technician Statuses.
  This feature verifies all combinations of event and technician statuses by performing different operations such as
  assign-accept-reject-repaired-completed-approved on events and techaccept-techenroute-techarrived-techreject on techncian.

  @RegressionTest @Smoke @Sanity
  Scenario: 01 Create TD Event -- Assign to CC [Accept] -- Assign to SP[Accept] -- Assign to Technician[TechAccept]-[TechEnroute]-[Tech Arrived]-[Repaired] -- SP[Completed] -- TD[Approved]
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                   | Defect  | Location |
      | Chassis       | Brakes | ABS       | ABSECUCable - ReplaceW/New| Broken  | Under    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck CC -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | CC         | Submitted | EventInfo |
      | eventStatus| TD         | Submitted | Dashboard |
      | eventLog   | CC         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- CC
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | eventLog   | CC         | In Process | EventInfo |
      | eventStatus| TD         | In Process | Dashboard |
      | dispatchLog| CC         | Open       | EventInfo |
    And AssignSecondTime CC event to -- AutoTruck SP -- Payment Method - Check
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | CC         | In Process | EventInfo |
    And SubContact -- TO -- AutoTruck SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | dispatchLog| SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And SubContact -- FROM -- AutoTruck CC
    And Verify Event Status
      | StatusType | TenandType        | Status     | Page      |
      | eventStatus| SP                | In Process | Dashboard |
      | eventLog   | SP                | In Process | EventInfo |
      | dispatchLog| SP                | In Process | EventInfo |
     And Assign Tech -- SP -- TECHSP
     And Verify Event Status
       | StatusType | TenandType        | Status     | Page      |
       | technStatus| CC                | ASSIGNED   | EventInfo |
       | technStatus| SP                | ASSIGNED   | EventInfo |

    Given Logout as -- SP
    Given Login as -- TECHSP

    And Verify Event Status
      | StatusType | TenandType        | Status     | Page      |
      | technStatus| TECHSP            | ASSIGNED   | EventInfo |
    And EventAction -- TechAccept -- by -- TECHSP
    And Verify Event Status
      | StatusType | TenandType   | Status     | Page      |
      | eventStatus| TECHSP    | In Process | Dashboard |
      | techStatus | TECHSP    | Accepted   | Dashboard |
      | technStatus| TECHSP    | ACCEPTED   | EventInfo |


    And EventAction -- TechEnroute -- by -- TECHSP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | techStatus | TECHSP  | En Route   | Dashboard |
      | technStatus| TECHSP  | EN ROUTE   | EventInfo |

    And EventAction -- TechArrive -- by -- TECHSP
    And Verify Event Status
      | StatusType | TenandType  | Status     | Page      |
      | techStatus | TECHSP   | Arrived    | Dashboard |
      | technStatus| TECHSP   | ARRIVED    | EventInfo |

    And EventAction -- TechRepair -- by -- TECHSP
    And Verify Event Status
      | StatusType | TenandType        | Status      | Page      |
      | technStatus| TECHSP         | REPAIRED    | EventInfo |
      | eventStatus| TECHSP         | Repaired    | Dashboard |
      | techStatus | TECHSP         | Repaired    | Dashboard |

    Given Logout as -- TECHSP
    Given Login as -- SP

    And Verify Event Status
      | StatusType | TenandType         | Status     | Page      |
      | eventStatus| SP       | Repaired   | Dashboard |
      | techStatus | SP       | Repaired   | Dashboard |
      | technStatus| SP       | REPAIRED   | EventInfo |
    And EventAction -- Complete -- by -- SP
    And Verify Event Status
      | StatusType | TenandType        | Status    | Page      |
      | eventStatus| SP| Completed | Dashboard |
      | techStatus | SP| Repaired  | Dashboard |
      | dispatchLog| SP| Completed | EventInfo |

    And Verify Event Status
      | StatusType | TenandType  | Status     | Page      |
      | eventStatus| TD          | Completed  | Dashboard |
      | technStatus| TD          | REPAIRED   | EventInfo |
    And EventAction -- Approve -- by -- TD
    And Verify Event Status
      | StatusType | TenandType | Status   | Page      |
      | eventLog   | TD         | Approved | EventInfo |