Feature: Validation of Event Statuses and Technician Statuses.
  This feature verifies event and technician statuses by performing different operations such as
  assign-accept-completed-Reprocess on events and techaccept-techenroute-techarrived-repaired on technician.

  @RegressionTest
  Scenario: 01 Create TD Event -- Assign to SP[Accept] -- Assign to Technician[TechAccept]-[TechEnroute]-[Tech Arrived]- SP[Repaired] -- SP[Completed] -- TD[Reprocess] -- SP[Repaired] -- TD[Approved]
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType        | Status    | Page      |
      | eventLog   | SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Assign Tech -- SP -- TECHSP

    Given Logout as -- SP
    Given Login as -- TECHSP

    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | technStatus| TECHSP  | ASSIGNED   | EventInfo |
    And EventAction -- TechAccept -- by -- TECHSP
    And Verify Event Status
      | StatusType | TenandType   | Status     | Page      |
      | technStatus| TECHSP    | ACCEPTED   | EventInfo |


    And EventAction -- TechEnroute -- by -- TECHSP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | technStatus| TECHSP  | EN ROUTE   | EventInfo |

    And EventAction -- TechArrive -- by -- TECHSP
    And Verify Event Status
      | StatusType | TenandType   | Status     | Page      |
      | technStatus| TECHSP    | ARRIVED    | EventInfo |

    And EventAction -- TechRepair -- by -- NEPTECHSP
    And Verify Event Status
      | StatusType | TenandType        | Status      | Page      |
      | technStatus| TECHSP         | REPAIRED    | EventInfo |

    Given Logout as -- TECHSP
    Given Login as -- SP

    And Verify Event Status
      | StatusType | TenandType         | Status     | Page      |
      | technStatus| SP | REPAIRED   | EventInfo |
    And EventAction -- Complete -- by -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | SP| Completed | EventInfo |

    And Verify Event Status
      | StatusType | TenandType  | Status     | Page      |
      | technStatus| TD          | REPAIRED   | EventInfo |
    And EventAction -- Reprocess -- by -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | techStatus | TD         | Repaired | Dashboard |
      | eventLog   | TD         | In Process | EventInfo |
      | technStatus| TD         | REPAIRED | EventInfo |

    And Verify Event Status
      | StatusType | TenandType         | Status     | Page      |
      | technStatus| SP | REPAIRED   | EventInfo |
    And EventAction -- Repaired -- by -- SP
    And Verify Event Status
      | StatusType | TenandType         | Status     | Page      |
      | technStatus| SP | REPAIRED   | EventInfo |

    And EventAction -- Complete -- by -- SP
    And Verify Event Status
      | StatusType | TenandType        | Status    | Page      |
      | eventLog   | SP       | Completed | EventInfo |