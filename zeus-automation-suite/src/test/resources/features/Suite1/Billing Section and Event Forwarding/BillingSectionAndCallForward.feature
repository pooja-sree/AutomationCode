Feature: Billing Section and Event Forward
  This feature verifies all combinations of Billing Section and Event Forward functionalities

#  @RegressionTest
#  Scenario: 01 Create a TD Event--Chassis-- Default Payment Method
#    Given Select Payment Method
#      | PaymentMethod |
#      | Default       |
#    Given Create a Event-- TD -- Feature - TDEventCreation
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD | Chassis       | AutoTruck         |
#    When Enter Service details -- Create
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- TD
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | TD         | Open   | EventInfo |
#    And Assign TD event to -- AutoTruck SP -- Payment Method - Cash
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | Single     | TD         | Submitted | EventInfo |
#    And DeSelect Payment Method
#      | PaymentMethod |
#      | Default       |
#
#  @RegressionTest @Smoke @Sanity
#  Scenario: 02 Create a TD Event--Chassis-- CashPaymentMethod
#    Given Select Payment Method
#      | PaymentMethod |
#      | Cash          |
#    Given Create a Event-- TD -- Feature - TDEventCreation
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD | Chassis       | AutoTruck         |
#    When Enter Service details -- Create
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- TD
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | TD         | Open   | EventInfo |
#    And Assign TD event to -- AutoTruck SP -- Payment Method - Cash
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | Single     | TD         | Submitted | EventInfo |
#    And Select Payment Method
#      | PaymentMethod |
#      | Cash          |

#  @RegressionTest @Smoke @Sanity @FC
#  Scenario: 03 Create a TD Event -- Chassis -- CallForwardSP -- Accept to withdraw from SP
#    Given Create a Event-- TD -- Feature - TDEventCreation
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD | Chassis       | AutoTruck         |
#    When Enter Service details -- Create
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- TD
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | TD         | Open   | EventInfo |
#    And Assign TD event to -- AutoForward -- Payment Method - Cash
#    And Get Event information from -- TD
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | Single     | TD         | Submitted | EventInfo |
#      | dispatchLog | SP3        | Event Forwarded	 | EventInfo |
#    And Validate CallForward -- AutoTruck SP3 -- AutoForward
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | eventLog     | AutoForward| Submitted | EventInfo |
#    And EventAction -- AcceptWithdraw -- by -- AutoForward
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | eventLog   | AutoForward| In Process | EventInfo |


#  @RegressionTest
#  Scenario: 04 Create a AutoForward Event -- CallForwardSP -- AutoForward Dropdown
#    Given Create a Event-- AutoForward -- Feature - EventForward
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD | Power Unit    | AutoTruck         |
#    When Enter Service details -- Create
#      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason                 |
#      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abuse Caused by Driver |
#    And Get Event information from -- AutoForward
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | eventLog    | AutoForward| Submitted | EventInfo |
#      | dispatchLog | AutoForward| Event Forwarded	 | EventInfo |
#    And Validate CallForward -- AutoForward -- AutoTruck CC1
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | dispatchLog | SP3        | Event Forwarded	 | EventInfo |
#    And Validate CallForward -- AutoTruck SP3 -- AutoForward
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | eventLog    | CC1       | Submitted | EventInfo |
#      | dispatchLog | CC1       | Event Forwarded	 | EventInfo |
#    And Validate CallForward -- AutoForward -- AutoTruck CC1


#  @RegressionTest
#  Scenario: 05 Create a TD Event--Chassis-- CallForwardCC
#    Given Create a Event-- TD -- Feature - TDEventCreation
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD | Chassis       | AutoTruck         |
#    When Enter Service details -- Create
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- TD
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | TD         | Open   | EventInfo |
#    And Assign TD event to -- AutoForwardCC -- Payment Method - Cash
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | Single     | TD         | Submitted | EventInfo |
#      | dispatchLog     | CC1        | Event Forwarded | EventInfo |
#    And Validate CallForward -- AutoTruck CC1 -- AutoForwardCC
#
#  @RegressionTest
#  Scenario: 06 Create a TD Event--Chassis-- CheckPaymentMethod
#    Given Select Payment Method
#      | PaymentMethod |
#      | Check         |
#    Given Create a Event-- TD -- Feature - TDEventCreation
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD | Chassis       | AutoTruck         |
#    When Enter Service details -- Create
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- TD
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | TD         | Open   | EventInfo |
#    And Assign TD event to -- AutoTruck SP1 -- Payment Method - Check
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | Single     | TD         | Submitted | EventInfo |
#      | Single     | SP1         | Submitted | EventInfo |
#    And Select Payment Method
#      | PaymentMethod |
#      | Check         |
#
#  @RegressionTest
#  Scenario: 07 Create a TD Event--Chassis-- NationalTirePaymentMethod
#    Given Select Payment Method
#      | PaymentMethod |
#      | NationalTire  |
#    Given Create a Event-- TD -- Feature - TDEventCreation
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD | Chassis       | AutoTruck         |
#    When Enter Service details -- Create
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- TD
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | TD         | Open   | EventInfo |
#    And Assign TD event to -- AutoTruck SP1 -- Payment Method - Continental
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | Single     | TD         | Submitted | EventInfo |
#    And Select Payment Method
#      | PaymentMethod |
#      | NationalTire  |
#
#  @RegressionTest
#  Scenario: 08 Create a TD Event--Chassis-- OEMpaymentMethod
#    Given Select Payment Method
#      | PaymentMethod |
#      | OEM           |
#    Given Create a Event-- TD -- Feature - TDEventCreation
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD | Chassis       | AutoTruck         |
#    When Enter Service details -- Create
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- TD
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | TD         | Open   | EventInfo |
#    And Assign TD event to -- AutoTruck SP1 -- Payment Method - OEM
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | Single     | TD         | Submitted | EventInfo |
#    And Select Payment Method
#      | PaymentMethod |
#      | OEM           |
#
#  Scenario: 09 Create a TD Event--Chassis-- ReachPaymentMethod
#    Given Select Payment Method
#      | PaymentMethod |
#      | Reach         |
#    Given Create a Event-- TD -- Feature - TDEventCreation
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD | Chassis       | AutoTruck         |
#    When Enter Service details -- Create
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- TD
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | TD         | Open   | EventInfo |
#    And Assign TD event to -- AutoTruck SP1 -- Payment Method - Reach
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | Single     | TD         | Submitted | EventInfo |
#    And Select Payment Method
#      | PaymentMethod |
#      | Reach         |
#
#  @RegressionTest
#  Scenario: 10 Create a TD Event--Chassis-- TireWarrantyPaymentMethod
#    Given Select Payment Method
#      | PaymentMethod |
#      | Tire Warranty |
#    Given Create a Event-- TD -- Feature - TDEventCreation
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD | Chassis       | AutoTruck         |
#    When Enter Service details -- Create
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- TD
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | TD         | Open   | EventInfo |
#    And Assign TD event to -- AutoTruck SP1 -- Payment Method - Tire Warranty
#    And Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | Single     | TD         | Submitted | EventInfo |
#    And Select Payment Method
#      | PaymentMethod |
#      | Tire Warranty |

#  @RegressionTest
#  Scenario: 11 Create a TD Event--Chassis-- StreamValidation
#    Given Create a Event-- TD -- Feature - TDEventCreation
#      | EquipmentType | EquipmentProvider | CustomerName |
#      | Chassis       | AutoTruck         | AutoTruck TD |
#    When Enter Service details -- Create
#      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
#      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
#    And Get Event information from -- TD
#    And Assign TD event to -- AutoTruck CC -- Payment Method - Cash
#    And Verify Payment Stream --TD
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | CC         | Submitted   | EventInfo |
#    And EventAction -- Accept -- by -- CC
#    And Assigncc CC event to -- AutoTruck SP -- Payment Method - Cash
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | SP         | In Process   | EventInfo |
#    And EventAction -- Accept -- by -- SP
##    And Verify Payment Stream --SP
#    And Verify Event Status
#      | StatusType | TenandType | Status | Page      |
#      | Single     | CC         | In Process   | EventInfo |
#    And Verify Payment Stream --CC

  @RegressionTest
  Scenario: 12 Create a TD Event--Chassis-- OEMBridgestonepaymentMethod
    Given Create a Event-- BridgeStone -- Feature - BridgestoneShipTo
      | CustomerName    | EquipmentType | EquipmentProvider    |
      | AutoTruck Fleet | Chassis       | AutoTruck            |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- BridgeStone
    And Verify Event Status
      | StatusType | TenandType          | Status      | Page      |
      | Single     | BridgeStone         | Submitted   | EventInfo |
    And EventAction -- Accept -- by -- CC
    And AssignAll TD event to -- AutoTruck SP -- Payment Method - BridgeStoneOEM
    And Verify Event Status
      | StatusType      | TenandType          | Status     | Page      |
      | eventLog        | BridgeStone         | In Process | EventInfo |
      | dispatchLog     | BridgeStone         | Submitted  | EventInfo |
