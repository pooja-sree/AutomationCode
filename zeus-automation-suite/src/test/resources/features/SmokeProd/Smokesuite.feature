Feature: Smoke Production
  
  This feature verifies all combinations of Alerts and Comments functionality

  #Alerts, Ancillary Location ,Billing Section
  Scenario: 01 Create a TD Event--EventTemplates--Chassis--Single--Brakes
    Given Select Payment Method -- TD
      | PaymentMethod |
      | Cash          |
    Given Create a Event-- TD -- Feature - SmokeSuiteAncillaryLocation
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Power Unit    | AutoTruck         |
    When Enter Service details -- AncillaryLocation
      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason      |
      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abandonment |
    And Get Event information from -- TD
    Then Validate Ancillary Location Info -- TD
    And Assign TD event to -- SP -- Payment Method - Cash
    And Assign Tech -- SP -- Testtech
    And Raise RFA ConfidentialTab -- SP
    And Logout as -- SP
    And Login as -- SCTECH
    And Get Event information from -- SCTECH
    And View RFA ConfidentialTab -- SCTECH
    And Logout as -- SCTECH
    And Login as -- SP
    Given Select Payment Method -- TD
      | PaymentMethod |
      | Cash          |

  #Crosswalk
  Scenario: 02 Create a SP Event--container--CrossWalk--Door
    Given Create a Event-- SP -- Feature - SmokeSuiteCrossWalk
      | CustomerName | EquipmentType | EquipmentProvider | Crosswalk  |
      | Autotruck TD | Container     | AutoTruck         | crosswalk1 |
    When Enter Service details -- Crosswalk
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | Reefer | Exhaust   | Exhaust - ReplaceW/New | Associated with Repair | Front    |
    And Validate Crosswalk -- SP
      | Crosswalk  |
      | crosswalk1 |

  #Clone and Void
  Scenario: 03 Create a TD Event--Clone--Void
    Given Create a Event-- TD -- Feature - SmokeSuiteVoidEvent
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Clone Event -- TD -- Clone
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Clone
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Void Event -- TD -- Void
      | VoidReason          | VoidStatus |
      | Cannot Locate Asset | Voided     |

  #Event Creation
  Scenario: 04 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - SmokeSuiteTDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD event to -- AutoTruck SP -- Payment Method - Yes
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |

  #Fleet Selection EP
  #Scenario: 05 Create a TD Event--Chassis-- EP Selection from Fleet
    #Given Create a Event-- Fleet -- Feature - EPselectionfromFleet
      #| CustomerName | EquipmentType | EquipmentProvider |
      #| Fleet        | Chassis       | TestFleetNEP      |
    #When Enter Service details -- Create
      #| EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      #| Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    #And Validate EquipmentProvider -- TestFleetNEP

  #TechStatus
  Scenario: 06 Create TD Event -- Assign to CC [Accept] -- Assign to SP[Accept] -- Assign to Technician[TechAccept]-[TechEnroute]-[Tech Arrived]-[Repaired] -- SP[Completed] -- TD[Approved]
    Given Create a Event-- TD -- Feature - SmokeSuiteTDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                    | Defect | Location |
      | Chassis       | Brakes | ABS       | ABSECUCable - ReplaceW/New | Broken | Under    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | eventLog   | TD         | Open   | EventInfo |
    And Assign TD event to -- Autotruck SP -- Payment Method - Yes
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventLog    | SP         | Submitted | EventInfo |
      | eventStatus | TD         | Submitted | Dashboard |
      | eventLog    | SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventLog    | SP         | In Process | EventInfo |
      | eventStatus | TD         | In Process | Dashboard |
    #| dispatchLog | SP         | Open       | EventInfo |
    #And AssignSecondTime CC event to -- Autotruck SP -- Payment Method - Yes
    #And Verify Event Status
    #| StatusType  | TenandType | Status    | Page      |
    #| eventStatus | CC         | Submitted | Dashboard |
    #| dispatchLog | SP         | Submitted | EventInfo |
    #And EventAction -- Accept -- by -- SP
    #And Verify Event Status
    #| StatusType  | TenandType         | Status     | Page      |
    #| dispatchLog | CC                 | In Process | EventInfo |
    #| eventStatus | SP | In Process | Dashboard |
    #| dispatchLog | SP | In Process | EventInfo |
    And Assign Tech -- SP -- Testtech
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | techStatus  | TD         | Assigned | Dashboard |
      | technLog    | TD         | Assigned | EventInfo |
      | technStatus | TD         | ASSIGNED | EventInfo |
    #| technStatus | CC                 | ASSIGNED | EventInfo |
    #| technStatus | SP         | ASSIGNED | EventInfo |
    Given Logout as -- SP
    Given Login as -- SCTech
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | technStatus | TD         | ASSIGNED | EventInfo |
      | technStatus | SCTech     | ASSIGNED | EventInfo |
    And EventAction -- TechAccept -- by -- SCTech
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventStatus | SCTech     | In Process | Dashboard |
      | techStatus  | SCTech     | Accepted   | Dashboard |
      | technStatus | SCTech     | ACCEPTED   | EventInfo |
    And EventAction -- TechEnroute -- by -- SCTech
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventStatus | SCTech     | In Process | Dashboard |
      | techStatus  | SCTech     | En Route   | Dashboard |
      | technStatus | SCTech     | EN ROUTE   | EventInfo |
    And EventAction -- TechArrive -- by -- SCTech
    And Verify Event Status
      | StatusType  | TenandType | Status     | Page      |
      | eventStatus | SCTech     | In Process | Dashboard |
      | techStatus  | SCTech     | Arrived    | Dashboard |
      | technStatus | SCTech     | ARRIVED    | EventInfo |
    And EventAction -- TechRepair -- by -- SCTech
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | technStatus | SCTech     | REPAIRED | EventInfo |
      | eventStatus | SCTech     | Repaired | Dashboard |
      | techStatus  | SCTech     | Repaired | Dashboard |
    Given Logout as -- SCTech
    Given Login as -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventStatus | SP         | Repaired | Dashboard |
      | techStatus  | SP         | Repaired | Dashboard |
      | technStatus | SP         | REPAIRED | EventInfo |
    And EventAction -- Complete -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | TD         | Completed | Dashboard |
      | eventStatus | SP         | Completed | Dashboard |
      | techStatus  | SP         | Repaired  | Dashboard |
      | eventLog    | SP         | Completed | EventInfo |
    #| dispatchLog | SP         | Completed | EventInfo |
    #Given Logout as -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | TD         | Completed | Dashboard |
      | technStatus | TD         | REPAIRED  | EventInfo |
    And EventAction -- Approve -- by -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventLog    | TD         | Approved | EventInfo |
      | eventStatus | TD         | Approved | Dashboard |

  #Find Duplicate
  Scenario: 07 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - SmokeSuiteDuplicate
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And AssignDuplicate TD event to -- AutoTruck SP -- Payment Method - Yes
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |

  #    And Validate WatchList
  #OrgStructure
  Scenario: 08 Create an Event in SP1 and Validate the event in Parent SPHQ
    Given Create a Event-- SP1 -- Feature - SmokeSuiteOrgStructure
      | EquipmentType | EquipmentProvider | CustomerName |
      | Chassis       | AutoTruck         | Autotruck TD |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem  | Service                   | Defect                  | Location  |
      | Chassis       | Tire   | Rim Spacer | Spacer,Rim - ReplaceW/New | Associated With Repairs | Left Rear |
    And Get Event information from -- SP1
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP1        | Submitted | Dashboard |
    #     | Single     | TESTSP2[NEP] | Submitted   | EventInfo |
    And Get Event information from -- SPHQ
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Org        | SPHQ>SP1   | Submitted | Dashboard |
      | Org        | SPHQ       | Submitted | EventInfo |

  #Departed Terminal
  Scenario: 09 Create a TD Event--Chassis-- DepartedTerminal
    Given Create a Event-- TD -- Feature - SmokeSuiteDepartedTerminal
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System    | SubSystem | Service                   | Defect                  | Location  |
      | Chassis       | Wheel End | Axel      | AxleCollar - ReplaceW/New | Associated With Repairs | Left Side |
    Then Get Event information from -- TD
    Then Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventStatus | TD         | Open   | Dashboard |
      | eventLog    | TD         | Open   | EventInfo |
    And Validate Demo Terminal on Event Show Page -- TD

  #Estimation
  Scenario: 10 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - SmokeSuiteTDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And AssignEstimate TD event to -- Autotruck SP2 -- Payment Method - Yes
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | TD         | Submitted | Dashboard |
      | Single     | TD         | Submitted | EventInfo |
    And Get Event information from -- SP2
    And EventAction -- Accept -- by -- SP2
    And Get Event information from -- SP2
    And Verify Event Status
      | StatusType | TenandType | Status     | Page      |
      | Single     | SP2        | In Process | Dashboard |
      | Single     | SP2        | In Process | EventInfo |
    And EventAction -- Estimate -- by -- SP2
    #And Get Event information from -- nEPAccessibilitySP
    #And Verify Event Status
    #| StatusType | TenandType         | Status     | Page      |
    #| Single     | NEPAccessibilitySP | Estimating | Dashboard |
    #| Eventlog   | NEPAccessibilitySP | Estimating | EventInfo |
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
    And Get Event information from -- TD
    And Validate Estimate PreApproval -- TD

  #FSC
  Scenario: 11 Event from TD to SP --Assign event-- Using All tab of FSC and Override Search Results
    Given Create a Event-- TD -- Feature - SmokeSuiteFSC
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
    And AssignAll TD event to -- Autotruck SP -- Payment Method - Yes
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | SP         | Submitted | Dashboard |
      | eventLog    | SP         | Submitted | EventInfo |
      | eventStatus | TD         | Submitted | Dashboard |
      | eventLog    | TD         | Submitted | EventInfo |
    And Override TD event to -- Autotruck SP1 -- Payment Method - Yes
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | SP1        | Submitted | Dashboard |
      | eventLog    | SP1        | Submitted | EventInfo |

  #LogTechArrival
  Scenario: 12 Verify Log Tech Arrival from SP
    Given Create a Event-- TD -- Feature - SmokeSuiteLogTechArrival
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType  | TenandType | Status | Page      |
      | eventStatus | TD         | Open   | Dashboard |
      | eventLog    | TD         | Open   | EventInfo |
    And Assign TD event to -- Autotruck SP -- Payment Method - Yes
    And Verify Event Status
      | StatusType  | TenandType | Status    | Page      |
      | eventStatus | TD         | Submitted | Dashboard |
      | eventLog    | TD         | Submitted | EventInfo |
      | eventStatus | SP         | Submitted | Dashboard |
      | eventLog    | SP         | Submitted | EventInfo |
    And EventAction -- Accept -- by -- SP
    And LogTechArrival -- In SP

  #PLT
  Scenario: 13 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - SmokeSuiteTDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And AssignPLT TD event to -- Autotruck SP -- Payment Method - Cash
    And Get Event information from -- SP
    And EventAction -- Accept -- by -- SP
    And PLT Event -- SP -- Add
      | GroupCode | GroupDescription |
      | Test      | Test Desc00      |
    And EventAction -- Repair -- by -- SP
    And EventAction -- Complete -- by -- SP
    And Get Event information from -- TD
    And EventAction -- Approve -- by -- TD
    And Get Event information from -- TD

  #RejectandReassign
  Scenario: 14 Event from TD to SP --(TD to SP)--Single Service line--Assign event--Accept Event--Reject event
    Given Create a Event-- TD -- Feature - SmokeSuiteRejectReassign
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
    And Assign TD event to -- Autotruck SP -- Payment Method - Yes
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
    And EventAction -- Reject -- by -- SP
    And Verify Event Status
      | StatusType  | TenandType | Status   | Page      |
      | eventStatus | SP         | Rejected | Dashboard |
      | eventLog    | SP         | Rejected | EventInfo |
      | eventStatus | TD         | Rejected | Dashboard |
      | eventLog    | TD         | Rejected | EventInfo |

  #Scheduled Event
  Scenario: 15 Create a TD Event--Validate slot limit configured in SP
    Given AutoTruck SP -- Enable/Disable feature -- Enable Event Schedule--Enable
    Given Create a Event-- TD -- Feature - SmokeSuiteSchedule Event
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    And AssignSchedule TD-Schedule event to -- Autotruck SP -- Payment Method - Yes
    And Dashboard actions for scheduled events -- SP
      | Dropdown             | Validate      |
      | Pending Confirmation | EventID       |
      | Pending Confirmation | Schedule Time |
    And ScheduleEventAction -- SP -- Confirm
    And Dashboard actions for scheduled events -- SP
      | Dropdown               | Validate      |
      | Scheduled Confirmation | EventID       |
      | Scheduled Confirmation | Schedule Time |
    Given Create a Event-- TD -- Feature - Schedule Event
      | CustomerName | EquipmentType | EquipmentProvider |
      | Autotruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                    | Defect | Location |
      | Chassis       | Brakes | ABS       | ABSECUCable - ReplaceW/New | Broken | Under    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    And Assign TD-Schedule(2) event to -- Autotruck SP -- Payment Method - Yes
    Given AutoTruck SP -- Enable/Disable feature -- Enable Event Schedule--Enable

  #Shipper #check
  #Scenario: 16 Create an Event in TD and assign the event to SP
    #Given Create a Event-- TD -- Feature - SmokeSuiteShipperFunction
      #| CustomerName | EquipmentType | EquipmentProvider |
      #| Autotruck TD | Chassis       | AutoTruck         |
    #When Enter Service details -- Feature - ShipperFunction
      #| EquipmentType | System | SubSystem | Service              | Defect   | Location                 | Size1   | Size2 |
      #| Chassis       | Tire   | Flap      | Flap - Replace w/new | Worn Out | LIC - Left Inside Center | 10R22.5 | 10-20 |
    #| EquipmentType | System | SubSystem | Service              | Defect                  | Location                 |
    #| Chassis       | Tire   | Flap      | Flap - Replace w/new | Associated With Repairs | LIC - Left Inside Center |
    #And Get Event information from -- TD
    #And Verify Event Status
      #| StatusType | TenandType | Status | Page      |
      #| Single     | TD         | Open   | Dashboard |
      #| Single     | TD         | Open   | EventInfo |
    #And Assign TD event to -- Autotruck SP -- Payment Method - Yes
    #And Verify Event Status
      #| StatusType  | TenandType | Status    | Page      |
      #| eventStatus | SP         | Submitted | Dashboard |
      #| eventLog    | SP         | Submitted | EventInfo |
    #Then Validate Shipper Function

  #Tech-Scheduler
  Scenario: 17 Add Technician in TS page
    Given Open SP6 dashboard
    And Add Tech -- SP6 Tech2 -- in TS -- SP6
    And Add Shift -- SP6 Tech2 -- in TS -- SP6
    And Add Notes and Verify Notes
    And Copy Shift in TS
    And Edit Tech -- SP6 Tech2 -- in TS -- SP6
    And Edit and Verify Shift -- SP6 Tech2 -- in TS -- SP6
    And Delete Shift -- SP6 Tech2 -- in TS -- SP6
    And Upload Shift -- SP6 Tech2 -- in TS -- SP6
    #And Validate Technician Log
    And Delete Tech -- SP6 Tech2 -- in TS -- SP6

  #Towing Services
  Scenario: 18 Event From SP -- Towing Services - VMRS - Double Service line
    Given Create a Event-- SP -- Feature - SmokeSuiteTowingServices
      | EquipmentType | EquipmentProvider | CustomerName |
      | Trailer       | AutoTruck         | AutoTruck TD |
    When Enter Service details -- Create
      | EquipmentType | System            | Assembly          | Component         | Position | WorkAccomplished | Reason                 | TowingDestination              | Mileage |
      | Trailer       | Accessories group | Accessories group | Accessories group | Front    | Towing           | Abuse Caused by Driver | AC Hotel by Marriott Palo Alto |      30 |
    Then Get Event information from -- SP
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | SP         | Submitted | Dashboard |
      | Single     | SP         | Submitted | EventInfo |
    Then Validate Towing Services Details- AAR - 744 San Antonio Rd, Palo Alto, CA 94303, USA - 35
    Then Re-Evaluate Towing Service - 1701 Airport Blvd, San Jose, CA 95110, USA - 40
    When Enter Service details -- SecondServiceLine
      | EquipmentType | System            | Assembly          | Component         | Position | WorkAccomplished | Reason                 | ValidateSecondServiceLine |
      | Trailer       | Accessories group | Accessories group | Accessories group | Front    | Towing           | Abuse Caused by Driver | Yes                       |
