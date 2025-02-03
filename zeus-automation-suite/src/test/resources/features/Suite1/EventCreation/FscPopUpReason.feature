Feature: FSC PopUp Reason 
  This feature validates the FSC Popup reason when assiging  an event (at regular hours . after hours, doorclosed)

  @RegressionTest @Smoke
 Scenario: 01 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD  | Chassis       | AutoTruck       |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And AssignNonWorkingHours TD event to -- AutoTruck SP1 -- Payment Method - Cash
    
   @RegressionTest
 Scenario: 02 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Close -- Autotruck SP5 -- Door
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And AssignDoorClosed TD event to -- AutoTruck SP5 -- Payment Method - Cash
    And Open -- Autotruck SP5 -- Door
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | EventInfo |
    And Available TD event to -- AutoTruck SP5 -- Payment Method - Cash

   @RegressionTest
 Scenario: 03 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- TD -- Feature - TDEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- TD
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | TD         | Open   | Dashboard |
      | Single     | TD         | Open   | EventInfo |
    And Available-afterHours TD event to -- AutoTruck SP6 -- Payment Method - Cash