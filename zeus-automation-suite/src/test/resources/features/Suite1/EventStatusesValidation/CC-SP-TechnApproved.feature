Feature: Validation of Event Statuses and Technician Statuses.
  This feature verifies event and technician statuses by performing different operations such as
  assign-repaired-completed-approved on events and accept-techaccept-techenroute-techarrived on techncian.

  @RegressionTest
  Scenario: 01 Create CC Event -- Assign to SP[Accept] -- Assign to Technician[TechAccept]-[TechEnroute]-[Tech Arrived]- SP[Repaired] -- SP[Completed] -- TD[Approved]
    Given Create a Event-- CC -- Feature - CCEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Power Unit    | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | Assembly |
      | Power Unit    | Brakes | Electric Brakes |
    And Get Event information from -- CC
    Then Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | CC         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- CC
    And Assigncc CC event to -- AutoTruck SP -- Payment Method - Check
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | SP| In Process| EventInfo |
      | dispatchLog| SP| Submitted | EventInfo |
    And Assign Tech -- SP -- TECHSP

    Given Logout as -- SP
    Given Login as -- TECHSP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | technStatus| TECHSP  | ASSIGNED   | EventInfo |

    And EventAction -- TechAccept2 -- by -- TECHSP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | technStatus| TECHSP  | ACCEPTED  | EventInfo |

    And EventAction -- TechEnroute -- by -- TECHSP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | technStatus| TECHSP  | EN ROUTE   | EventInfo |

    And EventAction -- TechArrive -- by -- NEPTECHSP
    And Verify Event Status
      | StatusType | TenandType  | Status     | Page      |
      | technStatus-remainingServiceLineItems| TECHSP      | ARRIVED-Electric Brakes (EBS)-Front Center-Adjust-Abandonment    | EventInfo |

    Given Logout as -- TECHSP
    Given Login as -- SP
    And Verify Event Status
      | StatusType | TenandType  | Status     | Page      |
      | technStatus| SP    | ARRIVED    | EventInfo |
    And EventAction -- Repair -- by -- SP
    And Verify Event Status
      | StatusType | TenandType        | Status      | Page      |
      | technStatus| SP                | ARRIVED     | EventInfo |

    And EventAction -- Complete -- by -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | SP| Completed | EventInfo |
      | dispatchLog| SP| Completed | EventInfo |

    And Verify Event Status
      | StatusType | TenandType  | Status     | Page      |
      | techStatus | CC          | Arrived   | Dashboard |
      | technStatus| CC          | ARRIVED   | EventInfo |
