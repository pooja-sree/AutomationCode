Feature: Validation of Event Statuses and Technician Statuses.
  This feature verifies event and technician statuses by performing different operations involving two tenchnicians such as
  assign-accept-completed-approved on events and techreject-techaccept-techenroute-techarrived on techncian.

  @RegressionTest @Sanity
  Scenario: 01 Create Fleet Event -- Assign to SP[Accept] -- Assign to Technician1[TechReject] -- Assign to Technician2[TechAccept]-[TechEnroute]-[Tech Arrived]- SP[Repaired] -- SP[Completed] -- Fleet[Approved]
    Given Create a Event-- Fleet -- Feature - FleetEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck Fleet  | Chassis  | AutoTruck      |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- Fleet
    Then Verify Event Status
      | StatusType | TenandType | Status| Page     |
      | Single     | Fleet      | Open | EventInfo |
    And Assign Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | SP| Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Assign Tech -- SP -- TECHSP

    Given Logout as -- SP
    Given Login as -- TECHSP

    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | technStatus| TECHSP  | ASSIGNED  | EventInfo |

    And EventAction -- TechReject -- by -- TECHSP
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | technStatus| TECHSP  | DECLINED   | EventInfo |
      | eventStatus| TECHSP  | In Process | Dashboard |

    Given Logout as -- TECHSP
    Given Login as -- SP

    And Verify Event Status
      | StatusType | TenandType          | Status    | Page      |
      | technStatus| SP  | DECLINED  | EventInfo |

    And Assign Tech -- SP -- TECH2SP

    Given Logout as -- SP
    Given Login as -- TECH2SP

    And Verify Event Status
      | StatusType | TenandType | Status      | Page      |
      | technStatus| TECH2SP  | ASSIGNED   | EventInfo |
    And EventAction -- TechAccept -- by -- TECH2SP
    And Verify Event Status
      | StatusType | TenandType    | Status     | Page      |
      | technStatus| TECH2SP    | ACCEPTED   | EventInfo |


    And EventAction -- TechEnroute -- by -- TECH2SP
    And Verify Event Status
      | StatusType | TenandType | Status      | Page      |
      | techStatus | TECH2SP  | En Route   | Dashboard |
      | technStatus| TECH2SP  | EN ROUTE   | EventInfo |

    And EventAction -- TechArrive -- by -- TECH2SP
    And Verify Event Status
      | StatusType | TenandType  | Status     | Page      |
      | techStatus | TECH2SP   | Arrived    | Dashboard |
      | technStatus| TECH2SP    | ARRIVED    | EventInfo |

    And EventAction -- TechRepair -- by -- TECH2SP
    And Verify Event Status
      | StatusType | TenandType        | Status      | Page      |
      | techStatus | TECH2SP         | Repaired    | Dashboard |
      | technStatus| TECH2SP         | REPAIRED    | EventInfo |

    Given Logout as -- TECH2SP
    Given Login as -- SP

    And Verify Event Status
      | StatusType | TenandType         | Status     | Page      |
      | technStatus| SP | REPAIRED   | EventInfo |
    And EventAction -- Complete2 -- by -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventStatus| SP| Completed | Dashboard |
      | techStatus | SP| Repaired | Dashboard |

    And Verify Event Status
      | StatusType | TenandType  | Status     | Page      |
      | technStatus| Fleet          | REPAIRED   | EventInfo |
    And EventAction -- Approve -- by -- Fleet
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | techStatus | Fleet         | Repaired | Dashboard |
      | eventLog   | Fleet         | Approved | EventInfo |
      | technStatus| Fleet         | REPAIRED | EventInfo |