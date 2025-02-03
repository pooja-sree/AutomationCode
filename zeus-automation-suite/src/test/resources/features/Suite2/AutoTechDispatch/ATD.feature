 #@AutoTechDispatch 
#Feature: Auto Tech Dispatch
  #This feature verifies all combinations of Auto Tech Dispatch functionality
#
  #Background: Enable Event Schedule feature for Autotruck
    #Given AutoTruck SP6 -- Enable/Disable feature -- Enable Auto Tech Dispatch--Enable
    #Given AutoTruck SP7 -- Enable/Disable feature -- Enable Auto Tech Dispatch--Enable
#
  #@RegressionTest @Smoke
  #Scenario: 01 Create a TD Event--Chassis-- ATD Event Tech Accept
    #Given Create a Event-- TD -- Feature - TechAccept
      #| CustomerName | EquipmentType | EquipmentProvider |
      #| AutoTruck TD  | Chassis       | AutoTruck         |
    #When Enter Service details -- Create
      #| EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      #| Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    #And Get Event information from -- TD
    #And Verify Event Status
      #| StatusType | TenandType | Status | Page      |
      #| Single     | TD         | Open   | Dashboard |
      #| Single     | TD         | Open   | EventInfo |
    #And Assign TD event to -- AutoTruck SP7 -- Payment Method - Yes
    #And Wait for Auto Approval
    #And Get Event information from -- TD
    #And Verify Event Status
      #| StatusType | TenandType | Status     | Page      |
      #| Single     | TD         | In Process | Dashboard |
      #| Single     | TD         | In Process | EventInfo |
    #And Validate ATDlog -- Initiated -- Ringing -- Call Answered -- Accepted
#
  #@RegressionTest
  #Scenario: 02 Create a TD Event--Chassis-- ATD Event Tech Decline
    #Given Create a Event-- TD -- Feature - TechDecline
      #| CustomerName | EquipmentType | EquipmentProvider |
      #| AutoTruck TD  | Chassis       | AutoTruck         |
    #When Enter Service details -- Create
      #| EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      #| Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    #And Get Event information from -- TD
    #And Verify Event Status
      #| StatusType | TenandType | Status | Page      |
      #| Single     | TD         | Open   | Dashboard |
      #| Single     | TD         | Open   | EventInfo |
    #And Assign TD event to -- AutoTruck SP7 -- Payment Method - Yes
    #And Wait for Auto Approval
    #And Get Event information from -- TD
    #And Verify Event Status
      #| StatusType | TenandType | Status    | Page      |
      #| Single     | TD         | Submitted | Dashboard |
      #| Single     | TD         | Submitted | EventInfo |
    #And Validate ATDlog -- Initiated -- Ringing -- Call Answered -- Declined
#
  #@RegressionTest
  #Scenario: 03 Create a TD Event--Chassis-- ATD Event Tech Accept
    #Given Create a Event-- TD -- Feature - ATD--SP
      #| CustomerName | EquipmentType | EquipmentProvider |
      #| AutoTruck TD  | Chassis       | AutoTruck         |
    #When Enter Service details -- Create
      #| EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      #| Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    #And Get Event information from -- TD
    #And Verify Event Status
      #| StatusType | TenandType | Status | Page      |
      #| Single     | TD         | Open   | Dashboard |
      #| Single     | TD         | Open   | EventInfo |
    #And Assign TD event to -- AutoTruck SP6 -- Payment Method - Cash
     #And Wait for Auto Approval
    #And Get Event information from -- TD
    #And Verify Event Status
      #| StatusType | TenandType | Status    | Page      |
      #| Single     | TD         | Submitted | Dashboard |
      #| Single     | TD         | Submitted | EventInfo |
    #And Validate ATDlog -- Initiated -- Ringing -- Call Answered -- Tenant Notified
